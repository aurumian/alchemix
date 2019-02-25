<template>
    <div id="invent">
        <div id="inimg">
            <img :src="imgsrc">
        </div>
        <div id="iname">
            {{this.name}} x{{this.quantity}}   Tier : {{tier}}
        </div>
        <div id="money">
              Price:
            <br/>
            {{price}}
        </div>
        <div id="describe">
            {{description}}
        </div>
        <div id="but">
            <button>
                Buy
            </button>
        </div>
        <div id="quantityButs">
            <quantity-counter value="0"></quantity-counter>
        </div>
    </div>
</template>

<script>
    import QuantityCounter from "./QuantityCounter";
    export default {
        name: "MarketItem",
        components: {QuantityCounter},
        props: {
            imgsrc: String,
            name: String,
            quantity: Number,
            description: String,
            tier: Number,
            price: Number,
            quantityBut: Number
        }
    }
</script>

<style scoped>
    #money{
        grid-area: price;
        font-family: fantasy;
        font-size: 26px;
        color: #7b0009;

    }
    #iname{
        grid-area: name;
        font-family: fantasy;
        font-size: 26px;
        color: #7b0009;
        text-align: left;
        margin-top: 10px;
    }
    #describe{
        grid-area: description;
        font-family: fantasy;
        font-size: 26px;
        color: #a0615f;
        text-align: left;
    }
    #quantityButs{
        grid-area: quantityButs;
    }
    img{
        margin: 10px;
        border-radius: 50%;
        width: 200px;
    }
    #inimg{
        grid-area: image;
    }
    #but{
        align-items: center;
        grid-area: button;
    }
    #invent{
        margin-bottom: 20px;
        width: 780px;
        height: 220px;
        background: #ffcccc;
        display: grid;
        grid-template-columns: 220px 380px  auto ;
        grid-row-gap: 10px;
        grid-column-gap: 15px;
        grid-template-rows: auto 50px 70px;
        grid-template-areas:
                'image name quantityButs '
                'image description price '
                'image . button ';
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