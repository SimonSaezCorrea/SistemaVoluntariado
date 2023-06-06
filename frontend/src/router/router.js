import Vue from "vue";
import Router from "vue-router";
import Home from "../views/Home.vue";
import Login from "../views/Login.vue";
import Register from "../views/Register.vue";
import Ranking from "../views/Ranking.vue";

Vue.use(Router);

const routes = [
  {
    path: "/",
    component: Home,
  },
  {
    path: "/login",
    component: Login,
  },
  {
    path: "/signup",
    component: Register,
  },
  {
    path: "/ranking",
    component: Ranking,
  },
];

export default new Router({
  mode: "history",
  routes,
});
