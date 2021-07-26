<template>
    <div>
        <div class='appointment'>
        <h3>Add Patient</h3>
            <b-form @submit="onSubmit" v-if="show">
            <!-- <b-form-group id="input-group-1" label="Patient ID:" label-for="input-1">
                <b-form-input
                id="input-1"
                v-model="form.patientId"
                required
                ></b-form-input>
            </b-form-group> -->
            <b-form-group id="input-group-2" label="Full Name:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.name"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Age" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.age"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Height" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.Height"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Weight" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.Weight"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-4" label="Gender:" label-for="input-4">
        <b-form-select
          id="input-4"
          v-model="form.gender"
          :options="Gender"
        ></b-form-select>
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

        <b-form-group id="input-group-7" label="History:" label-for="input-7">
        <b-form-textarea
          id="textarea-rows"
          v-model="form.hist"
          rows = "2"
          max-rows = "8"
        ></b-form-textarea>
      </b-form-group>

            <b-button type="submit" variant="primary" style="margin:10px;">Add</b-button>
            
            </b-form>
           
        </div>
    </div>
</template>

<script>
import axios from 'axios'
export default {
    name: "NewAppointment",
    data() {
      return {
        form: {
          name: '',
          age: '',
          Height: '',
          Weight: '',
          gender: '',
          date: '',
          contact: '',
          addr: '',
          bg: '',
          email: '',
          hist: ''
        },
        Gender: [{ text: 'Select One', value: null }, 'M', 'F', 'O'],
        show: true
      }
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()
        var patientJson = { "name" : this.form.name,
                            "age" : this.form.age,
                            "gender" : this.form.gender,
                            "height" : this.form.Height,
                            "weight" : this.form.Weight,
                            "contactNumber" : this.form.contact,
                            "emailId" : this.form.email,
                            "bloodGroup" : this.form.bg,
                            "address" : this.form.addr,
                            "history" : this.form.hist
                          }
        axios.post("http://localhost:8081/patient", patientJson )
                   .then((jsonData) => {
                        if (jsonData.status != 200){
                          alert("Something went wrong")
                        }
                        else{
                          // Reset our form values
                          this.form = {}
                          // Trick to reset/clear native browser form validation state
                          this.show = false
                          this.$nextTick(() => {
                            this.show = true
                          })
                        }
                   })
      }
    }
}
</script>

<style >
.appointment {
    /* top right bottom left */
  padding: 20px;
  background: rgb(250, 250, 250);
  margin: 10px 700px 10px 10px; 
  /* border: 1cm; */
  text-align: left;
  color:rgb(0, 0, 0);
}
</style>