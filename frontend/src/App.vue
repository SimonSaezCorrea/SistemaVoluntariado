<template>
  <main>
    <Navbar :user="user"/>
    <router-view :user="user"/>
  </main>
</template>

<script>
import Navbar from './components/Navbar.vue';
import axios from 'axios';

export default {
  components: {
    Navbar
  },
  data() {
    return {
      user: null
    }
  },
  async created() {
      try {
        const response = await axios.get('auth/sesion');
        this.user = response.data;
      } catch (error) {
        console.error(error);
      }
  }
}
</script>

<style scoped>
/* Estilos específicos de App.vue */
</style>
