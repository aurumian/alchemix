<template>
    <div id="invent">
        <div id="inimg">
            <img :src="'/api/image/' + storeResource.imageId">
        </div>
        <div id="iname">
            {{storeResource.name}} x{{storeResource.quantity<0?'&#8734;':storeResource.quantity}}   Tier : {{storeResource.tier}}
        </div>
        <div id="money">
              Price:
            <br/>
            {{storeResource.price*val}}
        </div>
        <div id="describe">
            {{storeResource.description}}
        </div>
        <div id="but">
            <button v-on:click="buy">
                Buy
            </button>
        </div>
        <div id="quantityButs">
            <quantity-counter v-model="val" :min="1" :max="storeResource.quantity<0?null:storeResource.quantity" ref="count"></quantity-counter>
        </div>
    </div>
</template>

<script>
    import QuantityCounter from "./input/QuantityCounter";
    import axios from 'axios'

    export default {
        name: "MarketItem",
        components: {QuantityCounter},
        data(){
            return{
                val: 1
            }
        },
        props: {
            storeResource: {}
        },
        methods:{
            buy(){

                if (this.user.money < this.val*this.storeResource.price) {
                    //user doesn't have enough money
                    return;
                }

                let formData = new FormData();
                formData.append('resourceId', this.storeResource.resourceId);
                formData.append('quantity', this.val);
                formData.append('sellerId', this.storeResource.sellerId);

                axios.post("/api/shop/buy", formData).then(resp => {
                    window.Store.update();
                })

            }
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