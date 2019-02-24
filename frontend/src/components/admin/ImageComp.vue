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
    div{
        background: rgba(8, 0, 255, 0.38);
        horiz-align: center;
        padding: 15px;
        font-family: fantasy;
        font-size: 22px;
        color: #05007b;
    }

</style>