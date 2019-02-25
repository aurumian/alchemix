<template>
    <div id="main">
        <div id="buttons">
            <router-button text="Market" to="/shop/market"></router-button>
            <router-button text="Store" to="/shop/store"></router-button>
        </div>
        <div id="tab">
            <router-view></router-view>
        </div>
    </div>
</template>

<script>

    import RouterButton from "./RouterButton";
    export default {
        name: "Shop",
        components: {RouterButton}
    }
</script>

<style scoped>
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
</style>