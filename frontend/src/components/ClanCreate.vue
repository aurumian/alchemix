<template>
    <div id="main" align="center">
        <br/>
        Create Clan
        <br/>
        Choose Clan Name: <input type="text" class="myInput" placeholder=" NAME"/>
        <br/>
        Clan Image: <input type="file" id="file" ref="file" v-on:change="handleFileUpload" align="center">
        <br>
        <button class="myButton" v-on:click="submitFile">Create Clan</button>
    </div>
</template>

<script>
    export default {
        name: "ClanCreate",
        props:[
            'uploadUrl'
        ],
        data(){
            return {
                file: '',
                uploadPercentage: 0
            }
        },
        methods:{
            handleFileUpload(){
                this.file = this.$refs.file.files[0];
            },
            submitFile(){
                //Initialize form data
                let formData = new FormData();

                //Add file to form data
                formData.append('file', this.file);

                //check file's format


                if (this.uploadUrl === '')
                    this.uploadUrl = '/api/image/upload';

                //Make POST request
                axios.post(this.uploadUrl,
                    formData,
                    {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        },
                        onUploadProgress: (progressEvent) => {
                            this.uploadPercentage = parseInt(Math.round((progressEvent.loaded * 100)/ progressEvent.total));
                        }
                    }
                ).then(() =>{
                    //Some handling code
                    console.log('Success');
                })
                    .catch(()=>{
                        //Some handling code
                        console.log('Failed to upload file')
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
</style>