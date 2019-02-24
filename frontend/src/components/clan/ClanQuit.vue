<template>
    <div id="main" align="center">
        <button>
            Quit Clan
        </button>
    </div>
</template>

<script>
    export default {
        name: "ClanQuit"
    }
</script>

<style scoped>
    #main{
        background: #ffcccc;
        width: 250px;
        margin-top: 20px;
        margin-bottom: 20px;
    }
    button, input{
        background-color: rgba(255, 1, 0, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        margin: 15px;
        width: 220px;
        height: 35px;
        text-align: center;
    }
    button:hover{
        background: red;
    }
</style>