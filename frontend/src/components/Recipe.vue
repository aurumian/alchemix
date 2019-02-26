<template>
    <div id="main">
        <div id="inimg">
            <img src="../assets/IndigoConePotionSmall.png">
        </div>
        <div id="iname">
            {{this.name}}   Tier : {{tier}}
        </div>
        <div id="describe">
            <resource-instance :tier="1" name="icy water" :quantity="2"></resource-instance>
            <resource-instance :tier="1" name="icy water" :quantity="2"></resource-instance>
            <resource-instance :tier="1" name="icy water" :quantity="2"></resource-instance>
            <resource-instance :tier="1" name="icy water with ice" :quantity="2"></resource-instance>
            <resource-instance :tier="1" name="icy water" :quantity="2"></resource-instance>
            <resource-instance :tier="1" name="icy water" :quantity="2"></resource-instance>
            <resource-instance :tier="1" name="icy water" :quantity="2"></resource-instance>
            <resource-instance :tier="1" name="icy water with ice" :quantity="2"></resource-instance>


        </div>
    </div>
</template>

<script>
    import ResourceInstance from "./ResourceInstance";
    export default {
        name: "Recipe",
        components: {ResourceInstance},
        props: {
            imgsrc: String,
            name: String,
            description: String,
            tier: Number
        }
    }
</script>

<style scoped>
    #iname{
        grid-area: name;
        font-family: fantasy;
        font-size: 26px;
        color: #7b0009;
        text-align: left;
        margin-top: 10px;
    }
    #describe{
        display: flex;
        flex-wrap: wrap;
        overflow: scroll;
        max-height: 150px;
        max-width: 500px;
        grid-area: description;
        font-family: fantasy;
        font-size: 26px;
        color: #a0615f;
        text-align: left;
    }
    #describe::-webkit-scrollbar{
        display: none;
    }


    img{
        margin: 10px;
        border-radius: 50%;
        width: 200px;
    }
    #inimg{
        grid-area: image;
    }
    #main{
        margin-bottom: 20px;
        width: 780px;
        height: 220px;
        background: #ffcccc;
        display: grid;
        grid-template-columns: 220px 540px;
        grid-row-gap: 10px;
        grid-column-gap: 15px;
        grid-template-rows: auto 170px;
        grid-template-areas:
                'image name '
                'image description';
    }
    button, input{
        background-color: rgba(255, 1, 0, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        margin: 15px;
        width: 100px;
        height: 35px;
        text-align: center;
    }
    #main[class~=mobile]{
        margin-bottom: 20px;
        width: 90%;
        height: auto;
        background: #ffcccc;
        display: grid;
        grid-template-columns: auto;
        grid-row-gap: 10px;
        grid-column-gap: 15px;
        grid-template-rows: 220px 50px auto;
        grid-template-areas:
                'image '
                'name '
                'description';
    }
    #iname[class~=mobile]{
        text-align: center;
    }
</style>