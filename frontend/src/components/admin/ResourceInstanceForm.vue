<template>
    <div id="instance">
        <table>
            <tr>
                <td>
                    ResourceID
                </td>
                <td>
                    <input type="number"/>
                </td>
            </tr>
            <tr>
                <td>
                    Quantity
                </td>
                <td>
                    <input type="number"/>
                </td>
            </tr>
        </table>
    </div>
</template>

<script>
    export default {
        name: "ResourceInstanceForm"
    }
</script>

<style scoped>
    #instance{
        background: rgba(193, 194, 255, 0.37);
        width: 240px;
        font-family: fantasy;
        font-size: 22px;
        color: #000d7b;
        border-radius: 5px;
        margin: 10px;

    }
    input{
        background-color: rgba(6, 0, 255, 0.4);
        border-radius: 5px;
        border-style: none;
        font-family: fantasy;
        font-size: 22px;
        color: #000b7b;
        margin: 10px;
        width: 100px;
        height: 35px;
    }
    td{
        text-align: right;
    }
</style>