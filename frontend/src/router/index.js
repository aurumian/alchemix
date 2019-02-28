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
import AssetPage from '../components/admin/AssetPage'
import Clan from '../components/clan/Clan'
import FullInventory from '../components/FullInventory'
import Recipes from '../components/Recipes'
import Market from '../components/Market'
import Shop from '../components/Shop'
import Store from '../components/Store'
import RecipePage from '../components/admin/RecipePage'

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
                    path: 'inventory',
                    component: FullInventory,
                    children:[
                        {
                            path: '',
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
                },
                {
                    path: 'shop',
                    component: Shop,
                    children: [
                        {
                            path: 'market',
                            component: Market
                        },
                        {
                            path: 'store',
                            component: Store
                        }
                    ]
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
                    path: 'asset',
                    component: AssetPage
                },
                {
                    path: 'recipe',
                    component: RecipePage
                }
            ]
        }
    ]
})