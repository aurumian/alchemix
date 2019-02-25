<template>
    <div>
        <put-resource-on-sale></put-resource-on-sale>
        <add-resource></add-resource>
        <url-table url="/admin/api/resource"></url-table>
    </div>
</template>

<script>
    import UrlTable from "./UrlTable";
    import AddResource from "./AddResource";
    import PutResourceOnSale from "./PutResourceOnSale";
    export default {
        name: "ResourcePage",
        components: {PutResourceOnSale, AddResource, UrlTable}
    }
</script>

<style scoped>

</style>