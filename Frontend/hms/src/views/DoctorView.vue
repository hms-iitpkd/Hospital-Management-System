<template>
    <div class="abc">
        <Navbar />
        <div class="sect">
            <h3 class="title">Appointments</h3>
        
            <b-table class="tab" dark sticky-header=80vh hover :items="items">
                <template #cell(patientId)="data">
                    <router-link :to="'patient/ ' + `${data.value}`">{{ data.value }}</router-link>
                </template>
            </b-table>
            
        </div>
    </div>
</template>

<script>
import Navbar from '../components/navbar.vue'
import axios from 'axios'

    export default {
        data() {    
            return {
                items: [],
                id : 1
            }
        },
        components: {
            Navbar
        },
        beforeCreate: function (){
            document.body.className = "doctor"
        },
        mounted: function(){
            axios.get("http://localhost:8081/doctors/" + this.$route.params.id)
            .then((jsonData) => {
                var x;
                for(x in jsonData.data.doctorAppointments){
                this.items.push({ patientId : jsonData.data.doctorAppointments[x].patient.patientId,
                                  patientName : jsonData.data.doctorAppointments[x].patient.name,
                                  age : jsonData.data.doctorAppointments[x].patient.age,
                                  gender : jsonData.data.doctorAppointments[x].patient.gender,
                                  bloodGroup : jsonData.data.doctorAppointments[x].patient.bloodGroup,
                                  time : jsonData.data.doctorAppointments[x].id.date_Time,
                                  lastVisitDate : jsonData.data.doctorAppointments[x].patient.lastVisitDate });
                }
            })
        }
    }
</script>

<style>
.abc{
    height: 90vh;
}
.sect{
	background-color: rgba(183, 200, 218, 0.72);
    margin-top: 10px;
    margin-left: 10px;
    margin-right: 10px;
    height: 100%;
}
.title{
	font-family: 'Archivo Black', sans-serif;
    padding: 10px;
}
.tab{
    width : 80%;
    margin: auto;
}

body.doctor{
    background-image:url('../assets/5.jpg');
    background-size: cover;
}

.h3{
	font-family: 'Archivo Black', sans-serif;
	color:#e0dada;
	margin-left:auto;
	margin-right:auto;
}

</style>