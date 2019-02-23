<template>
    <div>
        <addmin></addmin>
        <add-money></add-money>
    </div>

</template>

<script>

    import Addmin from "./Addmin";
    import AddMoney from "./AddMoney";
    export default {
        name: "AdminsPage",
        components: {AddMoney, Addmin}
    }
</script>

<style scoped>

</style>