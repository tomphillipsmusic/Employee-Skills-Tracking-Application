<template>
  <div id="skills">
    <h2>{{ employee.firstName }} {{ employee.lastName }}</h2>
    <p></p>
    <h3>{{ employee.position }}</h3>
    <skills-table v-bind:employeeId="employeeId"></skills-table>
    <button class="btn btn-primary" v-if="!createSkillForm" v-on:click="showCreateSkillForm">
      Add Skill
    </button>
    <create-skill-form
      v-if="createSkillForm"
      v-bind:id="employeeId"
      @close-form="closeForm"
    ></create-skill-form>
  </div>
</template>

<script>
import SkillsTable from "@/components/SkillsTable.vue";
import CreateSkillForm from "@/components/CreateSkillForm.vue";

export default {
  name: "skills",
  components: {
    SkillsTable,
    CreateSkillForm
  },
  data() {
    return {
      employeeId: this.$route.params.employeeId,
      employee: "",

      apiUrl: "http://localhost:8080/employees",
      createSkillForm: false
    };
  },
  methods: {
    showCreateSkillForm() {
      this.createSkillForm = true;
    },
    closeForm() {
      this.createSkillForm = false;
    }
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
