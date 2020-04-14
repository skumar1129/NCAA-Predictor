<template>
    <div class="form-group">
        <label class="label mr-2" for="off_rtg">Offensive Rating: </label>
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

export default {
    name: "Stat1",
    data() {
        return {
            stat: 1
        }
    },
    methods: {
        emitStat() {
            this.$emit('stat1',this.stat)
        }
    }
};
</script>

<style scoped>
    .label {
        font-size: large;
    }
</style>