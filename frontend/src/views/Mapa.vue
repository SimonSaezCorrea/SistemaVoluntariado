<template>
    <div class="home">
        <h1>Mapa Tareas</h1>
        <div class="mb-3">
            <label for="tarea" class="mr-2">ID Tarea:</label>
            <input type="number" class="form-control mr-2" v-model="id_tarea"
                        placeholder="Ingrese ID de la Tarea" required>
        </div>
        <div class="mb-3">
            <label for="numberLimit" class="mr-2">N° Límite:</label>
            <input type="number" class="form-control mr-2" v-model="numberLimit"
                        placeholder="Ingrese número límite" required>
        </div>
        <div class="col-sm-12 col-md-auto">
            <button class="btn btn-primary" @click="buscarCercanos">Buscar</button>
        </div>
        <div id="mapid"></div>
    </div>
</template>
<script>
//Importaciones
import 'leaflet/dist/leaflet'; //librería leaflet
import 'leaflet/dist/leaflet.css'; //css leaflet
var icon = require('leaflet/dist/images/marker-icon.png'); //ícono de marcadores
var icon2 = require('leaflet/dist/images/layers.png');
//Se crea objeto ícono con el marcador
var LeafIcon = L.Icon.extend({
    options: { iconSize: [25, 41], iconAnchor: [12, 41], popupAnchor: [-3, -41] }
});
var myIcon = new LeafIcon({ iconUrl: icon });
var myIcon2 = new LeafIcon({ iconUrl: icon2 });

//librería axios
import axios from 'axios';
import L from 'leaflet';
export default {
    name: 'MapaView',
    data: function () {
        return {
            id_tarea: "",
            numberLimit: "",
            points: [], //colección de puntos cargados de la BD
            mymap: null //objeto de mapa(DIV)
        }
    },
    computed: {
        point() { // función computada para representar el punto seleccionado
            if (this.latitud && this.longitud) {
                let lat = this.latitud.toFixed(3);
                let lon = this.longitud.toFixed(3);
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
        async getPoints(map) {
            try {
                //se llama el servicio 
                let response = await axios.get('api/tarea');
                let dataPoints = response.data;
                //Se itera por los puntos
                dataPoints.forEach(point => {

                    //Se crea un marcador por cada punto
                    let p = [point.latitud, point.longitud]
                    let marker = L.marker(p, { icon: myIcon }) //se define el ícono del marcador
                        .bindPopup(point.nombre) //Se agrega un popup con el nombre

                    //Se agrega a la lista
                    this.points.push(marker);
                });

                //Los puntos de la lista se agregan al mapa
                this.points.forEach(p => {
                    p.addTo(map)
                })
            } catch (error) {
                console.log('error', error);
            }

        },
        async buscarCercanos() {
            this.points.forEach(p => {
                this.mymap.removeLayer(p);
            })
            this.points = [];
            const response = await axios.get(`api/tarea/mapa/${this.id_tarea}/${this.numberLimit}`)
            const Voluntarios = response.data
            const response_tarea = await axios.get(`api/tarea/${this.id_tarea}`)
            const tarea = response_tarea.data
            let p = [tarea[0].latitud, tarea[0].longitud]
            let marker = L.marker(p, { icon: myIcon2 }) //se define el ícono del marcador
                    .bindPopup(tarea[0].nombre)
            this.points.push(marker)

            Voluntarios.forEach(point => {
                //Se crea un marcador por cada punto
                let p2 = [point.latitud, point.longitud]
                let marker2 = L.marker(p2, { icon: myIcon }) //se define el ícono del marcador
                    .bindPopup(point.nombre) //Se agrega un popup con el nombre
                //Se agrega a la lista
                this.points.push(marker2);
            });
            this.points.forEach(p => {
                    p.addTo(this.mymap)
                })
        },
    },
    mounted: function () {
        let _this = this;
        //Se asigna el mapa al elemento con id="mapid"
        this.mymap = L.map('mapid').setView([-33.456, -70.648], 7);
        //Se definen los mapas de bits de OSM
        L.tileLayer('http://{s}.tile.osm.org/{z}/{x}/{y}.png', {
            attribution: '&copy; <a href="http://osm.org/copyright">OpenStreetMap</a> contributors',
            maxZoom: 10
        }).addTo(this.mymap);

        //Evento click obtiene lat y long actual
        this.mymap.on('click', function (e) {
            _this.latitud = e.latlng.lat;
            _this.longitud = e.latlng.lng;
        });

        //Se agregan los puntos mediante llamada al servicio
        this.getPoints(this.mymap);
    }
}
</script>


<style>
.home {
    display: flex;
    flex-direction: column;
    align-items: center;
}

/* Estilos necesarios para definir el objeto de mapa */
#mapid {
    height: 600px;
    width: 600px;
}
div {
    padding-bottom: 1px;
}
</style>
