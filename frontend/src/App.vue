<template>
  <div id="app">
    <img alt="Vue logo" src="./assets/logo.png">
    <UnityGame msg="Welcome to Your Vue.js App"/>
  </div>
</template>

<script>
import UnityGame from './components/UnityGame.vue'

export default {
  name: 'app',
  components: {
    UnityGame
  }
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
