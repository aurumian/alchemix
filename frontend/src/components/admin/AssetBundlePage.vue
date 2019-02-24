<template>
    <div>
        <FileUploader upload-url="/api/admin/asset_bundle/add"></FileUploader>
        <url-table url="/api/admin/asset_bundle/table"></url-table>
    </div>
</template>

<script>
    import FileUploader from "../FileUploader";
    import UrlTable from "./UrlTable";
    export default {
        name: "AssetBundlePage",
        components: {UrlTable, FileUploader}
    }
</script>

<style scoped>

</style>