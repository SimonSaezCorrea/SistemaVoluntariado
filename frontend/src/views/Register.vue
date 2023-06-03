<template>
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
            <button type="submit" class="btn btn-primary">Registrarse</button>
            <p class="mt-3">{{ mensajeRegistro }}</p>
        </form>
    </div>
</template>

<script>
import api from '../services/api.js';

export default {
    name: 'RegisterCard',
    data() {
        return {
            nombre: '',
            email: '',
            password: '',
            mensajeRegistro: ''
        };
    },
    methods: {
        async submitForm(event) {
            event.preventDefault();
            try {
                const data = {
                    nombre: this.nombre,
                    email: this.email,
                    password: this.password
                };

                const response = await api.register(data); // Llama al método register de api.js
                this.mensajeRegistro = response.data;
                console.log(response.data);
            } catch (error) {
                console.error(error);
                if (error.response) {
                    this.mensajeRegistro = error.response.data; // Captura el mensaje de error de la respuesta
                } else {
                    this.mensajeRegistro = 'Error en la solicitud de registro'; // Maneja el error si la solicitud falla
                }
            }
        }
    }
}
</script>

<style scoped>
.register-card {
    max-width: 300px;
    margin: 0 auto;
    margin-top: 100px;
    padding: 20px;
}
</style>
