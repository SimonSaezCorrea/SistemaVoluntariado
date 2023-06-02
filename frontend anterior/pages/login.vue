<template>
    <div>
        <Navbar />
        <LoginCard />
    </div>
</template>

<script>
import LoginCard from '../components/LoginCard.vue'
import Navbar from '../components/Navbar.vue'
export default {
    components: { Navbar, LoginCard },
    name: 'LoginPage'
}
</script>