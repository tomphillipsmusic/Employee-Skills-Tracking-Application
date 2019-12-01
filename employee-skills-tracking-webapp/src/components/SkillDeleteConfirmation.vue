<template>
  <div id="skill-delete-confirmation">
    <h3>Are you sure you want to permanently delete {{ skill.name }}?</h3>

    <form>
      <div class="row">
        <div class="row"></div>
        <div class="col">
          <input
            class="btn btn-danger"
            type="submit"
            v-on:click="deleteSkill"
            value="Yes"
          />
        </div>
        <div class="col">
          <button class="btn btn-secondary" v-on:click="closeConfirmation">
            No
          </button>
        </div>
        <div class="row"></div>
      </div>
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
