import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Scoring from "../views/ScoringPage.vue";


Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  }, 
  {
    path: "/search",
    name: "Search",
    component: () => import('../views/SearchPage.vue')
  },
  {
    path: "/scoring",
    name: "Scoring",
    component: Scoring
  }
];

const router = new VueRouter({
  routes
});

export default router;
