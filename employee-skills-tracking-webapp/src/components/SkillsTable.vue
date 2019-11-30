<template>
  <div id="skills-table">
    <h6>Employee's Skills</h6>
    <table>
      <thead>
        <td>Skill</td>
        <td></td>
        <td>Rating</td>
        <td>Description</td>
      </thead>
      <tr v-for="skill in skills" v-bind:key="skill.skillId">
        <td>{{ skill.name }}</td>
        <td>{{ skill.rating }}</td>
        <td>{{ skill.rating }}</td>
      </tr>
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
  mounted() {
    console.log(this.apiURL);
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
};
</script>

<style></style>
