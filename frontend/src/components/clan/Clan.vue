<template>
    <div>
        <div id="noClan">
            <div id="create">
                <clan-create></clan-create>
            </div>
            <div id="join">
                <clan-search></clan-search>
            </div>
        </div>
        <div id="myClan">
            <div id="image">
                <clan-image></clan-image>
            </div>
            <div id="info">
                <clan-info description="best clan ever <3 <3 <3 "></clan-info>
            </div>
            <div id="quit">
                <clan-quit></clan-quit>
            </div>
            <div id="publish">
                <clan-post-create></clan-post-create>
            </div>
            <div id="post">
                <clan-post username="bl4ze" date-posted="10:37 18-01-2019" message="HI everybody!!!  love to be here <3"></clan-post>
                <clan-post username="bl4ze" date-posted="10:37 18-01-2019" message="HI everybody!!!  love to be here <3 sdfg dg dfg dfg dfg dfg dfgfg g"></clan-post>
                <clan-post username="bl4ze" date-posted="10:37 18-01-2019" message="HI everybody!!!  love to be here  dfdsf dsf dsf adsf dsf dsafads  fadsf fdsg fdsfgfdg dfg dfg dfg fdg dfg dfg dfs<3"></clan-post>
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
    export default {
        name: "Clan",
        components: {Clansmen, ClanPost, ClanPostCreate, ClanQuit, ClanInfo, ClanImage, ClanSearch, ClanCreate}
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