<template>
    <b-card title="Iniciar sesión" class="login-card">
        <b-form @submit="submitForm">
            <b-form-group id="username-group" label="Nombre de usuario" label-for="username-input">
                <b-form-input id="username-input" v-model="username" required></b-form-input>
            </b-form-group>
            <b-form-group id="password-group" label="Contraseña" label-for="password-input">
                <b-form-input id="password-input" type="password" v-model="password" required></b-form-input>
            </b-form-group>
            <b-button type="submit" variant="primary">Iniciar sesión</b-button>
        </b-form>
    </b-card>
</template>

<script>
export default {
    name: 'LoginCard',
    data() {
        return {
            username: '',
            password: ''
        };
    },
    methods: {
        submitForm(event) {
            event.preventDefault();
            // Aquí puedes realizar la llamada a tu backend utilizando Axios para autenticar al usuario
            // Puedes acceder a las credenciales ingresadas mediante this.username y this.password
        }
    }
};
</script>

<style scoped>
.login-card {
    max-width: 300px;
    margin: 0 auto;
    margin-top: 100px;
    padding: 20px;
}
</style>
