CREATE TABLE `Login` (
  `Name` varchar(36) NOT NULL,
  `Contact_Number` int,
  `Email_ID` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Account_Type` varchar(10),
  `Locality` varchar(20),
  `Access_Level` int NOT NULL,
  `Last_Login` DATETIME NOT NULL,
  PRIMARY KEY(Email_ID)
);

CREATE TABLE `Vehicle` (
  `Vehicle_Number` varchar(36) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `In_Use` int,
  `Description` varchar(255),
  PRIMARY KEY(Vehicle_Number)
);

CREATE TABLE `Patient` (
  `Patient_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  `Age` int,
  `Gender` varchar(10),
  `Height` varchar(10),
  `Weight` varchar(10),
  `Blood_Group` varchar(5),
  `Contact_Number` int,
  `Email_ID` varchar(100),
  `Address` varchar(100),
  `History` varchar(255),
  `Last_Visit_Date` DATE,
  PRIMARY KEY(Patient_ID)
);

CREATE TABLE `Utility` (
  `Item_ID` int NOT NULL AUTO_INCREMENT,
  `Type` varchar(36) NOT NULL,
  `Name` varchar(36) NOT NULL,
  `Number` int,
  PRIMARY KEY(Item_ID)
);

CREATE TABLE `Visitor` (
  `Visitor_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  `Contact_Number` varchar(36),
  `Relation` varchar(36),
  PRIMARY KEY (Visitor_ID)
);

CREATE TABLE `Treatment` (
  `Treatment_ID` int NOT NULL AUTO_INCREMENT,
  `Date` DATETIME NOT NULL,
  `Description` TEXT NOT NULL,
  `Problem` TEXT, 
  PRIMARY KEY(Treatment_ID)
);

CREATE TABLE `Manager` (
  `Manager_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  PRIMARY KEY(Manager_ID)
);

CREATE TABLE `Receptionist` (
  `Receptionist_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  `Experience` TEXT,
  `Shift` char(11),
  PRIMARY KEY(Receptionist_ID)
);

CREATE TABLE `Employee` (
  `Employee_ID` int NOT NULL AUTO_INCREMENT,
  `Government_ID` int NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Date_of_Birth` DATE,
  `Gender` char(1),
  `Contact_Number` varchar(12),
  `Address` varchar(100),
  `Blood_Group` varchar(3),
  `Email_ID` varchar(100) NOT NULL,
  `Date_of_Joining` DATE,
  `Date_of_Termination` DATE,
  `Department` varchar(100),
  `Annual_Salary` int,
  PRIMARY KEY(Employee_ID)
);

CREATE TABLE `Doctor` (
  `Doctor_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Department` varchar(100),
  `Experience` int,
  `Specialization` varchar(100),
  `Patients_treated` int,
  `Shift` DATETIME,
  `Room_no` int,
  `Consultancy Fees` int,
  PRIMARY KEY(Doctor_ID)
);

CREATE TABLE `Chemist` (
  `Chemist_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  `Contact_Number` char(12),
  `Shift` DATETIME,
  PRIMARY KEY(Chemist_ID)
);

CREATE TABLE `Nurse` (
  `Nurse_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL, 
  `Experience` int,
  PRIMARY KEY(Nurse_ID)
);

CREATE TABLE `Admitted` (
  `Admission_ID` int NOT NULL AUTO_INCREMENT,
  `Date_of_Admission` DATE,
  `Date_of_disharge` DATE,
  PRIMARY KEY(Admission_ID)
);

CREATE TABLE `Bill` (
  `Bill_ID` int NOT NULL AUTO_INCREMENT,
  `GST` float,
  `Total_Amount` float,
  `Paid` float,
  `Amount_Pending` float,
  `Date` DATE,
  PRIMARY KEY(Bill_ID)
);

CREATE TABLE `Laboratory` (
  `Laboratory_ID` int NOT NULL AUTO_INCREMENT,
  `Purpose` TEXT,
  `Sensitivity` TEXT,
  `Room_no` int,
 PRIMARY KEY(Laboratory_ID)
);

CREATE TABLE `Medicine` (
  `Medicine_ID` int NOT NULL AUTO_INCREMENT,
  `Name` varchar(100),
  `Type` char(100),
  `Price` int,
  `Stock` int,
  `Vendor` varchar(100),
  `Expiry_Date` DATE,
  PRIMARY KEY(Medicine_ID)
);

CREATE TABLE `Ward` (
  `Room_Number` int NOT NULL,
  `Occupancy` int,
  `Beds_Available` int,
  PRIMARY KEY(Room_Number)
);

CREATE TABLE `Stay` (
  `Patient_ID` int NOT NULL,
  `Admission_ID` int NOT NULL,
  PRIMARY KEY(Patient_ID, Admission_ID), 
  FOREIGN KEY (Patient_ID) REFERENCES Patient(Patient_ID),
  FOREIGN KEY (Admission_ID) REFERENCES Admitted(Admission_ID)
);

CREATE TABLE `Adm_Room` (
  `Admission_ID` int NOT NULL,
  `Room_Number` int NOT NULL,
  PRIMARY KEY (Admission_ID, `Room_Number`),
  FOREIGN KEY (Admission_ID) REFERENCES Admitted(Admission_ID),
  FOREIGN KEY (Room_Number) REFERENCES Ward(Room_Number)
);

