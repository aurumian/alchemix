<template>
    <div id="main1">
        <div id="bar">
            <div id="image">
                <img src="../../assets/GreenConePotionSmall.png">
            </div>
            <div id="name" >
                {{username}}
            </div>

        </div>
    </div>
</template>

<script>
    export default {
        name: "Clansman",
        props: {
            username: String,
            imageId: Number
        }
    }
</script>

<style scoped>
    #main1{
        margin: 10px;
        width: 200px;
        height: 50px;
        background: #ff9797;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        padding-bottom: 5px;
    }

    #image{
        grid-area: image;
    }
    #name{
        grid-area: name;
        text-align: left;
        height: 40px;
        margin-top: 14px;
        margin-left: 3px;
    }

    #bar{
        display: grid;
        grid-template-columns: 60px auto;
        grid-template-areas:
                'image name';
    }
    img{
        width: 40px;
        border-radius: 50%;

        margin: 5px;
        margin-left: 15px;
        margin-bottom: 0;
    }
</style>