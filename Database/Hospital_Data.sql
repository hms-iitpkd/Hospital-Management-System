-- MySQL dump 10.17  Distrib 10.3.25-MariaDB, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: Hospital
-- ------------------------------------------------------
-- Server version	10.3.25-MariaDB-0ubuntu0.20.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `Adm_Room`
--

DROP TABLE IF EXISTS `Adm_Room`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Adm_Room` (
  `Admission_ID` int(11) NOT NULL,
  `Room_Number` int(11) NOT NULL,
  PRIMARY KEY (`Admission_ID`,`Room_Number`),
  KEY `Room_Number` (`Room_Number`),
  CONSTRAINT `Adm_Room_ibfk_1` FOREIGN KEY (`Admission_ID`) REFERENCES `Admitted` (`Admission_ID`),
  CONSTRAINT `Adm_Room_ibfk_2` FOREIGN KEY (`Room_Number`) REFERENCES `Ward` (`Room_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Adm_Room`
--

LOCK TABLES `Adm_Room` WRITE;
/*!40000 ALTER TABLE `Adm_Room` DISABLE KEYS */;
INSERT INTO `Adm_Room` VALUES (1,201),(2,207),(3,205),(4,204);
/*!40000 ALTER TABLE `Adm_Room` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Admitted`
--

DROP TABLE IF EXISTS `Admitted`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Admitted` (
  `Admission_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date_of_Admission` date DEFAULT NULL,
  `Date_of_disharge` date DEFAULT NULL,
  PRIMARY KEY (`Admission_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Admitted`
--

LOCK TABLES `Admitted` WRITE;
/*!40000 ALTER TABLE `Admitted` DISABLE KEYS */;
INSERT INTO `Admitted` VALUES (1,'2021-01-01','2021-01-04'),(2,'2021-01-01','2021-01-07'),(3,'2021-02-01','2021-02-05'),(4,'2021-03-01',NULL);
/*!40000 ALTER TABLE `Admitted` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Appointment`
--

