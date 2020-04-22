<template>
    <div class="search-page">
        <div class="jumbotron">
           <form>
                <h1 class="display-2 mb-2">Choose your matchup</h1>
                <Search1 v-on:team1="team1Change" />
                <Search2 v-on:team2="team2Change" />
                <button class="btn btn-primary" type="submit" @click="submitTeams">Submit</button>
            </form>
            <img class="img-fluid mt-2" src="../assets/michigan_sucks_page.jpeg">
        </div>
    </div>
</template>

<script>
import Search1 from '../components/Search1.vue';
import Search2 from '../components/Search2.vue';
import { ref } from '@vue/composition-api';
export default {
    name: "SearchPage",
    components: {
        Search1,
        Search2
    },
    setup(props, context) {
        const team1 = ref('');
        const team2 = ref('');
        function team1Change(value) {
            team1.value = value;
        }
        function team2Change(value) {
            team2.value = value;
        }
        function submitTeams() {
            context.root.$store.dispatch('fetchTeam1', team1.value);
            context.root.$store.dispatch('fetchTeam2', team2.value);
            context.root.$router.push({ name: 'Scoring' });
        }
        return { team1Change, team2Change, submitTeams };
    }
    // components: {
    //     Search1,
    //     Search2
    // },
    // data() {
    //     return  {
    //         team1: '',
    //         team2: ''
    //     }
    // },
    // methods: {
    //     team1Change(value) {
    //         this.team1 = value;
    //         console.log(this.team1);
    //     },
    //     team2Change(value) {
    //         this.team2 = value;
    //         console.log(this.team2);
    //     },
    //     submitTeams() {
    //         this.$store.dispatch('fetchTeam1', this.team1);
    //         this.$store.dispatch('fetchTeam2', this.team2);
    //         this.$router.push({ name: 'Scoring'});
    //     }
    // }
};
</script>

<style>
    .img-fluid {
        height: 40rem;
        widows: 40rem;
    }
    
</style>
