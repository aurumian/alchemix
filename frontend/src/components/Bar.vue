<template>
    <div class="bar">
        <div class="logo">
            <img src="../assets/logoSmall.png">
        </div>

    </div>
</template>

<script>
    export default {
        name: "bar"
    }
</script>

<style scoped>
    .bar{
        margin: 0;
        padding: 0;
        background: red;
        width: 100%;
        height: 50px;
        max-height: 50px;
        align-self: flex-start;
    }
    .logo{
        margin-left: 15%;
        vertical-align: center;
    }
    img{

    }

</style>