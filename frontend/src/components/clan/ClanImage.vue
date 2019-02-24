<template>
    <div>
        <img src="../../assets/VioletConePotionSmall.png">
    </div>
</template>

<script>
    export default {
        name: "ClanImage",
        props: {
            imgsrc: String
        }
    }
</script>

<style scoped>
    div{
        width: 250px;
        height: 250px;
        background: #ffcccc;
    }
    img{
        width: 230px;
        margin: 10px;
        border-radius: 5%;
    }
</style>