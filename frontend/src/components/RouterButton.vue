<template>
    <button v-on:click="$router.push(to)">{{text}}</button>
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

<style>

</style>