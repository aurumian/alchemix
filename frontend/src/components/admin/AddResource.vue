<template>
    <div>
        Name:<input type="text" ref="name">
        <br><br>
        Description:<input type="text" ref="descript">
        <br><br>
        Tier:<input type="text" ref="tier">
        <br><br>
        ImageId:<input type="text" ref="imageId">
        <br><br>
        AssetBundleId<input type="text" ref="abId">
        <br><br>
        <button v-on:click="addResource">Add</button>

    </div>
</template>

<script>
    import axios from 'axios'
    import Resource from '../../model/resource'

    export default {
        name: "AddResource",
        methods: {
            addResource(){
                //prepare data
                let formData = new FormData();
                let resource = new Resource(this.$refs.name.value, this.$refs.descript.value ,this.$refs.tier.value, this.$refs.imageId.value, this.$refs.abId.value);
                formData.append("resource", JSON.stringify(resource));


                //make post request
                axios.post('/api/resource/create', resource).then(()=>{

                }).catch((err)=>{
                    console.log(err);
                })
            }
        }
    }
</script>

<style scoped>
    div{
        background-color: #7a97db;
        horiz-align: center;
        padding: 15px;
    }
</style>