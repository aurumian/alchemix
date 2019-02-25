<template>
    <div id="main1">
            <div id="bar">
                <div id="image">
                    <img src="../assets/GreenConePotionSmall.png">
                </div>
                <div id="tier">
                    Tier: {{tier}}
                </div>
                <div id="name" >
                    {{name}} x {{quantity}}
                </div>



            </div>
        </div>
</template>

<script>
    export default {
        name: "ResourceInstance",
        props: {
            name: String,
            imageId: String,
            tier: Number,
            quantity: Number
        }
    }
</script>

<style scoped>
    #main1{
        margin: 10px;
        width: 130px;
        height: 100px;
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
        margin-left: 5px;
    }
    #tier{
        margin-top: 14px;
        grid-area: tier;
    }

    #bar{
        display: grid;
        grid-template-columns: 60px auto;
        grid-template-areas:
                'image tier'
                'name name';
    }
    img{
        width: 40px;
        border-radius: 50%;

        margin: 5px;
        margin-bottom: 0;
    }
</style>