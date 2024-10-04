-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: maternidade
-- ------------------------------------------------------
-- Server version	5.5.5-10.4.32-MariaDB

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `bebe`
--
CREATE DATABASE `maternidade`;
USE `maternidade`;

DROP TABLE IF EXISTS `bebe`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `bebe` (
  `id_bebe` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `peso_nasc` decimal(5,3) DEFAULT NULL,
  `altura` decimal(4,2) DEFAULT NULL,
  `dt_nasc` datetime DEFAULT current_timestamp(),
  `mae_id` int(11) DEFAULT NULL,
  `medico_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id_bebe`),
  KEY `mae_id` (`mae_id`),
  KEY `medico_id` (`medico_id`),
  CONSTRAINT `bebe_ibfk_1` FOREIGN KEY (`mae_id`) REFERENCES `mae` (`id_mae`),
  CONSTRAINT `bebe_ibfk_2` FOREIGN KEY (`medico_id`) REFERENCES `medico` (`id_medico`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `bebe`
--

LOCK TABLES `bebe` WRITE;
/*!40000 ALTER TABLE `bebe` DISABLE KEYS */;
INSERT INTO `bebe` VALUES (1,'juberval','M',2.200,0.12,'2024-09-19 20:52:00',31,2),(2,'joaozinho','M',2.200,0.12,'2024-09-19 20:53:00',31,2),(3,'mariazinha','F',4.350,0.20,'2024-09-19 20:53:00',33,4),(4,'josue','M',2.200,0.12,'2024-09-19 20:55:50',31,2);
/*!40000 ALTER TABLE `bebe` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mae`
--

DROP TABLE IF EXISTS `mae`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mae` (
  `id_mae` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `telefone` char(11) DEFAULT NULL,
  `endereco` varchar(100) DEFAULT NULL,
  `dt_nasc` date DEFAULT NULL,
  PRIMARY KEY (`id_mae`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mae`
--

LOCK TABLES `mae` WRITE;
/*!40000 ALTER TABLE `mae` DISABLE KEYS */;
INSERT INTO `mae` VALUES (31,'gertrudes','2140028922','rua dos bobos','1987-06-01'),(32,'maria','27123456789','rua felizes','1947-06-01'),(33,'antonia','00000000','rua dos robos','1987-06-01'),(34,'carla','11111111','rua dos mariola','1947-06-01'),(35,'joana','22222222','rua dos anjos','1987-06-01'),(36,'beatriz','33333333','rua dos moribundos','1947-06-01'),(37,'Luana Ribeiro','111223344','Vitória','2002-10-23'),(38,'Juana Osvando','7788996655','Vila-Velha','1970-05-03');
/*!40000 ALTER TABLE `mae` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medico`
--

DROP TABLE IF EXISTS `medico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medico` (
  `id_medico` int(11) NOT NULL AUTO_INCREMENT,
  `crm_medico` varchar(8) DEFAULT NULL,
  `nome_medico` varchar(40) DEFAULT NULL,
  `especialidade` enum('Geral','Pediatra','Obstetra','Cirurgião') DEFAULT 'Geral',
  PRIMARY KEY (`id_medico`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medico`
--

LOCK TABLES `medico` WRITE;
/*!40000 ALTER TABLE `medico` DISABLE KEYS */;
INSERT INTO `medico` VALUES (1,'1234','JOANA','Geral'),(2,'2344','JOAO','Obstetra'),(3,'1224','carlos','Pediatra'),(4,'4432','estácio','Cirurgião'),(5,'5533','ruan','Geral'),(6,'0000','mario elias','Geral'),(8,'0000','mario elias','Geral'),(9,'0000','mario elias','Geral'),(10,'11457','Mario','Geral'),(11,'100','Lucas','Geral'),(12,'78965','Jucelino','Pediatra'),(13,'114','Marta','Geral');
/*!40000 ALTER TABLE `medico` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-10-03 21:44:32
