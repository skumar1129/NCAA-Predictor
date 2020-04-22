<template>
        <form>
            <div class="form-group">
                <label class="label mr-1" for="team1">Second Team:</label>
                <select v-model="choice" @change="emitTeam2">
                    <option v-for="team in teams" :key="team.teamName">{{team.teamName}}</option>
                </select>
            </div>
        </form>
</template>


<script lang="ts">
import ApiService from '../api/api.service';
import { ref, onBeforeMount } from '@vue/composition-api';

export default {
    name: "Search2",
    setup(props, context) {
        const teams = ref([]);
        const choice = ref('');
        onBeforeMount(() => {
            ApiService.getNames().then(res => {
                teams.value = res.data;
            })
        })
        function emitTeam2() {
            context.emit('team2', choice.value);
        }
        return { teams, choice, emitTeam2 };
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
    //     emitTeam2(event) {
    //         this.$emit('team2', this.choice)
    //     }
    // }
    
};
</script>

<style>
    .label {
        font-size: x-large;
    }
</style>

