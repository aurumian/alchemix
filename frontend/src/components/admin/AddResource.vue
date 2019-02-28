<template>
    <div>
        <table>
            <tr>
                <td>
                    Name:
                </td>
                <td>
                    <input type="text" ref="name">
                </td>
            </tr>
            <tr>
                <td>
                    Description:
                </td>
                <td>
                    <input type="text" ref="descript">
                </td>
            </tr>
            <tr>
                <td>
                    Tier:
                </td>
                <td>
                    <input type="number" ref="tier" min="1">
                </td>
            </tr>
            <tr>
                <td>
                    ImageId:
                </td>
                <td>
                    <input type="number" ref="imageId" min="1">
                </td>
            </tr>
            <tr>
                <td>
                    AssetName:
                </td>
                <td>
                    <input type="text" ref="abId">
                </td>
            </tr>
        </table>
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
                axios.post('/admin/api/resource/create', resource).then(()=>{

                }).catch((err)=>{
                    alert(err);
                })
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