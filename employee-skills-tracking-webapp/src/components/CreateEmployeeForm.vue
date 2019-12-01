<template>
  <div id="create-employee-form">
    <h2>Add Employee</h2>
    <div class="row">
      <div class="col"></div>
      <div class="col">
        <form class="form">
          <div class="form-group">
            <label for="firstName">First Name</label>
            <input
              class="form-control"
              type="text"
              name="firstName"
              v-model="employee.firstName"
            />
          </div>
          <div class="form-group">
            <label for="lastName">Last Name</label>
            <input
              class="form-control"
              type="text"
              name="lastName"
              v-model="employee.lastName"
            />
          </div>
          <div class="form-group">
            <label for="position">Position</label>
            <input
              class="form-control"
              type="text"
              name="position"
              v-model="employee.position"
            />
          </div>
          <button
            class="btn btn-primary"
            :disabled="!isValidForm"
            v-on:click="saveEmployee"
          >
            Add Employee
          </button>
        </form>
      </div>
      <div class="col"></div>
    </div>
    <h6>{{ JSON.stringify(this.employee) }}</h6>
  </div>
</template>

<script>
export default {
  data() {
    return {
      employee: {
        firstName: "",
        lastName: "",
        position: ""
      },
      apiUrl: "http://localhost:8080/employees"
    };
  },
  computed: {
    isValidForm() {
      return (
        this.employee.firstName != "" &&
        this.employee.lastName != "" &&
        this.employee.position != ""
      );
    }
  },
  methods: {
    saveEmployee() {
      fetch(this.apiUrl, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(this.employee)
      })
        .then(response => {
          if (response.ok) {
            console.log(this.employee);
          }
        })
        .catch(err => console.error(err));
    }
  }
};
</script>

<style></style>
