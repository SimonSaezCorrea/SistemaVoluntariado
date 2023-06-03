<template>
    <div class="container">
        <div class="card mt-4" style="max-width: 400px; margin: 0 auto;">
            <div class="card-body">
                <h5 class="card-title">Iniciar sesión</h5>
                <form @submit.prevent="submitForm">
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
</template>

<script>
export default {
    name: 'Login',
    data() {
        return {
            email: '',
            password: ''
        };
    },
    methods: {
        submitForm() {
            console.log('Correo electrónico:', this.email);
            console.log('Contraseña:', this.password);

        }
    }
}
</script>

<style scoped>
.container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}
</style>
