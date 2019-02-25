<template>
    <div id="item">
        <div id="inimg">
            <img :src="'/api/image/' + clan.imageId">
        </div>
        <div id="iname">
            {{this.clan.name}}
        </div>
        <div id="money">

        </div>
        <div id="describe">
            {{clan.description}}
        </div>
        <div id="but">
            <button v-on:click="joinClan">
                Join
            </button>
        </div>
    </div>
</template>

<script>
    import Clan from '../../model/clan.js'
    import axios from 'axios'

    export default {
        name: "ClanJoin",
        props: {
            clan: {}
        },
        methods:{
            joinClan(){
                //Initialize form data
                let formData = new FormData();

                //Add name to form data
                formData.append("name", this.clan.name);
                axios.post("/api/clan/join",
                    formData
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
    #money{
        grid-area: price;
    }
    #iname{
        grid-area: name;
        font-family: fantasy;
        font-size: 26px;
        color: #7b0009;
        text-align: left;
        margin-top: 10px;
    }
    #describe{
        grid-area: description;
        font-family: fantasy;
        font-size: 26px;
        color: #a0615f;
        text-align: left;
    }
    img{
        margin: 10px;
        border-radius: 50%;
        width: 200px;
    }
    #inimg{
        grid-area: image;
    }
    #but{
        align-items: center;
        grid-area: button;
    }
    #item{
        margin-bottom: 20px;
        width: 780px;
        height: 220px;
        background: #ffcccc;
        display: grid;
        grid-template-columns: 220px 380px  auto ;
        grid-row-gap: 10px;
        grid-column-gap: 15px;
        grid-template-rows: auto 50px 70px;
        grid-template-areas:
                'image name . '
                'image description . '
                'image . button ';
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
    #item[class~=mobile]{
        margin-bottom: 20px;
        width: 100%;
        height: auto;
        background: #ffcccc;
        display: grid;
        grid-template-columns: auto ;
        grid-row-gap: 10px;
        grid-template-areas:
                'image '
                ' name  '
                ' description  '
                ' button ';
    }

    #iname[class~=mobile]{
        text-align: center;
    }
    #describe[class~=mobile]{
        text-align: center;
    }
    #but[class~=mobile] button{
        margin: 0;
    }
</style>