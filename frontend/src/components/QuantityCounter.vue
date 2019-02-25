<template>
    <div id="quantityButs">
        <button class="smallBut" v-on:click="dec()">
            -
        </button>
        <button class="smallBut" id="qua">
            {{value}}
        </button>
        <button class="smallBut" v-on:click="inc()">
            +
        </button>
    </div>
</template>

<script>
    export default {
        name: "QuantityCounter",
        props: {
            value: Number
        },
        methods: {
            inc(){
                this.value++;
            },
            dec(){
                if (this.value <= 0) return;
                this.value--;
            }
        }
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
    .smallBut{
        width: 30px;
        margin: 2px;
        margin-top: 20px;
    }
    button:hover{
        background: red;
    }
    #qua:hover{
        background: rgba(255, 1, 0, 0.4);
    }
    #qua:focus{
        outline: none;
    }
</style>