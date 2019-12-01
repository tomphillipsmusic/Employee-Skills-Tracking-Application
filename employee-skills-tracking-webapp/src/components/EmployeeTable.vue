<template>
  <div id="employee-table">
    <h1>Perficient Employees</h1>
    <table class="table table-striped">
      <thead>
        <tr>
          <th scope="col">Id</th>
          <th scope="col">First Name</th>
          <th scope="col">Last Name</th>
          <th scope="col">Position</th>
          <th scope="col"></th>
          <th scope="col"></th>
        </tr>
      </thead>
      <tbody>
        <tr v-for="employee in employees" v-bind:key="employee.employeeId">
          <th scope="row">{{ employee.employeeId }}</th>
          <td>
            <router-link v-bind:to="`/employees/${employee.employeeId}/skills`">
              {{ employee.firstName }}
            </router-link>
          </td>
          <td>
            <router-link v-bind:to="`/employees/${employee.employeeId}/skills`">
              {{ employee.lastName }}
            </router-link>
          </td>
          <td>{{ employee.position }}</td>
          <td>
            <button
              class="btn btn-secondary"
              v-on:click="showUpdateEmployeeForm(employee)"
            >
              Update
            </button>
          </td>
          <td>
            <button
              class="btn btn-danger"
              v-on:click="showDeleteConfirmation(employee)"
            >
              Delete
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <update-employee-form
      v-if="updateForm"
      v-bind:employee="this.employee"
    ></update-employee-form>
    <employee-delete-confirmation
      v-if="deleteConfirmation"
      v-bind:employee="employee"
    ></employee-delete-confirmation>
  </div>
</template>

<script>
import UpdateEmployeeForm from "@/components/UpdateEmployeeForm.vue";
import EmployeeDeleteConfirmation from "@/components/EmployeeDeleteConfirmation.vue";

export default {
  name: "employee-table",
  components: {
    UpdateEmployeeForm,
    EmployeeDeleteConfirmation
  },
  data() {
    return {
      apiURL: "http://localhost:8080/employees/",
      employees: [],
      updateForm: false,
      deleteConfirmation: false,
      employeeId: 0,
      employee: Object
    };
  },
  methods: {
    getEmployees() {
      fetch(this.apiURL)
        .then(response => {
          return response.json();
        })
        .then(employees => {
          this.employees = employees;
        })
        .catch(err => console.error(err));
    },
    setEmployeeId(employeeId) {
      this.employeeId = employeeId;
    },
    showUpdateEmployeeForm(employee) {
      this.employee = employee;
      this.updateForm = true;
      this.deleteConfirmation = false;
      this.$emit("close-add-employee");
    },
    showDeleteConfirmation(employee) {
      this.employee = employee;
      this.deleteConfirmation = true;
      this.updateForm = false;
      this.$emit("close-add-employee");
    },
    closeConfirmation() {
      this.deleteConfirmation = false;
    }
  },
  created() {
    this.getEmployees();
  }
};
</script>

<style></style>
