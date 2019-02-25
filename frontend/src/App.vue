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
        PlatformService.check();
    },
    mounted(){
        PlatformService.check();
    }
}
</script>

