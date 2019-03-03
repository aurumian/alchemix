<template>
    <div>
        <header>Add resource to inventory</header>
        ResourceId: <input type="number" ref="rId"/>
        <br>
        Quantity: <input type="number" ref="quantity"/>
        <br>
        <button @click="addResource">
            Add
        </button>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "AddResourceToInventory",
        methods:{
            addResource(){
                let formData = new FormData();

                formData.append('resourceId', this.$refs.rId.value);
                formData.append('quantity', this.$refs.quantity.value);

                axios.post("/admin/api/inventory/add", formData).catch(err => {
                    alert("Couldn't add resource");
                    console.log(err);
                })
            }
        }
    }
</script>

<style scoped>
    div{
        background: rgba(8, 0, 255, 0.38);
        horiz-align: center;
        padding: 15px;
        font-family: fantasy;
        font-size: 22px;
        color: #05007b;
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