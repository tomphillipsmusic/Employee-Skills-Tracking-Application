import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import Skills from "../views/Skills.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "home",
    component: Home
  },
  {
    path: "/employees",
    name: "employees",
    component: Home
  },
  {
    path: "/employees/:employeeId/skills",
    name: Skills,
    component: Skills
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
