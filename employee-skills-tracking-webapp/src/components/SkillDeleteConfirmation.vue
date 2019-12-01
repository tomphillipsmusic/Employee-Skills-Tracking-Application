<template>
  <div id="skill-delete-confirmation">
    <h3>Are you sure you want to permanently delete {{ skill.name }}?</h3>
    <form>
      <input type="submit" v-on:click="deleteSkill" value="Yes" />
      <button v-on:click="closeConfirmation">No</button>
    </form>
  </div>
</template>

<script>
export default {
  props: {
    skill: {
      skillId: String,
      employeeId: String,
      name: String,
      rating: String,
      description: String
    }
  },
  data() {
    return {
      apiUrl: "http://localhost:8080/employees"
    };
  },
  methods: {
    closeConfirmation() {
      this.$emit("closeConfirmation");
    },
    deleteSkill() {
      console.log(
        `${this.apiUrl}/${this.skill.employeeId}/skills/${this.skill.skillId}`
      );
      fetch(
        `${this.apiUrl}/${this.skill.employeeId}/skills/${this.skill.skillId}`,
        {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json"
          },
          body: JSON.stringify(this.employee)
        }
      )
        .then(response => {
          if (response.ok) {
            alert(`${this.skill.name} has been
                    successfully deleted`);
            this.closeConfirmation();
          }
        })
        .catch(err => console.error(err));
    }
  }
};
</script>

<style></style>
