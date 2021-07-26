<template>
    <div class="abc">
        <Navbar/>
        <div class="sect">
            <h3 class="title">Ward Duty</h3>
        
            <b-table class="tab" dark sticky-header=80vh hover :items="items">
            <template #cell(room_number)="data">
                <router-link :to="'ward/' + `${data.value}`">{{ data.value }}</router-link>
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
                items: []
            }
        },
        components: {
            Navbar
        },
        beforeCreate: function (){
            document.body.className = "nurse"
        },
        mounted: function(){
            axios.get("http://localhost:8081/nurses/" + this.$route.params.id)
            .then((jsonData) => {
                var x;
                for(x in jsonData.data.nurseWardDutys){
                this.items.push(jsonData.data.nurseWardDutys[x].id);
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

body.nurse{
    background-image:url('../assets/5.jpg');
    background-size: cover;
}

</style>