<template>
    <div class="d-flex align-items-center justify-content-center vh-100">
        <div class="card p-4">
            <h3 v-if="user" class="text-center">Bienvenido, {{ user.nombre }}</h3>
            <h3 v-if="!user" class="text-center">Aun no has iniciado sesión</h3>
        </div>
    </div>
</template>



<script>
import { mapGetters } from 'vuex'
export default {
    name: 'HomeView',
    computed: {
        ...mapGetters(['user'])
    }
}
</script>
