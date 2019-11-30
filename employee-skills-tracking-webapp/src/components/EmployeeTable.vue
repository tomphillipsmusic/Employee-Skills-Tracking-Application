<template>
  <div id="employee-table">
    <h1>Perficient Employees</h1>
    <table>
      <thead>
        <td>First Name</td>
        <td>Last Name</td>
        <td>Position</td>
      </thead>
      <tr v-for="employee in employees" v-bind:key="employee.employeeId">
        <td>{{ employee.firstName }}</td>
        <td>{{ employee.lastName }}</td>
        <td>{{ employee.position }}</td>
      </tr>
    </table>
  </div>
</template>

<script>
export default {
  data() {
    return {
      apiURL: "http://localhost:8080/employees/",
      employees: [],
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
