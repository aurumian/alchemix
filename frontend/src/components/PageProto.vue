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
    import PersonalBar from "./user/PersonalBar";
    import SideMenu from "./SideMenu";
    import Inventory from "./Inventory";
    export default {
        name: "PageProto",
        components: {Inventory, SideMenu, PersonalBar}
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
        grid-row-gap: 20px;
        grid-auto-columns: 200px 220px 800px auto;
        grid-template-areas:
            'header header header header'
            '. sidebar main .';
    }
    .ConePotion{
        border-radius: 50%;
    }

</style>