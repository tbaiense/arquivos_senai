CREATE DATABASE  IF NOT EXISTS `escola_senai` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci */;
USE `escola_senai`;
-- MySQL dump 10.13  Distrib 8.0.38, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: escola_senai
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
-- Table structure for table `tb_aluno`
--

DROP TABLE IF EXISTS `tb_aluno`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_aluno` (
  `RA_ALUN` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_ALU` varchar(40) DEFAULT NULL,
  `DT_NASC_ALU` date DEFAULT NULL,
  `CPF_ALU` char(11) DEFAULT NULL,
  `SEXO_ALU` char(1) DEFAULT NULL,
  PRIMARY KEY (`RA_ALUN`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_aluno`
--

LOCK TABLES `tb_aluno` WRITE;
/*!40000 ALTER TABLE `tb_aluno` DISABLE KEYS */;
INSERT INTO `tb_aluno` VALUES (1,'Joao da Silva','2001-12-30','12345678910','M'),(2,'Maria Antonia','2003-04-02','12345678900','F'),(3,'Reginaldo Marques','2001-12-09','45672244890','M'),(4,'Natália Soares','2007-12-03','21523452345','F'),(5,'Mauro Pinheiros','2001-04-09','123412\'2112','M'),(6,'Carlos Eduardo','2000-12-17','33344212313','M'),(7,'Pedro Henrique Oliveria','2007-12-02','42342345566','M'),(8,'Rodrigo Oliz','2008-12-30','98765234556','M'),(9,'Rita Kowasky','2001-04-22','32189345234','F'),(10,'Raphael Kobayashi','2003-12-02','23425553433','M');
/*!40000 ALTER TABLE `tb_aluno` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_curso`
--

DROP TABLE IF EXISTS `tb_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_curso` (
  `COD_CURS` int(11) NOT NULL AUTO_INCREMENT,
  `NOME_CURS` varchar(100) NOT NULL,
  `PER_CURS` enum('Verspertino','Matutino','Noturno','Integral','Verspertino-Noturno','N/A') DEFAULT 'N/A',
  `DUR_CURS` int(11) NOT NULL,
  `VALOR_CURS` decimal(7,2) NOT NULL,
  PRIMARY KEY (`COD_CURS`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_curso`
--

LOCK TABLES `tb_curso` WRITE;
/*!40000 ALTER TABLE `tb_curso` DISABLE KEYS */;
INSERT INTO `tb_curso` VALUES (1,'Desenvolvimento de Sistemas','Noturno',1280,5250.99),(2,'Cibersegurança','Matutino',140,450.99),(3,'Eletrotécnica','Integral',1280,7250.99),(4,'Automação','Verspertino',320,900.99),(5,'Segurança do Trabalho','Matutino',1280,4250.99);
/*!40000 ALTER TABLE `tb_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tb_matricula`
--

DROP TABLE IF EXISTS `tb_matricula`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tb_matricula` (
  `COD_MAT` int(11) NOT NULL AUTO_INCREMENT,
  `RA_ALU` int(11) NOT NULL,
  `DATA_MAT` date DEFAULT NULL,
  `COD_CURS` int(11) NOT NULL,
  PRIMARY KEY (`COD_MAT`),
  KEY `fk_TB_MATRICULA_RA_ALU` (`RA_ALU`),
  KEY `fk_TB_MATRICULA_COD_CURS` (`COD_CURS`),
  CONSTRAINT `fk_TB_MATRICULA_COD_CURS` FOREIGN KEY (`COD_CURS`) REFERENCES `tb_curso` (`COD_CURS`),
  CONSTRAINT `fk_TB_MATRICULA_RA_ALU` FOREIGN KEY (`RA_ALU`) REFERENCES `tb_aluno` (`RA_ALUN`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tb_matricula`
--

LOCK TABLES `tb_matricula` WRITE;
/*!40000 ALTER TABLE `tb_matricula` DISABLE KEYS */;
INSERT INTO `tb_matricula` VALUES (1,1,'2022-01-20',1),(2,1,'2022-02-20',1),(3,1,'2022-04-20',2),(4,1,'2022-04-20',3),(5,2,'2022-09-20',1),(6,2,'2022-09-20',2),(7,2,'2022-09-20',4),(8,3,'2023-01-20',1),(9,4,'2023-02-20',1),(10,4,'2023-02-20',2),(11,5,'2023-04-20',1),(12,5,'2023-04-20',2),(13,5,'2023-09-20',3),(14,5,'2024-01-20',4),(15,5,'2024-02-20',1),(16,8,'2024-02-20',2),(17,9,'2024-04-20',1),(18,6,'2024-04-20',4),(19,7,'2024-09-20',1),(20,7,'2024-09-20',2);
/*!40000 ALTER TABLE `tb_matricula` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-09-20 15:47:42
