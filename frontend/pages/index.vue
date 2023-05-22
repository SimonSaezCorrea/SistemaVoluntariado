<template>
  <div class="container mt-4">
    <b-card title="Login" class="w-50 mx-auto">
      <b-form @submit.prevent="login">
        <b-form-group id="username" label="Username" label-for="username-input" :invalid-feedback="usernameError"
          :state="usernameState">
          <b-form-input id="username-input" v-model="username" required></b-form-input>
        </b-form-group>

        <b-form-group id="password" label="Password" label-for="password-input" :invalid-feedback="passwordError"
          :state="passwordState">
          <b-form-input id="password-input" v-model="password" type="password" required></b-form-input>
        </b-form-group>

        <b-button type="submit" variant="primary" class="mt-3">Login</b-button>
      </b-form>
      <b-button @click="register" variant="primary" class="mt-2">Register</b-button>
    </b-card>
  </div>
</template>

<script>
export default {
  data() {
    return {
      username: '',
      password: '',
      error: null
    };
  },
  methods: {
    async login() {
      try {
        const { data } = await this.$auth.loginWith('local', {
          data: {
            username: this.username,
            password: this.password
          }
        });

        // Si el inicio de sesión es exitoso, el token se almacenará automáticamente y se redireccionará según la configuración de 'redirect'.

      } catch (error) {
        // Si hay un error en el inicio de sesión, puedes mostrar un mensaje de error en el formulario.
        this.error = 'Error de inicio de sesión. Por favor, verifica tus credenciales.';
      }
    },
    register() {
      // Aquí puedes redirigir a la página de registro
      console.log('Ir a la página de registro');
    }
  }
};
</script>


<style scoped>
.container {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.card {
  max-width: 400px;
  padding: 20px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
}
</style>
