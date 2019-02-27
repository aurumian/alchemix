<template>
    <div>
        <div id="search" align="center">
            <input type="text" id="bar" placeholder="Type here to search" ref="filterKey" v-on:input="handleInput">
        </div>
        <div id="inventor">
            <inventory-item v-for="entry in filteredItems" :inventory-resource="entry" :key="entry.resourceId"></inventory-item>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import InventoryItem from "./InventoryItem";
    export default {
        name: "Inventory",
        data(){
            return{
                items: [],
                filterKey: ""
            }
        },
        components: {InventoryItem},
        methods:{
            getItems(){
                axios.get("/api/inventory/my-resources").then((resp)=>{
                    if (resp.status === 200)
                    this.items = resp.data;
                    else alert("Could not fetch data");
                })

            },
            handleInput(){
                this.filterKey = this.$refs.filterKey.value;
            },
            updateAfterSell(item){
                if (item.newQuantity < 0)
                    return;

                for (let i = 0; i < this.items.length; i++)
                    if (this.items[i].resourceId === item.resourceId){
                        if (item.newQuantity === 0)
                        //remove from items
                            this.items.splice(i, 1);
                        else
                            this.items[i].quantity = item.newQuantity;
                        return;
                    }
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
    #inventor[class~=mobile]{
        max-height: 100%;
    }

    #search{
        margin-bottom: 20px;
        width: 780px;
        height: 70px;
        background: #ffcccc;
    }
    #search[class~=mobile]{
        width: 100%;
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

    #search[class~=mobile] input{
        width: 80%;
    }

</style>