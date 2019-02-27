<template>
    <div id="main">
        <div id="search" align="center">
            <input type="text" id="bar" placeholder="Type here to search" ref="filterKey" v-on:input="handleInput">
        </div>
        <div id="recipeList">
            <recipe v-for="recipe in items" :recipe="recipe"></recipe>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    import Recipe from "./Recipe";
    export default {
        name: "Recipes",
        props:{
            url:{
                default: "/api/inventory/my-recipes"
            },
            displayId:{
                default: false
            }
        },
        data(){
            return{
                items: [],
                filterKey: ""
            }
        },
        components: {Recipe},
        methods:{
            getItems(){
                axios.get(this.url).then((resp)=>{
                    if (resp.status === 200)
                        this.items = resp.data;
                })

            },
            handleInput(){
                this.filterKey = this.$refs.filterKey.value;
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
        width: 400px;
    }

    #search[class~=mobile]{
        width: 100%;
    }

    #search[class~=mobile] input{
        width: 80%;
    }
</style>