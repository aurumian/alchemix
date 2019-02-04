<template>
    <div id="invent">
        <div id="inimg">
            <img src="../assets/OrangeConePotionSmall.png">
        </div>
        <div id="iname">
            {{this.name}} x{{this.quantity}}
        </div>
        <div id="but">
            <button>

            </button>
        </div>
    </div>
</template>

<script>
    export default {
        name: "InventoryItem",
        props: {
            imgsrc: String,
            name: String,
            quantity: Number
        }
    }
</script>

<style scoped>
    #iname{
        grid-area: name;
        font-family: fantasy;
        font-size: 26px;
        color: #7b0009;
        text-align: left;
        margin-top: 10px;
    }
    img{
        margin: 10px;
        border-radius: 50%;
        width: 200px;
    }
    #inimg{
        grid-area: image;
    }
    #invent{
        margin-bottom: 20px;
        margin-left: 20px;
        width: 780px;
        height: 220px;
        background: #ffcccc;
        display: grid;
        grid-template-columns: 220px 300px  auto 20px;
        grid-row-gap: 10px;
        grid-column-gap: 15px;
        grid-template-areas:
        'image name . .'
        'image . . .';
    }
</style>