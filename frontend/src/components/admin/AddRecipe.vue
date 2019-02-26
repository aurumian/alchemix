<template>
    <div id="main">
        <div id="quantity">
            <quantity-counter :min="1" v-model="count"></quantity-counter>
        </div>
        <div id="resources">
            <resource-instance-form v-for="index in count"></resource-instance-form>
        </div>
        <div id="res">
            ResResourceID <input type="number"/>
        </div>
        <div id="but">
            <button>
                Add Recipe
            </button>
        </div>
    </div>
</template>

<script>
    import QuantityCounter from "../input/QuantityCounter";
    import ResourceInstanceForm from "./ResourceInstanceForm";
    export default {
        name: "AddRecipe",
        components: {ResourceInstanceForm, QuantityCounter},
        data(){
            return{
                count: 1
            }
        }
    }
</script>

<style scoped>

    #quantity{
        grid-area: quantity;
    }

    #resources{
        display: flex;
        flex-wrap: wrap;
        overflow: scroll;
        max-height: 150px;
        width: 520px;
        grid-area: resources;
        font-family: fantasy;
        font-size: 26px;
        color: #a0615f;
        text-align: left;
        padding-bottom: 20px;
    }
    #resources::-webkit-scrollbar{
        display: none;
    }
    #but{
        grid-area: but;
    }
    #res{
        grid-area: res;
    }

    #main{
        background: rgba(8, 0, 255, 0.38);
        width: 800px;
        font-family: fantasy;
        font-size: 22px;
        color: #000d7b;
        grid-template-columns: auto 100px;
        grid-template-areas:
                'res quantity'
                'resources resources'
                'but but';
    }

    #welcome{
        height: 50px;
        horiz-align: center;
        vertical-align: center;
        font-size: 28px;
        text-align: center;
        text-align-all: center;
    }
    input, button{
        background-color: rgba(6, 0, 255, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #000b7b;
        margin: 15px;
        width: 300px;
        height: 35px;
    }
    .input_field{
        background: rgb(207, 212, 255);
    }
    button:hover{
        background: blue;
    }
</style>