<template>
    <div class="score2">
       <h3 class="display-6">{{team.teamName}}'s Metrics:</h3>
        
           <Stat1 v-on:stat1="newStat1" />
           <Stat2 v-on:stat2="newStat2" />
           <Stat3 v-on:stat3="newStat3" />
           <Stat4 v-on:stat4="newStat4" />
           <Stat5 v-on:stat5="newStat5" />
           <Stat6 v-on:stat6="newStat6" />
           <Stat7 v-on:stat7="newStat7" />
           <Stat8 v-on:stat8="newStat8" />
           <Stat9 v-on:stat9="newStat9" />
           <Stat10 v-on:stat10="newStat10" />
           <Stat11 v-on:stat11="newStat11" />
           <Stat12 v-on:stat12="newStat12" />
           <Stat13 v-on:stat13="newStat13" />
           <Stat14 v-on:stat14="newStat14" />
            <button @click="calculateScore" class="btn btn-primary">Get Score</button>
       
    </div>
</template>

<script>
import Stat1 from './Stat1.vue';
import Stat2 from './Stat2.vue';
import Stat3 from './Stat3.vue';
import Stat4 from './Stat4.vue';
import Stat5 from './Stat5.vue';
import Stat6 from './Stat6.vue';
import Stat7 from './Stat7.vue';
import Stat8 from './Stat8.vue';
import Stat9 from './Stat9.vue';
import Stat10 from './Stat10.vue';
import Stat11 from './Stat11.vue';
import Stat12 from './Stat12.vue';
import Stat13 from './Stat13.vue';
import Stat14 from './Stat14.vue';
import { ref, computed } from '@vue/composition-api';
export default {
    name: "Scoring2",
    components: {
        Stat1,
        Stat2,
        Stat3,
        Stat4,
        Stat5,
        Stat6,
        Stat7,
        Stat8,
        Stat9,
        Stat10,
        Stat11,
        Stat12,
        Stat13,
        Stat14
    },
        setup(props, context) {
        const score = ref(0);
        const stat1 = ref(1);
        const stat2 = ref(1);
        const stat3 = ref(1);
        const stat4 = ref(1);
        const stat5 = ref(1);
        const stat6 = ref(1);
        const stat7 = ref(1);
        const stat8 = ref(1);
        const stat9 = ref(1);
        const stat10 = ref(1);
        const stat11 = ref(1);
        const stat12 = ref(1);
        const stat13 = ref(1);
        const stat14 = ref(1);
        const stats = { stat1, stat2, stat3, stat4, stat5, stat6, stat7, stat8, stat9, stat10, stat11, stat12, stat13, stat14 };
        const team = computed(() => context.root.$store.getters.getTeam2);
        function newStat1(newValue) {
            stat1.value = newValue; 
        }
        function newStat2(newValue) {
            stat2.value = newValue; 
        }
        function newStat3(newValue) {
            stat3.value = newValue; 
        }
        function newStat4(newValue) {
            stat4.value = newValue; 
        }
        function newStat5(newValue) {
            stat5.value = newValue; 
        }
        function newStat6(newValue) {
            stat6.value = newValue; 
        }
        function newStat7(newValue) {
            stat7.value = newValue; 
        }
        function newStat8(newValue) {
            stat8.value = newValue; 
        }
        function newStat9(newValue) {
            stat9.value = newValue; 
        }
        function newStat10(newValue) {
            stat10.value = newValue; 
        }
        function newStat11(newValue) {
            stat11.value = newValue; 
        }
        function newStat12(newValue) {
            stat12.value = newValue; 
        }
        function newStat13(newValue) {
            stat13.value = newValue; 
        }
        function newStat14(newValue) {
            stat14.value = newValue; 
        }
        function calculateScore() {
            score.value = (stat1.value * team.value.offRtg) + (stat2.value * team.value.defRtg) + (stat3.value * team.value.pace)
            + (stat4.value * team.value.ftRate) + (stat5.value * team.value.threeFgTrend) + (stat6.value + team.value.tsPercent)
            + (stat7.value * team.value.efgPercent) + (stat8.value * team.value.toPercent) + (stat9.value + team.value.offRebPercent)
            + (stat10.value * team.value.ftFga) + (stat11.value * team.value.efgPercentAllow) + (stat12.value * team.value.toPercentAllow)
            + (stat13.value * team.value.defRebPercentAllow) + (stat14.value * team.value.ftFgaAllow);
            context.emit('score2', score.value);
        }
        const nStats = {newStat1, newStat2, newStat3, newStat4, newStat5, newStat6, newStat7, newStat8, newStat9, newStat10, newStat11, newStat12, newStat13, newStat14};
        return { team, score, ...stats, ...nStats, calculateScore};
    }
    // data() {
    //     return {
    //         stat1: 1,
    //         stat2: 1,
    //         stat3: 1,
    //         stat4: 1,
    //         stat5: 1,
    //         stat6: 1,
    //         stat7: 1,
    //         stat8: 1,
    //         stat9: 1,
    //         stat10: 1,
    //         stat11: 1,
    //         stat12: 1,
    //         stat13: 1,
    //         stat14: 1,
    //         score: 0
    //     }
    // },
    // computed: {
    //     team: function() {
    //         return this.$store.getters.getTeam2;  
    //     }
    // },
    // methods: {
    //     newStat1(value) {
    //         this.stat1 = value;
    //         console.log(this.stat1);
    //     },
    //     newStat2(value) {
    //         this.stat2 = value;
    //         console.log(this.stat2);
    //     },
    //     newStat3(value) {
    //         this.stat3 = value;
    //         console.log(this.stat3);
    //     },
    //     newStat4(value) {
    //         this.stat4 = value;
    //         console.log(this.stat4);
    //     },
    //     newStat5(value) {
    //         this.stat5 = value;
    //         console.log(this.stat5);
    //     },
    //     newStat6(value) {
    //         this.stat6 = value;
    //         console.log(this.stat6);
    //     },
    //     newStat7(value) {
    //         this.stat7 = value;
    //         console.log(this.stat7);
    //     },
    //     newStat8(value) {
    //         this.stat8 = value;
    //         console.log(this.stat8);
    //     },
    //     newStat9(value) {
    //         this.stat9 = value;
    //         console.log(this.stat9);
    //     },
    //     newStat10(value) {
    //         this.stat10 = value;
    //         console.log(this.stat10);
    //     },
    //     newStat11(value) {
    //         this.stat11 = value;
    //         console.log(this.stat11);
    //     },
    //     newStat12(value) {
    //         this.stat12 = value;
    //         console.log(this.stat12);
    //     },
    //     newStat13(value) {
    //         this.stat13 = value;
    //         console.log(this.stat13);
    //     },
    //     newStat14(value) {
    //         this.stat14 = value;
    //         console.log(this.stat14);
    //     },
    //     calculateScore(){
    //         this.score = (this.stat1 * this.team.offRtg) + (this.stat2 * this.team.defRtg) + (this.stat3 * this.team.pace)
    //         + (this.stat4 * this.team.ftRate) + (this.stat5 * this.team.threeFgTrend) + (this.stat6 + this.team.tsPercent)
    //         + (this.stat7 * this.team.efgPercent) + (this.stat8 * this.team.toPercent) + (this.stat9 + this.team.offRebPercent)
    //         + (this.stat10 * this.team.ftFga) + (this.stat11 * this.team.efgPercentAllow) + (this.stat12 * this.team.toPercentAllow)
    //         + (this.stat13 * this.team.defRebPercentAllow) + (this.stat14 * this.team.ftFgaAllow);
    //         this.$emit('score2', this.score);
    //     }
    // }
};
</script>