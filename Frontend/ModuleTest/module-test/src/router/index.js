import { createRouter, createWebHistory } from 'vue-router'
import ContactList from '@/pages/ContactListPage.vue'
import ContactDetail from '@/pages/ContactDetailPage.vue'
import ContactWrite from '@/pages/ContactWritePage.vue'
import ContactEdit from '@/pages/ContactEditPage.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      redirect: '/contacts',
    },
    {
      path: '/contacts',
      name: 'contacts',
      component: ContactList,
    },
    {
      path: '/contacts/detail/:id',
      name: 'contacts/detail',
      component: ContactDetail,
    },
    {
      path: '/contacts/write',
      name: 'contacts/write',
      component: ContactWrite,
    },
    {
      path: '/contacts/edit/:id',
      name: 'contacts/edit',
      component: ContactEdit,
    },
  ],
})

export default router
