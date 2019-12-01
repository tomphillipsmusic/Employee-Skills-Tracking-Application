<template>
  <div id="skills">
    <h1>{{ employee.firstName }} {{ employee.lastName }}</h1>
    <p></p>
    <h2>{{ employee.position }}</h2>
    <skills-table v-bind:employeeId="employeeId"></skills-table>
  </div>
</template>

<script>
import SkillsTable from "@/components/SkillsTable.vue";

export default {
  name: "skills",
  components: {
    SkillsTable
  },
  data() {
    return {
      employeeId: this.$route.params.employeeId,
      employee: "",

      apiUrl: "http://localhost:8080/employees"
    };
  },
  mounted() {
    console.log(this.employeeId);
    console.log(`${this.apiUrl}/${this.employeeId}`);
    fetch(`${this.apiUrl}/${this.employeeId}`)
      .then(response => {
        return response.json();
      })
      .then(employee => {
        this.employee = employee;
      });
  }
};
</script>

<style></style>
