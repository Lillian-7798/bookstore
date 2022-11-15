import { createRouter, createWebHistory } from 'vue-router'


const routes = [
    {
        path:"/home",
        name:'home',
        component:() =>
            import ('../views/Home'),
    },
    {
        path: '/Login',
        name:"Login",
        component:() =>
            import ('../views/Login'),
    },
    {
        path: '/Shop',
        name: "Shop",
        component: () =>
            import('../views/Shop'),
    },
    {
        path: '/Cart',
        name:"Cart",
        component:()=>
            import('../views/ShopingCart'),
    },
    {
        path: '/bookInformation',
        name:"bookInformation",
        component: () =>
            import('../views/booksInformation')
    },
    {
        path: '/manageUser',
        name:"manageUser",
        component: () =>
            import('../views/manage/manageUser')
    },
    {
        path: '/manageBooks',
        name:"manageBooks",
        component: () =>
            import('../views/manage/manageBooks')
    },
    {
        path: '/manageOrders',
        name:"manageOrders",
        component: () =>
            import('../views/manage/manageOrders')
    },
    {
        path: '/Order',
        name:"Order",
        component:() =>
            import('../views/Order')
    },
    {
        path: '/Statistics',
        name: "Statistics",
        component:()=>
            import('../views/statistics')
    },
    {
        path: '/',
        redirect: '/Login',
    },

]
const router = createRouter({
    history: createWebHistory(process.env.BASE_URL),
    routes
})

export  default  router