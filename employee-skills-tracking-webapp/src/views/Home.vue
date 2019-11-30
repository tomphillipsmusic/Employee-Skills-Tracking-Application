<template>
  <div class="home">
    <employee-table></employee-table>
    <h6>{{ employees }}</h6>
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
