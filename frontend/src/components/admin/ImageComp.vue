<template>
    <div align="center">
        <file-uploader upload-url="/api/image/upload"></file-uploader>
        <url-table url="/api/image"></url-table>
    </div>
</template>

<script>
    import FileUploader from '../FileUploader'
    import UrlTable from './UrlTable'
    import ATable from './ATable'

    export default {
        name: "ImageComp",
        components: {
            FileUploader,
            UrlTable,
            ATable
        }
    }
</script>

<style scoped>

</style>