<template>
    <div>
        <div class="register-card">
            <h2 class="mb-4">Registro</h2>
            <form @submit="submitForm">
                <div class="mb-3">
                    <label for="nombre-input" class="form-label">Nombre:</label>
                    <input id="nombre-input" class="form-control" v-model="nombre" required>
                </div>
                <div class="mb-3">
                    <label for="email-input" class="form-label">Email:</label>
                    <input id="email-input" class="form-control" v-model="email" type="email" required>
                </div>
                <div class="mb-3">
                    <label for="password-input" class="form-label">Contraseña:</label>
                    <input id="password-input" class="form-control" v-model="password" type="password" required>
                </div>
                <div>
                    <label for="">Ubicación:</label>
                    <div>{{ point }}</div>
                    <div id="mapid"></div>
                </div>
                <br>
                <button type="submit" class="btn btn-primary">Registrarse</button>
                <p class="mt-3">{{ mensajeRegistro }}</p>
            </form>
        </div>
    </div>
</template>

<script>
import 'leaflet/dist/leaflet';
import 'leaflet/dist/leaflet.css';
import axios from 'axios';
import L from 'leaflet';

// Se carga el ícono del marcador
const icon = require('leaflet/dist/images/marker-icon.png');
const LeafIcon = L.Icon.extend({
    options: { iconSize: [25, 41], iconAnchor: [12, 41], popupAnchor: [-3, -41] }
});
const myIcon = new LeafIcon({ iconUrl: icon });

export default {
    name: 'RegisterView',
    data() {
        return {
            nombre: '',
            email: '',
            password: '',
            mensajeRegistro: '',
            latitud: null,
            longitud: null,
            points: [],
            mymap: null
        };
    },
    computed: {
        point() {
            if (this.latitud && this.longitud) {
                const lat = this.latitud.toFixed(3);
                const lon = this.longitud.toFixed(3);
                return `(${lat}, ${lon})`;
            } else {
                return '';
            }
        }
    },
    methods: {
        clearMarkers: function () { //eliminar marcadores
            this.points.forEach(p => {
                this.mymap.removeLayer(p);
            })
            this.points = [];
        },
        async submitForm(event) {
            event.preventDefault();

            if (this.latitud === null || this.longitud === null) {
                this.mensajeRegistro = 'Debe seleccionar una ubicación';
            } else {
                try {
                    const response = await axios.post('auth/register', {
                        nombre: this.nombre,
                        email: this.email,
                        password: this.password,
                        latitud: this.latitud,
                        longitud: this.longitud
                    });

                    this.mensajeRegistro = response.data;
                    console.log(response.data);
                } catch (error) {
                    console.error(error);
                    if (error.response) {
                        this.mensajeRegistro = error.response.data;
                    } else {
                        this.mensajeRegistro = 'Error en la solicitud de registro';
                    }
                }
            }
        }
    },
    mounted() {
        this.mymap = L.map('mapid').setView([-33.456, -70.648], 7);
        L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
            maxZoom: 10
        }).addTo(this.mymap);

        this.mymap.on('click', (e) => {
            this.latitud = e.latlng.lat;
            this.longitud = e.latlng.lng;

            this.clearMarkers(this.mymap);
            const p = [this.latitud, this.longitud];
            const marker = L.marker(p, { icon: myIcon }).bindPopup('Ubicación');
            this.points.push(marker);

            this.points.forEach((p) => {
                p.addTo(this.mymap);
            });
        });
    }
};
</script>

<style scoped>
.register-card {
    max-width: 300px;
    margin: 0 auto;
    margin-top: 100px;
    padding: 20px;
}

#mapid {
    height: 200px;
    width: 260px;
}
</style>
