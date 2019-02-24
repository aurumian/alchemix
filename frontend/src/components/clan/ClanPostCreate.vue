<template>
    <div id="main">
        <div align="center" id="search">
            <input id="bar" type="text"/>
            <button>Post</button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "ClanPostCreate"
    }
</script>

<style scoped>
    #main{
        margin-top: 20px;
        margin-bottom: 20px;
        width: 510px;
        height: 50px;
        background: #ffcccc;
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
    input{
        width: 300px;
    }
    button:hover{
        background: red;
    }
</style>