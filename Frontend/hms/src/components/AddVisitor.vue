    <template>
    <div>
        <div class='appointment'>
        <h3>Add Visitor</h3>
            <b-form @submit="onSubmit" v-if="show">
            
            <b-form-group id="input-group-2" label="Visitor Name:" label-for="input-2">
                <b-form-input
                id="input-2"
                v-model="form.name"
                required
                ></b-form-input>
            </b-form-group>
            
            <b-form-group id="input-group-3" label="ContactNumber:" label-for="input-3">
                <b-form-input
                id="input-3"
                v-model="form.contact"
                required
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-4" label="Relation:" label-for="input-4">
                <b-form-input
                id="input-4"
                v-model="form.relation"  
                ></b-form-input>
            </b-form-group>

            <b-form-group id="input-group-5" label="Admission ID:" label-for="input-5">
                <b-form-input
                id="input-5"
                v-model="form.aid"
                ></b-form-input>
            </b-form-group>
            <b-form-group id="input-group-5" label="Session Timings:" label-for="input-5">
                <b-form-input
                id="input-5"
                v-model="form.stime"
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
        form: {
          visitorId: '',
          name: '',
          contact: '',
          relation: '',
          aid: '',
          stime: ''
        },
        show: true
      }
    },
    methods: {
      onSubmit(event) {
        var visitorJson = {
                              "name": this.form.name,
                              "contactNumber": this.form.contact,
                              "relation": this.form.relation
                          }
        event.preventDefault()
        axios.post("http://localhost:8081/visitors?admission_id=" + this.form.aid + "&session_timings=" + this.form.stime, visitorJson )
                   .then((jsonData) => {
                        if (jsonData.status != 200){
                          alert("Something went wrong")
                        }
                   })

        // Reset our form values
        this.form.visitorId = ''
        this.form.name = ''
        this.form.contact = ''
        this.form.relation = ''
        this.form.aid = ''
        this.form.stime = ''
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
</style>