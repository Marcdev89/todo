CREATE DATABASE  IF NOT EXISTS `todo` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `todo`;
-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: todo
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `todo`
--

DROP TABLE IF EXISTS `todo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `todo` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `completed` bit(1) NOT NULL,
  `title` varchar(255) DEFAULT NULL,
  `user_id` bigint DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `FK2ft3dfk1d3uw77pas3xqwymm7` (`user_id`),
  CONSTRAINT `FK2ft3dfk1d3uw77pas3xqwymm7` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `todo`
--

LOCK TABLES `todo` WRITE;
/*!40000 ALTER TABLE `todo` DISABLE KEYS */;
INSERT INTO `todo` VALUES (5,_binary '\0','Begin bonus number 2',4),(6,_binary '\0','Learn about Thymeleaf',5),(7,_binary '','Difference between Controller and RestController',6),(19,_binary '','Sorted by field',5),(20,_binary '\0','Do Pagination in SB',4),(23,_binary '\0','Begin bonus',6),(24,_binary '\0','Do exercise: PAST PERFECT',10),(25,_binary '','Reparar la finestra',9),(26,_binary '\0','Place to go: Sagrada Familia',8),(27,_binary '\0','Jogo bonito',7),(28,_binary '','Visitar familia en Lisboa',7),(29,_binary '','Place to go: la Pedrera',8),(30,_binary '','Place to go: Camp Nou',8),(31,_binary '','Place to go: Casa Batllo',8),(32,_binary '','Reparar el marc de la porta principal',9),(33,_binary '','Reparar marbre de la cuina',9),(34,_binary '\0','Canviar bombeta habitació del nen',9),(35,_binary '','Beure aigua (important)',9),(36,_binary '','Comprar pa',9),(37,_binary '\0','Comprar ous',9),(38,_binary '\0','Comprar arrosset',9),(39,_binary '\0','Reparar lavabo',9),(40,_binary '\0','Reparar manovelles ok',9),(41,_binary '','Descansar 30 minuts',9),(48,_binary '','I think I finished',7),(49,_binary '','Tifa is my friend since i was a kid',7),(50,_binary '','Learn restrictions',4),(51,_binary '','Learn restrictions about integrity',9),(52,_binary '','I\'m testing redirects',10),(54,_binary '','I\'m testing the html files',10),(55,_binary '\0','I\'m testing a validate method',4),(56,_binary '','It works!!',4),(57,_binary '','Refactor code',8),(58,_binary '','Programming Xiaomi Vacum at 18 o\'clock',8),(59,_binary '\0','Relationships are so complicated',5),(60,_binary '','Obrigado con Rui Costa',7);
/*!40000 ALTER TABLE `todo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `city` varchar(255) DEFAULT NULL,
  `country` varchar(255) DEFAULT NULL,
  `street` varchar(255) DEFAULT NULL,
  `zipcode` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (4,'Andrew','1234','javadeveloper3','Barcelona','Spain','Turó de la Peira 13','08040'),(5,'Sofia','1234','sof44','Barcelona','Spain','Turó de la Peira 13','08040'),(6,'Josep','1234','enjosep','Barcelona','Spain','Turó de la Peira 13','08040'),(7,'Ricardinho','strife7','Cloud','Lisboa','Portugal','Obrigado 1','0804044'),(8,'James','usa1234','james3','New York','United States','123 - 123','4044'),(9,'Anselm','anse7','senyor7','Mollet','Spain','Roger de Llúria 12','08814'),(10,'Vladimir','19ru','vladi','Podolsk','Rusia','Kalash 17','001414445');
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

-- Dump completed on 2023-05-21 15:43:28
