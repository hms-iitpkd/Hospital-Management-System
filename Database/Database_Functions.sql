delimiter $

create or replace Function get_amount(T_ID int) 
returns int deterministic
begin 
    declare test_amount int;
    declare med_amount int;
    declare doc_amount int;
    declare tot_amount int;

    set doc_amount = ( select COALESCE(sum(`Consultancy Fees`), 0)
                       from Treatment natural join Treats natural join Doctor 
                       where Treatment_ID=T_ID );

    set med_amount = ( select COALESCE(sum(`Price`), 0) 
                       from Includes natural join Medicine 
                       where Treatment_ID=T_ID );
    
    set test_amount = ( select COALESCE(sum(`Price`), 0)
                        from Test 
                        where Treatment_ID=T_ID );
    

    set tot_amount = doc_amount + test_amount + med_amount;
    return tot_amount;

end;$


create Function empty_ward()
returns int deterministic
begin 
    declare room_no int;
    set room_no = ( select Room_Number from 
                    (select Room_Number from Ward where Beds_Available > 0) as Temp
                    order by Temp.Room_Number limit 1);

    return room_no;
end;$

create Function find_a_ward_without_nurse()
returns int deterministic
begin 
    declare ret int;
    set ret = (select Room_Number from  
                (select Room_Number from 
                 Ward left outer join Ward_Duty using(Room_Number)
                 where Occupancy > Beds_Available and Nurse_ID is NULL) as Temp 
               order by Temp.Room_Number limit 1);

    return ret;
end;$


delimiter ;