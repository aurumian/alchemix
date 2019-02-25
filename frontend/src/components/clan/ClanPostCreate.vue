<template>
    <div id="main">
        <div align="center">
            <input id="bar" type="text" ref="text"/>
            <button  v-on:click="clicked">Post</button>
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "ClanPostCreate",
        props:{
            callback: Function
        },
        methods:{
            clicked(){
                let formData = new FormData();

                formData.append('text', this.$refs.text.value);

                axios.post("/api/clan/post", formData).then(resp =>{
                    if (resp.status === 200)
                        if (this.callback)
                        this.callback(resp.data);
                })
            }
        }
    }
</script>

<style scoped>
    #main{
        margin-top: 20px;
        width: 510px;
        height: 65px;
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
    input{
        width: 300px;
    }
    button:hover{
        background: red;
    }
</style>