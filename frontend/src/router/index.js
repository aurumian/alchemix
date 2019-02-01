import Router from 'vue-router'
import Vue from 'vue'
import UnityGame from '../components/UnityGame'
import FileUploader from '../components/FileUploader'
Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/unity',
            component: UnityGame
        },
    ]
})