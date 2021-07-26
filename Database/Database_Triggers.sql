-- Triggers

delimiter $
create or replace trigger test_insert_bill_update
    after insert on Test for each row 
        update Bill set 
            Total_Amount = get_amount(new.Treatment_ID), 
            Amount_Pending = (Total_Amount - Paid)
        where Bill_ID in (select Bill_ID from Payment where Treatment_ID = new.Treatment_ID); $


delimiter $
create or replace trigger doctor_employee_update
    after update on Employee 
    for each row 
    begin
        update Doctor set
        Doctor.Name = new.Name
        where Doctor_ID in 
        (select Doctor.Doctor_ID from Employee inner join D_Job using(Employee_ID) 
        inner join Doctor using (Doctor_ID) 
        where Employee.Employee_ID = new.Employee_ID);
    end $
delimiter ;

delimiter $
create or replace trigger chemist_employee_update
    after update on Employee 
    for each row 
    begin
        update Chemist set
        Chemist.Name = new.Name,
        Chemist.Contact_Number = new.Contact_Number
        where Chemist_ID in 
        (select Chemist.Chemist_ID from Employee inner join Ch_Job using(Employee_ID) 
        inner join Chemist using (Chemist_ID) 
        where Employee.Employee_ID = new.Employee_ID);
    end $
delimiter ;

delimiter $
create or replace trigger nurse_employee_update
    after update on Employee 
    for each row 
    begin
        update Nurse set
        Nurse.Name = new.Name
        where Nurse_ID in 
        (select Nurse.Nurse_ID from Employee inner join N_Job using(Employee_ID) 
        inner join Nurse using (Nurse_ID) 
        where Employee.Employee_ID = new.Employee_ID);
    end $
delimiter ;

delimiter $
create or replace trigger manager_employee_update
    after update on Employee 
    for each row 
    begin
        update Manager set
        Manager.Name = new.Name
        where Manager_ID in 
        (select Manager.Manager_ID from Employee inner join M_Job using(Employee_ID) 
        inner join Manager using (Manager_ID) 
        where Employee.Employee_ID = new.Employee_ID);
    end $
delimiter ;

delimiter $
create or replace trigger receptionist_employee_update
    after update on Employee 
    for each row 
    begin
        update Receptionist set
        Receptionist.Name = new.Name
        where Receptionist_ID in 
        (select Receptionist.Receptionist_ID from Employee inner join R_Job using(Employee_ID) 
        inner join Receptionist using (Receptionist_ID) 
        where Employee.Employee_ID = new.Employee_ID);
    end $
delimiter ;

delimiter $
create or replace trigger admitted_ward_update
    after update on Admitted
    for each row 
    begin
        update Ward set 
        Ward.Beds_Available = Ward.Beds_Available + 1
        where Ward.Room_Number in 
        (select Ward.Room_Number from Admitted inner join Adm_Room using(Admission_ID)
         inner join Ward using (Room_Number)
         where Admitted.Admission_ID = new.Admission_ID); 
    end $
delimiter ;

delimiter $
create or replace trigger treatment_doctor_patient_insert 
    after insert on Treatment
    for each row 
    begin 
        update Doctor set 
        Doctor.Patients_treated = Doctor.Patients_treated + 1
        where Doctor.Doctor_ID in 
        (select Doctor.Doctor_ID from Treatment inner join Treats using(Treatment_ID)
         inner join Doctor using (Doctor_ID)
         where Treatment.Treatment_ID = new.Treatment_ID);

        update Patient set 
        Patient.Last_Visit_Date = new.Date 
        where Patient.Patient_ID in 
        (select Patient.Patient_ID from Treatment inner join Patient_Treatment using(Treatment_ID)
         inner join Patient using (Patient_ID)
         where Treatment.Treatment_ID = new.Treatment_ID);
    end $
delimiter ;

delimiter $
create or replace trigger t1 after insert on Treatment
    for each row
    BEGIN
    declare a int;
    declare d DATE;
    set @d = DATE(NOW()); 
    set @a = (select Bill_ID from Bill order by Bill_ID desc limit 1);
    insert into Bill values ((@a)+1,17.5,get_amount(new.Treatment_ID),0,get_amount(new.Treatment_ID),@d);
    insert into Payment values (new.Treatment_ID,(@a)+1, NULL);
    END;$
delimiter ;

delimiter $
create or replace trigger t2 after insert on Treats
    for each row
    BEGIN
        declare a int;
        set @a = (select Bill_ID from Payment where Treatment_ID = new.Treatment_ID);
    update Bill set Total_Amount = get_amount(new.Treatment_ID) where Bill_ID = @a;
        update Bill set Amount_Pending = get_amount(new.Treatment_ID) where Bill_ID = @a;
    END;$
delimiter ;


delimiter $
create or replace trigger test_insert_bill_update
    after insert on Test for each row 
        update Bill set 
            Total_Amount = get_amount(new.Treatment_ID), 
            Amount_Pending = (Total_Amount - Paid)
        where Bill_ID in (select Bill_ID from Payment where Treatment_ID = new.Treatment_ID); $

create or replace trigger test_update_bill_update
    after update on Test for each row 
        update Bill set 
            Total_Amount = get_amount(new.Treatment_ID), 
            Amount_Pending = (Total_Amount - Paid)
        where Bill_ID in (select Bill_ID from Payment where Treatment_ID = new.Treatment_ID); $


create or replace trigger includes_insert_bill_update
    after insert on Includes for each row 
        update Bill set 
            Total_Amount = get_amount(new.Treatment_ID), 
            Amount_Pending = (Total_Amount - Paid)
        where Bill_ID in (select Bill_ID from Payment where Treatment_ID = new.Treatment_ID); $

create or replace trigger includes_update_bill_update
    after update on Includes for each row 
        update Bill set 
            Total_Amount = get_amount(new.Treatment_ID), 
            Amount_Pending = (Total_Amount - Paid)
        where Bill_ID in (select Bill_ID from Payment where Treatment_ID = new.Treatment_ID); $

delimiter ;