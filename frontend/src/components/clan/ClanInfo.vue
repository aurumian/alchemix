<template>
    <div id="main">
        <div id="name">
            Clan Info
        </div>
        <hr/>
        <duv id="describe">
            {{description}}
        </duv>

        <br/>
    </div>
</template>

<script>
    export default {
        name: "ClanInfo",
        props:{
            description: String
        }
    }
</script>

<style scoped>
    #main{
        width: 510px;
        height: 250px;
        background: #ffcccc;
        font-family: fantasy;
        font-size: 26px;
        color: #7b0009;

    }
    #name{
        vertical-align: center;
        text-align: center;
        height: 25px;
    }
    #describe{
        margin: 10px;
        font-family: fantasy;
        font-size: 26px;
        color: #7b4447;
        height: 200px;
    }

    hr{
        border: 0;
        height: 3px;
        background: #ffcccc;
        background-image: linear-gradient(to right, rgba(255, 204, 204, 0.71), rgba(128, 0, 0, 0.77), rgba(255, 204, 204, 0.69));
    }

</style>