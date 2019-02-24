<template>
    <div class="bar">
        <div class="logo">
            <img src="../../assets/logoSmall.png" v-on:click="getUser()">

        </div>
        <div id="userBar">
            <user-info ></user-info>
        </div>

    </div>
</template>

<script>
    import UserInfo from "./UserInfo"

    export default {
        name: "PersonalBar",
        components: {UserInfo}
    }
</script>

<style scoped>
    .bar{
        position: fixed;
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