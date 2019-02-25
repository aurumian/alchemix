<template>
    <div>
        <div id="noClan">
            <div v-if="!user.isInClan">
                <div id="create">
                    <clan-create></clan-create>
                </div>
                <div id="join">
                    <clan-search></clan-search>
                </div>
            </div>
        </div>

        <div id="myClan" v-if="user.isInClan">
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
                <clan-post-create></clan-post-create>
            </div>
            <div id="post">
                <clan-post v-for="post in posts" :username="post.clansman.username" :date-posted="post.datePosted" :message="post.text" :image-id="post.clansman.imageId"></clan-post>
            </div>
            <div id="members">
                <clansmen></clansmen>
            </div>
        </div>
    </div>
</template>

<script>
    import ClanCreate from "./ClanCreate";
    import ClanSearch from "./ClanSearch";
    import ClanImage from "./ClanImage";
    import ClanInfo from "./ClanInfo";
    import ClanQuit from "./ClanQuit";
    import ClanPostCreate from "./ClanPostCreate";
    import ClanPost from "./ClanPost";
    import Clansmen from "./Clansmen";
    import axios from 'axios';

    export default {
        name: "Clan",
        components: {Clansmen, ClanPost, ClanPostCreate, ClanQuit, ClanInfo, ClanImage, ClanSearch, ClanCreate},
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

</style>