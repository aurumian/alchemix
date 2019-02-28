<template>
    <div>
        <asset-create></asset-create>
        <url-table url="/admin/api/asset/table"></url-table>
    </div>
</template>

<script>
    import FileUploader from "../FileUploader";
    import UrlTable from "./UrlTable";
    import AssetCreate from "./AssetCreate";
    export default {
        name: "AssetPage",
        components: {AssetCreate, UrlTable, FileUploader}
    }
</script>

<style scoped>

</style>