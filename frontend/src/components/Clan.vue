<template>
    <div>
        <div id="noClan">
            <div id="create">
                <clan-create></clan-create>
            </div>
            <div id="join">

            </div>
        </div>
        <div id="myClan">

        </div>
    </div>
</template>

<script>
    import ClanCreate from "./ClanCreate";
    export default {
        name: "Clan",
        components: {ClanCreate}
    }
</script>

<style scoped>

</style>