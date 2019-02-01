<template>
    <div>

        <div id="welcome">
            First time on AlcheMix?
        </div>
        <input class="input_field" type="text" placeholder=" login">
        <br/>
        <input class="input_field" type="password" placeholder=" password">
        <br/>
        <input type="submit" value="sign up">
    </div>
</template>

<script>
    export default {
        name: "Signup"
    }
</script>

<style scoped>
    div{
        background: rgba(255, 1, 0, 0.38);
        width: 330px;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
    }
    #welcome{
        height: 50px;
        horiz-align: center;
        vertical-align: center;
        font-size: 28px;
        text-align: center;
        text-align-all: center;
    }
    input{
        background-color: rgba(255, 1, 0, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
        margin: 15px;
        width: 300px;
        height: 35px;
    }
    .input_field{
        background: rgba(255,1,0,0.14);
    }
</style>