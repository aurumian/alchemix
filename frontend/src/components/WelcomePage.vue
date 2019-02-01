<template>
    <div class="wpMain">
        <bar></bar>
        <div class="field" align="center">
            <div class="img">
                <img src="../assets/Viles.png">
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
    import Bar from "./Bar";
    export default {
        name: "WelcomePage",
        components: {Bar, Signup, Login}
    }
</script>

<style scoped>
    .wpMain{

    }
    .field{
        display: grid;
        grid-template-areas:
            'img login'
            'img login';
        width: 100%;
        height: 700px;
        background-image: linear-gradient(#ffe8ed, #ffcccc);
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