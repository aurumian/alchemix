<template>
    <div id="main">
        <div>

        </div>
        <clan-join imgsrc="../assets/OrangeConePotionSmall.png" cclan="getClan()"></clan-join>
    </div>
</template>

<script>
    import ClanJoin from "./ClanJoin";
    export default {
        name: "ClanSearch",
        components: {ClanJoin}
    }
</script>

<style scoped>

</style>