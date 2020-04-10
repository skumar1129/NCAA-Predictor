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


export default {
    name: "Search1",
    data() {
        return{
            teams: [],
            choice: ""
        }       
    },
    mounted() {
      ApiService.getNames().then(res => {
          this.teams = res.data;
      })  
    },
    methods: {
        emitTeam1(event) {
            this.$emit('team1', this.choice)
        }
    }
};
</script>

<style>
    .label {
        font-size: x-large;
    }
</style>

