<template>
    <div>
        ResourceId: <input type="number" min="1" ref="resource"/>
        <br>
        Quantity: <input type="number" min="1" ref="quantity"/>
        <br>
        Price: <input type="number" min="1" ref="price"/>
        <br>
        <button v-on:click="putOnSale">Put On Sale</button>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "PutResourceOnSale",
        methods:{
            putOnSale(){
                //validate data ...

                //put data
                let formData = new FormData();
                formData.append("resourceId", this.$refs.resource.value);
                formData.append("quantity", this.$refs.quantity.value);
                formData.append("price", this.$refs.price.value);

                //make request
                axios.post("/admin/api/resource/putOnSale", formData);

            }
        }
    }
</script>

<style scoped>

</style>