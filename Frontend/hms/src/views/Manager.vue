<template >
<div class ="rt">  
  <Navbar /> 
  <b-card no-body class= "t">
    <b-tabs card>
      <b-tab title="Doctors" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover  :items="doctors" :fields="doctorFields"></b-table>
          <!-- <p></p>
          <router-link to="/doctor"> 
            <b-button class="btn " variant="dark">Doctor</b-button> 
          </router-link> -->
        </b-card-text>
      </b-tab>
      <b-tab title="Nurses" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover :items="nurses" :fields="nurseFields"></b-table>
          <!-- <p></p>
          <router-link to="/nurse"> 
            <b-button class="btn " variant="dark">Nurse</b-button> 
          </router-link> -->
        </b-card-text>
      </b-tab>
      <b-tab title="Chemist" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover :items="chemists" :fields="chemistFields"></b-table>
          <!-- <p></p>
          <router-link to="/chemist"> 
            <b-button class="btn " variant="dark">Chemist</b-button> 
          </router-link> -->
        </b-card-text>
      </b-tab>
      <b-tab title="Receptionist" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover :items="receptionsts" :fields="recepFields"></b-table>
          <!-- <p></p>
          <router-link to="/receptionist"> 
            <b-button class="btn " variant="dark">Receptionist</b-button> 
          </router-link> -->
        </b-card-text>
      </b-tab>

      <b-tab title="Add Employee">
          <b-card-text>
            <AddEmployee />
          </b-card-text>
        </b-tab>

    <!-- Added here temporarily -->
        <!-- <b-tab title="Update Employee Profile">
          <b-card-text>
            <Profile />
          </b-card-text>
        </b-tab> -->

      <b-tab title="Payment" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover :items="payment" :fields="paymentFields"></b-table>
        </b-card-text>
      </b-tab>

      <b-tab title="Visitors" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover :items="visitor" :fields="visFields"></b-table>
        </b-card-text>
      </b-tab>

      <b-tab title="Laboratories" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover :items="laboratories" :fields="labFields"></b-table>
        </b-card-text>
      </b-tab>

      <b-tab title="Vehicles" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover :items="vehicles" :fields="vecFields"></b-table>
        </b-card-text>
      </b-tab>

      <b-tab title="Utilities" active>
        <b-card-text>
          <b-table class="tab" dark sticky-header=80vh hover :items="utilities" :fields="utFields"></b-table>
        </b-card-text>
      </b-tab>

    </b-tabs>
  </b-card>

</div>
</template>

<script>
import Navbar from '../components/navbar.vue'
import axios from 'axios'
import AddEmployee from '../components/AddEmployee.vue'
// import Profile from '../components/Profile.vue'

  export default {
    data() {    
        return {
            isshow: false,
            doctors: [],
            doctorFields : ["doctorId", "name", "department", "experience", "specialization", "patientsTreated", "roomNo", "consultancyFees"],
            nurses: [],
            nurseFields : [ "nurseId", "name", "experience"],
            chemists: [],
            chemistFields: [ "chemistId", "name", "contactNumber", "shift"],
            receptionsts: [],
            recepFields: [ "receptionistId", "name", "experience", "shift"],
            laboratories: [],
            labFields: ["laboratoryId", "purpose", "sensitivity","roomNo"],
            vehicles: [],
            vecFields: ["vehicleNumber","type","inUse","description"],
            utilities: [],
            utFields: ["itemId","type","name","number"],
            payment: [],
            paymentFields: ["patientId","name","treatmentId","billId","totalAmount","amountPending"],
            visitor: [],
            visFields: ["visitorId","name","contactNumber","relation","patientId","dateOfAdmission","dateOfDisharge"],
            items: [
            { age: 40, first_name: 'Dickerson', last_name: 'Macdonald', name: "asds" },
            { age: 21, first_name: 'Larsen', last_name: 'Shaw', name: "asds" },
            { age: 89, first_name: 'Geneva', last_name: 'Wilson', name: "asds" },
            { age: 38, first_name: 'Jami', last_name: 'Carney', name: "asds" }
            ]
        }
    },
    components: {
        Navbar,
        AddEmployee,
        // Profile
    },
    beforeCreate: function(){
      document.body.className = 'manager';
    },
    mounted: function(){
           axios.get("http://localhost:8081/doctors")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.doctors.push(jsonData.data[x])
                }
            });
           axios.get("http://localhost:8081/nurses")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.nurses.push(jsonData.data[x])
                }
            });
           axios.get("http://localhost:8081/chemist")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.chemists.push(jsonData.data[x])
                }
            });
           axios.get("http://localhost:8081/receptionists")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.receptionsts.push(jsonData.data[x])
                }
            });
           
           axios.get("http://localhost:8081/laboratories")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.laboratories.push(jsonData.data[x])
                }
            });

           axios.get("http://localhost:8081/vehicles")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.vehicles.push(jsonData.data[x])
                }
            });
          
           axios.get("http://localhost:8081/utilities")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                  this.utilities.push(jsonData.data[x])
                }
            });

            axios.get("http://localhost:8081/admitted")
            .then((jsonData) => {
                var x;
                var y;
                for(x in jsonData.data){
                  for (y in jsonData.data[x].admissionVisitings){
                    this.visitor.push({   visitorId : jsonData.data[x].admissionVisitings[y].visitor.visitorId,
                                          name : jsonData.data[x].admissionVisitings[y].visitor.name,
                                          contactNumber : jsonData.data[x].admissionVisitings[y].visitor.contactNumber,
                                          relation : jsonData.data[x].admissionVisitings[y].visitor.relation,
                                          patientId : jsonData.data[x].stayPatients[0].patientId,
                                          dateOfAdmission : jsonData.data[x].dateOfAdmission,
                                          dateOfDisharge : jsonData.data[x].dateOfDisharge})
                  }
                }
            });

            axios.get("http://localhost:8081/patient")
            .then((jsonData) => {
                var x;
                var y;
                for(x in jsonData.data){
                  for (y in jsonData.data[x].patientTreatmentTreatments){
                    this.payment.push({   patientId : jsonData.data[x].patientId,
                                          name : jsonData.data[x].name,
                                          treatmentId : jsonData.data[x].patientTreatmentTreatments[y].treatmentId,
                                          billId : jsonData.data[x].patientTreatmentTreatments[y].treatmentPayments[0].bill.billId,
                                          totalAmount : jsonData.data[x].patientTreatmentTreatments[y].treatmentPayments[0].bill.totalAmount,
                                          amountPending : jsonData.data[x].patientTreatmentTreatments[y].treatmentPayments[0].bill.amountPending})
                  }
                }
            });
    }
  };
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style >
/* top right bottom left */

.managerheading {
  /* margin: 400px 500px 10px 50px; */
  border: 1cm;
  color:rgb(0, 0, 0);
  font-size: 1.3cm;
}

body.manager{
  background-image:url('https://cdn.nerdschalk.com/wp-content/uploads/2020/09/download-premium-vector-of-blank-camellia-leaves-frame-vector-1208573.jpg');
  background-size: cover;
  /* display: flex;
  flex-direction:column;
  justify-content:center;
  align-items:center; */
  color: rgb(255, 255, 255);
}

.manager1 {
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