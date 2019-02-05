<template>
    <div id="inventor">
        <inventory-item v-for="entry in items" :imgsrc='"/api/image/" + entry.imageId' :name="entry.name" :quantity="entry.quantity" :description="entry.description" :tier="entry.tier"></inventory-item>
        </div>
</template>

<script>
    import axios from 'axios'
    import InventoryItem from "./InventoryItem";
    export default {
        name: "Inventory",
        data(){
            return{
                items: []
            }
        },
        components: {InventoryItem},
        methods:{
            getItems(){
                axios.get("/api/inventory").then((resp)=>{
                    if (resp.status === 200)
                    this.items = resp.data;
                    else alert("Could not fetch data");
                })
            }
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

</style>