-- MySQL Administrator dump 1.4
--
-- ------------------------------------------------------
-- Server version	5.0.19-nt


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


--
-- Create schema cart
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ cart;
USE cart;

--
-- Structure for table `cart`.`cart_avail_product`
--

DROP TABLE IF EXISTS `cart`.`cart_avail_product`;
CREATE TABLE  `cart`.`cart_avail_product` (
  `proid` int(10) unsigned NOT NULL auto_increment,
  `shopid` int(10) unsigned default NULL,
  `pro_name` varchar(100) default NULL,
  `Availability` int(10) unsigned default NULL,
  PRIMARY KEY  (`proid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`.`cart_avail_product`
--

/*!40000 ALTER TABLE `cart_avail_product` DISABLE KEYS */;
INSERT INTO `cart`.`cart_avail_product` (`proid`,`shopid`,`pro_name`,`Availability`) VALUES 
 (1,1001,'CellPhones',50),
 (2,1001,'Dresses',1000),
 (3,1001,'FancyItems',500),
 (4,1001,'Toys',200),
 (5,1001,'Vessels',150),
 (6,1001,'Cosmetics',50),
 (7,1001,'Bags',100),
 (8,1001,'ElectronicItems',30),
 (9,1002,'Gold',60),
 (10,1002,'Silver',50),
 (11,1002,'Diamond',70),
 (12,1002,'Platinum',50),
 (13,1002,'Stones',80),
 (14,1003,'Dresses',1000),
 (15,1003,'ElectronicItems',40),
 (16,1003,'Gold',80),
 (17,1003,'Silver',87),
 (18,1003,'Diamond',45),
 (19,1003,'Platinum',56),
 (20,1004,'Stones',67),
 (21,1004,'Dresses',98),
 (22,1004,'ElectronicItems',56),
 (23,1004,'Gold',70),
 (24,1004,'Platinum',23),
 (25,1005,'Stones',45),
 (26,1005,'Dresses',500),
 (27,1005,'ElectronicItems',57),
 (28,1005,'Cellphones',34);
/*!40000 ALTER TABLE `cart_avail_product` ENABLE KEYS */;


--
-- Structure for table `cart`.`cart_billdetails`
--

DROP TABLE IF EXISTS `cart`.`cart_billdetails`;
CREATE TABLE  `cart`.`cart_billdetails` (
  `name` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `mobno` varchar(45) default NULL,
  `ccno` blob
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`.`cart_billdetails`
--

/*!40000 ALTER TABLE `cart_billdetails` DISABLE KEYS */;
INSERT INTO `cart`.`cart_billdetails` (`name`,`address`,`mobno`,`ccno`) VALUES 
 ('illayaraja','chennai','45564524',0xFC3B398F1CC6CFE4515EFB531058F46A),
 ('raju','sdfgd','32454',0xADC8A6355A2B32AC39A6CC73650E1917),
 ('zdfxd','dsfdx','547564',0xFC3B398F1CC6CFE4515EFB531058F46A),
 ('cxfgb','cvbc','245452',0x5DA8154630C9B55B3089CE19AA02DF94);
/*!40000 ALTER TABLE `cart_billdetails` ENABLE KEYS */;


--
-- Structure for table `cart`.`cart_login`
--

DROP TABLE IF EXISTS `cart`.`cart_login`;
CREATE TABLE  `cart`.`cart_login` (
  `userid` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) NOT NULL default '',
  `password` blob NOT NULL,
  `address` varchar(45) NOT NULL default '',
  `phone` varchar(45) NOT NULL default '',
  `email` varchar(45) NOT NULL default '',
  PRIMARY KEY  (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`.`cart_login`
--

/*!40000 ALTER TABLE `cart_login` DISABLE KEYS */;
INSERT INTO `cart`.`cart_login` (`userid`,`username`,`password`,`address`,`phone`,`email`) VALUES 
 (1,'amutha',0x616D75746861,'jkhjk','534354','ghfh'),
 (2,'null',0x6E756C6C,'null','null','null'),
 (3,'null',0x6E756C6C,'null','null','null'),
 (4,'null',0x6E756C6C,'null','null','null'),
 (5,'mar',0x313233343536,'chennai','12315','sdfd@sdfd.com'),
 (6,'serfs',0x3231353634,'dsdff','35235','sdfdsfd'),
 (7,'sdsf',0x7364667364,'sdfsdsdsf','5665','sdfsdfsdd'),
 (8,'sdas',0x6173647361,'ssds','56457','1234254'),
 (9,'sdwaee',0x6572746572,'rfter','4234','1234534'),
 (10,'amar',0x616D6172,'amar','12345','amar@gmail.com'),
 (11,'sdfder',0x7266,'dfadf','5456','cvfdgv'),
 (12,'vmbnmn',0x626E626D626E,'mghjg','23156454','hgjhgjgh'),
 (13,'fcgh',0x31333234,'tfhg','3565','fthfg'),
 (14,'fcgh',0x31333234,'tfhg','3565','fthfg'),
 (15,'drgf',0x3231343534,'ddg','dfgdf','dfgdf'),
 (16,'dkjhjgh',0x313233343536,'chennai','9791005951','cxzvxcvcxv'),
 (17,'dkjhjgh',0x313233343536,'chennai','9791005951','cxzvxcvcxv'),
 (18,'raja',0x313233343536,'sdfdsgfdr','97910091','sdfgdfg');
INSERT INTO `cart`.`cart_login` (`userid`,`username`,`password`,`address`,`phone`,`email`) VALUES 
 (19,'keerthana',0x333234333235363332,'srdfdsfdf','2343254532','klbvcjlvjkljn'),
 (20,'ravi',0x313233343536,'chennai','1324221413','sdjhfydfdh'),
 (21,'ravi',0x313233343536,'chennai','123456','sadfds'),
 (22,'ravi',0x313233343536,'chennai','123456','sadfds'),
 (23,'hariharan',0x313233343536,'chennai','123456','sadfs'),
 (24,'haran',0x7D20D238EBD4EF1CB55A240DEA68C30D,'chennai','123456','sadfs'),
 (25,'rahul',0x313233343536,'chennai','123456','nb,mjk'),
 (26,'ramesh',0x7D20D238EBD4EF1CB55A240DEA68C30D,'chennai','123456','sdfdsfd'),
 (27,'sugu',0x7D20D238EBD4EF1CB55A240DEA68C30D,'dxfgdgf','123123','xdfghfhfgh');
/*!40000 ALTER TABLE `cart_login` ENABLE KEYS */;


--
-- Structure for table `cart`.`cart_productdetail`
--

DROP TABLE IF EXISTS `cart`.`cart_productdetail`;
CREATE TABLE  `cart`.`cart_productdetail` (
  `shopid` int(10) unsigned default NULL,
  `proid` int(10) unsigned default NULL,
  `variety` varchar(45) default NULL,
  `quantity` varchar(45) default NULL,
  `cost` varchar(100) default NULL,
  `company` varchar(45) default NULL,
  `Availability` varchar(45) default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`.`cart_productdetail`
--

/*!40000 ALTER TABLE `cart_productdetail` DISABLE KEYS */;
INSERT INTO `cart`.`cart_productdetail` (`shopid`,`proid`,`variety`,`quantity`,`cost`,`company`,`Availability`) VALUES 
 (1001,1,'Model-1100','1','2000','Nokia','10'),
 (1001,3,'lipstics','1','200','lotus','10'),
 (1001,4,'electronic','1','300','deluxe','10'),
 (1001,5,'pan','1','300','','10'),
 (1001,6,'Fair and lovely','1','30','Fair and lovely','10'),
 (1001,7,'traveling bag','1','400','Dell','10'),
 (1001,8,'DVD','1','2000','Samsung','10'),
 (1002,9,'chain','1','10000','','10'),
 (1002,10,'spoon','1','1000','','10'),
 (1002,11,'ring','1','30000','','10'),
 (1002,12,'bangle','1','40000','','10'),
 (1002,13,'big size','1','2000','','10'),
 (1003,14,'sarees','1','300','co-optex','10'),
 (1003,15,'Air condition','1','20000','LG','10'),
 (1003,16,'stud','1','4000','','10'),
 (1003,17,'plate','1','2000','','10'),
 (1003,18,'ring','1','20000','','10'),
 (1003,19,'stone','1','40000','','10'),
 (1003,19,'stone','1','40000','','10'),
 (1003,19,'stone','1','40000','','10'),
 (1004,20,'small size','1','400','','10'),
 (1004,21,'jeans','1','500','trigger','10');
INSERT INTO `cart`.`cart_productdetail` (`shopid`,`proid`,`variety`,`quantity`,`cost`,`company`,`Availability`) VALUES 
 (1004,22,'Television','1','8000','vedeocon','10'),
 (1004,23,'bangle','1','10000','','10'),
 (1004,24,'stone','1','40000','','10'),
 (1005,25,'small size','1','400','','10'),
 (1005,26,'Kids Dresses','1','20000','','10'),
 (1005,27,'Computer','1','5000','pentium-4','10'),
 (1005,28,'model-c816','1','5000','Motorola','10'),
 (1001,2,'churidhar','1','500','','10');
/*!40000 ALTER TABLE `cart_productdetail` ENABLE KEYS */;


--
-- Structure for table `cart`.`cart_shopdetails`
--

DROP TABLE IF EXISTS `cart`.`cart_shopdetails`;
CREATE TABLE  `cart`.`cart_shopdetails` (
  `shopid` int(10) unsigned NOT NULL auto_increment,
  `shopname` varchar(45) default NULL,
  `location` varchar(45) default NULL,
  `city` varchar(45) default NULL,
  PRIMARY KEY  (`shopid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cart`.`cart_shopdetails`
--

/*!40000 ALTER TABLE `cart_shopdetails` DISABLE KEYS */;
INSERT INTO `cart`.`cart_shopdetails` (`shopid`,`shopname`,`location`,`city`) VALUES 
 (1001,'Saravana','T.Nagar','Chennai'),
 (1002,'GRT','T.Nagar','Chennai'),
 (1003,'JeyaChandran','T.Nagar','Chennai'),
 (1004,'Lifestyle','T.Nagar','Chennai'),
 (1005,'Pothys','T.Nagar','Chennai');
/*!40000 ALTER TABLE `cart_shopdetails` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
