<template>
    <div id="main">
        Name: <input type="text" placeholder="Asset name" ref="name">
        <br>
        <button @click="createAsset">
            Create
        </button>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "AssetCreate",
        methods:{
            createAsset(){
                if (this.$refs.name.value){
                    let formData = new FormData();
                    formData.append('name', this.$refs.name.value);

                    axios.post('/admin/api/asset/create', formData).catch(err =>{
                            alert("couldn't create asset")
                        }
                    )
                }
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