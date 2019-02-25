<template>
    <div id="main">
        <div id="bar">
            <div id="image">
                <img :src="'/api/image/' + imageId">
            </div>
            <div id="name" >
                {{username}}
            </div>
            <div id="date">
                {{datePosted}}
            </div>

        </div>
        <hr/>
        <div id="message">
            {{message}}
        </div>
    </div>
</template>

<script>
    export default {
        name: "ClanPost",
        props: {
            username: String,
            imageId: Number,
            datePosted: String,
            message: String
        }
    }
</script>

<style scoped>

    #main{
        margin-bottom: 20px;
        width: 510px;
        height: 200px;
        background: #ffcccc;
        font-family: fantasy;
        font-size: 22px;
        color: #7b0009;
    }

    #image{
        grid-area: image;
    }
    #name{
        grid-area: name;
        text-align: left;
        height: 40px;
        margin-top: 20px;
    }
    #date{
        grid-area: date;
        margin-top: 25px;
        margin-right: 10px;
        text-align: right;
        font-size: 18px;
        color: #7b4445;
    }
    #bar{
        display: grid;
        grid-template-columns: 50px auto auto;
        grid-template-areas:
                'image name date';
    }

    hr{
        border: 0;
        height: 3px;
        background: #ffcccc;
        background-image: linear-gradient(to right, rgba(255, 204, 204, 0.71), rgba(128, 0, 0, 0.77), rgba(255, 204, 204, 0.69));
        margin-top: 0;
    }

    img{
        width: 40px;
        border-radius: 50%;
        margin: 5px;
        margin-top: 10px;

    }
    
    #message{
        text-align: left;
        color: #9c403f;
        margin-left: 10px;
    }
</style>