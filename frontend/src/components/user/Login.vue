<template>
    <div>
        <input class="input_field" type="text" ref="username" placeholder=" login">
        <br/>
        <input class="input_field" type="password" ref="password" placeholder=" password">
        <br/>
        <input type="button" value="log in" v-on:click="buttonClick">
    </div>
</template>

<script>
    import axios from 'axios'
    import AuthService from '../../services/AuthService'

    export default {
        name: "Login",
        methods:{
            buttonClick(){
                let formData = new FormData();
                formData.append("username",this.$refs.username.value);
                formData.append("password",this.$refs.password.value);

                this.attemptLogin(formData);

            },
            attemptLogin(formData){

                axios.post("/api/auth",
                            formData,
                )
                    .then((resp) => {
                        if (resp.status === 200) {
                            this.$router.push("/");
                        }
                    })
                    .catch((error) => {
                       //handle error
                        console.log(error);
                        if (error.response) {
                            alert("wrong credentials");
                        }
                    })
                ;


            }
        }
    }
</script>

<style scoped>
    div{
        background: rgba(255, 1, 0, 0.38);
        width: 330px;
    }
    input{
        background-color: rgba(255, 1, 0, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        margin: 15px;
        width: 300px;
        height: 35px;
    }
    .input_field{
        background: rgba(255,1,0,0.14);
    }
</style>