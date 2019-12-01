<template>
  <div class="home">
    <employee-table></employee-table>
    <create-employee-form></create-employee-form>
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import EmployeeTable from "@/components/EmployeeTable.vue";
import CreateEmployeeForm from "@/components/CreateEmployeeForm";

export default {
  name: "home",
  components: {
    EmployeeTable,
    HelloWorld,
    CreateEmployeeForm
  }
};
</script>
