<template>
    <div class="section">
        <form>
            <!-- <nav class="navbar shadow bg-white rounded justify-content-between flex-nowrap flex-row fixed-top"> -->
            <h3 class="loginheading">Login</h3>

            <div class="form-group row">
                <!-- <label for="staticEmail" class="col-sm-2 col-form-label">Email address</label> -->
                <input v-model="form.email" class="form-control1" placeholder="Email"/>
            </div>

            <div class="form-group row">
                <!-- <label for="inputPassword" class="col-sm-2 col-form-label">Password</label> -->
                <input v-model="form.password" type="password" class="form-control1" placeholder="Password"/>
            </div>

            <b-button v-on:click="onlogin" type="submit" class="btn btn-info btn-lg btn-block" variant="primary">Login</b-button>
            <p> </p>
            
            <!-- </nav> -->
        </form>
    </div>
</template>

<script>
import axios from 'axios'

    export default {
        data() {
            return {
                form: {
                email: '',
                password: '',
                }
            }
        },

        beforeCreate: function(){
            document.body.className = 'login';
        },
        methods:{
            onlogin(event){
                event.preventDefault()
                axios("http://localhost:8081/login?email=" + this.form.email + "&pwd=" + this.form.password)
                        .then((jsonData) => {
                            this.$router.push({ name : jsonData.data.login.accountType, params: { id : jsonData.data.id } })
                        })
                this.form.email= ''
                this.form.password= ''
            }
        },
    }
</script>

<style>
html, body{
	width:100%;
	height:100%;
	margin:0px;
	font-family: 'Work Sans', sans-serif;
}

body.login{
    background-image:url('../assets/5.jpg');
    background-size: cover;
    display: flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    color: #fff;
}

.section{
    margin: 100px;
    padding: 120px;
    padding-bottom: 60px;
    padding-top: 90px;
    /* background-image: url('../assets/trial2.jpg'); */
	background-color: rgba(183, 200, 218, 0.72);
	width:100%;
	min-height:50%;
	display:flex;
	flex-direction:column;
	margin-left:auto;
	margin-right:auto;
}

.loginheading{
	font-family: 'Archivo Black', sans-serif;
    font-weight: bold;
	color:#020f44;
	margin-left:auto;
	margin-right:auto;
}


.form-control1{
	height:40px;
	padding: 10px 10px;
	margin: 10px 10px;
	background-color:#ffffff;
	border:royalblue;
}

</style>