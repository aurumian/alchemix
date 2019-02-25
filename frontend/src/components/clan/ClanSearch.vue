<template>
    <div id="main">
        <div align="center" id="search">
            <input id="bar" type="text" ref="query"/> <button v-on:click="getClans">Search</button>
        </div>
        <clan-join imgsrc="../assets/OrangeConePotionSmall.png" v-for="c in clans" :clan="c" ></clan-join>
    </div>
</template>

<script>
    import ClanJoin from "./ClanJoin";
    import axios from 'axios'
    import Clan from '../../model/clan'

    export default {
        name: "ClanSearch",
        components: {ClanJoin},
        data(){
            return{
                clans: Clan[0]
            }
        },
        methods:{
            getClans(){

                let query = this.$refs.query.value;

                axios.get("/api/clan/get", {
                    params:{
                        query
                    }
                }).then( resp => {
                    if (resp.status === 200)
                        this.clans = resp.data;
                })
            }
        },
        mounted(){
            this.getClans();
        }
    }
</script>

<style scoped>
    #search{
        margin-top: 20px;
        margin-bottom: 20px;
        width: 780px;
        height: 70px;
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
    #bar{
        width:400px;
    }
    button:hover{
        background: red;
    }

    #search[class~=mobile]{
        width: 100%;
    }

    #search[class~=mobile] input{
        width: 50%;
    }
</style>