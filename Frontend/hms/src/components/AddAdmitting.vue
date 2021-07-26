<template>
    <div>
        <div class='appointment'>
        <h3>Admitting Patient</h3>
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
            

            <b-button @click="onClick" variant="primary" style="margin:10px;">Check for Empty Room Number</b-button>
            <b-card class="mt-3" header="Room having space to admit patient">
            <pre class="m-0">{{ room.RoomNo }}</pre>
            </b-card>

            <b-form-group id="input-group-4" label="Room Number:" label-for="input-4">
                <b-form-input
                id="input-4"
                v-model="form.rn"  
                ></b-form-input>
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
        room: {
            RoomNo : '',
        },
        form: {
          patientId: '',
          name: '',
          admId: '',
          rn: '',
          date: '',
        },
        show: true
      }
    },
    methods: {
      onClick(event){
        event.preventDefault()
        axios.get("http://localhost:8081/wards/empty")
            .then((jsonData) => {
                this.room.RoomNo = jsonData.data
            })
      },
      onSubmit(event) {
        event.preventDefault()
        axios.post("http://localhost:8081/admitted?patient_id=" + this.form.patientId + "&room_number=" + this.form.rn )

                   .then((jsonData) => {
                        if (jsonData.status != 200){
                          alert("Something went wrong")
                        }
                        else{
                          // Reset our form values
                          this.form.patientId = ''
                          this.form.name = ''
                          this.form.admId = ''
                          this.form.rn = ''
                          this.form.date = ''
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

</style>