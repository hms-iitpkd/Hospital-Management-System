<template>
    <div class="fp_section">
        <form>
            <h3 class="FP">Forgot Password</h3>
            <br>
            <div class="form-group">
                <label>Email address</label>
                <input type="email" class="form-control form-control-sm" placeholder="Enter Email"/>
            </div>

            <br>
            <button type="submit" class="btn btn-dark btn-lg">Reset password</button>

        </form>
    </div>
</template>

<script>
    export default {
        data() {
            return {}
        },
        beforeCreate : function(){
            document.body.className = "forgotpassword"
        }
    }
</script>

<style>
.fp_section{
    /* background-image: url('../assets/4.jpeg'); */
    background-color:rgba(4, 35, 56, 0.705);
    text-align: center;
    padding: 100px;
    color:rgb(255, 255, 255);
}

.FP{
    font-weight: bold;
}

.forgotpassword{
    background-image:url('../assets/white.jpg');
    /* background-color: skyblue; */
    background-size: cover;
    display: flex;
    flex-direction:column;
    justify-content:center;
    align-items:center;
    color: #fff;
}

</style>