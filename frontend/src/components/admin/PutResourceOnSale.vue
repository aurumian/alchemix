<template>
    <div>
        <table>
            <tr>
                <td>
                    ResourceId:
                </td>
                <td>
                    <input type="number" min="1" ref="resource"/>
                </td>
            </tr>
            <tr>
                <td>
                    Quantity:
                </td>
                <td>
                    <input type="number" min="1" ref="quantity"/>
                </td>
            </tr>
            <tr>
                <td>
                    Price:
                </td>
                <td>
                    <input type="number" min="1" ref="price"/>
                </td>
            </tr>
        </table>
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
    td{
        text-align: right;
    }
    div{
        background: rgba(8, 0, 255, 0.38);
        horiz-align: center;
        padding: 15px;
        font-family: fantasy;
        font-size: 22px;
        color: #05007b;
        margin-bottom: 20px;
    }
    button, input{
        background-color: rgba(1, 0, 255, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #03007b;
        margin: 5px;
        width: 200px;
        height: 35px;
    }
    button:hover{
        background: blue;
    }
    input{
        background: rgb(207, 212, 255);
    }
</style>