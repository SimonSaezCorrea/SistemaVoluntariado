<template>
    <b-card title="Registro" class="register-card">
        <b-form @submit="submitForm">
            <b-form-group id="name-group" label="Nombre" label-for="name-input">
                <b-form-input id="name-input" v-model="name" required></b-form-input>
            </b-form-group>
            <b-form-group id="email-group" label="Email" label-for="email-input">
                <b-form-input id="email-input" v-model="email" type="email" required></b-form-input>
            </b-form-group>
            <b-form-group id="password-group" label="Contraseña" label-for="password-input">
                <b-form-input id="password-input" v-model="password" type="password" required></b-form-input>
            </b-form-group>
            <b-button type="submit" variant="primary">Registrarse</b-button>
        </b-form>
    </b-card>
</template>

<script>
import axios from 'axios'
export default {
    name: 'RegisterCard',
    data() {
        return {
            name: '',
            email: '',
            password: ''
        };
    },
    methods: {
        submitForm(event) {
            event.preventDefault();
            const data = {
                name: this.name,
                email: this.email,
                password: this.password
            };

            axios.post('http:')

           
            console.log(data);
        }
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
</style>
