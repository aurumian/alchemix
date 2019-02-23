<template>
    <div class="bar">
        <div class="logo">
            <img src="../../assets/logoSmall.png">

        </div>
        <div id="userBar">
            <user-info :my-user="myUser"></user-info>
        </div>

    </div>
</template>

<script>
    import UserInfo from "./UserInfo";
    import user from "../../model/user.js";
    export default {
        name: "PersonalBar",
        components: {UserInfo},
        data(){
            return {
                myUser: new user("name", 2, 200, "ROLE_USER")
            }
        }
    }
</script>

<style scoped>
    .bar{
        display: grid;
        grid-template-columns: auto 200px 500px 300px auto;
        grid-template-areas:
        '. logo . userInf .';
        margin: 0;
        padding: 0;
        background: red;
        width: 100%;
        height: 50px;
        max-height: 50px;
        align-self: flex-start;
    }
    .logo{
        margin-left: 15%;
        vertical-align: center;
        grid-area: logo;
    }
    #userBar{
        grid-area: userInf;
    }
</style>