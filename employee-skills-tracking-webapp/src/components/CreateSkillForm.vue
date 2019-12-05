<template>
  <div id="create-skill-form">
    <h2>Add Skill</h2>
    <div class="row">
      <div class="col"></div>
      <div class="col">
        <form class="form">
          <div class="form-group">
            <label for="name">Skill Name</label>
            <input
              class="form-control"
              type="text"
              name="name"
              v-model="skill.name"
            />
          </div>
          <div class="form-group">
            <label for="rating">Rating</label>
            <input
              class="form-control"
              type="text"
              name="rating"
              v-model="skill.rating"
            />
          </div>
          <div class="form-group">
            <label for="description">Description</label>
            <input
              class="form-control"
              type="text"
              name="description"
              v-model="skill.description"
            />
          </div>
          <input
            type="submit"
            class="btn btn-primary"
            :disabled="!isValidForm"
            v-on:click="saveSkill"
            value="Add Skill"
          />
        </form>
      </div>
      <div class="col"></div>
    </div>
    <button class="btn btn-secondary" v-on:click="closeForm">Close Form</button>
  </div>
</template>

<script>
export default {
  props: {
    id: String
  },
  data() {
    return {
      skill: {
        employeeId: "",
        name: "",
        rating: "",
        description: ""
      },
      apiUrl: "http://localhost:8080/employees"
    };
  },
  computed: {
    isValidForm() {
      return (
        this.skill.name != "" &&
        this.skill.rating != "" &&
        this.skill.description != ""
      );
    }
  },
  methods: {
    saveSkill() {
      console.log(`${this.apiUrl}/${this.skill.employeeId}/skills`);
      fetch(`${this.apiUrl}/${this.skill.employeeId}/skills`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.skill)
      })
        .then(response => {
          if (response.ok) {
            console.log(this.skill);
          }
          window.location.href = `/employees/${this.skill.employeeId}/skills`;
        })
        .catch(err => console.error(err));
    },
    closeForm() {
      this.$emit("close-form");
    }
  },
  created() {
    this.skill.employeeId = this.id;
  }
};
</script>

<style scoped>
button {
  margin: 5px;
  padding: 5px;
}
</style>
