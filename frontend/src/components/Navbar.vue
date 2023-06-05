<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <a class="navbar-brand" href="/Home">SistemaVoluntariado</a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav" v-if="!user">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <router-link to="/login" class="nav-link">Login</router-link>
                </li>
                <li class="nav-item">
                    <router-link to="/signup" class="nav-link">Sign Up</router-link>
                </li>
            </ul>
        </div>
        <div class="collapse navbar-collapse justify-content-end" id="navbarNav" v-if="user">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <a href="javascript:void(0)" @click="logout" class="nav-link">Logout</a>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
export default {
    name: 'Navbar',
    props: ['user'],
    methods: {
        logout() {
            localStorage.removeItem('token');
            this.$router.push('/');
        }
    }
}
</script>
