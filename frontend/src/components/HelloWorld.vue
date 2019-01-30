<template>
  <div class="hello">

      <div class="webgl-content">
          <div id="gameContainer" style="width: 960px; height: 600px"></div>
          <div class="footer">
              <div class="webgl-logo"></div>
              <div class="fullscreen" v-on:click="onClick"></div>
              <div class="title">AlcheMix</div>
          </div>
      </div>

      <!--<unity src="Build/webgl.json" unity-loader="Build/UnityLoader.js" height="600" width="900"></unity>-->
  </div>
</template>


<script>

    export default {
      name: 'HelloWorld',
      props: {
        msg: String,
      },
        gameInstance: {},
      mounted: function () {
          this.$nextTick(function () {
              this.gameInstance = UnityLoader.instantiate("gameContainer", "Build/webgl.json", {onProgress: UnityProgress});
          })
      },
        methods: {
          onClick(){
              this.gameInstance.SetFullscreen(1);
          }
        }
    }
</script>

<style src="../../public/TemplateData/style.css"></style>

