<template>
    <div>
        <Navbar />
        <RegisterCard />
    </div>
</template>

<script>
import RegisterCard from '../components/RegisterCard.vue'
import Navbar from '../components/Navbar.vue'
export default {
    components: { Navbar, RegisterCard },
    name: 'RegisterPage'
}
</script>