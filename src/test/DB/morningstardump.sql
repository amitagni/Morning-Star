-- MySQL dump 10.13  Distrib 5.7.13, for Win64 (x86_64)
--
-- Host: localhost    Database: morningstar
-- ------------------------------------------------------
-- Server version	5.7.13-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `fee_slip`
--

DROP TABLE IF EXISTS `fee_slip`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_slip` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` int(8) NOT NULL,
  `payment_id` int(8) NOT NULL,
  `month` tinyint(4) NOT NULL,
  `amount` varchar(20) NOT NULL,
  `discount` varchar(10) DEFAULT NULL,
  `created_by` int(8) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_slip`
--

LOCK TABLES `fee_slip` WRITE;
/*!40000 ALTER TABLE `fee_slip` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_slip` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `fee_structure`
--

DROP TABLE IF EXISTS `fee_structure`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `fee_structure` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `fee_freq_type` tinyint(3) NOT NULL,
  `abbr_name` varchar(20) NOT NULL,
  `class` tinyint(3) NOT NULL,
  `session` tinyint(3) DEFAULT NULL,
  `created_by` int(11) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_fee_struct_1` (`created_by`),
  CONSTRAINT `fk_fee_struct_1` FOREIGN KEY (`created_by`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `fee_structure`
--

LOCK TABLES `fee_structure` WRITE;
/*!40000 ALTER TABLE `fee_structure` DISABLE KEYS */;
/*!40000 ALTER TABLE `fee_structure` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `payment`
--

DROP TABLE IF EXISTS `payment`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `payment` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `student_id` int(8) DEFAULT NULL,
  `fee_type` tinyint(4) NOT NULL,
  `amount` varchar(20) DEFAULT NULL,
  `discount_amt` varchar(20) DEFAULT NULL,
  `payment_type` tinyint(4) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `payment`
--

LOCK TABLES `payment` WRITE;
/*!40000 ALTER TABLE `payment` DISABLE KEYS */;
/*!40000 ALTER TABLE `payment` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_contact_info`
--

DROP TABLE IF EXISTS `student_contact_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_contact_info` (
  `id` int(11) NOT NULL,
  `student_id` int(11) NOT NULL,
  `address1` varchar(100) DEFAULT NULL,
  `address2` varchar(100) DEFAULT NULL,
  `area` varchar(100) DEFAULT NULL,
  `city` varchar(50) DEFAULT NULL,
  `state` varchar(50) DEFAULT NULL,
  `pincode` varchar(6) DEFAULT NULL,
  `phone` varchar(15) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `email` varchar(15) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_contact_info`
--

LOCK TABLES `student_contact_info` WRITE;
/*!40000 ALTER TABLE `student_contact_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_contact_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_info`
--

DROP TABLE IF EXISTS `student_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_info` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `reg_id` int(8) NOT NULL,
  `first_name` varchar(30) NOT NULL,
  `last_name` varchar(30) DEFAULT NULL,
  `dob` varchar(10) NOT NULL,
  `father_name` varchar(50) NOT NULL,
  `mother_name` varchar(50) NOT NULL,
  `admission_class` tinyint(3) NOT NULL,
  `current_class` tinyint(3) NOT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(8) DEFAULT NULL,
  `category` tinyint(3) NOT NULL,
  `section` varchar(1) DEFAULT NULL,
  `house` varchar(20) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL,
  `nationality` varchar(20) DEFAULT NULL,
  `religion` varchar(20) DEFAULT NULL,
  `caste` varchar(30) DEFAULT NULL,
  `tc_path` varchar(300) DEFAULT NULL,
  `dob_proof_path` varchar(300) DEFAULT NULL,
  `transport_taken` tinyint(3) DEFAULT NULL,
  `sibling_study` tinyint(3) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_info`
--

LOCK TABLES `student_info` WRITE;
/*!40000 ALTER TABLE `student_info` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `student_reg`
--

DROP TABLE IF EXISTS `student_reg`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `student_reg` (
  `id` int(8) NOT NULL,
  `form_num` varchar(20) NOT NULL,
  `reg_date` varchar(10) DEFAULT NULL,
  `last_class` tinyint(3) NOT NULL,
  `last_school` varchar(100) DEFAULT NULL,
  `result` varchar(2) DEFAULT NULL,
  `created_by` int(8) NOT NULL,
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `reg_num` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `student_reg`
--

LOCK TABLES `student_reg` WRITE;
/*!40000 ALTER TABLE `student_reg` DISABLE KEYS */;
/*!40000 ALTER TABLE `student_reg` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `mobile` varchar(15) DEFAULT NULL,
  `dept_id` int(8) DEFAULT NULL,
  `role_id` int(8) DEFAULT NULL,
  `status` tinyint(4) NOT NULL DEFAULT '0',
  `created_at` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `created_by` int(8) NOT NULL,
  `updated_by` int(8) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-03-12 11:52:47
