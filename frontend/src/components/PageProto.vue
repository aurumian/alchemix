<template>
    <div>
        <PersonalBar></PersonalBar>
        <div id="pagepgrid">
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
    #pagepgrid{
        display: grid;
        grid-template-areas:
            'sidemenu extra extra';
    }
</style>