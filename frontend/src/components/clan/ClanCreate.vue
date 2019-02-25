<template>
    <div id="main" align="center">
        <br/>
        Create Clan
        <br/>
        <hr/>
        Choose Clan Name: <input type="text" class="myInput" placeholder=" NAME" ref="name"/>
        <br/>
        Clan Image: <input type="file" id="file" ref="file" align="center">
        <br>
        <button class="myButton" v-on:click="submitForm">Create Clan</button>
        <br/>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "ClanCreate",
        data(){
            return {
                file: '',
                uploadPercentage: 0
            }
        },
        methods:{
            submitForm(){
                if (this.$refs.name.value === '')
                    return;

                //Initialize form data
                let formData = new FormData();

                //Add file to form data
                formData.append('file', this.$refs.file.files[0]);
                formData.append('name', this.$refs.name.value);

                //check file's format


                //Make POST request
                axios.post("/api/clan/create",
                    formData,
                    {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        }
                    }
                ).then(() =>{
                    //Some handling code
                    window.Store.update();
                })
                    .catch(()=>{
                        //Some handling code

                    })
            }
        }
    }
</script>

<style scoped>
    #main{
        margin-bottom: 20px;
        width: 780px;
        height: 270px;
        background: #ffcccc;
    }
    .myButton, button, .myInput{
        background-color: rgba(255, 1, 0, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        margin: 15px;

        height: 35px;
        text-align: center;
    }
    div, input{
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        vertical-align: center;
    }
    input{
        margin: 20px;
    }
    hr{
        border: 0;
        height: 3px;
        background: #ffcccc;
        background-image: linear-gradient(to right, rgba(255, 204, 204, 0.71), rgba(128, 0, 0, 0.77), rgba(255, 204, 204, 0.69));
    }
    button:hover{
        background: red;
    }
</style>