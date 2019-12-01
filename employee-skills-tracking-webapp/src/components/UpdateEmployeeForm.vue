<template>
  <div id="update-employee-form">
    <h2>Update Employee</h2>
    <form class="form">
      <div class="form-input">
        <label for="employeeId">Employee ID</label>
        <input
          type="number"
          name="employeeId"
          v-model="employee.employeeId"
          v-on:change="getEmployee"
        />
      </div>
      <div class="form-input">
        <label for="firstName">First Name</label>
        <input
          type="text"
          name="firstName"
          v-model="employee.firstName"
          v-bind:placeholder="employee.firstName"
        />
      </div>
      <div class="form-input">
        <label for="lastName">Last Name</label>
        <input type="text" name="lastName" v-model="employee.lastName" />
      </div>
      <div class="form-input">
        <label for="position">Position</label>
        <input type="text" name="position" v-model="employee.position" />
      </div>
      <button
        class="btn btn-primary"
        :disabled="!isValidForm"
        v-on:click="updateEmployee"
      >
        Update Employee
      </button>
    </form>
    <h6>{{ JSON.stringify(this.employee) }}</h6>
  </div>
</template>

<script>
export default {
  data() {
    return {
      employee: {
        employeeId: 0,
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
            console.log('Getting employee information...')  
            return response.json();
          }
        })
        .then(employee => {
          console.log('Employee found')  
          this.employee = employee;
        })
        .catch(err => {
            console.error(err);
            console.log('Employee not found')
            this.employee.firstName = '';
            this.employee.lastName = '';
            this.employee.position = '';
        });
    }
  }
};
</script>

<style></style>
