<template>
    <div>
        <input type="text" v-on:input="filterKey=$refs.txt.value" ref="txt">
        <input type="button" v-on:click="downloadTable" value="Update">
        <br>
        <a-table :filter-key="filterKey" :data="data"></a-table>
    </div>
</template>

<script>
    import ATable from "./ATable";
    import axios from 'axios';

    export default {
        name: "UrlTable",
        props:{
            url: String
        },
        components:{
            ATable
        },
        data(){
            return{
                filterKey:"",
                data: []
            }
        },
        methods:{
            downloadTable(){
                if (this.url){
                    axios.get(this.url).then((resp)=>{
                            if (resp.status === 200)
                                this.data = resp.data;
                        }
                    )
                }

            }
        },
        created(){
            this.downloadTable();
        }
    }
</script>

<style scoped>
    input {
        border: 3px solid #42b;
        border-radius: 5px;
        margin: 10px;
        alignment: left;
    }
</style>