DROP TABLE IF EXISTS `Appointment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Appointment` (
  `Patient_ID` int(11) NOT NULL,
  `Doctor_ID` int(11) NOT NULL,
  `Date_Time` datetime NOT NULL,
  PRIMARY KEY (`Patient_ID`,`Doctor_ID`,`Date_Time`),
  KEY `Doctor_ID` (`Doctor_ID`),
  CONSTRAINT `Appointment_ibfk_1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`Patient_ID`),
  CONSTRAINT `Appointment_ibfk_2` FOREIGN KEY (`Doctor_ID`) REFERENCES `Doctor` (`Doctor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Appointment`
--

LOCK TABLES `Appointment` WRITE;
/*!40000 ALTER TABLE `Appointment` DISABLE KEYS */;
INSERT INTO `Appointment` VALUES (5,12,'2022-03-18 09:19:00'),(6,1,'2022-03-18 09:19:00'),(7,6,'2022-03-18 09:19:00');
/*!40000 ALTER TABLE `Appointment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Bill`
--

DROP TABLE IF EXISTS `Bill`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Bill` (
  `Bill_ID` int(11) NOT NULL AUTO_INCREMENT,
  `GST` float DEFAULT NULL,
  `Total_Amount` float NOT NULL,
  `Paid` float DEFAULT NULL,
  `Amount_Pending` float DEFAULT NULL,
  `Date` date DEFAULT NULL,
  PRIMARY KEY (`Bill_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Bill`
--

LOCK TABLES `Bill` WRITE;
/*!40000 ALTER TABLE `Bill` DISABLE KEYS */;
INSERT INTO `Bill` VALUES (1,17.5,18000,15000,3000,'2020-03-18'),(2,17.5,23000,20000,3000,'2020-03-18'),(3,17.5,42000,20000,22000,'2020-03-18'),(4,17.5,41000,21000,20000,'2020-03-18'),(5,17.5,31000,28000,3000,'2020-03-18'),(6,17.5,8000,5000,3000,'2020-03-18'),(7,17.5,7000,4000,3000,'2020-03-18'),(8,17.5,5000,2000,3000,'2020-03-18'),(9,17.5,50000,2000,3000,'2020-03-18'),(10,17.5,13000,10000,3000,'2020-03-18'),(11,17.5,10000,7000,3000,'2020-03-18'),(12,17.5,6000,3000,3000,'2020-03-18'),(13,17.5,18000,15000,3000,'2020-03-18'),(14,17.5,23000,20000,3000,'2020-03-18'),(15,17.5,42000,20000,22000,'2020-03-18'),(16,17.5,41000,21000,20000,'2020-03-18'),(17,17.5,31000,28000,3000,'2020-03-18'),(18,17.5,8000,5000,3000,'2020-03-18'),(19,17.5,7000,4000,3000,'2020-03-18'),(20,17.5,5000,2000,3000,'2020-03-18'),(21,17.5,50000,2000,3000,'2020-03-18'),(22,17.5,13000,10000,3000,'2020-03-18'),(23,17.5,10000,7000,3000,'2020-03-18'),(24,17.5,6000,3000,3000,'2020-03-18'),(25,17.5,31000,28000,3000,'2020-03-18'),(26,17.5,8000,5000,3000,'2020-03-18'),(27,17.5,7000,4000,3000,'2020-03-18'),(28,17.5,5000,2000,3000,'2020-03-18'),(29,17.5,50000,2000,3000,'2020-03-18'),(30,17.5,13000,10000,3000,'2020-03-18');
/*!40000 ALTER TABLE `Bill` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ch_Job`
--

DROP TABLE IF EXISTS `Ch_Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ch_Job` (
  `Chemist_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  KEY `Chemist_ID` (`Chemist_ID`),
  CONSTRAINT `Ch_Job_ibfk_1` FOREIGN KEY (`Chemist_ID`) REFERENCES `Chemist` (`Chemist_ID`),
  CONSTRAINT `Ch_Job_ibfk_2` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ch_Job`
--

LOCK TABLES `Ch_Job` WRITE;
/*!40000 ALTER TABLE `Ch_Job` DISABLE KEYS */;
INSERT INTO `Ch_Job` VALUES (1,5),(2,6),(3,7);
/*!40000 ALTER TABLE `Ch_Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Chemist`
--

DROP TABLE IF EXISTS `Chemist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Chemist` (
  `Chemist_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  `Contact_Number` char(12) DEFAULT NULL,
  `Shift` datetime DEFAULT NULL,
  PRIMARY KEY (`Chemist_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Chemist`
--

LOCK TABLES `Chemist` WRITE;
/*!40000 ALTER TABLE `Chemist` DISABLE KEYS */;
INSERT INTO `Chemist` VALUES (1,'Chemist1','234567891','2020-03-18 09:19:00'),(2,'Chemist2','234567892','2020-03-18 09:19:00'),(3,'Chemist3','234567893','2020-03-18 09:19:00');
/*!40000 ALTER TABLE `Chemist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `D_Job`
--

DROP TABLE IF EXISTS `D_Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `D_Job` (
  `Doctor_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  KEY `Doctor_ID` (`Doctor_ID`),
  CONSTRAINT `D_Job_ibfk_1` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`),
  CONSTRAINT `D_Job_ibfk_2` FOREIGN KEY (`Doctor_ID`) REFERENCES `Doctor` (`Doctor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `D_Job`
--

LOCK TABLES `D_Job` WRITE;
/*!40000 ALTER TABLE `D_Job` DISABLE KEYS */;
INSERT INTO `D_Job` VALUES (1,11),(2,12),(3,13),(4,14),(5,15),(6,16),(7,17),(8,18),(9,19),(10,20),(11,21),(12,22);
/*!40000 ALTER TABLE `D_Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Doctor`
--

DROP TABLE IF EXISTS `Doctor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Doctor` (
  `Doctor_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Department` varchar(100) DEFAULT NULL,
  `Experience` int(11) DEFAULT NULL,
  `Specialization` varchar(100) DEFAULT NULL,
  `Patients_treated` int(11) DEFAULT NULL,
  `Shift` datetime DEFAULT NULL,
  `Room_no` int(11) DEFAULT NULL,
  `Consultancy Fees` int(11) DEFAULT NULL,
  PRIMARY KEY (`Doctor_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Doctor`
--

LOCK TABLES `Doctor` WRITE;
/*!40000 ALTER TABLE `Doctor` DISABLE KEYS */;
INSERT INTO `Doctor` VALUES (1,'Doctor1','Department1',16,'Cardiologist',13081,NULL,1,750),(2,'Doctor2','Department1',23,'Pediatrician',25478,NULL,2,450),(3,'Doctor3','Department2',8,'Gynecologist',1023,NULL,3,800),(4,'Doctor4','Department2',4,'Physician',2564,NULL,4,200),(5,'Doctor5','Department1',17,'Pulmonologist',18465,NULL,5,350),(6,'Doctor6','Department1',12,'Hematologist',11023,NULL,6,350),(7,'Doctor7','Department0',31,'NeuroSurgeon',37876,NULL,7,800),(8,'Doctor8','Department1',11,'Gastrologist',9834,NULL,8,200),(9,'Doctor9','Department2',9,'Psychiatrist',1401,NULL,9,250),(10,'Doctor10','Department2',7,'Allergist',1543,NULL,10,150),(11,'Doctor11','Department0',28,'Physician',34578,NULL,11,350),(12,'Doctor12','Department2',3,'Plastic Surgeon',97,NULL,12,1500);
/*!40000 ALTER TABLE `Doctor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee`
--

DROP TABLE IF EXISTS `Employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee` (
  `Employee_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Government_ID` int(11) NOT NULL,
  `Name` varchar(100) NOT NULL,
  `Date_of_Birth` date DEFAULT NULL,
  `Gender` char(1) DEFAULT NULL,
  `Contact_Number` varchar(12) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `Blood_Group` varchar(3) DEFAULT NULL,
  `Email_ID` varchar(100) NOT NULL,
  `Date_of_Joining` date DEFAULT NULL,
  `Date_of_Termination` date DEFAULT NULL,
  `Department` varchar(100) DEFAULT NULL,
  `Annual_Salary` int(11) DEFAULT NULL,
  PRIMARY KEY (`Employee_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee`
--

LOCK TABLES `Employee` WRITE;
/*!40000 ALTER TABLE `Employee` DISABLE KEYS */;
INSERT INTO `Employee` VALUES (1,234567,'Manager1','1999-04-18','M','999999999','HNo: 1 Sec 1 Delhi','B+','Manager1@gmail.com','2018-04-20','2025-04-18','Manager',500000),(2,234567,'Manager2','1998-01-18','F','999999989','HNo: 5 Sec 1 Delhi','A+','Manager2@gmail.com','2020-04-18','2025-04-18','Manager',500000),(3,233567,'Manager3','1999-03-18','O','919999999','HNo: 4 Sec 1 Delhi','B+','Manager3@gmail.com','2020-04-18','2026-04-18','Manager',500000),(4,231567,'Manager4','1999-05-18','F','999999994','HNo: 8 Sec 1 Delhi','B+','Manager4@gmail.com','2029-04-18','2024-04-18','Manager',500000),(5,234567,'Chemist1','1999-04-18','M','999999999','HNo: 2 Sec 1 Delhi','B+','Chemist1@gmail.com','2025-04-18','2025-04-18','Chemist',600000),(6,234567,'Chemist2','1999-04-18','F','999999999','HNo: 3 Sec 1 Delhi','A+','Chemist2@gmail.com','2025-04-18','2025-04-18','Chemist',600000),(7,234567,'Chemist3','1999-04-18','F','999999999','HNo: 6 Sec 1 Delhi','B+','Chemist3@gmail.com','2025-04-18','2025-04-18','Chemist',600000),(8,234567,'Nurse1','1999-04-18','M','999999999','HNo: 7 Sec 1 Delhi','O+','Nurse1@gmail.com','2025-04-18','2025-04-18','Nurse',700000),(9,234567,'Nurse2','1999-04-18','F','999999999','HNo: 8 Sec 1 Delhi','B+','Nurse2@gmail.com','2025-04-18','2025-04-18','Nurse',700000),(10,234567,'Nurse3','1999-04-18','F','999999999','HNo: 9 Sec 1 Delhi','B+','Nurse3@gmail.com','2025-04-18','2025-04-18','Nurse',700000),(11,234567,'Doctor1','1999-04-18','M','999999999','HNo: 10 Sec 1 Delhi','O-','Doctor1@gmail.com','2025-04-18','2025-04-18','Doctor',600000),(12,234567,'Doctor2','1999-04-18','F','999999999','HNo: 11 Sec 1 Delhi','O+','Doctor2@gmail.com','2025-04-18','2025-04-18','Doctor',600000),(13,234567,'Doctor3','1999-04-18','F','999999999','HNo: 12 Sec 1 Delhi','B+','Doctor3@gmail.com','2025-04-18','2025-04-18','Doctor',600000),(14,234567,'Doctor4','1999-04-18','M','999999999','HNo: 13 Sec 1 Delhi','A+','Doctor4@gmail.com','2025-04-18','2025-04-18','Doctor',700000),(15,234567,'Doctor5','1999-04-18','F','999999999','HNo: 14 Sec 1 Delhi','A+','Doctor5@gmail.com','2025-04-18','2025-04-18','Doctor',700000),(16,234567,'Doctor6','1999-04-18','F','999999999','HNo: 15 Sec 1 Delhi','B-','Doctor6@gmail.com','2025-04-18','2025-04-18','Doctor',700000),(17,234567,'Doctor7','1999-04-18','M','999999999','HNo: 16 Sec 1 Delhi','A+','Doctor7@gmail.com','2025-04-18','2025-04-18','Doctor',600000),(18,234567,'Doctor8','1999-04-18','F','999999999','HNo: 17 Sec 1 Delhi','A+','Doctor8@gmail.com','2025-04-18','2025-04-18','Doctor',600000),(19,234567,'Doctor9','1999-04-18','F','999999999','HNo: 18 Sec 1 Delhi','B+','Doctor9@gmail.com','2025-04-18','2025-04-18','Doctor',600000),(20,234567,'Doctor10','1999-04-18','M','999999999','HNo: 19 Sec 1 Delhi','B-','Doctor10@gmail.com','2025-04-18','2025-04-18','Doctor',700000),(21,234567,'Doctor11','1999-04-18','F','999999999','HNo: 31 Sec 1 Delhi','O+','Doctor11@gmail.com','2025-04-18','2025-04-18','Doctor',700000),(22,234567,'Doctor12','1999-04-18','F','999999999','HNo: 20 Sec 1 Delhi','B-','Doctor12@gmail.com','2025-04-18','2025-04-18','Doctor',700000),(23,234567,'Receptionist1','1999-04-18','F','999999999','HNo: 18 Sec 1 Delhi','B+','Receptionist1@gmail.com','2025-04-18','2025-04-18','Receptionist',600000),(24,234567,'Receptionist2','1999-04-18','M','999999999','HNo: 19 Sec 1 Delhi','B-','Receptionist2@gmail.com','2025-04-18','2025-04-18','Receptionist',700000),(25,234567,'Receptionist3','1999-04-18','F','999999999','HNo: 31 Sec 1 Delhi','O+','Receptionist3@gmail.com','2025-04-18','2025-04-18','Receptionist',700000),(26,234567,'Receptionist4','1999-04-18','F','999999999','HNo: 20 Sec 1 Delhi','B-','Receptionist4@gmail.com','2025-04-18','2025-04-18','Receptionist',700000),(27,234567,'Receptionist5','1999-04-18','F','999999999','HNo: 20 Sec 1 Delhi','B-','Receptionist5@gmail.com','2025-04-18','2025-04-18','Receptionist',700000);
/*!40000 ALTER TABLE `Employee` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Employee_login`
--

DROP TABLE IF EXISTS `Employee_login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Employee_login` (
  `Employee_ID` int(11) NOT NULL,
  `Email_ID` varchar(100) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  KEY `Email_ID` (`Email_ID`),
  CONSTRAINT `Employee_login_ibfk_1` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`),
  CONSTRAINT `Employee_login_ibfk_2` FOREIGN KEY (`Email_ID`) REFERENCES `Login` (`Email_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Employee_login`
--

LOCK TABLES `Employee_login` WRITE;
/*!40000 ALTER TABLE `Employee_login` DISABLE KEYS */;
INSERT INTO `Employee_login` VALUES (5,'Chemist1@gmail.com'),(6,'Chemist2@gmail.com'),(7,'Chemist3@gmail.com'),(20,'Doctor10@gmail.com'),(21,'Doctor11@gmail.com'),(22,'Doctor12@gmail.com'),(11,'Doctor1@gmail.com'),(12,'Doctor2@gmail.com'),(13,'Doctor3@gmail.com'),(14,'Doctor4@gmail.com'),(15,'Doctor5@gmail.com'),(16,'Doctor6@gmail.com'),(17,'Doctor7@gmail.com'),(18,'Doctor8@gmail.com'),(19,'Doctor9@gmail.com'),(1,'Manager1@gmail.com'),(2,'Manager2@gmail.com'),(3,'Manager3@gmail.com'),(4,'Manager4@gmail.com'),(8,'Nurse1@gmail.com'),(9,'Nurse2@gmail.com'),(10,'Nurse3@gmail.com'),(23,'Receptionist1@gmail.com'),(24,'Receptionist2@gmail.com'),(25,'Receptionist3@gmail.com'),(26,'Receptionist4@gmail.com'),(27,'Receptionist5@gmail.com');
/*!40000 ALTER TABLE `Employee_login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Includes`
--

DROP TABLE IF EXISTS `Includes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Includes` (
  `Treatment_ID` int(11) NOT NULL,
  `Medicine_ID` int(11) NOT NULL,
  PRIMARY KEY (`Treatment_ID`,`Medicine_ID`),
  KEY `Medicine_ID` (`Medicine_ID`),
  CONSTRAINT `Includes_ibfk_1` FOREIGN KEY (`Treatment_ID`) REFERENCES `Treatment` (`Treatment_ID`),
  CONSTRAINT `Includes_ibfk_2` FOREIGN KEY (`Medicine_ID`) REFERENCES `Medicine` (`Medicine_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Includes`
--

LOCK TABLES `Includes` WRITE;
/*!40000 ALTER TABLE `Includes` DISABLE KEYS */;
INSERT INTO `Includes` VALUES (1,1),(1,2),(2,2),(2,12),(3,4),(4,4),(4,5),(5,2),(5,4),(6,8),(6,10),(7,9),(8,11),(9,2),(10,10),(10,11),(11,11),(11,12),(12,2),(13,5),(13,11),(14,4),(15,1),(16,10),(17,10),(18,9),(19,10),(20,12),(21,12),(22,2),(23,1),(24,11),(25,2),(26,6),(27,3),(27,9),(27,11),(28,2),(29,4),(30,10);
/*!40000 ALTER TABLE `Includes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Laboratory`
--

DROP TABLE IF EXISTS `Laboratory`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Laboratory` (
  `Laboratory_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Purpose` text DEFAULT NULL,
  `Sensitivity` text DEFAULT NULL,
  `Room_no` int(11) DEFAULT NULL,
  PRIMARY KEY (`Laboratory_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Laboratory`
--

LOCK TABLES `Laboratory` WRITE;
/*!40000 ALTER TABLE `Laboratory` DISABLE KEYS */;
INSERT INTO `Laboratory` VALUES (1,'X-Ray','Med',101),(2,'CT-Scan','High',102),(3,'Sonography','High',103),(4,'Blood-Test/Allergy-Test/Endoscopy','Low',104),(5,'MRI','High',105),(6,'ECG','Medium',106);
/*!40000 ALTER TABLE `Laboratory` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Login`
--

DROP TABLE IF EXISTS `Login`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Login` (
  `Name` varchar(36) NOT NULL,
  `Contact_Number` int(11) DEFAULT NULL,
  `Email_ID` varchar(100) NOT NULL,
  `Password` varchar(100) NOT NULL,
  `Account_Type` varchar(10) DEFAULT NULL,
  `Locality` varchar(20) DEFAULT NULL,
  `Access_Level` int(11) NOT NULL,
  `Last_Login` datetime NOT NULL,
  PRIMARY KEY (`Email_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Login`
--

LOCK TABLES `Login` WRITE;
/*!40000 ALTER TABLE `Login` DISABLE KEYS */;
INSERT INTO `Login` VALUES ('Chemist1',12345678,'Chemist1@gmail.com','1234','chemist','Delhi',4,'2020-03-18 09:19:00'),('Chemist2',12345678,'Chemist2@gmail.com','1234','chemist','Delhi',4,'2020-03-18 09:19:00'),('Chemist3',12345678,'Chemist3@gmail.com','1234','chemist','Delhi',4,'2020-03-18 09:19:00'),('Doctor10',12345678,'Doctor10@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor11',12345678,'Doctor11@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor12',12345678,'Doctor12@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor1',12345678,'Doctor1@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor2',12345678,'Doctor2@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor3',12345678,'Doctor3@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor4',12345678,'Doctor4@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor5',12345678,'Doctor5@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor6',12345678,'Doctor6@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor7',12345678,'Doctor7@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor8',12345678,'Doctor8@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Doctor9',12345678,'Doctor9@gmail.com','1234','doctor','Delhi',1,'2020-03-18 09:19:00'),('Manager1',1234567890,'Manager1@gmail.com','1234','manager','Delhi',0,'2020-03-18 09:19:00'),('Manager2',1234567891,'Manager2@gmail.com','1234','manager','Delhi',0,'2020-03-18 09:19:00'),('Manager3',1234567892,'Manager3@gmail.com','1234','manager','Delhi',0,'2020-03-18 09:19:00'),('Manager4',1234567893,'Manager4@gmail.com','1234','manager','Delhi',0,'2020-03-18 09:19:00'),('Nurse1',12345678,'Nurse1@gmail.com','1234','nurse','Delhi',2,'2020-03-18 09:19:00'),('Nurse2',12345678,'Nurse2@gmail.com','1234','nurse','Delhi',2,'2020-03-18 09:19:00'),('Nurse3',12345678,'Nurse3@gmail.com','1234','nurse','Delhi',2,'2020-03-18 09:19:00'),('Receptionist1',12345678,'Receptionist1@gmail.com','1234','recep','Delhi',3,'2020-03-18 09:19:00'),('Receptionist2',12345678,'Receptionist2@gmail.com','1234','recep','Delhi',3,'2020-03-18 09:19:00'),('Receptionist3',12345678,'Receptionist3@gmail.com','1234','recep','Delhi',3,'2020-03-18 09:19:00'),('Receptionist4',12345678,'Receptionist4@gmail.com','1234','recep','Delhi',3,'2020-03-18 09:19:00'),('Receptionist5',12345678,'Receptionist5@gmail.com','1234','recep','Delhi',3,'2020-03-18 09:19:00');
/*!40000 ALTER TABLE `Login` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `M_Job`
--

DROP TABLE IF EXISTS `M_Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `M_Job` (
  `Manager_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  KEY `Manager_ID` (`Manager_ID`),
  CONSTRAINT `M_Job_ibfk_1` FOREIGN KEY (`Manager_ID`) REFERENCES `Manager` (`Manager_ID`),
  CONSTRAINT `M_Job_ibfk_2` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `M_Job`
--

LOCK TABLES `M_Job` WRITE;
/*!40000 ALTER TABLE `M_Job` DISABLE KEYS */;
INSERT INTO `M_Job` VALUES (1,1),(2,2),(3,3),(4,4);
/*!40000 ALTER TABLE `M_Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Manager`
--

DROP TABLE IF EXISTS `Manager`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Manager` (
  `Manager_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  PRIMARY KEY (`Manager_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Manager`
--

LOCK TABLES `Manager` WRITE;
/*!40000 ALTER TABLE `Manager` DISABLE KEYS */;
INSERT INTO `Manager` VALUES (1,'Manager1'),(2,'Manager2'),(3,'Manager3'),(4,'Manager4');
/*!40000 ALTER TABLE `Manager` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Medicine`
--

DROP TABLE IF EXISTS `Medicine`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Medicine` (
  `Medicine_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) DEFAULT NULL,
  `Type` char(100) DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  `Stock` int(11) DEFAULT NULL,
  `Vendor` varchar(100) DEFAULT NULL,
  `Expiry_Date` date DEFAULT NULL,
  PRIMARY KEY (`Medicine_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Medicine`
--

LOCK TABLES `Medicine` WRITE;
/*!40000 ALTER TABLE `Medicine` DISABLE KEYS */;
INSERT INTO `Medicine` VALUES (1,'Medicine1','Type1',100,5,'Vendor1','2021-03-18'),(2,'Medicine1','Type1',400,11,'Vendor1','2021-03-18'),(3,'Medicine2','Type2',100,5,'Vendor1','2022-03-18'),(4,'Medicine3','Type1',120,2,'Vendor1','2023-03-23'),(5,'Medicine4','Type2',300,5,'Vendor1','2021-05-18'),(6,'Medicine5','Type4',70,6,'Vendor1','2022-03-18'),(7,'Medicine6','Type6',230,12,'Vendor1','2022-04-18'),(8,'Medicine7','Type2',100,2,'Vendor1','2021-03-12'),(9,'Medicine8','Type5',450,10,'Vendor1','2024-03-13'),(10,'Medicine9','Type2',70,11,'Vendor1','2022-01-18'),(11,'Medicine10','Type1',20,15,'Vendor1','2023-06-18'),(12,'Medicine11','Type9',40,5,'Vendor1','2025-04-18');
/*!40000 ALTER TABLE `Medicine` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `N_Job`
--

DROP TABLE IF EXISTS `N_Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `N_Job` (
  `Nurse_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  KEY `Nurse_ID` (`Nurse_ID`),
  CONSTRAINT `N_Job_ibfk_1` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`),
  CONSTRAINT `N_Job_ibfk_2` FOREIGN KEY (`Nurse_ID`) REFERENCES `Nurse` (`Nurse_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `N_Job`
--

LOCK TABLES `N_Job` WRITE;
/*!40000 ALTER TABLE `N_Job` DISABLE KEYS */;
INSERT INTO `N_Job` VALUES (1,8),(2,9),(3,10);
/*!40000 ALTER TABLE `N_Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Nurse`
--

DROP TABLE IF EXISTS `Nurse`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Nurse` (
  `Nurse_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(100) NOT NULL,
  `Experience` int(11) DEFAULT NULL,
  PRIMARY KEY (`Nurse_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Nurse`
--

LOCK TABLES `Nurse` WRITE;
/*!40000 ALTER TABLE `Nurse` DISABLE KEYS */;
INSERT INTO `Nurse` VALUES (1,'Nurse1',3),(2,'Nurse2',3),(3,'Nurse3',3);
/*!40000 ALTER TABLE `Nurse` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient`
--

DROP TABLE IF EXISTS `Patient`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Patient` (
  `Patient_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  `Age` int(11) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Height` varchar(10) DEFAULT NULL,
  `Weight` varchar(10) DEFAULT NULL,
  `Blood_Group` varchar(5) DEFAULT NULL,
  `Contact_Number` int(11) DEFAULT NULL,
  `Email_ID` varchar(100) DEFAULT NULL,
  `Address` varchar(100) DEFAULT NULL,
  `History` varchar(255) DEFAULT NULL,
  `Last_Visit_Date` date DEFAULT NULL,
  PRIMARY KEY (`Patient_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient`
--

LOCK TABLES `Patient` WRITE;
/*!40000 ALTER TABLE `Patient` DISABLE KEYS */;
INSERT INTO `Patient` VALUES (1,'Patient1',23,'Male','5\'7','46 kg','AB-',987653,'Patient1@gmail.com','34,East Colony','History1','2020-01-19'),(2,'Patient2',20,'Female','5\'2','54 kg','B-',987654,'Patient2@gmail.com','39,West Colony','History2','2021-01-29'),(3,'Patient3',40,'Male','5\'4','48 kg','B+',987652,'Patient3@gmail.com','63,South Market','History3','2020-03-15'),(4,'Patient4',56,'Male','5\'8','80 kg','O+',987651,'Patient4@gmail.com','10/11, Kailash Marg','History4','2020-10-09'),(5,'Patient5',21,'Female','5\'1','65 kg','B+',987650,'Patient5@gmail.com','77, Joshi Marg','History5','2019-07-16'),(6,'Patient6',76,'Male','6\'2','90 kg','AB+',987659,'Patient6@gmail.com','23, Vaishali Nagar','History6','2020-03-31'),(7,'Patient7',23,'Male','5\'7','46 kg','AB-',987653,'Patient7@gmail.com','34,East Colony','History1','2020-01-19'),(8,'Patient8',20,'Female','5\'2','54 kg','B-',987654,'Patient8@gmail.com','39,West Colony','History2','2021-01-29'),(9,'Patient9',40,'Male','5\'4','48 kg','B+',987652,'Patient9@gmail.com','63,South Market','History3','2020-03-15'),(10,'Patient10',56,'Male','5\'8','80 kg','O+',987651,'Patient10@gmail.com','10/11, Kailash Marg','History4','2020-10-09'),(11,'Patient11',21,'Female','5\'1','65 kg','B+',987650,'Patient11@gmail.com','77, Joshi Marg','History5','2019-07-16'),(12,'Patient12',76,'Male','6\'2','90 kg','AB+',987659,'Patient12@gmail.com','23, Vaishali Nagar','History6','2020-03-31');
/*!40000 ALTER TABLE `Patient` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Patient_Treatment`
--

DROP TABLE IF EXISTS `Patient_Treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Patient_Treatment` (
  `Patient_ID` int(11) NOT NULL,
  `Treatment_ID` int(11) NOT NULL,
  PRIMARY KEY (`Treatment_ID`),
  KEY `Patient_ID` (`Patient_ID`),
  CONSTRAINT `Patient_Treatment_ibfk_1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`Patient_ID`),
  CONSTRAINT `Patient_Treatment_ibfk_2` FOREIGN KEY (`Treatment_ID`) REFERENCES `Treatment` (`Treatment_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Patient_Treatment`
--

LOCK TABLES `Patient_Treatment` WRITE;
/*!40000 ALTER TABLE `Patient_Treatment` DISABLE KEYS */;
INSERT INTO `Patient_Treatment` VALUES (1,1),(1,2),(1,3),(2,4),(2,5),(2,6),(3,7),(3,8),(3,9),(4,10),(4,11),(4,12),(5,13),(5,14),(5,15),(6,16),(6,17),(6,18),(7,19),(7,20),(7,21),(8,22),(8,23),(8,24),(9,25),(9,26),(9,27),(10,28),(11,29),(12,30);
/*!40000 ALTER TABLE `Patient_Treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Payment`
--

DROP TABLE IF EXISTS `Payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Payment` (
  `Treatment_ID` int(11) NOT NULL,
  `Bill_ID` int(11) NOT NULL,
  `Mode of Payment` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`Treatment_ID`),
  KEY `Bill_ID` (`Bill_ID`),
  CONSTRAINT `Payment_ibfk_1` FOREIGN KEY (`Treatment_ID`) REFERENCES `Treatment` (`Treatment_ID`),
  CONSTRAINT `Payment_ibfk_2` FOREIGN KEY (`Bill_ID`) REFERENCES `Bill` (`Bill_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Payment`
--

LOCK TABLES `Payment` WRITE;
/*!40000 ALTER TABLE `Payment` DISABLE KEYS */;
INSERT INTO `Payment` VALUES (1,5,'Debit Card'),(2,4,'Paytm'),(3,3,'Google Pay'),(4,2,'Cash'),(5,1,'Credit Card'),(6,10,'Paytm'),(7,9,'Google Pay'),(8,8,'Paytm'),(9,7,'Cash'),(10,6,'Cash'),(11,11,'Cash'),(12,20,'Cash'),(13,19,'Paytm'),(14,18,'Cash'),(15,17,'Google Pay'),(16,16,'Paytm'),(17,15,'Cash'),(18,14,'Debit Card'),(19,13,'Credit Card'),(20,12,'Cash'),(21,30,'Paytm'),(22,29,'Credit Card'),(23,28,'Google Pay'),(24,27,'Cash'),(25,26,'Cash'),(26,25,'Cash'),(27,24,'Paytm'),(28,23,'Paytm'),(29,22,'Google Pay'),(30,21,'Paytm');
/*!40000 ALTER TABLE `Payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `R_Job`
--

DROP TABLE IF EXISTS `R_Job`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `R_Job` (
  `Receptionist_ID` int(11) NOT NULL,
  `Employee_ID` int(11) NOT NULL,
  PRIMARY KEY (`Employee_ID`),
  KEY `Receptionist_ID` (`Receptionist_ID`),
  CONSTRAINT `R_Job_ibfk_1` FOREIGN KEY (`Employee_ID`) REFERENCES `Employee` (`Employee_ID`),
  CONSTRAINT `R_Job_ibfk_2` FOREIGN KEY (`Receptionist_ID`) REFERENCES `Receptionist` (`Receptionist_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `R_Job`
--

LOCK TABLES `R_Job` WRITE;
/*!40000 ALTER TABLE `R_Job` DISABLE KEYS */;
INSERT INTO `R_Job` VALUES (1,23),(2,24),(3,25),(4,26),(5,27);
/*!40000 ALTER TABLE `R_Job` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Receptionist`
--

DROP TABLE IF EXISTS `Receptionist`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Receptionist` (
  `Receptionist_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  `Experience` text DEFAULT NULL,
  `Shift` char(11) DEFAULT NULL,
  PRIMARY KEY (`Receptionist_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Receptionist`
--

LOCK TABLES `Receptionist` WRITE;
/*!40000 ALTER TABLE `Receptionist` DISABLE KEYS */;
INSERT INTO `Receptionist` VALUES (1,'Receptionist1','Good Receptionist','Thus,Even'),(2,'Receptionist2','','Fri,Night'),(3,'Receptionist3','','Sat,Morn'),(4,'Receptionist4','','Mon,Morn'),(5,'Receptionist5','','Tue,Noon');
/*!40000 ALTER TABLE `Receptionist` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Stay`
--

DROP TABLE IF EXISTS `Stay`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Stay` (
  `Patient_ID` int(11) NOT NULL,
  `Admission_ID` int(11) NOT NULL,
  PRIMARY KEY (`Patient_ID`,`Admission_ID`),
  KEY `Admission_ID` (`Admission_ID`),
  CONSTRAINT `Stay_ibfk_1` FOREIGN KEY (`Patient_ID`) REFERENCES `Patient` (`Patient_ID`),
  CONSTRAINT `Stay_ibfk_2` FOREIGN KEY (`Admission_ID`) REFERENCES `Admitted` (`Admission_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Stay`
--

LOCK TABLES `Stay` WRITE;
/*!40000 ALTER TABLE `Stay` DISABLE KEYS */;
INSERT INTO `Stay` VALUES (3,1),(6,2),(9,3),(12,4);
/*!40000 ALTER TABLE `Stay` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Test`
--

DROP TABLE IF EXISTS `Test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Test` (
  `Treatment_ID` int(11) NOT NULL,
  `Laboratory_ID` int(11) NOT NULL,
  `Date` date DEFAULT NULL,
  `Price` int(11) DEFAULT NULL,
  PRIMARY KEY (`Treatment_ID`,`Laboratory_ID`),
  KEY `Laboratory_ID` (`Laboratory_ID`),
  CONSTRAINT `Test_ibfk_1` FOREIGN KEY (`Treatment_ID`) REFERENCES `Treatment` (`Treatment_ID`),
  CONSTRAINT `Test_ibfk_2` FOREIGN KEY (`Laboratory_ID`) REFERENCES `Laboratory` (`Laboratory_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Test`
--

LOCK TABLES `Test` WRITE;
/*!40000 ALTER TABLE `Test` DISABLE KEYS */;
INSERT INTO `Test` VALUES (1,1,'2020-03-18',200),(1,4,'2020-03-18',750),(2,4,'2020-03-18',750),(3,4,'2020-03-18',750),(4,4,'2020-03-18',750),(6,6,'2020-03-18',500),(9,5,'2020-03-18',1200),(10,4,'2020-03-18',750),(11,4,'2020-03-18',750),(12,4,'2020-03-18',750),(13,4,'2020-03-18',200),(15,4,'2020-03-18',750),(16,4,'2020-03-18',750),(17,2,'2020-03-18',2000),(18,4,'2020-03-18',750),(19,3,'2020-03-18',700),(20,4,'2020-03-18',750),(21,4,'2020-03-18',200),(22,1,'2020-03-18',200),(22,2,'2020-03-18',2000),(22,3,'2020-03-18',700),(22,4,'2020-03-18',750),(23,4,'2020-03-18',750),(25,4,'2020-03-18',750),(26,4,'2020-03-18',750),(27,1,'2020-03-18',200),(27,4,'2020-03-18',750),(28,4,'2020-03-18',750),(29,6,'2020-03-18',500),(30,6,'2020-03-18',500);
/*!40000 ALTER TABLE `Test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Treatment`
--

DROP TABLE IF EXISTS `Treatment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Treatment` (
  `Treatment_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Date` datetime NOT NULL,
  `Description` text NOT NULL,
  `Problem` text DEFAULT NULL,
  PRIMARY KEY (`Treatment_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Treatment`
--

LOCK TABLES `Treatment` WRITE;
/*!40000 ALTER TABLE `Treatment` DISABLE KEYS */;
INSERT INTO `Treatment` VALUES (1,'2020-03-18 09:19:00','Desc1','asthama'),(2,'2020-03-18 09:19:00','Desc2','Skin Allergies'),(3,'2020-03-18 09:19:00','Desc3','Urinary Tract Infection'),(4,'2020-03-18 09:19:00','Desc4','Crohn\'s disease'),(5,'2020-03-18 09:19:00','Desc5','Stroke'),(6,'2020-03-18 09:19:00','Desc6','Coronary heart disease'),(7,'2020-03-18 09:19:00','Desc7','Fever'),(8,'2020-03-18 09:19:00','Desc8','Fever'),(9,'2020-03-18 09:19:00','Desc9','Perkinsons Disease'),(10,'2020-03-18 09:19:00','Desc10','Atherosclerosis'),(11,'2020-03-18 09:19:00','Desc11','Anemia'),(12,'2020-03-18 09:19:00','Desc12','Hepatitis'),(13,'2020-03-18 09:19:00','Desc13','Tuberculosis'),(14,'2020-03-18 09:19:00','Desc14','Face surgery'),(15,'2020-03-18 09:19:00','Desc15','Hay fever'),(16,'2020-03-18 09:19:00','Desc16','Atherosclerosis'),(17,'2020-03-18 09:19:00','Desc17','Sepsis'),(18,'2020-03-18 09:19:00','Desc18','Anemia'),(19,'2020-03-18 09:19:00','Desc19','PCOD'),(20,'2020-03-18 09:19:00','Desc20','Hepatitis'),(21,'2020-03-18 09:19:00','Desc21','Tuberculosis'),(22,'2020-03-18 09:19:00','Desc22','Leukemia'),(23,'2020-03-18 09:19:00','Desc23','Atherosclerosis'),(24,'2020-03-18 09:19:00','Desc24','Heartburn'),(25,'2020-03-18 09:19:00','Desc25','Urinary Tract Infection'),(26,'2020-03-18 09:19:00','Desc26','Meningitis'),(27,'2020-03-18 09:19:00','Desc27','Asthama'),(28,'2020-03-18 09:19:00','Desc28','Hay fever'),(29,'2020-03-18 09:19:00','Desc29','Nerve Damage'),(30,'2020-03-18 09:19:00','Desc30','Coronary heart Disease');
/*!40000 ALTER TABLE `Treatment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Treats`
--

DROP TABLE IF EXISTS `Treats`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Treats` (
  `Doctor_ID` int(11) NOT NULL,
  `Treatment_ID` int(11) NOT NULL,
  PRIMARY KEY (`Treatment_ID`),
  KEY `Doctor_ID` (`Doctor_ID`),
  CONSTRAINT `Treats_ibfk_1` FOREIGN KEY (`Treatment_ID`) REFERENCES `Treatment` (`Treatment_ID`),
  CONSTRAINT `Treats_ibfk_2` FOREIGN KEY (`Doctor_ID`) REFERENCES `Doctor` (`Doctor_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Treats`
--

LOCK TABLES `Treats` WRITE;
/*!40000 ALTER TABLE `Treats` DISABLE KEYS */;
INSERT INTO `Treats` VALUES (1,6),(1,10),(1,16),(1,23),(1,30),(2,12),(2,20),(2,26),(3,3),(3,19),(3,25),(4,7),(5,1),(5,13),(5,21),(5,27),(6,11),(6,17),(6,18),(6,22),(7,5),(7,9),(7,29),(8,4),(8,24),(10,2),(10,15),(10,28),(11,8),(12,14);
/*!40000 ALTER TABLE `Treats` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Utility`
--

DROP TABLE IF EXISTS `Utility`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Utility` (
  `Item_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Type` varchar(36) NOT NULL,
  `Name` varchar(36) NOT NULL,
  `Number` int(11) DEFAULT NULL,
  PRIMARY KEY (`Item_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Utility`
--

LOCK TABLES `Utility` WRITE;
/*!40000 ALTER TABLE `Utility` DISABLE KEYS */;
INSERT INTO `Utility` VALUES (1,'Chair','Necessity',60),(2,'Table','Necessity',35),(3,'AC','Luxury',10),(4,'Cooler','Luxury',32),(5,'Water Purifier','Necessity',9);
/*!40000 ALTER TABLE `Utility` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Vehicle`
--

DROP TABLE IF EXISTS `Vehicle`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Vehicle` (
  `Vehicle_Number` varchar(36) NOT NULL,
  `Type` varchar(20) NOT NULL,
  `In_Use` int(11) DEFAULT NULL,
  `Description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`Vehicle_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Vehicle`
--

LOCK TABLES `Vehicle` WRITE;
/*!40000 ALTER TABLE `Vehicle` DISABLE KEYS */;
INSERT INTO `Vehicle` VALUES ('DL BC 6781','Ambulance',1,NULL),('DL CE 0900','Van',1,'Mini Ambulance'),('DL LL 0913','Car',1,'General purpose TAXI'),('DL LR 7836','Car',1,'General purpose TAXI'),('DL MC 8537','Ambulance',0,NULL),('DL ML 3357','Ambulance',1,'Old and not in good shape');
/*!40000 ALTER TABLE `Vehicle` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Visiting`
--

DROP TABLE IF EXISTS `Visiting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Visiting` (
  `Visitor_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Admission_ID` int(11) NOT NULL,
  `Session_Timings` varchar(100) NOT NULL,
  `Date_of_Visit` date NOT NULL,
  PRIMARY KEY (`Visitor_ID`,`Admission_ID`,`Session_Timings`,`Date_of_Visit`),
  KEY `Admission_ID` (`Admission_ID`),
  CONSTRAINT `Visiting_ibfk_1` FOREIGN KEY (`Visitor_ID`) REFERENCES `Visitor` (`Visitor_ID`),
  CONSTRAINT `Visiting_ibfk_2` FOREIGN KEY (`Admission_ID`) REFERENCES `Admitted` (`Admission_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Visiting`
--

LOCK TABLES `Visiting` WRITE;
/*!40000 ALTER TABLE `Visiting` DISABLE KEYS */;
INSERT INTO `Visiting` VALUES (1,4,'17:00 to 18:30','2021-03-02'),(2,2,'19:00 to 19:30','2021-01-01'),(2,4,'11:00 to 11:30','2021-03-03'),(3,1,'19:00 to 19:30','2021-01-01'),(4,2,'20:15 to 20:45','2021-01-05'),(5,1,'09:00 to 10:30','2021-01-02'),(6,1,'13:00 to 13:30','2021-01-02');
/*!40000 ALTER TABLE `Visiting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Visitor`
--

DROP TABLE IF EXISTS `Visitor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Visitor` (
  `Visitor_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Name` varchar(36) NOT NULL,
  `Contact_Number` varchar(36) DEFAULT NULL,
  `Relation` varchar(36) DEFAULT NULL,
  PRIMARY KEY (`Visitor_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Visitor`
--

LOCK TABLES `Visitor` WRITE;
/*!40000 ALTER TABLE `Visitor` DISABLE KEYS */;
INSERT INTO `Visitor` VALUES (1,'Visitor1','9999999999','Friend'),(2,'Visitor2','9999999998','Daughter'),(3,'Visitor3','9999999997','Grandsom'),(4,'Visitor4','9999999996','Father'),(5,'Visitor5','9999999995','Son'),(6,'Visitor6','9999999994','Mother');
/*!40000 ALTER TABLE `Visitor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ward`
--

DROP TABLE IF EXISTS `Ward`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ward` (
  `Room_Number` int(11) NOT NULL,
  `Occupancy` int(11) DEFAULT NULL,
  `Beds_Available` int(11) DEFAULT NULL,
  PRIMARY KEY (`Room_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ward`
--

LOCK TABLES `Ward` WRITE;
/*!40000 ALTER TABLE `Ward` DISABLE KEYS */;
INSERT INTO `Ward` VALUES (201,10,10),(202,10,10),(203,10,9),(204,10,10),(205,10,9),(206,10,8),(207,10,10),(208,10,10);
/*!40000 ALTER TABLE `Ward` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `Ward_Duty`
--

DROP TABLE IF EXISTS `Ward_Duty`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `Ward_Duty` (
  `Room_Number` int(11) NOT NULL,
  `Nurse_ID` int(11) NOT NULL,
  `Shift` varchar(20) NOT NULL,
  `Date` date NOT NULL,
  PRIMARY KEY (`Room_Number`,`Nurse_ID`,`Shift`,`Date`),
  KEY `Nurse_ID` (`Nurse_ID`),
  CONSTRAINT `Ward_Duty_ibfk_1` FOREIGN KEY (`Nurse_ID`) REFERENCES `Nurse` (`Nurse_ID`),
  CONSTRAINT `Ward_Duty_ibfk_2` FOREIGN KEY (`Room_Number`) REFERENCES `Ward` (`Room_Number`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `Ward_Duty`
--

LOCK TABLES `Ward_Duty` WRITE;
/*!40000 ALTER TABLE `Ward_Duty` DISABLE KEYS */;
INSERT INTO `Ward_Duty` VALUES (203,1,'17:00 to 24:00','2020-03-18'),(203,2,'9:00 to 17:00','2020-03-18'),(203,3,'24:00 to 9:00','2020-03-18'),(205,1,'17:00 to 24:00','2020-03-18'),(205,2,'9:00 to 17:00','2020-03-18'),(205,3,'24:00 to 9:00','2020-03-18'),(206,1,'17:00 to 24:00','2020-03-18'),(206,2,'9:00 to 17:00','2020-03-18'),(206,3,'24:00 to 9:00','2020-03-18');
/*!40000 ALTER TABLE `Ward_Duty` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-23 16:04:43
