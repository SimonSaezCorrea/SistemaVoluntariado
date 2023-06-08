<template>
    <div class="ranking-container">
        <div class="d-flex flex-column justify-content-center align-items-center">
            <h1>Ranking de Voluntarios por Tarea</h1>
            <div class="mt-4">
                <div class="row align-items-center">
                    <div class="col-sm-12 col-md-auto">
                        <label for="tarea" class="mr-2">ID Tarea:</label>
                    </div>
                    <div class="col-sm-12 col-md-auto">
                        <input type="number" class="form-control mr-2" v-model="tarea"
                            placeholder="Ingrese ID de la Tarea">
                    </div>
                    <div class="col-sm-12 col-md-auto">
                        <button class="btn btn-primary" @click="buscarRanking">Buscar</button>
                    </div>
                </div>
            </div>
        </div>
        <br>
        <div class="d-flex flex-column justify-content-center align-items-center">
            <h2>Ranking:</h2>
        </div>
        <div v-if="ranking.length > 0" class="mt-4">
            <table class="table table-striped">
                <thead>
                    <tr>
                        <th>Posición</th>
                        <th>Nombre</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(item, index) in ranking" :key="item.id">
                        <td>{{ index + 1 }}</td>
                        <td>{{ item.nombre }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
        <div v-if="ranking.length == 0" class="mt-4">
            <table class="table table-striped">
                 <thead>
                     <tr>
                        <th>Posición</th>
                        <th>Nombre</th>
                    </tr>
                 </thead>
                <tbody>
                    <tr>
                        <td colspan="2" class="text-center">No hay Voluntarios</td>
                    </tr>
                 </tbody>
            </table>
        </div>
    </div>
</template>

<script>
import axios from 'axios'

export default {
    name: 'RankingView',
    data() {
        return {
            tarea: '',
            ranking: []
        }
    },
    methods: {
        async buscarRanking() {
            const response = await axios.get(`api/ranking/select/${this.tarea}`)
            this.ranking = response.data
        }
    }
}
</script>
