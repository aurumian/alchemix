<template>
  <div>
    <welcome-page></welcome-page>
    <page-proto></page-proto>
  </div>
</template>

<script>
import UnityGame from './components/UnityGame.vue'
import Bar from "./components/Bar";
import Login from "./components/Login";
import Signup from "./components/Signup";
import WelcomePage from "./components/WelcomePage";
import PageProto from "./components/PageProto";

export default {
  name: 'app',
  components: {
      PageProto,
      WelcomePage,
      Signup,
      Login,
      Bar,
    UnityGame
  }
}
</script>

