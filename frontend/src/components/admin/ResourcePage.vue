<template>
    <div>
        <add-resource></add-resource>
        <url-table url="/admin/api/resource"></url-table>
    </div>
</template>

<script>
    import UrlTable from "./UrlTable";
    import AddResource from "./AddResource";
    export default {
        name: "ResourcePage",
        components: {AddResource, UrlTable}
    }
</script>

<style scoped>

</style>