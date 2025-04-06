import {
  createRouter,
  createWebHistory,
  isNavigationFailure,
} from "vue-router";
import Home from "@/pages/Home.vue";
import About from "@/pages/About.vue";
import Members from "@/pages/Members.vue";
import Videos from "@/pages/Videos.vue";
import MemberInfo from "@/pages/MemberInfo.vue";
import NotFound from "@/pages/NotFound.vue";

// guard
const membersIdGuard = (to, from) => {
  if (from.name !== "members" && from.name !== "members/id") {
    return false;
  }
};

const router = createRouter({
  history: createWebHistory(),
  routes: [
    { path: "/", name: "home", component: Home },
    { path: "/about", name: "about", component: About },
    { path: "/members", name: "members", component: Members },
    {
      path: "/members/:id(\\d+)",
      name: "members/id",
      component: MemberInfo,
      beforeEnter: membersIdGuard,
    },
    { path: "/videos", name: "videos", component: Videos },
    { path: "/:paths(.*)*", name: "notfound", component: NotFound }, // 404
  ],
});
export default router;
