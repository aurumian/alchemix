<template>
    <div id="main">
        <div id="name">
            {{name}}
        </div>
        <hr/>
        <div id="describe">
            <span v-if="!user.isLeader">
                {{description}}
            </span>

            <span v-if="user.isLeader">
                <textarea :value="description" cols="30" rows="5" placeholder="Your clan description" ref="descr" v-on:change="descrChange"></textarea>
            </span>
        </div>



        <br/>
    </div>
</template>

<script>
    import axios from 'axios'
    export default {
        name: "ClanInfo",
        props:{
            description: String,
            name: String
        },
        methods:{
            descrChange(){

                let formData = new FormData();

                formData.append('description', this.$refs.descr.value);

                axios.post('/api/clan/descript', formData).then(resp =>{

                }).catch(err =>{
                    this.$refs.descr.value = this.description;
                })
            }
        }
    }
</script>

<style scoped>
    #main{
        width: 510px;
        height: 250px;
        background: #ffcccc;
        font-family: fantasy;
        font-size: 26px;
        color: #7b0009;

    }
    #name{
        text-align: center;
        height: 25px;
    }
    #describe{
        font-family: fantasy;
        font-size: 26px;
        color: #7b4447;
        height: 200px;
    }

    hr{
        border: 0;
        height: 3px;
        background: #ffcccc;
        background-image: linear-gradient(to right, rgba(255, 204, 204, 0.71), rgba(128, 0, 0, 0.77), rgba(255, 204, 204, 0.69));
    }

    textarea{
        background-color: inherit;
        border: none;
        font-family: fantasy;
        font-size: 26px;
        color: inherit;
    }
    textarea:focus{
        outline: none;
        border: solid 2px #c66a63;
        border-radius: 5px;
    }

</style>