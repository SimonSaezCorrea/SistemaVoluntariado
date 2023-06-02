<template>
  <div>
    <Navbar/>
    <Home/>
  </div> 
</template>

<script>
import LoginCard from '../components/LoginCard.vue'
import Navbar from '../components/Navbar.vue'
export default {
  components: { Navbar, LoginCard },
  name: 'IndexPage'
}
</script>