<template>
  <main>
    <Navbar />
    <router-view />
  </main>
</template>

<script>
import Navbar from './components/Navbar.vue';

export default {
  components: {
    Navbar
  }
}
</script>

<style scoped>
/* Estilos específicos de App.vue */
</style>
