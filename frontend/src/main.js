import { createApp } from "vue";
import App from "./App.vue";
import router from "./router/router.js";
import "bootstrap/dist/css/bootstrap.css";
import "bootstrap";

createApp(App).use(router).mount("#app");
