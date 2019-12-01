<template>
  <div id="employee-delete-confirmation">
    <h3>
      Are you sure you want to permanently delete {{ employee.firstName }}
      {{ employee.lastName }}?
    </h3>
    <form>
      <input type="submit" v-on:click="deleteEmployee" value="Yes" />
      <button v-on:click="closeConfirmation">No</button>
    </form>
  </div>
</template>

<script>
export default {
  props: {
    employee: {
      employeeId: String,
      firstName: String,
      lastName: String,
      position: String
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
    deleteEmployee() {
      fetch(`${this.apiUrl}/${this.employee.employeeId}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.employee)
      })
        .then(response => {
          if (response.ok) {
            alert(`${this.employee.firstName} ${this.employee.lastName} has been
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
