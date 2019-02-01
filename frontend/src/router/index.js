import Router from 'vue-router'
import Vue from 'vue'
import WelcomePage from '../components/WelcomePage'
import PageProto from '../components/PageProto'
import UnityGame from '../components/UnityGame'
Vue.use(Router);

export default new Router({
    mode: 'history',
    routes: [
        {
            path: '/login',
            component: WelcomePage
        },
        {
            path: '/',
            component: PageProto,
            children: [
                {
                    path: 'craft',
                    component: UnityGame
                }
            ]
        }
    ]
})