<template>
    <div>
        <div class="register-card">
            <h2 class="mb-4">Registro</h2>
            <form @submit="submitForm">
                <div class="mb-3">
                    <label for="nombre-input" class="form-label">Nombre</label>
                    <input id="nombre-input" class="form-control" v-model="nombre" required>
                </div>
                <div class="mb-3">
                    <label for="email-input" class="form-label">Email</label>
                    <input id="email-input" class="form-control" v-model="email" type="email" required>
                </div>
                <div class="mb-3">
                    <label for="password-input" class="form-label">Contraseña</label>
                    <input id="password-input" class="form-control" v-model="password" type="password" required>
                </div>
                <div class="mb-3">
                    <label for="latitud-input" class="form-label">Latitud</label>
                    <input id="latitud-input" class="form-control" v-model="latitud" required>
                </div>
                <div class="mb-3">
                    <label for="longitud-input" class="form-label">Longitud</label>
                    <input id="longitud-input" class="form-control" v-model="longitud" required>
                </div>
                <button type="submit" class="btn btn-primary">Registrarse</button>
                <p class="mt-3">{{ mensajeRegistro }}</p>
            </form>
        </div>
    </div>
</template>

<script>
import axios from 'axios';

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
        };
    },
    methods: {
        async submitForm(event) {
            event.preventDefault();
            try {
                const response = await axios.post('auth/register', {
                    nombre: this.nombre,
                    email: this.email,
                    password: this.password,
                    latitud: this.latitud,
                    longitud: this.longitud,
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
        },
    },
};
</script>

<style scoped>
.register-card {
    max-width: 300px;
    margin: 0 auto;
    margin-top: 100px;
    padding: 20px;
}
</style>
