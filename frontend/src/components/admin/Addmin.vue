<template>
    <div align="center">
        <input class="input_field" type="text" ref="username" placeholder=" username">
        <br/>
        <input class="input_field" type="password" ref="password"  placeholder=" password">
        <br/>
        <input type="button" value="Addmin" v-on:click="attemptSignup">
    </div>
</template>

<script>
    import axios from 'axios';

    export default {
        name: "Addmin",
        methods:{
            attemptSignup(){
                let formData = new FormData();

                formData.append("username",this.$refs.username.value);
                formData.append("password",this.$refs.password.value);

                axios.post("/admin/api/addmin",
                    formData
                ).then((resp) =>{
                    if (resp.status === 200){

                        }
                    }

                ).catch(err =>{

                });
            }
        }
    }
</script>

<style scoped>
    div{
        background: rgba(8, 0, 255, 0.38);
        width: 800px;
        font-family: fantasy;
        font-size: 22px;
        color: #000d7b;

    }
    #welcome{
        height: 50px;
        horiz-align: center;
        vertical-align: center;
        font-size: 28px;
        text-align: center;
        text-align-all: center;
    }
    input{
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
</style>