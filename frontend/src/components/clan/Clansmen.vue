<template>
    <div id="main">
        <clansman username="bl4ze"></clansman>
        <clansman username="bl4ze"></clansman>
        <clansman username="bl4ze"></clansman>
    </div>
</template>

<script>
    import Clansman from "./Clansman";
    export default {
        name: "Clansmen",
        components: {Clansman}
    }
</script>

<style scoped>
    #main{
        margin-bottom: 20px;
        width: 250px;
        height: auto;
        background: #ffcccc;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        padding-top: 10px;
        padding-bottom: 10px;
    }
</style>