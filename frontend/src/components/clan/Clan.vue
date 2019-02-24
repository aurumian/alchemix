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
        </div>
    </div>
</template>

<script>
    import ClanCreate from "./ClanCreate";
    import ClanSearch from "./ClanSearch";
    import ClanImage from "./ClanImage";
    import ClanInfo from "./ClanInfo";
    import ClanQuit from "./ClanQuit";
    export default {
        name: "Clan",
        components: {ClanQuit, ClanInfo, ClanImage, ClanSearch, ClanCreate}
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
    #myClan{
        display: grid;
        grid-template-columns: 250px auto;
        grid-column-gap: 20px;

        grid-template-areas:
        'image info'
        'quit .';
    }
</style>