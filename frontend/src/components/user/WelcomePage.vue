<template>
    <div class="wpMain">

        <div class="field">
            <div class="myBar">
                <bar></bar>
            </div>
            <div class="img">
                <img src="../../assets/Viles.png">
            </div>
            <div class="login">
                <login></login>
                <br/>
                <signup></signup>
            </div>
        </div>
        <router-link to="/">To protoPage</router-link>
    </div>
</template>

<script>
    import Login from "./Login";
    import Signup from "./Signup";
    import Bar from "../Bar";
    export default {
        name: "WelcomePage",
        components: {Bar, Signup, Login}
    }
</script>

<style scoped>
    .wpMain{

    }
    .myBar{
        grid-area: header;
    }
    .img{
        grid-area: sidebar;
    }
    .login{
        grid-area: main;
    }
    .field{
        display: grid;
        grid-template-columns: auto 500px 500px auto;
        grid-template-areas:
            'header header header header'
            '. sidebar main .';
        width: 100%;
        height: 700px;

        margin: auto;
    }

    .img{

        margin-left: 30%;
    }
    .login{

        margin-right: 20%;
        margin-left: 0;
        margin-top: 20px;
    }

</style>