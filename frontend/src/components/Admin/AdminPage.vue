<template>
    <div>

        <div id="pagegrid">
            <div id="ABar">
                <admin-bar></admin-bar>
            </div>
            <div id="sidemenu">
                <admin-side-menu></admin-side-menu>
            </div>
            <div id="extra">
                <router-view></router-view>
            </div>
        </div>
    </div>
</template>

<script>
    import AdminBar from "./AdminBar"
    import AdminSideMenu from "./AdminSideMenu"

    export default {
        name: "AdminPage",
        components: {
            AdminBar,
            AdminSideMenu
        }
    }
</script>

<style scoped>
    #ABar{
        grid-area: header;
    }
    #sidemenu{
        grid-area: sidebar;
    }
    #extra{
        grid-area: main;
    }
    #pagegrid{
        display: grid;
        grid-auto-columns: 200px 300px 800px auto;
        grid-template-areas:
                'header header header header'
                '. sidebar main .';
    }
</style>