<template>
    <div id="table" v-if="data[0]">
        <table>
            <thead>
                <tr>
                    <th v-for="k in (!columns ? Object.keys(data[0]): columns)">
                        {{k | capitalize}}
                    </th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="entry in filteredData" :key="entry[(!columns ? Object.keys(data[0]): columns)[0]]">
                    <td v-for="key in (!columns ? Object.keys(data[0]): columns)" v-html="entry[key]">

                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
    export default {
        name: "ATable",
        props: {
            data: Array,
            columns: Array,
            filterKey: String
        },
        filters:{
            capitalize(str){
                return str.charAt(0).toUpperCase() + str.slice(1);
            }
        },
        computed: {
            filteredData(){
                let filterKey = this.filterKey && this.filterKey.toLowerCase();
                let data = this.data;
                if(filterKey){
                    data = data.filter((row)=>{
                        return Object.keys(row).some((key)=>{
                            return String(row[key]).toLowerCase().indexOf(filterKey) > -1;
                        })
                    })
                }
                return data;
            }
        }
    }
</script>

<style scoped>

    #table{
        max-height: 685px;
        overflow: scroll;
    }

    #table >>> img{
        max-height: 120px;
        border-radius: 10px;
    }

    #table::-webkit-scrollbar{
        display: none;
    }

    table {
        border: 3px solid #42b;
        border-radius: 5px;
        background-color: #fff;

    }

    th {
        background-color: #42b;
        color: rgba(189, 189, 189, 0.66);
        cursor: pointer;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
    }

    td {
        background-color: #a1bcf9;
    }

    th, td {
        min-width: 100px;
        padding: 10px 20px;
        border-radius: 5px;
    }
</style>