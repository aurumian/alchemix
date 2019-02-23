<template>
    <div id="userBar">
        <div id="inimg">
            <img :src="'/api/image/' + myUser.imageId">
        </div>
        <div id="iname">
            {{myUser.username}}
        </div>
        <div id="money">
            {{myUser.money}}
        </div>
        <div id="role">
            {{myUser.role}}
        </div>
    </div>
</template>

<script>
    import user from "../../model/user.js"
    //image name money role
    export default {
        name: "UserInfo",
        props: {myUser: user}
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
        text-align: right;
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
        grid-template-columns: 120px 50px  auto 80px;
        grid-template-areas:
                'name image money role';
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