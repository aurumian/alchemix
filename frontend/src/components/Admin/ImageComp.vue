<template>
    <div align="center">
        <file-uploader upload-url="/api/image/upload"></file-uploader>
        <url-table url="/api/images"></url-table>
        <a-table :data="data" :filter-key="filterKey"></a-table>
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
        },
        data(){
            return {
                columns: ['id'],
                data: [
                    {'id': 200, 'data': 'stuff'},
                    {id: 210, data: '<img src="https://thebusybaker.ca/wp-content/uploads/2018/08/best-ever-greek-yogurt-chocolate-chip-muffins-fbig3.jpg" height="80px">'},
                    {id: 212, data: '<img src="https://d2gk7xgygi98cy.cloudfront.net/1600-3-large.jpg" style="max-height:80px;">'},
                    {id: 201, data: 'fluff'},
                    {id: 220, data: 'volts'}
                    ],
                filterKey: ""
            }
        }
    }
</script>

<style scoped>

</style>