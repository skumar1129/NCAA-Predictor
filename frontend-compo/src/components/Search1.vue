<template>
        <form>
            <div class="form-group">
                <label class="label mr-1" for="team1">First Team:</label>
                <select v-model="choice" @change="emitTeam1">
                    <option v-for="team in teams" :key="team.teamName">{{team.teamName}}</option>
                </select>
            </div>
        </form>
</template>


<script lang="ts">
import ApiService from '../api/api.service';
import { ref, onBeforeMount } from '@vue/composition-api';


export default {
    name: "Search1",
    setup(props, context) {
        const teams = ref([]);
        const choice = ref('');
        onBeforeMount(() => {
            ApiService.getNames().then(res => {
                teams.value = res.data;
            })
        })
        function emitTeam1() {
            context.emit('team1', choice.value);
        }
        return { teams, choice, emitTeam1 };
    }
    // data() {
    //     return{
    //         teams: [],
    //         choice: ""
    //     }       
    // },
    // mounted() {
    //   ApiService.getNames().then(res => {
    //       this.teams = res.data;
    //   })  
    // },
    // methods: {
    //     emitTeam1(event) {
    //         this.$emit('team1', this.choice)
    //     }
    // }
};
</script>

<style>
    .label {
        font-size: x-large;
    }
</style>

