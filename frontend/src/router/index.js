import Router from 'vue-router'
import Vue from 'vue'
import WelcomePage from '../components/user/WelcomePage'
import PageProto from '../components/PageProto'
import UnityGame from '../components/UnityGame'
import AdminPage from '../components/admin/AdminPage'
import AdminsPage from '../components/admin/AdminsPage'
import ImageComp from '../components/admin/ImageComp'
import Inventory from '../components/Inventory'
import ResourcePage from '../components/admin/ResourcePage'
import AssetBundlePage from '../components/admin/AssetBundlePage'
import Clan from '../components/clan/Clan'
import FullInventory from '../components/FullInventory'
import Recipes from '../components/Recipes'

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
                },
                {
                    path: 'fullinventory',
                    component: FullInventory,
                    children:[
                        {
                            path: 'inventory',
                            component: Inventory
                        },
                        {
                            path: 'recipes',
                            component: Recipes
                        }

                    ]
                },
                {
                    path: 'clan',
                    component: Clan
                }
            ]
        },
        {
            path: '/admin',
            component: AdminPage,
            children: [
                {
                    path: '/admin/image',
                    component: ImageComp
                },
                {
                    path: '/admin/resource',
                    component: ResourcePage
                },
                {
                    path: '/admin/admins',
                    component: AdminsPage
                },
                {
                    path: 'asset_bundle',
                    component: AssetBundlePage
                }
            ]
        }
    ]
})