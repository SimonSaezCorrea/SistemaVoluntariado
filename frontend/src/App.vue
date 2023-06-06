<template>
  <div id="app">
    <Navbar/>
    <router-view/>
  </div>
</template>

<script>
import Navbar from './components/Navbar.vue'
import axios from 'axios'

export default {
  name: 'App',
  components: {
    Navbar
  },
  data() {
    return {
      user: null
    }
  },
  async created() {
    const response = await axios.get('auth/sesion');
    this.$store.dispatch('user', response.data);
  }
}
</script>

<style>
</style>
