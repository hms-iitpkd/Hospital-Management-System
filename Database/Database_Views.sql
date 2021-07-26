
-- The view that relates employee and his login credentials
-- This view can be useful for Manager, for keeping track of the current login credentials
create view employee_login_info as
select Login.Name, Employee_ID, Government_ID, Employee.Contact_Number, Department, Annual_Salary, Access_Level, Last_Login, Date_of_Joining, Date_of_Termination
from Login 
inner join Employee_login using (Email_ID)
inner join Employee using (Employee_ID);

-- This view contains all the information of the doctor
create view employee_doctor as 
select Employee_ID, Government_ID, Doctor_ID, Doctor.Name, Date_of_Joining, Date_of_Termination, Annual_Salary, Specialization, Patients_treated, Room_no, `Consultancy Fees`, Experience 
from Employee
inner join D_Job using (Employee_ID) 
inner join Doctor using (Doctor_ID);

-- This view contains all the information of the receptionist
create view employee_receptionist as 
select Employee_ID, Government_ID, Receptionist_ID, Employee.Name, Date_of_Joining, Date_of_Termination, Annual_Salary, Experience, Shift
from Employee
inner join R_Job using (Employee_ID) 
inner join Receptionist using (Receptionist_ID);

-- This view contains all the information related to the nurse
create view employee_nurse as 
select Employee_ID, Government_ID, Nurse_ID, Employee.Name, Date_of_Joining, Date_of_Termination, Annual_Salary, Experience
from Employee
inner join N_Job using (Employee_ID) 
inner join Nurse using (Nurse_ID);

-- This view contains all the information related to the chemist
create view employee_chemist as 
select Employee_ID, Government_ID, Chemist_ID, Employee.Name, Date_of_Joining, Date_of_Termination, Annual_Salary, Shift
from Employee
inner join Ch_Job using (Employee_ID) 
inner join Chemist using (Chemist_ID);

-- This view has information related to which visitor has come to visit which paitent and in which ward is the patient
-- Such view can be made accessible to the Receptionist, so that they are aware of the history of the visitor visits
create view admitted_visitor_ward as
with ward_room as (select Room_number from Ward)
select * from 
Admitted left outer join Visiting using (Admission_ID) 
left outer join Visitor using (Visitor_ID)
left outer join Adm_Room using (Admission_ID)
inner join ward_room using (Room_number);

-- This contains the patient information and the information about where they are staying
-- This information will be useful for the receptionist in case some visitor has come to visit some patient, and he is trying to locate where that patient is currently staying
create view admitted_patient as
with ward_room as (select Room_number from Ward)
select * from 
Patient natural join Stay  natural join Admitted natural join Adm_Room natural join ward_room;

-- This view has information relating to the upcoming appointments.
-- Both the doctors and the receptionists will be given the access to this view so that the Doctor can keep track of the current appointments, and the receptionist can fix further appointments, accordingly
create view patient_appointment_doctor as 
select Patient.Name as Patient_Name, Doctor.Name as Doctor_Name, Date_Time from Patient natural join Appointment inner join Doctor using(Doctor_ID);

-- This view has information about which patient has been treated by which patient in the past, and other attributes related to the treatment
create view patient_doctor as
select Patient.Name as Patient_name, Treatment_ID, Doctor_ID, Doctor.Name as Doctor_name from Patient natural join Patient_Treatment natural join Treatment natural join Treats join Doctor using(Doctor_ID);
 
-- This view shows the nurses about their upcoming ward duties, and also the history to her duties. Nurses will be given access to this view in order to keep track of their duties
create view nurse_duty as
select * from (select Nurse_ID, Name as Nurse_name, Experience from Nurse) as A natural join Ward_Duty natural join Ward natural join Adm_Room natural join Stay join Patient using(patient_id);

