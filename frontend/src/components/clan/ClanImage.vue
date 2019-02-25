<template>
    <div>
        <img v-if="imageId" :src="'/api/image/' + imageId">
    </div>
</template>

<script>
    export default {
        name: "ClanImage",
        props: {
            imageId: Number
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