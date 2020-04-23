<template>
    <div class="scoring-page">
        <div class="jumbotron">
            <img class="img-fluid mb-2" src="../assets/final_four_pic.jpg">
            <form>
                 <h1 class="display-5">Choose the Value of each metric for the Teams</h1>
                 <div class="row" id="comps">
                    <Scoring1 v-on:score1="setScore1" class="comp1" />
                    <Scoring2 v-on:score2="setScore2" class="comp2" />
                 </div>
                 
            </form>
            <img class="img-fluid mt-2 mb-2" id="bot" src="../assets/brunson_pic.jpeg">
            <div class="container mt-2">
                <label class="label">{{team1}}'s Score: {{score1}}</label>
                <br/>
                <label class="label">{{team2}}'s Score: {{score2}}</label>
            </div>
            
        </div>
    </div>
</template>

<script lang='ts'>
import Scoring1 from '../components/Scoring1.vue';
import Scoring2 from '../components/Scoring2.vue';
import { ref, computed, defineComponent } from '@vue/composition-api';

export default defineComponent({
    name: "Scoring",
    components: {
        Scoring1,
        Scoring2
    },
    setup(props, context) {
        const score1: number = ref(0);
        const score2: number = ref(0);
        const team1: string = computed(() => context.root.$store.getters.getTeam1.teamName);
        const team2: string = computed(() => context.root.$store.getters.getTeam2.teamName);
        function setScore1(newValue) {
            score1.value = newValue.toFixed(20);
        }
        function setScore2(newValue) {
            score2.value = newValue.toFixed(20);
        }
        return { score1, score2, team1, team2, setScore1, setScore2 };
    }
    // data() {
    //     return {
    //         score1: 0,
    //         score2: 0
    //     }
    // },
    // computed: {
    //     team1: function() {
    //         return this.$store.getters.getTeam1.teamName;
    //     },
    //     team2: function() {
    //         return this.$store.getters.getTeam2.teamName;
    //     }
    // },
    // methods: {
    //      setScore1(value) {
    //          this.score1 = value.toFixed(20);
    //      },
    //      setScore2(value) {
    //          this.score2 = value.toFixed(20);
    //      }  
    // }
});
</script>

<style scoped>
    #bot {
        height: 25rem;
        width: 50rem;
    }
    .label {
        font-size: xx-large;
    }
    #comps {
        display: flex;
        justify-content: center;
    }
    .comp1 {
        margin-right: 5%;
    }
    .comp2 {
        margin-left: 5%;
    }
    .container {
        display: flex;
        justify-content: flex-start;
        flex-flow: column;
    }
    
</style>
