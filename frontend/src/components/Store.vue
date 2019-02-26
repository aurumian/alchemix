<template>
    <div>
        <div id="search" align="center">
            <input type="text" id="bar" placeholder="Type here to search" ref="filterKey" v-on:input="handleInput">
        </div>
        <div id="inventor">
            <market-item v-for="entry in filteredItems"  :store-resource="entry"></market-item>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import MarketItem from "./MarketItem";
    export default {
        name: "Store",
        data(){
            return{
                items: [],
                filterKey: ""
            }
        },
        components: {MarketItem},
        methods:{
            getItems(){
                axios.get("/api/shop/store").then((resp)=>{
                    if (resp.status === 200)
                    this.items = resp.data;
                })
            },
            handleInput(){
                this.filterKey = this.$refs.filterKey.value;
            },
            updateAfterPurchase(item){
                if (item.newQuantity < 0)
                    return;
                if (item.newQuantity == 0)
                    //remove from items
                    this.items
            }
        },
        computed:{
            filteredItems(){
                let filterKey = this.filterKey && this.filterKey.toLowerCase();
                let items = this.items;

                if (filterKey && filterKey !== ''){
                    items = items.filter(item =>{
                        return item.name.toLowerCase().indexOf(filterKey) > -1;
                    })
                }

                return items;
            }
        },
        mounted(){
            this.getItems();
        }
    }
</script>

<style scoped>
    #inventor{
        max-height: 680px;
        overflow: scroll;
    }
    #inventor::-webkit-scrollbar{
        display: none;
    }

    #search{
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

    #search[class~=mobile]{
        width: 100%;
    }

    #search[class~=mobile] input{
        width: 80%;
    }

</style>