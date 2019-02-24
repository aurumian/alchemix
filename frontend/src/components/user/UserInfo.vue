<template>
    <div id="userBar">
        <div id="inimg">
            <img :src="'/api/image/' + user.imageId">
        </div>
        <div id="iname">
            {{user.username}}
        </div>
        <div id="money">
            {{user.money}}
        </div>
        <div id="role">
            {{user.role}}
        </div>
    </div>
</template>

<script>
    import axios from 'axios'
    //image name money role
    export default {
        name: "UserInfo",
        methods:{
            getUser(){
                axios.get("/api/user/info").then(resp => {
                    if (resp.status === 200){
                        Object.assign(this.user, resp.data);
                    }
                })
            }
        },
        created(){
            this.getUser();
        }
    }
</script>

<style scoped>
    #money{
        grid-area: money;
        font-family: fantasy;
        font-size: 20px;
        color: #ffffff;
        text-align: center;
        margin-top: 13px;
    }
    #iname{
        grid-area: name;
        font-family: fantasy;
        font-size: 22px;
        color: #ffffff;
        text-align: left;
        margin-top: 10px;
    }
    #role{
        grid-area: role;
        font-family: fantasy;
        font-size: 20px;
        color: #969696;
        text-align: left;
        vertical-align: center;
        margin-top: 13px;
    }
    img{
        margin: 5px;
        border-radius: 50%;
        width: 40px;
    }
    #inimg{
        grid-area: image;
    }
    #but{
        align-items: center;
        grid-area: button;
    }
    #userBar{
        width: 300px;
        height: 50px;

        display: grid;
        grid-template-columns:  50px auto auto 80px;
        grid-template-areas:
                'image name money role';
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
</style>