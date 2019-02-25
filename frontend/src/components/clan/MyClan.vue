<template>
    <div id="myClan">
        <div id="image">
            <clan-image :image-id="clan.imageId"></clan-image>
        </div>
        <div id="info">
            <clan-info :name="clan.name" :description="clan.description"></clan-info>
        </div>
        <div id="quit">
            <clan-quit></clan-quit>
        </div>
        <div id="publish">
            <clan-post-create :callback="addPost"></clan-post-create>
        </div>
        <div id="post">
            <clan-post v-for="post in posts" :username="post.clansman.username" :date-posted="post.datePosted" :message="post.text" :image-id="post.clansman.imageId"></clan-post>
        </div>
        <div id="members">
            <clansmen></clansmen>
        </div>
    </div>
</template>

<script>
    import ClanImage from "./ClanImage";
    import ClanInfo from "./ClanInfo";
    import ClanQuit from "./ClanQuit";
    import ClanPostCreate from "./ClanPostCreate";
    import ClanPost from "./ClanPost";
    import Clansmen from "./Clansmen";
    import axios from 'axios';

    export default {
        name: "MyClan",
        components:{ClanImage, ClanInfo, ClanQuit, ClanPostCreate, ClanPost, Clansmen},
        data(){
            return{
                clan: {},
                posts: []
            }
        },
        mounted(){
            axios.get("/api/clan/myClan").then(resp =>{
                if (resp.status === 200)
                    this.clan = resp.data;
            });
            axios.get("/api/clan/posts").then(resp =>{
                if (resp.status === 200)
                    this.posts = resp.data;
            })
        },
        methods:{
            addPost(post){
                this.posts.unshift(post);
            }
        }
    }
</script>

<style scoped>
    #image{
        grid-area: image;
    }
    #quit{
        grid-area: quit;
    }
    #info{
        grid-area: info;
    }
    #publish{
        grid-area: publish;
    }
    #post{
        grid-area: post;
    }
    #members{
        grid-area: members;
    }
    #myClan{
        margin-left: 10px;
        display: grid;
        grid-template-columns: 250px 550px;


        grid-template-areas:
                'image info'
                'quit publish'
                'members post';
    }
    #myClan[class~=mobile]{
        margin-left: 0;
        display: grid;
        grid-template-columns: auto;
        grid-row-gap: 10px;


        grid-template-areas:
                'image'
                'info'
                'quit'
                'members'
                'publish'
                'post';
    }
</style>