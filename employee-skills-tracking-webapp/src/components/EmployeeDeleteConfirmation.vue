<template>
  <div id="employee-delete-confirmation">
    <h3>
      Are you sure you want to permanently delete {{ employee.firstName }}
      {{ employee.lastName }}?
    </h3>
    <form>
      <div class="row">
        <div class="col"></div>
        <div class="col">
          <input
            class="btn btn-danger"
            type="submit"
            v-on:click="deleteEmployee"
            value="Yes"
          />
        </div>
        <div class="col">
          <button class="btn btn-secondary" v-on:click="closeConfirmation">No</button>
        </div>
        <div class="col"></div>
      </div>
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
      this.$emit("close-confirmation");
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

<style>

</style>
