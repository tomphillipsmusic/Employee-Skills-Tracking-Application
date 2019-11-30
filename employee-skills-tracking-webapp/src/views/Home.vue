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
  data() {
    return {
      apiURL: "http://localhost:8080/employees/",
      employees: []
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
        .catch(err => console.log(err));
      console.log(this.employees);
    }
  }
};
</script>
