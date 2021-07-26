<template>
  <div class='profiled'>
    <h1>Profile</h1>
    <b-form @save="onSave" v-if="show">

      <b-form-group id="input-group-2" label="Employee ID:" label-for="input-2">
        <b-form-select
          id="input-2"
          v-model="form.empid"  
          required
          :options="EmployeeIds"
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-2" label="Government ID:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.govid"
          required
          
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Full Name:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.name"
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
        ></b-form-input>
      </b-form-group>
      
      <b-form-group id="input-group-3" label="Contact:" label-for="input-3">
        <b-form-input
          id="input-3"
          v-model="form.contact"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-7" label="Address:" label-for="input-7">
        <b-form-textarea
          id="textarea-rows"
          v-model="form.addr"
          rows = "2"
          max-rows = "8"
        ></b-form-textarea>
      </b-form-group>

      
      <b-form-group id="input-group-6" label="Blood Group:" label-for="input-6">
        <b-form-input
          id="input-6"
          v-model="form.bg"
        ></b-form-input>
      </b-form-group>

      <b-form-group
        id="input-group-1"
        label="Email address:"
        label-for="input-1"
      >
        <b-form-input
          id="input-1"
          v-model="form.email"
          type="email"
        ></b-form-input>
      </b-form-group>


      <b-form-group id="input-group-12" label="Date of Joining:" label-for="input-12">
        <b-form-input
          id="input-12"
          v-model="form.doj"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-12" label="Date of Termination:" label-for="input-12">
        <b-form-input
          id="input-12"
          v-model="form.dot"
        ></b-form-input>
      </b-form-group>


      <b-form-group id="input-group-8" label="Department:" label-for="input-8">
        <b-form-select
          id="input-8"
          v-model="form.dept"
          :options="Dept"
        ></b-form-select>
      </b-form-group>

      <b-form-group id="input-group-12" label="Annual Salary:" label-for="input-12">
        <b-form-input
          id="input-12"
          v-model="form.as"
        ></b-form-input>
      </b-form-group>

      <b-button type="save" variant="primary" style="margin:10px;">Save</b-button>
    </b-form>
  </div>
</template>

<script>
import axios from 'axios'
  export default {
    data() {
      return {
        form: {
          empid: '',
          govid: '',
          email: '',
          name: '',
          gender: '',
          contact: '',
          dot: '',
          doj: '',
          dob: '',
          bg: '',
          addr: '',
          dept: '',
          as: '',
        },
        Gender: [{ text: 'Select One', value: null }, 'M', 'F', 'O'],
        Dept: [{text: 'Select One', value: null}, 'Chemist', 'Doctor','Manager','Nurse', 'Receptionist'],
        EmployeeIds: [{text: 'Select One', value: null}],
        show: true
      }
    },
    beforeCreate: function(){
        document.body.className="profile"
    },
    mounted: function(){
        axios.get("http://localhost:8081/employees")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.EmployeeIds.push(jsonData.data[x].employeeId)
            }
        });
        axios.get("http://localhost:8081/employees")
        .then((jsonData)=>{
            console.log("something")
            this.form.govid=(jsonData.data[this.form.empid].governmentId)
        });
    }, 
    methods: {
      onSave(event) {
        event.preventDefault()
        alert(JSON.stringify("Employee Updated"))
      }
    }
  }
</script>


<style >
.profiled {
    /* top right bottom left */
  padding: 20px;
  background: rgb(250, 250, 250);
  margin: 10px 700px 10px 10px; 
  /* border: 1cm; */
  text-align: left;
  color:rgb(0, 0, 0);
}
</style>