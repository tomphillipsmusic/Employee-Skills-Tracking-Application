<template>
  <div class="home">
    <employee-table @close-add-employee="formCompleted"></employee-table>
    <button
      class="btn btn-primary"
      v-if="!employeeForm"
      v-on:click="showEmployeeForm"
    >
      Add Employee
    </button>
    <create-employee-form
      v-if="employeeForm"
      @close-form="formCompleted"
    ></create-employee-form>
  </div>
</template>

<script>
// @ is an alias to /src
import EmployeeTable from "@/components/EmployeeTable.vue";
import CreateEmployeeForm from "@/components/CreateEmployeeForm.vue";

export default {
  name: "home",
  components: {
    EmployeeTable,
    CreateEmployeeForm
  },
  data() {
    return {
      employeeForm: false
    };
  },
  methods: {
    showEmployeeForm() {
      this.employeeForm = true;
    },
    formCompleted() {
      this.employeeForm = false;
    },
    getEmployees() {
      fetch(this.apiURL)
        .then(response => {
          return response.json();
        })
        .then(employees => {
          this.employees = employees;
        })
        .catch(err => console.error(err));
    }
  }
};
</script>
