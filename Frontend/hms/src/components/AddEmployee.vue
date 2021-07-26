<template>
  <div class='registerform'>
    <h1>Registration Form</h1>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group
        id="input-group-1"
        label="Email address:"
        label-for="input-1"
        description="We'll never share your email with anyone else."
      >
        <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
          placeholder="Enter email"
          required
        ></b-form-input>
      </b-form-group>

    <b-form inline>
      <b-form-group id="input-group-2" label="Your Name:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.name"
          placeholder="Enter name"
          required
        ></b-form-input>
      </b-form-group>
      
      <b-form-group id="input-group-3" label="Contact:" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="form.contact"
          placeholder="Enter contact number"
          required
        ></b-form-input>
      </b-form-group>
    </b-form>
    <br>
      <b-form-group id="input-group-12" label="Government ID:" label-for="input-12">
        <b-form-input
          id="input-12"
          v-model="form.govtid"
          placeholder="Enter govt. ID"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-4" label="Gender:" label-for="input-4">
        <b-form-select
          id="input-4"
          v-model="form.gender"
          :options="Gender"
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-5" label="Date Of Birth:" label-for="input-5">
        <b-form-input
          id="input-5"
          v-model="form.dob"
          type=date
        ></b-form-input>
      </b-form-group>
      
      <b-form-group id="input-group-6" label="Blood Group:" label-for="input-6">
        <b-form-input
          id="input-6"
          v-model="form.bg"
          placeholder="Enter Blood Group"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-8" label="Department:" label-for="input-8">
        <b-form-select
          id="input-8"
          v-model="form.dept"
          :options="Dept"
          required
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-7" label="Address:" label-for="input-7">
        <b-form-textarea
          id="textarea-rows"
          v-model="form.addr"
          placeholder="Enter Address"
          rows = "2"
          max-rows = "8"
        ></b-form-textarea>
      </b-form-group>

      <b-form-group id="input-group-11" label="Password:" label-for="input-11">
        <b-form-input
          id="input-11"
          v-model="form.password"
          type="password"
          placeholder="Enter Password"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-10" v-slot="{ ariaDescribedby }">
        <b-form-checkbox-group
          v-model="form.checked"
          id="checkboxes-4"
          :aria-describedby="ariaDescribedby"
        >
          <b-form-checkbox value="me">I agree the terms and conditions</b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group>

      <b-button type="submit" variant="primary" style="margin:10px;">Submit</b-button>
      
      <b-button type="reset" variant="danger" style="margin:10px;">Reset</b-button>
    </b-form>
  </div>
</template>

<script>
import axios from 'axios'

  export default {
    data() {
      return {
        form: {
          email: '',
          name: '',
          gender: null,
          contact: '',
          govtid: '',
          dob: '',
          bg: '',
          addr: '',
          dept: null,
          checked: []
        },
        ac : ['Manager', 'Doctor', 'Nurse', 'Receptionist', 'Chemist'],
        Gender: [{ text: 'Select One', value: null }, 'Male', 'Female', 'Other'],
        Dept: [{text: 'Select One', value: null}, 'Manager', 'Doctor', 'Nurse', 'Receptionist', 'Chemist'],
        show: true
      }
    },
    beforeCreate: function(){
        document.body.className="register"
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()

        var accountType = "";

        if (this.form.dept == "Receptionist"){
          accountType = "recep"  
        }
        else{
          accountType = this.form.dept.toLowerCase()
        }

        var loginJson = {
                          "emailId" : this.form.email,
                          "name" : this.form.name,
                          "password" : this.form.password,
                          "contactNumber" : this.form.contact,
                          "accountType" : accountType,
                          "accessLevel" : this.ac.indexOf(this.form.dept),
                          "lastLogin": new Date()
                        }
        var employeeJson ={
                            "governmentId": this.form.govtid,
                            "name": this.form.name,
                            "dateOfBirth": this.form.dob,
                            "gender": this.form.gender[0],
                            "contactNumber": this.form.contact,
                            "address": this.form.addr,
                            "bloodGroup": this.form.bg,
                            "emailId": this.form.email,
                            "department": this.form.dept,
                            "dateOfJoining" : new Date()
                          }

        var requestJson = { "login" : loginJson,
                            "employee" : employeeJson }

        axios.post("http://localhost:8081/login/register", requestJson)
                      .then((jsonData) => {
                        if(jsonData.status != 200){
                          alert("Someting went wrong")
                        }
                      })

        
      },
      onReset(event) {
        event.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.name = ''
        this.form.gender = null
        this.form.contact = ''
        this.form.govtid = ''
        this.form.dob = ''
        this.form.bg = ''
        this.form.addr = ''
        this.form.dept = null
        this.form.checked = []
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
    }
  }
</script>

<style >
.registerform {
    /* top right bottom left */
  padding: 20px;
  background: rgb(250, 250, 250);
  margin: 10px 700px 10px 10px; 
  /* border: 1cm; */
  text-align: left;
  color:rgb(0, 0, 0);
}
</style>