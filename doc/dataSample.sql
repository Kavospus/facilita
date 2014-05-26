CREATE DATABASE  IF NOT EXISTS `facilita` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `facilita`;
-- MySQL dump 10.13  Distrib 5.5.37, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: facilita
-- ------------------------------------------------------
-- Server version	5.5.37-0+wheezy1

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
-- Table structure for table `menu_perfil`
--

DROP TABLE IF EXISTS `menu_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu_perfil` (
  `id_perfil` int(11) NOT NULL,
  `id_menu` int(11) NOT NULL,
  PRIMARY KEY (`id_perfil`,`id_menu`),
  KEY `fk_perfil_has_menu_menu1_idx` (`id_menu`),
  KEY `fk_perfil_has_menu_perfil1_idx` (`id_perfil`),
  CONSTRAINT `fk_perfil_has_menu_menu1` FOREIGN KEY (`id_menu`) REFERENCES `menu` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_perfil_has_menu_perfil1` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu_perfil`
--

LOCK TABLES `menu_perfil` WRITE;
/*!40000 ALTER TABLE `menu_perfil` DISABLE KEYS */;
INSERT INTO `menu_perfil` VALUES (1,1),(2,1),(1,2),(1,3),(1,4),(1,5);
/*!40000 ALTER TABLE `menu_perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `menu`
--

DROP TABLE IF EXISTS `menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `menu` varchar(255) NOT NULL,
  `link` varchar(255) NOT NULL,
  `icone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `menu`
--

LOCK TABLES `menu` WRITE;
/*!40000 ALTER TABLE `menu` DISABLE KEYS */;
INSERT INTO `menu` VALUES (1,'Home','index.jsp','imagens/home.png'),(2,'Calculos','list_calculus.jsp','imagens/list.png'),(3,'Usuários','list_user.jsp','imagens/list.png'),(4,'Perfis','list_profile.jsp','imagens/list.png'),(5,'Menus','list_menu.jsp','imagens/list.png');
/*!40000 ALTER TABLE `menu` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuario` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login` varchar(255) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `nome` varchar(255) NOT NULL,
  `id_perfil` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `login_UNIQUE` (`login`),
  KEY `fk_usuario_perfil_idx` (`id_perfil`),
  CONSTRAINT `fk_usuario_perfil` FOREIGN KEY (`id_perfil`) REFERENCES `perfil` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'admin','21232f297a57a5a743894a0e4a801fc3','Admin',1),(2,'guest','084e0343a0486ff05530df6c705c8bb4','Convidado',2);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `perfil` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'Administrador'),(2,'Convidado');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `calculo`
--

DROP TABLE IF EXISTS `calculo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `calculo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `operacao` varchar(255) NOT NULL,
  `entrada` varchar(1023) NOT NULL,
  `resultado` varchar(1023) NOT NULL,
  `id_usuario` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_calculo_usuario1_idx` (`id_usuario`),
  CONSTRAINT `fk_calculo_usuario1` FOREIGN KEY (`id_usuario`) REFERENCES `usuario` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `calculo`
--

LOCK TABLES `calculo` WRITE;
/*!40000 ALTER TABLE `calculo` DISABLE KEYS */;
INSERT INTO `calculo` VALUES (3,'Invert','{{2.0,5.0},{3.0,10.0}}','{{2.0000000000000004,-1.0000000000000002},{-0.6000000000000002,0.40000000000000013}}',1),(6,'Scale','{{2.0000000000000004,-0.6000000000000002},{-1.0000000000000002,0.40000000000000013}};{3.0};','{{6.000000000000002,-1.8000000000000007},{-3.000000000000001,1.2000000000000004}}',1),(7,'Scale','{{6.000000000000002,-1.8000000000000007},{-3.000000000000001,1.2000000000000004}};{2.0};','{{12.000000000000004,-3.6000000000000014},{-6.000000000000002,2.400000000000001}}',1),(8,'Invert','{{1.0,0.0},{0.0,1.0}}','{{1.0,-0.0},{-0.0,1.0}}',1),(9,'Transpose','{{1.0,-0.0},{-0.0,1.0}}','{{1.0,-0.0},{-0.0,1.0}}',1),(10,'Scale','{{1.0,-0.0},{-0.0,1.0}};{3.0};','{{3.0,-0.0},{-0.0,3.0}}',1),(11,'Determine','{{3.0,-0.0},{-0.0,3.0}}','{9.0}',1),(12,'Scale','{{1.0,2.0},{1.0,2.0}};{9.0};','{{9.0,18.0},{9.0,18.0}}',1),(13,'Determine','{{2.0,3.0},{2.0,1.0}}','{-4.0}',1),(14,'Scale','{{8.0,3.0},{2.0,1.0}};{-4.0};','{{-32.0,-12.0},{-8.0,-4.0}}',1),(15,'Transpose','{{-32.0,-12.0},{-8.0,-4.0}}','{{-32.0,-8.0},{-12.0,-4.0}}',1),(16,'Invert','{{-32.0,-8.0},{-12.0,-4.0}}','{{-0.125,0.25},{0.375,-1.0}}',1),(17,'Multiply','{{2.0,3.0},{4.0,3.0}};{{5.0,3.0},{3.0,54.0}};','{{19.0,168.0},{29.0,174.0}}',1);
/*!40000 ALTER TABLE `calculo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-05-26 10:22:30
