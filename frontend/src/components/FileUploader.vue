<template>
    <div>
        File: <input type="file" id="file" ref="file" v-on:change="handleFileUpload">
        <br>
        <progress max="100" :value.prop="uploadPercentage"></progress>
        <br>
        <button v-on:click="submitFile ">Submit</button>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "FileUploader",
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

                //Make POST request
                axios.post('/api/image/upload',
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
    progress[value] {
        /* Reset the default appearance*/
        -webkit-appearance: none;
        appearance: none;

        width: 250px;
        height: 20px;
    }

    progress[value]::-webkit-progress-bar{
        background-color: #eee;
        border-radius: 2px;
        box-shadow: 0 2px 5px rgba(0,0,0,0.25) inset;
    }

    progress[value]::-webkit-progress-value {
        background-image:
            -webkit-linear-gradient(-45deg,
                                    transparent 33%, rgba(0,0,0, .1) 33%,
                                    rgba(0,0,0,.1)66%, transparent 66%),
            -webkit-linear-gradient(top,
                                rgba(255, 255, 255, .25),
                                rgba(0, 0, 0, .25)),
            -webkit-linear-gradient(left, #09c, #f44);

        border-radius: 2px;
        background-size: 35px 20px, 100% 100%, 100%, 100%;
    }
</style>