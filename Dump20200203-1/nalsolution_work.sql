CREATE DATABASE  IF NOT EXISTS `nalsolution` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `nalsolution`;
-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: localhost    Database: nalsolution
-- ------------------------------------------------------
-- Server version	5.7.21-log

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
-- Table structure for table `work`
--

DROP TABLE IF EXISTS `work`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `work` (
  `id_work` int(11) NOT NULL,
  `work_name` varchar(50) DEFAULT NULL,
  `starting_date` varchar(45) DEFAULT NULL,
  `ending_date` varchar(45) DEFAULT NULL,
  `status` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id_work`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `work`
--

LOCK TABLES `work` WRITE;
/*!40000 ALTER TABLE `work` DISABLE KEYS */;
INSERT INTO `work` VALUES (1,'C Test nal','2020-01-02','2020-01-04','(Planning'),(2,'B Test nal','2020-01-04','2020-01-02','1(Planning'),(3,'A Test nal','2020-01-04','2020-01-02','(Planning'),(6,'Test nal','2020-01-04','2020-01-02','(Planning'),(7,'Test nal','2020-01-04','2020-01-02','(Planning'),(8,'Test nal','2020-01-04','2020-01-02','(Planning'),(9,'Test nal','2020-01-04','2020-01-02','(Planning'),(10,'Test nal','2020-01-04','2020-01-02','(Planning'),(11,'Tes122t nal','2020-01-04','2020-01-02','(Planning'),(12,'1Tes122t nal','2020-01-04','2020-01-02','(Planning'),(13,'12Tes122t nal','2020-01-04','2020-01-02','(Planning'),(14,'132Tes122t nal','2020-01-04','2020-01-02','(Planning'),(15,'1342Tes122t nal','2020-01-04','2020-01-02','(Planning'),(16,'1342Tes122t nal','2020-01-04','2020-01-02','(Planning'),(17,'1342Tes122t nal','01/01/2020','01/01/2020','Planning'),(18,'1342Tes122t nal','2020/01/01','01/01/2020','Planning'),(19,'1342Tes122t nal','2020/01/01','01/01/2020','Planning'),(20,'12đ','01/01/2020','02/01/2020','Planning'),(21,'12đ','01/01/2020','01/01/2020','Planning'),(22,'12đ','01/01/2020','01/01/2020','Planning');
/*!40000 ALTER TABLE `work` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-03 22:32:05
