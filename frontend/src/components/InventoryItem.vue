<template>
    <div id="invent">
        <div id="inimg">
            <img :src="'/api/image/' + inventoryResource.imageId">
        </div>
        <div id="iname">
            {{inventoryResource.name}} x {{inventoryResource.quantity}}   Tier : {{inventoryResource.tier}}
        </div>
        <div id="money">
            <input type="number" placeholder="Price" ref="price"/>
        </div>
        <div id="quantityButs">
            <quantity-counter ref="count" :min="1" v-model="quantity" :max="inventoryResource.quantity"></quantity-counter>
        </div>
        <div id="describe">
            {{inventoryResource.description}}
        </div>
        <div id="but">
            <button @click="sell">
                Sell
            </button>
        </div>
    </div>
</template>

<script>
    import QuantityCounter from "./input/QuantityCounter";
    import axios from 'axios'
    export default {
        name: "InventoryItem",
        components: {QuantityCounter},
        data(){
            return{
                quantity: 1
            }
        },
        props: {
            inventoryResource: {},
            callback: Function
        },
        methods:{
            sell(){
                if (!this.$refs.price.value)
                    return;

                let formData = new FormData();
                formData.append('resourceId', this.inventoryResource.resourceId);
                formData.append('price', this.$refs.price.value);
                formData.append('quantity', this.quantity);

                axios.post("/api/shop/putOnSale", formData).then(resp => {
                    if (resp.status === 200){
                        let item = {
                            resourceId: this.inventoryResource.resourceId,
                            newQuantity: resp.data
                        };
                        this.$parent.updateAfterSell(item);
                    }
                })
            }
        }
    }
</script>

<style scoped>
    #quantityButs{
        grid-area: quantityButs;
    }
    #money{
        grid-area: price;
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
    #invent[class~=mobile]{
        width: 90%;
        height: auto;
        margin-left: 5%;
        margin-right: 5%;
        grid-template-columns: auto ;
        grid-row-gap: 10px;
        grid-column-gap: 15px;
        grid-template-areas:
                'image '
                'name '
                'description'
                'quantityButs'
                'price'
                'button';
    }
    #but[class~=mobile] button, input{
        margin-top:0;
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
    #iname[class~=mobile]{
        text-align: center;
    }
    #describe[class~=mobile]{
        text-align: center;
    }
</style>