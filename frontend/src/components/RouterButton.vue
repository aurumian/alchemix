<template>
    <router-link :to="to" class="routerlink">{{text}}</router-link>
</template>

<script>
    export default{
        name: "RouterButton",
        props: [
            'to',
            'text'
        ]
    }
</script>

<style scoped>
    .routerlink{
        display: block;
        font-family: fantasy;
        font-size: 24px;
        text-decoration: none;
        border-radius: 3px;
        background-color: red;
        color: #570a0a;
        width: 140px;
        margin-bottom: 10px;
        margin-top: 10px;
    }
    .router-link-exact-active{
        text-decoration: none;
        background-color: #ff6662;

    }
</style>