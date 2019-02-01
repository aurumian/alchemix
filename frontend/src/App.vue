<template>
  <div>
    <bar></bar>
  </div>
</template>

<script>
import UnityGame from './components/UnityGame.vue'
import Bar from "./components/Bar";

export default {
  name: 'app',
  components: {
      Bar,
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
