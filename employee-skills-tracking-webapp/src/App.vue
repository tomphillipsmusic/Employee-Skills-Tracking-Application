<template>
  <div id="app">
    <img src="./assets/perficient-logo.jpg" />
    <div id="nav">
      <router-link to="/"><span id="home">Home</span></router-link> |
      <a
        href="https://documenter.getpostman.com/view/9650473/SWDzeM91?version=latest"
        >Documentation</a
      >
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: "Avenir", Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

body{
  background:rgba(235, 229, 229, 0.931);
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#home {
  color: rgba(204, 0, 0, 0.931);
}

#skills-table,
#employee-table {
  padding: 10px;
  margin: 20px;
}
img {
  width: 50%;
  height: auto;
}
</style>

<script>
export default {};
</script>
