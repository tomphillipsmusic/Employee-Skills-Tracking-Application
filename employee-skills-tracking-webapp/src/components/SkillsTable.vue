<template>
  <div id="skills-table">
    <table class="table table-striped">
      <thead>
        <th scope="col">Id</th>
        <th scope="col">Skill</th>
        <th scope="col">Rating</th>
        <th scope="col">Description</th>
        <th scope="col"></th>
        <th scope="col"></th>
      </thead>
      <tbody>
        <tr v-for="skill in skills" v-bind:key="skill.skillId">
          <th scope="row">{{ skill.skillId }}</th>
          <td>{{ skill.name }}</td>
          <td>{{ skill.rating }}</td>
          <td>{{ skill.description }}</td>
          <td>
            <button
              class="btn btn-secondary"
              v-on:click="showUpdateSkillForm(skill)"
            >
              Update
            </button>
          </td>
          <td>
            <button
              class="btn btn-danger"
              v-on:click="displayDeleteConfirmation(skill)"
            >
              Delete
            </button>
          </td>
        </tr>
      </tbody>
    </table>
    <update-skill-form
      v-if="updateForm"
      v-bind:skill="this.skill"
      @close-update-form="closeUpdateForm"
    ></update-skill-form>
    <skill-delete-confirmation
      v-if="deleteConfirmation"
      v-bind:skill="skill"
    ></skill-delete-confirmation>
  </div>
</template>

<script>
import SkillDeleteConfirmation from "@/components/SkillDeleteConfirmation.vue";
import UpdateSkillForm from "@/components/UpdateSkillForm.vue";
export default {
  name: "skills-table",
  components: {
    SkillDeleteConfirmation,
    UpdateSkillForm
  },
  props: {
    employeeId: String
  },
  data() {
    return {
      apiURL: `http://localhost:8080/employees/${this.employeeId}/skills`,
      skills: [],
      skill: {},
      deleteConfirmation: false,
      updateForm: false
    };
  },
  created() {
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
    },
    displayDeleteConfirmation(skill) {
      this.deleteConfirmation = true;
      this.skill = skill;
      console.log(this.skill);
    },
    closeConfirmation() {
      this.deleteConfirmation = false;
    },
    showUpdateSkillForm(skill) {
      this.skill = skill;
      this.updateForm = true;
      this.deleteConfirmation = false;
    },
    closeUpdateForm() {
      this.updateForm = false;
    }
  },
  mounted() {
    this.getSkillsByEmployeeId();
  }
};
</script>

<style></style>
