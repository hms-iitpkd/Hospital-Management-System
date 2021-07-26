<template>
  <div>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      <b-form-group id="input-group-1" label-for="input-1">
        <b-form-input
          id="input-1"
          v-model="form.problem"
          placeholder="Problem:"
          required
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label-for="input-2">
        <b-form-textarea
          id="textarea"
          v-model="form.desc"
          placeholder="Description"
          rows="3"
          max-rows="6"
        ></b-form-textarea>
      </b-form-group>

      <b-form-group label="Tests :" v-slot="{ ariaDescribedby }">
        <b-form-checkbox-group
          id="checkbox-group-1"
          v-model="form.checked"
          :options="options"
          :aria-describedby="ariaDescribedby"
          name="flavour-1"
        ></b-form-checkbox-group>
      </b-form-group>

      <b-form-group label="Medicines:" >
        <b-form-select v-model="form.meds" :options="meds" multiple :select-size="4"></b-form-select>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>

  </div>
</template>

<script>
import axios from 'axios'

export default {
  data() {
    return {
      options: [],
      meds: [],
      form: {
        desc: '',
        problem: '',
        checked: [],
        meds: []
      },
      show: true
    }
  },
  props: ['patientId', 'doctorId'],
  methods: {
    onSubmit(event) {
      event.preventDefault()

      var treatmentJson = {
                            "date" : new Date(),
                            "description" : this.form.desc,
                            "problem" : this.form.problem
                          }
      
      var requestJson = { "treatment" : treatmentJson,
                          "patientId" : this.patientId,
                          "doctorId" : this.doctorId,
                          "medicineId" : this.form.meds,
                          "testId" : this.form.checked }

      axios.post("http://localhost:8081/treatment", requestJson)
                  .then((jsonData) => {
                    if(jsonData.status != 200) alert("Someting went wrong")
                    else if(jsonData.data == -1) alert("Something went wrong")
                  })
    },
    onReset(event) {
      event.preventDefault()
      // Reset our form values
      this.form.email = ''
      this.form.name = ''
      this.form.food = null
      this.form.checked = []
      // Trick to reset/clear native browser form validation state
      this.show = false
      this.$nextTick(() => {
        this.show = true
      })
    }
  },
  mounted: function(){
      axios.get("http://localhost:8081/laboratories")
      .then((jsonData) => {
          var x;
          for(x in jsonData.data){
            this.options.push({ text : jsonData.data[x].purpose, value : jsonData.data[x].laboratoryId })
          }
      })
      axios.get("http://localhost:8081/medicines")
      .then((jsonData) => {
          var x;
          for(x in jsonData.data){
            this.meds.push({ text : jsonData.data[x].name,  value : jsonData.data[x].medicineId })
          }
      })

  }


  }
</script>