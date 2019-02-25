<template>
    <div id="main">
        <div id="buttons">
            <router-button text="Resources" to="/fullinventory/inventory"></router-button>
            <router-button text="Recipes" to="/fullinventory"></router-button>
        </div>
        <div id="tab">
            <router-view></router-view>
        </div>
    </div>
</template>

<script>
    import RouterButton from "./RouterButton";
    export default {
        name: "FullInventory",
        components: {RouterButton}
    }
</script>

<style scoped>
    button{
        background-color: rgba(255, 1, 0, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        margin: 15px;
        width: 140px;
        height: 35px;
    }
    button:hover{
        background-color: red;
    }
</style>