<template>
    <nav class="navbar navbar-expand-lg navbar-dark bg-primary">
        <div class="container" style="padding-left: 20px; padding-right: 20px;">
            <router-link class="navbar-brand" to="/">SistemaVoluntariado</router-link>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-between" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <router-link to="/ranking" class="nav-link" v-if="user">Ranking</router-link>
                    </li>
                </ul>
                <ul class="navbar-nav">
                    <li class="nav-item" v-if="!user">
                        <router-link to="/login" class="nav-link">Login</router-link>
                    </li>
                    <li class="nav-item" v-if="!user">
                        <router-link to="/signup" class="nav-link">Sign Up</router-link>
                    </li>
                    <li class="nav-item" v-if="user">
                        <a href="javascript:void(0)" @click="logout" class="nav-link">Logout</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</template>

<script>
import { mapGetters } from 'vuex';

export default {
    name: 'NavbarMenu',
    methods: {
        logout() {
            localStorage.removeItem('token');
            this.$store.dispatch('user', null);
            this.$router.push('/');
        },
    },
    computed: {
        ...mapGetters(['user']),
    },
};
</script>
