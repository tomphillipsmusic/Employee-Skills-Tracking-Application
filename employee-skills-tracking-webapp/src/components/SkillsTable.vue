<template>
  <div id="skills-table">
    <table class="table table-striped">
      <thead>
        <th scope="col">Id</th>
        <th scope="col">Skill</th>
        <th scope="col">Rating</th>
        <th scope="col">Description</th>
      </thead>
      <tbody>
        <tr v-for="skill in skills" v-bind:key="skill.skillId">
          <th scope="row">{{ skill.skillId }}</th>
          <td>{{ skill.name }}</td>
          <td>{{ skill.rating }}</td>
          <td>{{ skill.description }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
export default {
  props: {
    employeeId: String
  },
  data() {
    return {
      apiURL: `http://localhost:8080/employees/${this.employeeId}/skills`,
      skills: []
    };
  },
  created() {
    console.log(this.employeeId);
    this.apiURL = `http://localhost:8080/employees/${this.employeeId}/skills`;
  },
  methods: {
    getSkillsByEmployeeId() {
      fetch(this.apiURL)
        .then(response => {
          console.log("Fetching skills...");
          return response.json();
        })
        .then(skills => {
          console.log("Loading skills...");
          this.skills = skills;
        })
        .catch(err => console.log(err));
      console.log(this.skills);
    }
  },
  mounted() {
    console.log(this.apiURL);
    this.getSkillsByEmployeeId();
  }
};
</script>

<style></style>
