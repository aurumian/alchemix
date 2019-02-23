import Vue from 'vue'
import App from './App.vue'
import router from './router'
import User from './model/user'

Vue.config.productionTip = false;


/*
(function(open){
  XMLHttpRequest.prototype.open = function (method, url, async, user, pass) {
      console.log("method: " + method + "url: " + url + "async: " + async + "user: " + user + "password: " + pass);
      open.call(this, method, url, async, user, pass);
  }
})(XMLHttpRequest.prototype.open);
*/

let open = window.XMLHttpRequest.prototype.open;
let send = window.XMLHttpRequest.prototype.send;

function openReplacement(method, url, async, user, password){
  this._url =url;


  return open.apply(this, arguments);
}

function sendReplacement(data){
  if (this.onreadystatechange) {
      this._onreadystatechange = this.onreadystatechange;
  }

  this.setRequestHeader("x-requested-with", "xhr");
  if (window.localStorage.getItem("token"))
      this.setRequestHeader("Authorization", "Bearer " + window.localStorage.getItem("token"));

  this.onreadystatechange = onReadyStateChangeReplacement;
  return send.apply(this, arguments);
}

function onReadyStateChangeReplacement(){
  if (this.readyState === 4) {

      console.log("Status is " + this.status);
      if (this.status === 401) {
          window.localStorage.removeItem("token");
          router.push("/login");
      }

  }

  if(this._onreadystatechange)
    return this._onreadystatechange.apply(this, arguments);
}

window.XMLHttpRequest.prototype.open = openReplacement;
window.XMLHttpRequest.prototype.send = sendReplacement;

router.afterEach((to, from) =>{
    if (to.path.indexOf("/admin") > -1)
        document.getElementsByTagName("html")[0].className = "blue";
    else
        document.getElementsByTagName("html")[0].className = "pink";
});

const Store = {
    user: new User("name", 5, 100, "ROLE_USER")
};

Vue.mixin({
    data(){
        return {
            user: Store.user
        }
    }
});
new Vue({
  render: h => h(App),
  router
}).$mount('#app');
