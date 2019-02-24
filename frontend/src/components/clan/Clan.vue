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

        </div>
    </div>
</template>

<script>
    import ClanCreate from "./ClanCreate";
    import ClanSearch from "./ClanSearch";
    export default {
        name: "Clan",
        components: {ClanSearch, ClanCreate}
    }
</script>

<style scoped>

</style>