<template>
    <div>
        <PersonalBar></PersonalBar>
        <side-menu></side-menu>
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

</style>