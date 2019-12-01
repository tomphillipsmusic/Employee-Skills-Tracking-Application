<template>
  <div class="home">
    <employee-table></employee-table>
    <button v-if="!saveEmployeeForm" v-on:click="showSaveEmployeeForm">
      Add Employee
    </button>
    <create-employee-form v-if="saveEmployeeForm"></create-employee-form>
    <img alt="Vue logo" src="../assets/logo.png" />
    <HelloWorld msg="Welcome to Your Vue.js App" />
  </div>
</template>

<script>
// @ is an alias to /src
import HelloWorld from "@/components/HelloWorld.vue";
import EmployeeTable from "@/components/EmployeeTable.vue";
import CreateEmployeeForm from "@/components/CreateEmployeeForm.vue";

export default {
  name: "home",
  components: {
    EmployeeTable,
    HelloWorld,
    CreateEmployeeForm
  },
  data() {
    return {
      saveEmployeeForm: false
    };
  },
  methods: {
    showSaveEmployeeForm() {
      this.saveEmployeeForm = true;
    },
    formCompleted() {
      this.SaveEmployeeForm = false;
    }
  }
};
</script>
