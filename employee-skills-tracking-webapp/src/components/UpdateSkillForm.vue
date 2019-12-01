<template>
  <div id="update-skill-form">
    <h2>Update Skill</h2>
    <div class="form">
      <div class="form-input">
        <label for="name">Skill Name</label>
        <input
          type="text"
          name="name"
          v-model="skill.name"
          v-bind:placeholder="skill.name"
        />
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
        v-on:click="updateSkill"
      >
        Update Skill
      </button>
    </div>
    <h6>{{ JSON.stringify(this.skill) }}</h6>
  </div>
</template>

<script>
export default {
  data() {
    return {
      apiUrl: "http://localhost:8080/employees"
    };
  },
  props: {
    skill: {
      skillId: String,
      nameame: String,
      rating: String,
      description: String
    }
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
    updateSkill() {
      console.log(
        `${this.apiUrl}/${this.$route.params.employeeId}/skills/${this.skill.skillId}`
      );
      fetch(
        `${this.apiUrl}/${this.$route.params.employeeId}/skills/${this.skill.skillId}`,
        {
          method: "PUT",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(this.skill)
        }
      )
        .then(response => {
          if (response.ok) {
            console.log('test1');
            this.$emit("close-update-form");
          }
        })
        .catch(err => console.error(err));
    }
  }
};
</script>

<style></style>
