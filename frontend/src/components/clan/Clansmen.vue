<template>
    <div id="main">
        <clansman v-for="clansman in clansmen" :username="clansman.username" :image-id="clansman.imageId"></clansman>
    </div>
</template>

<script>
    import Clansman from "./Clansman";
    import axios from 'axios'
    export default {
        name: "Clansmen",
        components: {Clansman},
        data(){
            return {
                clansmen: []
            }
        },
        mounted(){
            axios.get("/api/clan/clansmen").then(resp =>{
                if (resp.status === 200)
                    this.clansmen = resp.data;
            })
        }
    }
</script>

<style scoped>
    #main{
        margin-bottom: 20px;
        width: 250px;
        height: auto;
        background: #ffcccc;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        padding-top: 10px;
        padding-bottom: 10px;
    }

    #main[class~=mobile]{
        width: 100%;
        margin-bottom: 0;
        max-height: 150px;
        overflow: scroll;
    }
    #main[class~=mobile]::-webkit-scrollbar{
        display: none;
    }
</style>