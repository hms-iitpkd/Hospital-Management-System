import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import About from '../views/About.vue'
import FP from '../views/ForgotPassword.vue'
import Doctor from '../views/DoctorView.vue'
import Nurse from '../views/NurseView.vue'
import Chemist from '../views/ChemistView.vue'
import Manager from '../views/Manager.vue'
import Receptionist from '../views/Receptionist.vue'
import Ward from '../views/WardView.vue'
import Patient from '../views/Patient.vue'
import Profile from '../components/Profile.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/forgot-password',
    name: 'forgot-password',
    component: FP
  },
  {
      path: '/about',
      name: 'about',
      component: About
  },
  {
    path: '/doctor/:id',
    name: 'doctor',
    component: Doctor
  },
  {
    path: '/nurse/:id',
    name: 'nurse',
    component: Nurse
  },
  { 
    path: '/chemist',
    name: 'chemist',
    component: Chemist
  },
  { 
    path: '/manager',
    name: 'manager',
    component: Manager
  },
  { 
    path: '/receptionist',
    name: 'recep',
    component: Receptionist
  },
  { 
    path: '/nurse/ward/:id',
    name: 'ward',
    component: Ward
  },
  { 
    path: '/doctor/patient/:id',
    name: 'patient',
    component: Patient,
    props: true
  },
  {
    path: '/employee',
    name: 'Profile',
    component: Profile
  },
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
