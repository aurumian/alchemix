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
                axios.post('/image',
                    formData,
                    {
                        headers: {
                            'Content-Type': 'multipart/form-data'
                        },
                        onUploadProgress: (progressEvent) => {
                            this.uploadPercentage = parseInteger(Math.round((progressEvent.loaded * 100)/ progressEvent.total));
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