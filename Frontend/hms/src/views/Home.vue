<template >
  <div class="home1">
    <h1 class='homeheading'>Sangwan Hospital</h1>
    <p>
      "Here every normal thing is an emergency"
    </p>
    <router-link to="/login"> 
      <b-button class="btn " variant="dark">Go To Login Page</b-button> 
    </router-link>
  </div>
</template>

<script>
  export default {
    beforeCreate: function(){
      document.body.className = 'home';
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
/* top right bottom left */

.homeheading {
  /* margin: 400px 500px 10px 50px; */
  border: 1cm;
  color:rgb(0, 0, 0);
  font-size: 1.3cm;
}

body.home{
  background-image:url('https://cdn.nerdschalk.com/wp-content/uploads/2020/09/download-premium-vector-of-blank-camellia-leaves-frame-vector-1208573.jpg');
  background-size: cover;
  display: flex;
  flex-direction:column;
  /* justify-content:center; */
  align-items:center;
  color: rgb(255, 255, 255);
}

.home1 {
  margin: 350px 500px 300px 50px;  
  font-family: Avenir, Helvetica, Arial, sans-serif;
  font-weight: 800;
  font-size: 0.6cm;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color:rgb(0, 0, 0);
  /* margin-top: 0px; */
}
</style>