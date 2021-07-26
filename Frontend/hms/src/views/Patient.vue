<template>
    <div class="abc">
        <Navbar/>
        <b-card no-body class = "t">
            <b-tabs card >
                <b-tab title="Patient Details" active>
                <b-card-text>
                    <b-table class="tab" dark sticky-header=79vh hover :items="items" :fields="fields"></b-table>
                    <Input class = "tab" :doctorId = 1 :patientId = this.$route.params.id />
                </b-card-text>
                </b-tab>
                <b-tab title="History">
                <b-card-text>
                    <b-table class="tab" dark sticky-header=79vh hover :items="history"></b-table>
                </b-card-text>
                </b-tab>
            </b-tabs>
        </b-card>

        
    {{doctorId}}
    </div>
</template>

<script>
import Navbar from '../components/navbar.vue'
import Input from '../components/treatmentInput'
import axios from 'axios'

    export default {
        data() {    
            return {
                items: [],
                fields : [ "patientId", "name", "age", "gender", "height", "weight", "bloodGroup", "contactNumber", "emailId", "address", "history", "lastVisitDate"],
                history: []
            }
        },
        props : ['doctorId'],
        components: {
            Navbar, Input
        },
        beforeCreate: function (){
            document.body.className = "nurse"
        },
        mounted: function(){
            axios.get("http://localhost:8081/patient/" + this.$route.params.id)
            .then((jsonData) => {
                this.items.push(jsonData.data)
                var x;
                for(x in jsonData.data.patientTreatmentTreatments){
                    var y;
                    var med = ""
                    for(y in jsonData.data.patientTreatmentTreatments[x].includesMedicines){
                        med += jsonData.data.patientTreatmentTreatments[x].includesMedicines[y].name + ", "
                    }
                    this.history.push({ treatmentId : jsonData.data.patientTreatmentTreatments[x].treatmentId,
                                        data : jsonData.data.patientTreatmentTreatments[x].date,
                                        description : jsonData.data.patientTreatmentTreatments[x].description,
                                        problem : jsonData.data.patientTreatmentTreatments[x].problem,
                                        medcines : med })
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
    width : 90%;
    margin: auto;
    padding: 10px;
}

body.nurse{
    background-image:url('../assets/5.jpg');
    background-size: cover;
}

</style>