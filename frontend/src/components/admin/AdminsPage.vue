<template>
    <div>
        <addmin></addmin>
        <add-money  class="marginBottom"></add-money>
        <add-resource-to-inventory></add-resource-to-inventory>
    </div>

</template>

<script>

    import Addmin from "./Addmin";
    import AddMoney from "./AddMoney";
    import AddResourceToInventory from "./AddResourceToInventory";
    export default {
        name: "AdminsPage",
        components: {AddResourceToInventory, AddMoney, Addmin}
    }
</script>

<style scoped>
    .marginBottom{
        margin-bottom: 10px;
    }
</style>