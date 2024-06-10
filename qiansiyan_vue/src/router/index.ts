import { createRouter, createWebHashHistory, createWebHistory } from 'vue-router'

const router = createRouter({
    history: createWebHashHistory(import.meta.env.BASE_URL),
    routes: [
        {
            path: '/',
            name: 'home',
            component: () => import('../views/HomeView.vue')
        },
        {
            path: '/passage',
            name: 'passage',
            component: () => import('../layouts/passage/index.vue'),
            children: [
                {
                    path: '/passage/sizhoushiyan',
                    name: 'sizhoushiyan',
                    component: () => import('../views/sizhoushiyan.vue')
                },
                {
                    path: '/passage/about',
                    name: 'about',
                    component: () => import('../components/about/AboutAbout.vue')
                }
            ]
        },
        {
            // 404
            path: '/:pathMatch(.*)*',
            component: () => import('../components/error/404.vue')
        }
    ]
})

export default router
