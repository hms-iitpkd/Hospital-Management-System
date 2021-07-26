<template >

<div class ="rt">  
  <Navbar /> 
    <b-card no-body class = "t">
      <b-tabs card >
        <b-tab title="Appointments" active>
          <b-card-text>
            <b-table class="tab" dark sticky-header=79vh hover :items="appointments"></b-table>
          </b-card-text>
        </b-tab>
        <b-tab title="Add Appointment">
          <b-card-text>
            <AddAppointment />
          </b-card-text>
        </b-tab>
        <b-tab title="Doctors">
          <b-card-text>
            <b-table class="tab" dark sticky-header=79vh hover :items="doctors" :fields="fields"></b-table>
          </b-card-text>
        </b-tab>
        <b-tab title="Admitted Patients">
          <b-card-text>
            <b-table class="tab" dark sticky-header=79vh hover :items="adp" :fields="adpFields"></b-table>
          </b-card-text>
        </b-tab>
        <b-tab title="Patients">
          <b-card-text>
            <b-table class="tab" dark sticky-header=79vh hover :items="pat" :fields="patFields"></b-table>
          </b-card-text>
        </b-tab>
         <b-tab title="Admitting Patient">
          <b-card-text>
            <AddAdmitting />
          </b-card-text>
        </b-tab>
        <b-tab title="Add Visitor">
          <b-card-text>
            <AddVisitor />
          </b-card-text>
        </b-tab>
        <b-tab title="Visitor">
          <b-card-text>
            <b-table class="tab" dark sticky-header=79vh hover :items="vis"></b-table>
          </b-card-text>
        </b-tab>
        <b-tab title="Add Patient">
          <b-card-text>
            <AddPatient />
          </b-card-text>
        </b-tab>
      </b-tabs>
    </b-card>

</div>
</template>

<script>
import Navbar from '../components/navbar.vue'
import AddAppointment from '../components/AddAppointment.vue'
import AddAdmitting from '../components/AddAdmitting.vue'
import AddVisitor from '../components/AddVisitor.vue'
import AddPatient from '../components/AddPatient.vue'
import axios from 'axios'

  export default {
    data() {    
        return {
            isshow: false,
            appointments: [],
            doctors: [],
            adp: [],
            pat: [],
            vis: [],
            fields: ["doctorId", "name", "department", "experience", "specialization", "patientsTreated", "roomNo", "consultancyFees"],
            adpFields: ["admissionId","patientId","name","dateOfAdmission"],
            patFields: ["patientId","name","age","gender","height","weight","bloodGroup","contactNumber"]            
        }
    },
    components: {
        Navbar,
        AddAppointment,
        AddAdmitting,
        AddVisitor,
        AddPatient
    },
    beforeCreate: function(){
      document.body.className = 'nurse';
    },
    methods: {
      onClick(){
        this.isshow= !this.isshow
      }
    },
    mounted: function(){
           axios.get("http://localhost:8081/doctors")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.doctors.push(jsonData.data[x])
                  var y;
                  for(y in jsonData.data[x].doctorAppointments){
                    this.appointments.push({ doctorId : jsonData.data[x].doctorId,
                                             doctorName : jsonData.data[x].name,
                                             patientName : jsonData.data[x].doctorAppointments[y].patient.name,
                                             age : jsonData.data[x].doctorAppointments[y].patient.age,
                                             gender : jsonData.data[x].doctorAppointments[y].patient.gender,
                                             bloodGroup : jsonData.data[x].doctorAppointments[y].patient.bloodGroup,
                                             time : jsonData.data[x].doctorAppointments[y].id.date_Time,
                                             lastVisitDate : jsonData.data[x].doctorAppointments[y].patient.lastVisitDate });
                  }
                }
            });
            axios.get("http://localhost:8081/patient")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.pat.push(jsonData.data[x])
                  
                }
            });
            axios.get("http://localhost:8081/admitted")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.adp.push({dateOfAdmission: jsonData.data[x].dateOfAdmission,
                                 admissionId: jsonData.data[x].admissionId,
                                 patientId: jsonData.data[x].stayPatients[0].patientId,
                                 name: jsonData.data[x].stayPatients[0].name})
                }
            });

            axios.get("http://localhost:8081/admitted")
            .then((jsonData) => {
                var x;
                var y;
                for(x in jsonData.data){
                  for (y in jsonData.data[x].admissionVisitings){
                    this.vis.push({   visitorId : jsonData.data[x].admissionVisitings[y].visitor.visitorId,
                                      name : jsonData.data[x].admissionVisitings[y].visitor.name,
                                      contactNumber : jsonData.data[x].admissionVisitings[y].visitor.contactNumber,
                                      relation : jsonData.data[x].admissionVisitings[y].visitor.relation,
                                      patientId : jsonData.data[x].stayPatients[0].patientId,
                                      dateOfAdmission : jsonData.data[x].dateOfAdmission,
                                      dateOfDisharge : jsonData.data[x].dateOfDisharge})
                  }
                }
            })
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
/* top right bottom left */

.t {
  min-height: 89vh;
  background-color: rgba(183, 200, 218, 0.72);
  margin: 10px;
}

.receptionistheading {
  /* margin: 400px 500px 10px 50px; */
  border: 1cm;
  color:rgb(0, 0, 0);
  font-size: 1.3cm;
}

body.receptionist{
  background-image:url('../assets/5.jpg');
  background-size: cover;
  /* display: flex;
  flex-direction:column;
  justify-content:center;
  align-items:center; */;
}

.receptionist1 {
  /* margin: 350px 500px 300px 50px;   */
  font-family: Avenir, Helvetica, Arial, sans-serif;
  font-weight: 800;
  font-size: 0.6cm;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  /* text-align: center; */
  color:rgb(0, 0, 0);
  /* margin-top: 0px; */
}
</style>