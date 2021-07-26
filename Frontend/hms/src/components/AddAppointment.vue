<template>
    <div>
        <div class='appointment'>
        <h3>Add Appointment</h3>
            <b-form @submit="onSubmit" v-if="show">
            <b-form-group id="input-group-1" label="Patient ID:" label-for="input-1">
                <b-form-input
                id="input-1"
                v-model="form.patientId"
                required
                ></b-form-input>
            </b-form-group>
            
            <b-form-group id="input-group-2" label="Patient Name:" label-for="input-2">
                <b-form-input
                id="input-2"
                v-model="form.name"
                required
                ></b-form-input>
            </b-form-group>
            
            <b-form-group id="input-group-3" label="Doctor ID:" label-for="input-3">
                <b-form-input
                id="input-3"
                v-model="form.doctorId"
                required
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-4" label="Doctor Name:" label-for="input-4">
                <b-form-input
                id="input-4"
                v-model="form.doctorName"  
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Date:" label-for="input-5">
                <b-form-input
                id="input-5"
                v-model="form.date"
                type=date
                ></b-form-input>
            </b-form-group>
            
            <b-form-group id="input-group-6" label="Time:" label-for="input-6">
               <b-form-timepicker v-model="form.time" locale="en"></b-form-timepicker>
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
          patientId: '',
          name: '',
          doctorId: '',
          doctorName: '',
          date: '',
          time: '',
        },
        show: true
      }
    },
    methods: {
      onSubmit(event) {
        event.preventDefault()
        axios.post("http://localhost:8081/appointments?doctor_id=" + this.form.doctorId
                   + "&patient_id=" + this.form.patientId )
                   .then((jsonData) => {
                        if (jsonData.data != "Success"){
                          alert("Something went wrong")
                        }
                   })

        // Reset our form values
        this.form.patientId = ''
        this.form.name = ''
        this.form.doctorId = ''
        this.form.doctorName = ''
        this.form.date = ''
        this.form.time = ''
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