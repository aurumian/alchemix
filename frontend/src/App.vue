<template>
  <div>
    <router-view></router-view>
  </div>
</template>

<script>
    import PlatformService from './services/PlatformService'
export default {
    name: 'app',
    updated(){
        this.$nextTick(function()
        {
            PlatformService.check();
        })
    },
    mounted(){
        this.$nextTick(function()
        {
            PlatformService.check();
        })
    }
}
</script>

