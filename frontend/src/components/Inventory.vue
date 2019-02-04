<template>
    <div id="inventor">
        <inventory-item imgsrc="/api/image/2" name="Liquid Fire" quantity="4"></inventory-item>
        <inventory-item imgsrc="/api/image/2" name="Liquid Fire" quantity="4"></inventory-item>
        <inventory-item imgsrc="/api/image/2" name="Liquid Fire" quantity="4"></inventory-item>
        <inventory-item imgsrc="/api/image/2" name="Liquid Fire" quantity="4"></inventory-item>
        <inventory-item imgsrc="/api/image/2" name="Liquid Fire" quantity="4"></inventory-item>

    </div>
</template>

<script>
    import InventoryItem from "./InventoryItem";
    export default {
        name: "Inventory",
        components: {InventoryItem}
    }
</script>

<style scoped>
    #inventor{
        height: 800px;
        overflow: scroll;
    }
</style>