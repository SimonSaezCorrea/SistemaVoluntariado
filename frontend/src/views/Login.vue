<template>
    <div class="container">
        <div class="login-card">
            <div class="card mt-4" style="max-width: 400px; margin: 0 auto;">
                <div class="card-body">
                    <h5 class="card-title">Iniciar sesión</h5>
                    <form @submit.prevent="login">
                        <div class="mb-3">
                            <label for="email" class="form-label">Correo electrónico</label>
                            <input type="email" class="form-control" id="email" v-model="email" required>
                        </div>
                        <div class="mb-3">
                            <label for="password" class="form-label">Contraseña</label>
                            <input type="password" class="form-control" id="password" v-model="password" required>
                        </div>
                        <button type="submit" class="btn btn-primary">Iniciar sesión</button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: 'LoginView',
    data() {
        return {
            email: '',
            password: ''
        };
    },
    methods: {
        async login() {
            const response = await axios.post('/auth/login', {
                email: this.email,
                password: this.password
            });

            localStorage.setItem('token', response.data.jwtToken);
            this.$store.dispatch('user', response.data.sesion);

            this.$router.push('/');
        }
    }
}
</script>

<style scoped>
.login-card {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
</style>
