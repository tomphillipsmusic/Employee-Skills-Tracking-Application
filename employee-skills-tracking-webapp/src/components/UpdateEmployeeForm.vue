<template>
  <div id="update-employee-form">
    <h2>Update Employee</h2>
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
              v-bind:placeholder="employee.firstName"
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
            v-on:click="updateEmployee"
          >
            Update Employee
          </button>
        </form>
      </div>
      <div class="col"></div>
    </div>
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
    employee: {
      employeeId: String,
      firstName: String,
      lastName: String,
      position: String
    }
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
    updateEmployee() {
      fetch(`${this.apiUrl}/${this.employee.employeeId}`, {
        method: "PUT",
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
    },
    getEmployee() {
      fetch(`${this.apiUrl}/${this.employee.employeeId}`, {
        method: "GET"
      })
        .then(response => {
          if (response.ok) {
            console.log("Getting employee information...");
            return response.json();
          }
        })
        .then(employee => {
          console.log("Employee found");
          this.employee = employee;
        })
        .catch(err => {
          console.error(err);
          console.log("Employee not found");
          this.employee.firstName = "";
          this.employee.lastName = "";
          this.employee.position = "";
        });
    }
  }
};
</script>

<style></style>
