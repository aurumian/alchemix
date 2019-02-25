<template>
    <div id="main">
        <div id="menu">
            <router-button to="/clan" text="MyClan"></router-button>
            <router-button to="/fullinventory/inventory" text="MyInventory"></router-button>
            <router-button to="/craft" text="Craft"></router-button>
            <router-button to="/shop/market" text="Shop"></router-button>
            <button v-on:click="logout">Log Out</button>
        </div>
    </div>
</template>

<script>
    import RouterButton from './RouterButton'
    import axios from 'axios'
    export default {
        name: "SideMenu",
        components: {RouterButton},
        methods:{
            logout(){
                axios.get("/api/logout");
                this.$router.push("/login");
            }
        }
    }
</script>

<style scoped>
    #main{
        position: fixed;
        margin-top: 50px;
    }
    #menu{
        text-decoration:none;
        background: #ffcccc;
        width: 170px;
        font-size: 18px;
        margin-left: 16%;
    }
    #menu a{
        text-decoration: none;
        text-decoration-color: #7b0009;
    }
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