CREATE TABLE `Visiting` (
  `Visitor_ID` int NOT NULL AUTO_INCREMENT,
  `Admission_ID` int NOT NULL,
  `Session_Timings` varchar(100),
  `Date_of_Visit` DATE, 
  PRIMARY KEY (Visitor_ID,Admission_ID,Session_Timings,Date_of_Visit),
  FOREIGN KEY(Visitor_ID) REFERENCES Visitor(Visitor_ID),
  FOREIGN KEY(Admission_ID) REFERENCES Admitted(Admission_ID)
);

CREATE TABLE `Payment` (
  `Treatment_ID` int NOT NULL,
  `Bill_ID` int NOT NULL,
  `Mode of Payment` varchar(20),
  PRIMARY KEY(`Treatment_ID`),
  FOREIGN KEY (Treatment_ID) REFERENCES Treatment(Treatment_ID),
  FOREIGN KEY (Bill_ID) REFERENCES Bill(Bill_ID)
  
);

CREATE TABLE `Ward_Duty` (
  `Room_Number` int NOT NULL,
  `Nurse_ID` int NOT NULL,
  `Shift` varchar(20) NOT NULL,
  `Date` DATE NOT NULL,
  PRIMARY KEY (`Room_Number`, `Nurse_ID`, `Shift`, `Date`),
  FOREIGN key (Nurse_ID) REFERENCES Nurse(Nurse_ID),
  FOREIGN key (Room_Number) REFERENCES Ward(Room_Number)
);

CREATE TABLE `Test` (
  `Treatment_ID` int NOT NULL,
  `Laboratory_ID` int NOT NULL,
  `Date` DATE,
  `Price` int,
  PRIMARY KEY(`Treatment_ID`, `Laboratory_ID`,`Date`),
  FOREIGN key (Treatment_ID) REFERENCES Treatment(Treatment_ID),
  FOREIGN key (Laboratory_ID) REFERENCES Laboratory(Laboratory_ID)
);

CREATE TABLE `N_Job` (
  `Nurse_ID` int NOT NULL,
  `Employee_ID` int NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID),
  FOREIGN key (Nurse_ID) REFERENCES Nurse(Nurse_ID)
);

CREATE TABLE `Employee_login` (
  `Employee_ID` int NOT NULL,
  `Email_ID` varchar(100) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID),
  FOREIGN KEY (Email_ID) REFERENCES `Login` (Email_ID)
);
  

CREATE TABLE `Includes` (
  `Treatment_ID` int NOT NULL,
  `Medicine_ID` int NOT NULL,
  PRIMARY KEY (`Treatment_ID`, `Medicine_ID`),
  FOREIGN KEY(Treatment_ID) REFERENCES Treatment(Treatment_ID),
  FOREIGN KEY(Medicine_ID) REFERENCES Medicine(Medicine_ID)
);

CREATE TABLE `Ch_Job` (
  `Chemist_ID` int NOT NULL,
  `Employee_ID` int NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  FOREIGN KEY(Chemist_ID) REFERENCES Chemist(Chemist_ID),
  FOREIGN KEY(Employee_ID) REFERENCES Employee(Employee_ID)
);

CREATE TABLE `D_Job` (
  `Doctor_ID` int NOT NULL,
  `Employee_ID` int NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  FOREIGN KEY (Employee_ID) REFERENCES Employee(Employee_ID),
  FOREIGN KEY (Doctor_ID) REFERENCES Doctor(Doctor_ID)
);

CREATE TABLE `Appointment` (
  `Patient_ID` int NOT NULL,
  `Doctor_ID` int NOT NULL,
  `Date_Time` DATETIME NOT NULL,
  PRIMARY KEY (`Patient_ID`, `Doctor_ID`, `Date_Time`), 
  FOREIGN KEY (Patient_ID) REFERENCES Patient (Patient_ID), 
  FOREIGN KEY (Doctor_ID) REFERENCES Doctor (Doctor_ID)
);

CREATE TABLE `R_Job` (
  `Receptionist_ID` int NOT NULL,
  `Employee_ID` int NOT NULL,
   PRIMARY KEY (`Employee_ID`),
  FOREIGN KEY(Employee_ID) REFERENCES Employee(Employee_ID),
  FOREIGN KEY(Receptionist_ID) REFERENCES Receptionist(Receptionist_ID) 
);

CREATE TABLE `Treats` (
  `Doctor_ID` int NOT NULL,
  `Treatment_ID` int NOT NULL,
  PRIMARY KEY (`Treatment_ID`),
  FOREIGN KEY(Treatment_ID) REFERENCES Treatment(Treatment_ID),
  FOREIGN KEY(Doctor_ID) REFERENCES Doctor(Doctor_ID)
);

CREATE TABLE `Patient_Treatment` (
  `Patient_ID` int NOT NULL,
  `Treatment_ID` int NOT NULL,
  PRIMARY KEY (`Treatment_ID`),
  FOREIGN KEY(Patient_ID) REFERENCES Patient(Patient_ID),
  FOREIGN KEY(Treatment_ID) REFERENCES Treatment(Treatment_ID)
);

CREATE TABLE `M_Job` (
  `Manager_ID` int NOT NULL,
  `Employee_ID` int NOT NULL,
  PRIMARY KEY(`Employee_ID`), 
  FOREIGN KEY(`Manager_ID`) REFERENCES Manager(Manager_ID),
  FOREIGN KEY(Employee_ID) REFERENCES Employee(Employee_ID)
);

