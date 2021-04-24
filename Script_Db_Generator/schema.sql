-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: wheredoieat
-- ------------------------------------------------------
-- Server version	5.7.20-log
USE wheredoieat;
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
-- Table structure for table `attivita`
--

DROP TABLE IF EXISTS `attivita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `attivita` (
  `idAttivita` int(10) NOT NULL AUTO_INCREMENT,
  `nome` varchar(20) NOT NULL,
  `comune` varchar(20) NOT NULL,
  `oraApertura` int(5) NOT NULL,
  `oraChiusura` int(5) NOT NULL,
  `giornoChiusura` varchar(10) DEFAULT NULL,
  `indirizzo` varchar(40) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `numPosti` int(5) NOT NULL,
  `mappa` varchar(400) DEFAULT NULL,
  `personaUsername` varchar(32) NOT NULL,
  PRIMARY KEY (`idAttivita`),
  KEY `personaUsername` (`personaUsername`),
  CONSTRAINT `attivita_ibfk_1` FOREIGN KEY (`personaUsername`) REFERENCES `persona` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `attivita`
--

LOCK TABLES `attivita` WRITE;
/*!40000 ALTER TABLE `attivita` DISABLE KEYS */;
INSERT INTO `attivita` VALUES (1,'El pampa Sosa','Fisciano',13,23,'Mercoledi','via bomber','39340412122',200,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3025.9426235718774!2d14.769572615021944!3d40.67523314780173!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bc239baaf7187%3A0x9cae3635339ffee0!2sSalerno%20Stazione!5e0!3m2!1sit!2sit!4v1577092641285!5m2!1sit!2sit','amecuomo'),
(2,'Numero1','Baronissi',19,24,'Lunedi','Via numero 1','123213123',90,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3021.4536055228923!2d14.79028741502506!3d40.77404084175542!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bc5a5fb14b909%3A0x38886a101e6824ee!2sFisciano%20(Universit%C3%A0)!5e0!3m2!1sit!2sit!4v1577093098487!5m2!1sit!2sit','toni9'),
(3,'El pocho di Salerno','Salerno',19,24,'Lunedi','via Roma','4324322',110,'https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3022.6707045574185!2d14.76813671502418!3d40.74727084339462!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x133bc43e1a9c404b%3A0x7f2d39e1b567aa1!2sBaronissi%20Municipio!5e0!3m2!1sit!2sit!4v1577093153931!5m2!1sit!2sit','amecuomo'),
(4,'DaTotò','Roccadaspide',18,22,'Martedì','via soldi','24643',150,'https://maps.google.com/maps?width=700&amp;height=440&amp;hl=en&amp;q=Roccoadaspide%2Cvia%20santa%20palomba+(Da%20toto)&amp;ie=UTF8&amp;t=&amp;z=15&amp;iwloc=B&amp;output=embed','A_DeMatteo'),
(5,'FoodSA','SanCipriano',20,24,'Domenica','via tenente colombo','24243243',110,'https://maps.google.com/maps?width=700&amp;height=440&amp;hl=en&amp;q=San%20cipriano%20picentino%2C%20via%20vigna+(Titolo)&amp;ie=UTF8&amp;t=&amp;z=15&amp;iwloc=B&amp;output=embed','A_DeMatteo'),
(6,'Food&Beverage','Agropoli',19,23,'Lunedì','Lungomare Caracciolo','089763203',30,'https://maps.google.com/maps?width=700&amp;height=440&amp;hl=en&amp;q=agropoli%2C%20lungomare+(Titolo)&amp;ie=UTF8&amp;t=&amp;z=15&amp;iwloc=B&amp;output=embed','A_DeMatteo')
;
/*!40000 ALTER TABLE `attivita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `foto`
--

DROP TABLE IF EXISTS `foto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `foto` (
  `foto` varchar(150) NOT NULL,
  `attivitaIDattivita` int(10) NOT NULL,
  PRIMARY KEY (`foto`),
  KEY `attivitaIDattivita` (`attivitaIDattivita`),
  CONSTRAINT `foto_ibfk_1` FOREIGN KEY (`attivitaIDattivita`) REFERENCES `attivita` (`idAttivita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `foto`
--

