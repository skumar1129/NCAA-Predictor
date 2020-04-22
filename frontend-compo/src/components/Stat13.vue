<template>
    <div class="form-group">
        <label class="label mr-2" for="defRebPercentAllow">Defensive Rebounding Percentage Allowed:</label>
        <select v-model="stat" @change="emitStat">
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
            <option>6</option>
            <option>7</option>
            <option>8</option>
            <option>9</option>
            <option>10</option>
        </select>
    </div>
</template>

<script lang="ts">
import { ref } from '@vue/composition-api';
export default {
    name: "Stat13",
    setup(props, context) {
        const stat = ref(1);
        function emitStat() {
            context.emit('stat13', stat.value);
        }
        return { stat, emitStat };
    }
    // data() {
    //     return {
    //         stat: 1
    //     }
    // },
    // methods: {
    //     emitStat() {
    //         this.$emit('stat13',this.stat)
    //     }
    // }
};
</script>

<style scoped>
    .label {
        font-size: large;
    }
</style>