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

        <my-clan v-if="user.isInClan"></my-clan>
    </div>
</template>

<script>
    import ClanCreate from "./ClanCreate";
    import ClanSearch from "./ClanSearch";
    import MyClan from "./MyClan";

    export default {
        name: "Clan",
        components: {MyClan, ClanSearch, ClanCreate}
    }
</script>

<style scoped>

</style>