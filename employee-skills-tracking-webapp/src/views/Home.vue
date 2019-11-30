<template>
  <div class="home">
    <employee-table></employee-table>
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import EmployeeTable from "@/components/EmployeeTable.vue";

export default {
  name: "home",
  components: {
    EmployeeTable,
    HelloWorld
  },
};
</script>