LOCK TABLES `foto` WRITE;
/*!40000 ALTER TABLE `foto` DISABLE KEYS */;
INSERT INTO `foto` VALUES ('fotodb/bruschetta.jpg',1),('fotodb/ristorante-da-kico.jpg',1),('fotodb/img-ristoranti.jpg',2),('fotodb/la-sala.jpg',2),('fotodb/pizza.jpg',2),('fotodb/ristorante-servizio.jpg',2),('fotodb/testata-ristorante.jpg',2),('fotodb/imagesILV4I6JR.jpg',3),('fotodb/Montagna-Verde-Ristorante.jpg',3),('fotodb/ristorante-firenze.jpg',3),('fotodb/ristorante.jpg',3),('fotodb/ristorante1.jpg',3),
('fotodb/toto.jpg',4), ('fotodb/zuppa.jpg',4), ('fotodb/ceci.jpg',4),
('fotodb/foodSA.jpg',5), ('fotodb/foodSA1.jpg',5), ('fotodb/foodSA2.jpg',5),
('fotodb/aperitivo.jpg',6), ('fotodb/aperitivo1.jpg',6), ('fotodb/aperitivo2.jpg',6)
;
/*!40000 ALTER TABLE `foto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `persona`
--

DROP TABLE IF EXISTS `persona`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `persona` (
  `username` varchar(32) NOT NULL,
  `nome` varchar(20) NOT NULL,
  `cognome` varchar(20) NOT NULL,
  `email` varchar(100) NOT NULL,
  `telefono` varchar(20) NOT NULL,
  `citta` varchar(30) NOT NULL,
  `tipo` int(1) NOT NULL,
  `comune` varchar(15) NOT NULL,
  `password` varchar(25) NOT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `persona`
--

LOCK TABLES `persona` WRITE;
/*!40000 ALTER TABLE `persona` DISABLE KEYS */;
INSERT INTO `persona` VALUES ('amecuomo','Amedeo','Cuomo','amedeo@bestemmio.com','393452134567','Salerno',2,'Baronissi','Mistersessa69'),('elcardinero','Cruz','Cruz','elcardinero@gmail.com','393404181948','Buenos Aires',1,'Buenos Aires','Mistersessa69'),('ElPampa','Sosa','Sosa','elpampasosa@gmail.com','393404181948','Buenos Aires',1,'Buenos Aires','Mistersessa69'),('elpojo','Vittorio','Scarano','vitsca@gmail.com','393404181948','Salerno',2,'Baronissi','Vittorio9'),('gerdenis','German','Denis','eltanke@gmail.com','393404181948','Buenos Aires',1,'Buenos Aires','Mistersessa69'),('imperatore','Adriano','Adriano','imperatore10@gmail.com','393478923456','Rio De Janeiro',1,'Rio','Mistersessa69'),('tanucc','Gaetano','Mauro','g.mauro14@studenti.unisa.it','393404181948','Avellino',1,'Atripalda','mistersessa'),('tanucc33','Gaetano','De Lucia','g.maur44o14@studenti.unisa.it','3404181948','Salerno',1,'Fisciano','mistersessa'),('toni9','Luca','Toni','toniluca9@gmail.com','393453456789','Firenze',2,'casigliolo','Mistersessa69'),
('A_DeMatteo','Antonio','DeMatteo','adematteo@gmail.com','393404621948','Salerno',2,'Salerno','mipiaceilpesce');
/*!40000 ALTER TABLE `persona` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `piatti`
--

DROP TABLE IF EXISTS `piatti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `piatti` (
  `idPiatto` int(10) NOT NULL AUTO_INCREMENT,
  `piatto` varchar(40) NOT NULL,
  `descrizione` varchar(150) DEFAULT NULL,
  `attivitaIDAttivita` int(10) NOT NULL,
  PRIMARY KEY (`idPiatto`),
  KEY `attivitaIDAttivita` (`attivitaIDAttivita`),
  CONSTRAINT `piatti_ibfk_1` FOREIGN KEY (`attivitaIDAttivita`) REFERENCES `attivita` (`idAttivita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=92 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `piatti`
--

LOCK TABLES `piatti` WRITE;
/*!40000 ALTER TABLE `piatti` DISABLE KEYS */;
INSERT INTO `piatti` VALUES (1,'gnocchi al forno','gnocchi cotti al forno  per 10 minuti',1),(2,'pizza integrale','pizza con farina integrale',2),(3,'pizza','pizza cotta nel forno a legna',2),(4,'pizza','pizza cotta nel forno a legna',1),(5,'pizza','pizza cotta nel forno a legna',3),(6,'risotto','Risotto tipico della zona con funghi paesani',1),(7,'tagliata di carne','carne servita con contorni tipici della zona',3)
,(8,'zuppa di legumi','legumi della campagna cotti in una buonissima zuppa di verdure',4),(9,'zuppa di ceci','zuppa di ceci biologici',4),(10,'Carne al barbecue',"Carne di angus in crosta di salsa barbecue",5),(11,'avocado e sfizi vari', "aperitivo da sogno",5),(12,'spritz con stuzzichini',"Classico aperitivo domenicale",6);
/*!40000 ALTER TABLE `piatti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferiti`
--

DROP TABLE IF EXISTS `preferiti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `preferiti` (
  `idPref` int(11) NOT NULL AUTO_INCREMENT,
  `personaUsername` varchar(32) NOT NULL,
  `attivitaIDAttivita` int(10) NOT NULL,
  PRIMARY KEY (`idPref`),
  KEY `personaUsername` (`personaUsername`),
  KEY `attivitaIDAttivita` (`attivitaIDAttivita`),
  CONSTRAINT `preferiti_ibfk_1` FOREIGN KEY (`personaUsername`) REFERENCES `persona` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `preferiti_ibfk_2` FOREIGN KEY (`attivitaIDAttivita`) REFERENCES `attivita` (`idAttivita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=71 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferiti`
--

LOCK TABLES `preferiti` WRITE;
/*!40000 ALTER TABLE `preferiti` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferiti` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prenotazione`
--

DROP TABLE IF EXISTS `prenotazione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prenotazione` (
  `idPren` int(11) NOT NULL AUTO_INCREMENT,
  `data` date NOT NULL,
  `ora` int(5) NOT NULL,
  `numPosti` int(5) NOT NULL,
  `personaUsername` varchar(32) NOT NULL,
  `attivitaIDAttivita` int(10) NOT NULL,
  PRIMARY KEY (`idPren`),
  KEY `personaUsername` (`personaUsername`),
  KEY `attivitaIDAttivita` (`attivitaIDAttivita`),
  CONSTRAINT `prenotazione_ibfk_1` FOREIGN KEY (`personaUsername`) REFERENCES `persona` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `prenotazione_ibfk_2` FOREIGN KEY (`attivitaIDAttivita`) REFERENCES `attivita` (`idAttivita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=109 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prenotazione`
--

LOCK TABLES `prenotazione` WRITE;
/*!40000 ALTER TABLE `prenotazione` DISABLE KEYS */;
INSERT INTO `prenotazione` VALUES (1,'2020-03-02',1300,12,'tanucc',1),(2,'2020-03-04',1330,2,'tanucc',1),(3,'2020-03-02',1300,13,'tanucc',1),(4,'2020-03-04',2000,20,'tanucc',3);
/*!40000 ALTER TABLE `prenotazione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `recensione`
--

DROP TABLE IF EXISTS `recensione`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `recensione` (
  `idRecensione` int(11) NOT NULL AUTO_INCREMENT,
  `valutazione` int(10) NOT NULL,
  `commento` varchar(255) DEFAULT NULL,
  `personaUsername` varchar(32) NOT NULL,
  `attivitaIDAttivita` int(10) NOT NULL,
  PRIMARY KEY (`idRecensione`),
  KEY `personaUsername` (`personaUsername`),
  KEY `attivitaIDAttivita` (`attivitaIDAttivita`),
  CONSTRAINT `recensione_ibfk_1` FOREIGN KEY (`personaUsername`) REFERENCES `persona` (`username`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `recensione_ibfk_2` FOREIGN KEY (`attivitaIDAttivita`) REFERENCES `attivita` (`idAttivita`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=135 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `recensione`
--

LOCK TABLES `recensione` WRITE;
/*!40000 ALTER TABLE `recensione` DISABLE KEYS */;
INSERT INTO `recensione` VALUES (2,5,'ciao didod idiv nsaivoans ija ','ElPampa',2),(3,1,'asdfsf safsd gfdsg','gerdenis',2),(4,2,'sfsdfsdfasfdasfdasf','ElPampa',1),(42,3,'ho mangiato vermanete ben in questo locale','tanucc',3),(96,3,'ho mangiato vermanete ben in questo locale','tanucc',3);
/*!40000 ALTER TABLE `recensione` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `suggerimenti`
--

DROP TABLE IF EXISTS `suggerimenti`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `suggerimenti` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `titolo` varchar(50) NOT NULL,
  `testo` varchar(255) NOT NULL,
  `personaUsername` varchar(32) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `personaUsername` (`personaUsername`),
  CONSTRAINT `suggerimenti_ibfk_1` FOREIGN KEY (`personaUsername`) REFERENCES `persona` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `suggerimenti`
--

LOCK TABLES `suggerimenti` WRITE;
/*!40000 ALTER TABLE `suggerimenti` DISABLE KEYS */;
INSERT INTO `suggerimenti` VALUES (22,'recensioni non funzionanti',' jvhsdkvbhjsvbjs vbsvbsdk vhsdkjvbhdj fv svsd fsvd fsd bsdfb sdfb dsfbds b s dfb sdbdfb sdb sdbd','tanucc'),(24,'problema home',' jvhsdkvbhjsvbjs vbsvbsdk vhsdkjvbhdj fv svsd fsvd fsd bsdfb sdfb dsfbds b s dfb sdbdfb sdb sdbd ds fasg ag ds gsdhsh sdh shbsv dfsb sdfb sdfb sfdbfsdbfdsb sfdbsfbsdfbsdfbsdf b','tanucc'),(26,'pizzerie non presenti','non ci sono pizzerie sul sito','tanucc'),(27,'ciao','il problema Ã¨ questo','tanucc');
/*!40000 ALTER TABLE `suggerimenti` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-22 20:12:26
