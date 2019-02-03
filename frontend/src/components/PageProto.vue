<template>
    <div>

        <div id="pagepgrid">
            <div id="PBar">
                <PersonalBar></PersonalBar>
            </div>
            <div id="sidemenu">

                <side-menu></side-menu>
            </div>
            <div id="extra">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<script>
    import PersonalBar from "./PersonalBar";
    import SideMenu from "./SideMenu";
    export default {
        name: "PageProto",
        components: {SideMenu, PersonalBar}
    }
</script>

<style scoped>
    #PBar{
        grid-area: header;
    }
    #sidemenu{
        grid-area: sidebar;
    }
    #extra{
        grid-area: main;
    }
    #pagepgrid{
        display: grid;
        grid-auto-columns: 200px 220px 800px auto;
        grid-template-areas:
            'header header header header'
            '. sidebar main .';
    }
</style>