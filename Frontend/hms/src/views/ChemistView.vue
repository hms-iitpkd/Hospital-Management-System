<template>
    <div class="abc">
        <Navbar />
        <div class="sect">
            <h3 class="title">Medicines</h3>
        
            <b-table class="tab" dark sticky-header=80vh hover :items="items"></b-table>
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
            document.body.className = "chemist"
        },
        mounted: function(){
            axios.get("http://localhost:8081/medicines")
            .then((jsonData) => {
                var x;
                for(x in jsonData.data){
                this.items.push(jsonData.data[x]);
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

body.chemist{
    background-image:url('../assets/5.jpg');
    background-size: cover;
}

</style>