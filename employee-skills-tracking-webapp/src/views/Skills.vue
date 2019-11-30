<template>
  <div id="skills">
    <skills-table v-bind:employeeId="employeeId"></skills-table>
  </div>
</template>

<script>
import SkillsTable from "@/components/SkillsTable.vue";

export default {
  name: "skills",
  components: {
    SkillsTable
  },
  data() {
      return {
          employeeId : this.$route.params.employeeId
      }
  }
};
</script>

<style></style>
