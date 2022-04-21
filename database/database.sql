/*
SQLyog Community v13.1.5  (64 bit)
MySQL - 5.1.53-community-log : Database - preduzece
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`preduzece` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_unicode_ci */;

USE `preduzece`;

/*Table structure for table `racun` */

DROP TABLE IF EXISTS `racun`;

CREATE TABLE `racun` (
  `BrojRacuna` int(15) NOT NULL AUTO_INCREMENT,
  `UkupanIznos` double DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Zaposleni` int(15) DEFAULT NULL,
  `RBRacuna` int(50) DEFAULT NULL,
  `Trosak` int(15) DEFAULT NULL,
  PRIMARY KEY (`BrojRacuna`),
  KEY `racun_ibfk_3` (`Zaposleni`),
  KEY `racun_ibfk_4` (`Trosak`),
  CONSTRAINT `racun_ibfk_3` FOREIGN KEY (`Zaposleni`) REFERENCES `zaposleni` (`ZaposleniId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `racun_ibfk_4` FOREIGN KEY (`Trosak`) REFERENCES `trosak` (`TrosakID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `racun` */

insert  into `racun`(`BrojRacuna`,`UkupanIznos`,`Datum`,`Zaposleni`,`RBRacuna`,`Trosak`) values 
(30,5000,'2021-12-08',196,1547,77),
(31,4900,'2021-12-29',196,9658,77),
(32,7400,'2022-02-01',186,1547,78),
(33,17000,'2022-02-03',186,9685,78),
(46,13000,'2022-01-03',186,896,101),
(47,1000,'2022-02-08',186,965,102),
(58,5400,'2022-01-18',196,896,113);

/*Table structure for table `statustroska` */

DROP TABLE IF EXISTS `statustroska`;

CREATE TABLE `statustroska` (
  `StatusID` int(15) NOT NULL,
  `Naziv` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`StatusID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `statustroska` */

insert  into `statustroska`(`StatusID`,`Naziv`) values 
(1,'Odobren'),
(2,'Odbijen'),
(3,'Na čekanju');

/*Table structure for table `stavkaracuna` */

DROP TABLE IF EXISTS `stavkaracuna`;

CREATE TABLE `stavkaracuna` (
  `Rb` int(15) NOT NULL,
  `IznosStavke` double DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Naziv` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Racun` int(15) DEFAULT NULL,
  PRIMARY KEY (`Rb`),
  KEY `Racun` (`Racun`),
  CONSTRAINT `stavkaracuna_ibfk_1` FOREIGN KEY (`Racun`) REFERENCES `racun` (`BrojRacuna`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `stavkaracuna` */

insert  into `stavkaracuna`(`Rb`,`IznosStavke`,`Datum`,`Naziv`,`Racun`) values 
(0,566,'2021-01-12','222',0);

/*Table structure for table `tip` */

DROP TABLE IF EXISTS `tip`;

CREATE TABLE `tip` (
  `TipID` int(15) NOT NULL,
  `Naziv` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`TipID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `tip` */

insert  into `tip`(`TipID`,`Naziv`) values 
(1,'Menadzer'),
(2,'Supervizor'),
(3,'Zaposleni');

/*Table structure for table `trosak` */

DROP TABLE IF EXISTS `trosak`;

CREATE TABLE `trosak` (
  `TrosakID` int(15) NOT NULL AUTO_INCREMENT,
  `Naziv` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `VrstaTroska` int(15) DEFAULT NULL,
  `Datum` date DEFAULT NULL,
  `Opis` varchar(500) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Zaposleni` int(15) DEFAULT NULL,
  `StatusTroska` int(15) DEFAULT NULL,
  PRIMARY KEY (`TrosakID`),
  KEY `VrstaTroska` (`VrstaTroska`),
  KEY `StatusTroska` (`StatusTroska`),
  KEY `trosak_ibfk_2` (`Zaposleni`),
  CONSTRAINT `trosak_ibfk_1` FOREIGN KEY (`VrstaTroska`) REFERENCES `vrstatroska` (`VrstaTroskaID`),
  CONSTRAINT `trosak_ibfk_2` FOREIGN KEY (`Zaposleni`) REFERENCES `zaposleni` (`ZaposleniId`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `trosak_ibfk_3` FOREIGN KEY (`StatusTroska`) REFERENCES `statustroska` (`StatusID`)
) ENGINE=InnoDB AUTO_INCREMENT=114 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `trosak` */

insert  into `trosak`(`TrosakID`,`Naziv`,`VrstaTroska`,`Datum`,`Opis`,`Zaposleni`,`StatusTroska`) values 
(77,'Gorivo za Decembar 2021',2,'2022-02-21','Racuni za gorivo',135,1),
(78,'Put u Austriju',1,'2022-02-21','Svi racuni sa sluzbenog puta',135,1),
(101,'Sluzbeni put u Austriju',1,'2022-02-22','Dnevnice',135,1),
(102,'Kancelarijski materijal',3,'2022-02-08','Materijal potreban za rad od kuce',186,3),
(113,'Gorivo za Januar 2022',2,'2022-02-22','racun za gorivo',135,1);

/*Table structure for table `vrstatroska` */

DROP TABLE IF EXISTS `vrstatroska`;

CREATE TABLE `vrstatroska` (
  `VrstaTroskaID` int(15) NOT NULL,
  `Naziv` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`VrstaTroskaID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `vrstatroska` */

insert  into `vrstatroska`(`VrstaTroskaID`,`Naziv`) values 
(1,'SluzbeniPut'),
(2,'Gorivo'),
(3,'SitniMaterijal');

/*Table structure for table `zaposleni` */

DROP TABLE IF EXISTS `zaposleni`;

CREATE TABLE `zaposleni` (
  `ZaposleniId` int(15) NOT NULL AUTO_INCREMENT,
  `Ime` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Prezime` varchar(150) COLLATE utf8_unicode_ci DEFAULT NULL,
  `JMBG` varchar(15) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Username` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Password` varchar(50) COLLATE utf8_unicode_ci DEFAULT NULL,
  `Tip` int(15) DEFAULT NULL,
  PRIMARY KEY (`ZaposleniId`),
  KEY `Tip` (`Tip`),
  CONSTRAINT `zaposleni_ibfk_1` FOREIGN KEY (`Tip`) REFERENCES `tip` (`TipID`)
) ENGINE=InnoDB AUTO_INCREMENT=218 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

/*Data for the table `zaposleni` */

insert  into `zaposleni`(`ZaposleniId`,`Ime`,`Prezime`,`JMBG`,`Username`,`Password`,`Tip`) values 
(135,'Katarina','Vujicic','1231231471597','vujicickatt@gmail.com','kat',1),
(186,'Aleksandra','Lopusina','1203258963258','akica@yahoo.com','akica',2),
(189,'Pavle','Vujicic','1708585236987','pavle@gmail.com','pavle',3),
(194,'Nemanja','Vujicic','2509632589654','nemke@gmail.com','Nemanja',2),
(195,'Danko','Paestka','2302158965456','danko@gmail.com','dane',3),
(196,'Kosta','Vujicic','1205156965874','kosta@gmail.com','kosta',2),
(217,'Bojana','Nedeljkovic','1310958632145','bojana@gmail.com','bojana',3);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
