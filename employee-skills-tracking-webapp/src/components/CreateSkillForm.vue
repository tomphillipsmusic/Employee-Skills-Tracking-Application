<template>
  <div id="create-skill-form">
    <h2>Add Skill</h2>
    <form class="form">
      <div class="form-input">
        <label for="name">Skill Name</label>
        <input type="text" name="name" v-model="skill.name" />
      </div>
      <div class="form-input">
        <label for="rating">Rating</label>
        <input type="text" name="rating" v-model="skill.rating" />
      </div>
      <div class="form-input">
        <label for="description">Description</label>
        <input type="text" name="description" v-model="skill.description" />
      </div>
      <button
        class="btn btn-primary"
        :disabled="!isValidForm"
        v-on:click="saveSkill"
      >
        Add Skill
      </button>
    </form>
    <h6>{{ JSON.stringify(this.skill) }}</h6>
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
        })
        .catch(err => console.error(err));
      this.$emit("closeForm");
    }
  },
  created() {
    this.skill.employeeId = this.id;
  }
};
</script>

<style></style>
