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
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      apiURL: "http://localhost:8080/employees/",
      employees: []
    };
  },

  created() {
    fetch(this.apiURL)
      .then(response => {
        console.log("Fetching employees...");
        return response.json();
      })
      .then(employees => {
        console.log("Loading employees...");
        this.employees = employees;
      })
      .catch(err => console.log(err));
    console.log(this.employees);
  }
};
</script>

<style></style>
