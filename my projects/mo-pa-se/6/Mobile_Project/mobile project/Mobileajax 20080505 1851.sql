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
-- Create schema mobileajax
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ mobileajax;
USE mobileajax;

--
-- Structure for table `mobileajax`.`accdetail`
--

DROP TABLE IF EXISTS `mobileajax`.`accdetail`;
CREATE TABLE  `mobileajax`.`accdetail` (
  `accno` int(10) unsigned NOT NULL,
  `id` int(10) unsigned default NULL,
  `intdeposit` int(10) unsigned default NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mobileajax`.`accdetail`
--

/*!40000 ALTER TABLE `accdetail` DISABLE KEYS */;
INSERT INTO `mobileajax`.`accdetail` (`accno`,`id`,`intdeposit`) VALUES 
 (1111111101,1,2000),
 (2,2,1000),
 (1111111102,3,1100),
 (1111111103,4,1000),
 (1111111104,5,7000),
 (1111111105,6,1000),
 (1111111106,7,1800),
 (1111111107,8,1200),
 (1111111108,9,1822),
 (1111111109,10,1000),
 (1111111110,11,532522),
 (1111111111,12,5345),
 (1111111112,13,1000),
 (1111111113,14,1000),
 (1111111114,15,10000),
 (1111111115,16,123124),
 (1111111116,17,3545),
 (1111111117,18,1000),
 (1111111118,19,800),
 (1111111120,20,9000),
 (1111111120,20,9000),
 (1111111121,22,900),
 (1111111114,15,2000),
 (1111111123,24,1600),
 (1111111124,25,2000),
 (1111111125,26,2000),
 (1111111126,27,2000),
 (1111111127,28,2000),
 (1111111128,29,2000);
/*!40000 ALTER TABLE `accdetail` ENABLE KEYS */;


--
-- Structure for table `mobileajax`.`credit`
--

DROP TABLE IF EXISTS `mobileajax`.`credit`;
CREATE TABLE  `mobileajax`.`credit` (
  `cid` int(10) unsigned NOT NULL auto_increment,
  `id` int(10) unsigned default NULL,
  `accno` int(10) unsigned default NULL,
  `credit` int(10) unsigned default NULL,
  `cdate` date default NULL,
  PRIMARY KEY  (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mobileajax`.`credit`
--

/*!40000 ALTER TABLE `credit` DISABLE KEYS */;
INSERT INTO `mobileajax`.`credit` (`cid`,`id`,`accno`,`credit`,`cdate`) VALUES 
 (1,3,1111111101,500,'2008-03-13'),
 (2,1,1111111102,500,'2008-03-14'),
 (3,1,1111111102,1000,'2008-03-14'),
 (4,1,1111111102,1000,'2008-03-14'),
 (5,1,1111111102,1000,'2008-03-14'),
 (6,1,1111111102,1000,'2008-03-14'),
 (7,1,1111111102,1000,'2008-03-14'),
 (8,1,1111111102,1000,'2008-03-14'),
 (9,1,1111111102,1000,'2008-03-14'),
 (10,1,1111111102,1000,'2008-03-14'),
 (11,3,1111111101,1000,'2008-03-14'),
 (12,4,1111111104,1000,'2008-03-14'),
 (13,3,1111111103,1000,'2008-03-14'),
 (14,0,1111111101,1000,'2008-03-15'),
 (15,0,1111111101,1000,'2008-03-15'),
 (16,3,1111111103,500,'2008-03-15'),
 (17,3,1111111103,500,'2008-03-15'),
 (18,3,1111111103,1000,'2008-03-15'),
 (19,3,1111111101,100,'2008-03-25'),
 (20,3,1111111101,100,'2008-03-25'),
 (21,3,1111111101,100,'2008-03-25'),
 (22,3,1111111101,100,'2008-03-25'),
 (23,1,1111111102,200,'2008-03-25'),
 (24,3,1111111101,100,'2008-03-25'),
 (25,3,1111111101,100,'2008-03-25'),
 (26,7,1111111107,200,'2008-03-25');
INSERT INTO `mobileajax`.`credit` (`cid`,`id`,`accno`,`credit`,`cdate`) VALUES 
 (27,19,1111111102,200,'2008-03-26'),
 (28,19,1111111102,200,'2008-03-26'),
 (29,9,1111111102,500,'2008-03-29'),
 (30,20,1111111102,1000,'2008-03-31'),
 (31,3,1111111101,500,'2008-04-04'),
 (32,1,1111111102,500,'2008-04-04'),
 (33,3,1111111102,100,'2008-04-05'),
 (34,1,1111111102,200,'2008-04-05'),
 (35,1,1111111102,200,'2008-04-05'),
 (36,1,1111111102,200,'2008-04-05'),
 (37,1,1111111102,100,'2008-04-05'),
 (38,1,1111111102,100,'2008-04-05'),
 (39,1,1111111102,100,'2008-04-05'),
 (40,1,1111111102,100,'2008-04-05'),
 (41,1,1111111102,100,'2008-04-05'),
 (42,3,1111111101,100,'2008-04-05'),
 (43,3,1111111101,100,'2008-04-05'),
 (44,22,1111111101,100,'2008-04-05'),
 (45,3,1111111101,100,'2008-04-05'),
 (46,3,1111111101,100,'2008-04-05'),
 (47,3,1111111101,100,'2008-04-05'),
 (48,24,1111111102,200,'2008-04-08'),
 (49,24,1111111102,200,'2008-04-08'),
 (50,1,1111111103,100,'2008-04-12'),
 (51,3,1111111101,100,'2008-04-19'),
 (52,3,1111111101,100,'2008-04-19');
INSERT INTO `mobileajax`.`credit` (`cid`,`id`,`accno`,`credit`,`cdate`) VALUES 
 (53,3,1111111101,200,'2008-04-19'),
 (54,3,1111111101,100,'2008-04-19'),
 (55,3,1111111101,100,'2008-04-19'),
 (56,3,1111111103,100,'2008-05-05'),
 (57,3,1111111103,100,'2008-05-05'),
 (58,3,1111111103,100,'2008-05-05'),
 (59,3,1111111103,100,'2008-05-05');
/*!40000 ALTER TABLE `credit` ENABLE KEYS */;


--
-- Structure for table `mobileajax`.`debit`
--

DROP TABLE IF EXISTS `mobileajax`.`debit`;
CREATE TABLE  `mobileajax`.`debit` (
  `did` int(10) unsigned NOT NULL auto_increment,
  `id` int(10) unsigned default NULL,
  `accno` int(10) unsigned default NULL,
  `debit` int(10) unsigned default NULL,
  `ddate` date default NULL,
  PRIMARY KEY  (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mobileajax`.`debit`
--

/*!40000 ALTER TABLE `debit` DISABLE KEYS */;
INSERT INTO `mobileajax`.`debit` (`did`,`id`,`accno`,`debit`,`ddate`) VALUES 
 (1,3,1111111102,500,'2008-03-13'),
 (2,3,1111111101,500,'2008-03-14'),
 (3,3,1111111101,1000,'2008-03-14'),
 (4,3,1111111101,1000,'2008-03-14'),
 (5,3,1111111101,1000,'2008-03-14'),
 (6,3,1111111101,1000,'2008-03-14'),
 (7,3,1111111101,1000,'2008-03-14'),
 (8,3,1111111101,1000,'2008-03-14'),
 (9,3,1111111101,1000,'2008-03-14'),
 (10,3,1111111101,1000,'2008-03-14'),
 (11,1,1111111102,1000,'2008-03-14'),
 (12,5,1111111103,1000,'2008-03-14'),
 (13,4,1111111102,1000,'2008-03-14'),
 (14,1,111111102,1000,'2008-03-15'),
 (15,1,111111102,1000,'2008-03-15'),
 (16,4,1111111102,500,'2008-03-15'),
 (17,4,1111111102,500,'2008-03-15'),
 (18,4,1111111102,1000,'2008-03-15'),
 (19,1,1111111102,100,'2008-03-25'),
 (20,1,1111111102,100,'2008-03-25'),
 (21,1,1111111102,100,'2008-03-25'),
 (22,1,1111111102,100,'2008-03-25'),
 (23,3,1111111101,200,'2008-03-25'),
 (24,1,1111111102,100,'2008-03-25'),
 (25,1,1111111102,100,'2008-03-25'),
 (26,8,1111111106,200,'2008-03-25');
INSERT INTO `mobileajax`.`debit` (`did`,`id`,`accno`,`debit`,`ddate`) VALUES 
 (27,3,1111111118,200,'2008-03-26'),
 (28,3,1111111118,200,'2008-03-26'),
 (29,3,1111111108,500,'2008-03-29'),
 (30,3,1111111120,1000,'2008-03-31'),
 (31,1,1111111102,500,'2008-04-04'),
 (32,3,1111111101,500,'2008-04-04'),
 (33,3,1111111102,100,'2008-04-05'),
 (34,3,1111111101,200,'2008-04-05'),
 (35,3,1111111101,200,'2008-04-05'),
 (36,3,1111111101,200,'2008-04-05'),
 (37,3,1111111101,100,'2008-04-05'),
 (38,3,1111111101,100,'2008-04-05'),
 (39,3,1111111101,100,'2008-04-05'),
 (40,3,1111111101,100,'2008-04-05'),
 (41,3,1111111101,100,'2008-04-05'),
 (42,1,1111111102,100,'2008-04-05'),
 (43,1,1111111102,100,'2008-04-05'),
 (44,1,1111111121,100,'2008-04-05'),
 (45,1,1111111102,100,'2008-04-05'),
 (46,1,1111111102,100,'2008-04-05'),
 (47,1,1111111102,100,'2008-04-05'),
 (48,3,1111111123,200,'2008-04-08'),
 (49,3,1111111123,200,'2008-04-08'),
 (50,4,1111111101,100,'2008-04-12'),
 (51,1,1111111102,100,'2008-04-19'),
 (52,1,1111111102,100,'2008-04-19');
INSERT INTO `mobileajax`.`debit` (`did`,`id`,`accno`,`debit`,`ddate`) VALUES 
 (53,1,1111111102,200,'2008-04-19'),
 (54,1,1111111102,100,'2008-04-19'),
 (55,1,1111111102,100,'2008-04-19'),
 (56,4,1111111102,100,'2008-05-05'),
 (57,4,1111111102,100,'2008-05-05'),
 (58,4,1111111102,100,'2008-05-05'),
 (59,4,1111111102,100,'2008-05-05');
/*!40000 ALTER TABLE `debit` ENABLE KEYS */;


--
-- Structure for table `mobileajax`.`deposit`
--

DROP TABLE IF EXISTS `mobileajax`.`deposit`;
CREATE TABLE  `mobileajax`.`deposit` (
  `did` int(10) unsigned NOT NULL auto_increment,
  `id` int(10) unsigned NOT NULL default '0',
  `accno` int(10) unsigned NOT NULL default '0',
  `deposit` int(10) unsigned NOT NULL default '0',
  `depositdate` date NOT NULL default '0000-00-00',
  PRIMARY KEY  (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mobileajax`.`deposit`
--

/*!40000 ALTER TABLE `deposit` DISABLE KEYS */;
INSERT INTO `mobileajax`.`deposit` (`did`,`id`,`accno`,`deposit`,`depositdate`) VALUES 
 (1,1,1111111101,1000,'2008-03-13'),
 (2,2,2,1000,'2008-03-13'),
 (3,3,1111111102,1000,'2008-03-13'),
 (4,1,1111111101,500,'2008-03-13'),
 (5,3,1111111102,500,'2008-03-13'),
 (6,3,1111111102,500,'2008-03-13'),
 (7,1,1111111101,500,'2008-03-14'),
 (8,1,1111111101,500,'2008-03-14'),
 (9,1,1111111101,1000,'2008-03-14'),
 (10,1,1111111101,1000,'2008-03-14'),
 (11,1,1111111101,1000,'2008-03-14'),
 (12,1,1111111101,1000,'2008-03-14'),
 (13,1,1111111101,1000,'2008-03-14'),
 (14,1,1111111101,1000,'2008-03-14'),
 (15,1,1111111101,1000,'2008-03-14'),
 (16,1,1111111101,1000,'2008-03-14'),
 (17,3,1111111102,1000,'2008-03-14'),
 (18,4,1111111103,6000,'2008-03-14'),
 (19,5,1111111104,8000,'2008-03-14'),
 (20,4,1111111103,1000,'2008-03-14'),
 (21,6,1111111105,1000,'2008-03-14'),
 (22,3,1111111102,1000,'2008-03-14'),
 (23,7,1111111106,2000,'2008-03-14'),
 (24,8,1111111107,1000,'2008-03-15'),
 (25,9,1111111108,2322,'2008-03-15'),
 (26,0,111111102,1000,'2008-03-15');
INSERT INTO `mobileajax`.`deposit` (`did`,`id`,`accno`,`deposit`,`depositdate`) VALUES 
 (27,0,111111102,1000,'2008-03-15'),
 (28,3,1111111102,500,'2008-03-15'),
 (29,3,1111111102,500,'2008-03-15'),
 (30,3,1111111102,1000,'2008-03-15'),
 (31,3,1111111102,100,'2008-03-25'),
 (32,3,1111111102,100,'2008-03-25'),
 (33,3,1111111102,100,'2008-03-25'),
 (34,3,1111111102,100,'2008-03-25'),
 (35,1,1111111101,200,'2008-03-25'),
 (36,3,1111111102,100,'2008-03-25'),
 (37,3,1111111102,100,'2008-03-25'),
 (38,7,1111111106,200,'2008-03-25'),
 (39,10,1111111109,1000,'2008-03-25'),
 (40,11,1111111110,532522,'2008-03-25'),
 (41,12,1111111111,5345,'2008-03-25'),
 (42,13,1111111112,1000,'2008-03-25'),
 (43,14,1111111113,1000,'2008-03-25'),
 (44,15,1111111114,10000,'2008-03-25'),
 (45,16,1111111115,123124,'2008-03-25'),
 (46,17,1111111116,3545,'2008-03-25'),
 (47,18,1111111117,1000,'2008-03-25'),
 (48,19,1111111118,1000,'2008-03-26'),
 (49,19,1111111118,200,'2008-03-26'),
 (50,19,1111111118,200,'2008-03-26'),
 (51,9,1111111108,500,'2008-03-29');
INSERT INTO `mobileajax`.`deposit` (`did`,`id`,`accno`,`deposit`,`depositdate`) VALUES 
 (52,20,1111111119,10000,'2008-03-31'),
 (53,20,1111111119,10000,'2008-03-31'),
 (54,20,1111111120,1000,'2008-03-31'),
 (55,3,1111111102,500,'2008-04-04'),
 (56,1,1111111101,500,'2008-04-04'),
 (57,3,1111111102,100,'2008-04-05'),
 (58,1,1111111101,200,'2008-04-05'),
 (59,1,1111111101,200,'2008-04-05'),
 (60,1,1111111101,200,'2008-04-05'),
 (61,1,1111111101,100,'2008-04-05'),
 (62,1,1111111101,100,'2008-04-05'),
 (63,1,1111111101,100,'2008-04-05'),
 (64,1,1111111101,100,'2008-04-05'),
 (65,1,1111111101,100,'2008-04-05'),
 (66,3,1111111102,100,'2008-04-05'),
 (67,3,1111111102,100,'2008-04-05'),
 (68,22,1111111121,1000,'2008-04-05'),
 (69,22,1111111121,100,'2008-04-05'),
 (70,3,1111111102,100,'2008-04-05'),
 (71,3,1111111102,100,'2008-04-05'),
 (72,3,1111111102,100,'2008-04-05'),
 (73,15,1111111114,2000,'2008-04-08'),
 (74,24,1111111123,2000,'2008-04-08'),
 (75,24,1111111123,200,'2008-04-08'),
 (76,25,1111111124,2000,'2008-04-08'),
 (77,24,1111111123,200,'2008-04-08');
INSERT INTO `mobileajax`.`deposit` (`did`,`id`,`accno`,`deposit`,`depositdate`) VALUES 
 (78,1,1111111101,100,'2008-04-12'),
 (79,26,1111111125,2000,'2008-04-12'),
 (80,27,1111111126,2000,'2008-04-12'),
 (81,28,1111111127,2000,'2008-04-12'),
 (82,29,1111111128,2000,'2008-04-12'),
 (83,3,1111111102,100,'2008-04-19'),
 (84,3,1111111102,100,'2008-04-19'),
 (85,3,1111111102,200,'2008-04-19'),
 (86,3,1111111102,100,'2008-04-19'),
 (87,3,1111111102,100,'2008-04-19'),
 (88,3,1111111102,100,'2008-05-05'),
 (89,3,1111111102,100,'2008-05-05'),
 (90,3,1111111102,100,'2008-05-05'),
 (91,3,1111111102,100,'2008-05-05');
/*!40000 ALTER TABLE `deposit` ENABLE KEYS */;


--
-- Structure for table `mobileajax`.`login`
--

DROP TABLE IF EXISTS `mobileajax`.`login`;
CREATE TABLE  `mobileajax`.`login` (
  `id` int(10) unsigned NOT NULL auto_increment,
  `username` varchar(45) default NULL,
  `password` varchar(45) default NULL,
  `regdate` date default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mobileajax`.`login`
--

/*!40000 ALTER TABLE `login` DISABLE KEYS */;
INSERT INTO `mobileajax`.`login` (`id`,`username`,`password`,`regdate`) VALUES 
 (1,'vasanth','123','2008-03-13'),
 (2,'amutha','123456','2008-03-13'),
 (3,'sriram','1234562','2008-03-13'),
 (4,'suganya','123456','2008-03-14'),
 (5,'arul','123456','2008-03-14'),
 (6,'udhai','123456','2008-03-14'),
 (7,'raga','123456','2008-03-14'),
 (8,'merlin','123456','2008-03-15'),
 (9,'dxfsd','12312','2008-03-15'),
 (10,'laxman','123456','2008-03-25'),
 (11,'hai','dfsd','2008-03-25'),
 (12,'ertret','123456','2008-03-25'),
 (13,'raja','123456','2008-03-25'),
 (14,'raj','123456','2008-03-25'),
 (15,'hari','123456','2008-03-25'),
 (16,'ravi','123456','2008-03-25'),
 (17,'haja','1234565','2008-03-25'),
 (18,'muthu','123456','2008-03-25'),
 (19,'Ragavendar','123456','2008-03-26'),
 (20,'damo','123456','2008-03-31'),
 (21,'damo','123456','2008-03-31'),
 (22,'rahul','123456','2008-04-05'),
 (23,'hari','123456','2008-04-08'),
 (24,'sugu','123456','2008-04-08'),
 (25,'devi','123456','2008-04-08'),
 (26,'ari','123456','2008-04-12'),
 (27,'haja','123456','2008-04-12');
INSERT INTO `mobileajax`.`login` (`id`,`username`,`password`,`regdate`) VALUES 
 (28,'kk','123456','2008-04-12'),
 (29,'mani','123456','2008-04-12');
/*!40000 ALTER TABLE `login` ENABLE KEYS */;


--
-- Structure for table `mobileajax`.`registration`
--

DROP TABLE IF EXISTS `mobileajax`.`registration`;
CREATE TABLE  `mobileajax`.`registration` (
  `id` int(11) NOT NULL default '0',
  `accno` int(10) unsigned NOT NULL auto_increment,
  `name` varchar(45) default NULL,
  `fname` varchar(45) default NULL,
  `age` int(10) unsigned default NULL,
  `dob` date default NULL,
  `sex` varchar(45) default NULL,
  `education` varchar(45) default NULL,
  `occupation` varchar(45) default NULL,
  `aincome` varchar(45) default NULL,
  `address` varchar(45) default NULL,
  `city` varchar(45) default NULL,
  `phoneno` varchar(45) default NULL,
  `email` varchar(45) default NULL,
  PRIMARY KEY  (`accno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `mobileajax`.`registration`
--

/*!40000 ALTER TABLE `registration` DISABLE KEYS */;
INSERT INTO `mobileajax`.`registration` (`id`,`accno`,`name`,`fname`,`age`,`dob`,`sex`,`education`,`occupation`,`aincome`,`address`,`city`,`phoneno`,`email`) VALUES 
 (2,2,'amutha','Murugesh',25,'1983-08-03','m','MCA','Programmer','10000000','chennai','chennai','null','amutha@gmail.com'),
 (1,1111111101,'vasanth','somasundaram',24,'1983-08-28','m','MCA','programmer','100000','chennai','chennai','null','vas@gmail.com'),
 (3,1111111102,'sriram','s',24,'1984-03-12','m','Mca','Programmer','10000000','chennai','chennai','null','sri@gmail.com'),
 (4,1111111103,'suganya','a',24,'1983-03-12','f','MCA','programmer','100000','chennai','chennai','null','sugan@gmail.com'),
 (5,1111111104,'Arul','a',23,'1985-03-21','m','BE','Student','100000','chennai','chennai','null','arul@gmail.com'),
 (6,1111111105,'udhai','gnanam',21,'1987-10-16','M','BE','student','10000','chennai','chebbai','null','sdfd@sdghf.com'),
 (7,1111111106,'raga','sefd',21,'1987-02-12','m','be','student','1000000','chennai','chennai','null','sdf@sdfjhd.com'),
 (8,1111111107,'merlin','sdf',24,'1987-11-12','f','MCA','chennai','100000','chennai','chennai','null','dfsd@sdgf.com');
INSERT INTO `mobileajax`.`registration` (`id`,`accno`,`name`,`fname`,`age`,`dob`,`sex`,`education`,`occupation`,`aincome`,`address`,`city`,`phoneno`,`email`) VALUES 
 (9,1111111108,'sdfsd','sdfsd',231,'1451-12-12','m','zxdf','xcfc','2331','zxcfvxc','xcvcx','null','xcv'),
 (10,1111111109,'lax','d',21,'1998-12-12','m','be','student','10000','jhgfyhty','chennai','null','hgfhgf'),
 (11,1111111110,'dsfd','sdf',25,'2000-02-10','m','ddfg','srdf','32454','dsrg','dfgdf','null','drfgw34twe'),
 (12,1111111111,'ertre','dfgfdsfg',112,'1212-12-21','erg','werw','werw','32456','wrwe4rt','res','null','ewrte'),
 (13,1111111112,'illaya','raja',12,'1990-12-12','m','MCA','chennai','121212121','chennai','chennai','null','sefed'),
 (14,1111111113,'raj','raj',21,'1998-12-12','male','mca','dfsdf','1232','skjdklf','rfds','null','erfesrf'),
 (15,1111111114,'hari','p',12,'1998-12-12','m','BE','student','122222','chennai','chennai','null','sdgfhdsf'),
 (16,1111111115,'sdfd','dsfds',21,'2005-12-12','m','sfd','dsf','4454','sfdsfds','sdfds','null','sdfsfd'),
 (17,1111111116,'dsfs','sdfdsa',12,'1212-12-12','cv','asdfas','sdsa','41454','dfsd','dsfsdfs','null','ddsfas');
INSERT INTO `mobileajax`.`registration` (`id`,`accno`,`name`,`fname`,`age`,`dob`,`sex`,`education`,`occupation`,`aincome`,`address`,`city`,`phoneno`,`email`) VALUES 
 (18,1111111117,'muthu','sf',12,'1989-12-12','m','mca','sdf','1324534','sdfs','adfs','null','sdfsd'),
 (19,1111111118,'Ragavendar','M',12,'1987-12-12','dsgf','dffds','dfdx','dsfds','dfgdsf','dxfg','null','dfgdfg'),
 (20,1111111119,'damo','Ramadoss',23,'1984-09-05','male','MCA','Student','10000','chennai','chennai','null','damo@gmail.com'),
 (20,1111111120,'damo','Ramadoss',23,'1984-09-05','male','MCA','Student','10000','chennai','chennai','null','damo@gmail.com'),
 (22,1111111121,'Rahul','ravi',23,'1984-01-12','Male','MCA','Programmer','100000','westst,Tnagar','chennai','null','rahuul@gmail.com'),
 (15,1111111122,'hari','p',21,'1984-12-12','male','BE','student','10000','chennai','chennai','null','sdfsdgfds'),
 (24,1111111123,'suganya','a',23,'1984-06-05','f','MCA','programmer','72000','chennai','chennai','null','sdfgsd'),
 (25,1111111124,'Devika','k',23,'1984-10-18','f','MCA','prg','10000','Namakkal','Namakkal','null','sdfsdg');
INSERT INTO `mobileajax`.`registration` (`id`,`accno`,`name`,`fname`,`age`,`dob`,`sex`,`education`,`occupation`,`aincome`,`address`,`city`,`phoneno`,`email`) VALUES 
 (26,1111111125,'hari','dsfsd',21,'1985-12-12','male','dsfd','sdfdfsd','2121','sdfjhsdg','sdfd','null','sddfsdfsd'),
 (27,1111111126,'dfsdf','sdf',12,'1252-12-12','sdf','ssd','sdfd','234534','sdfs','sdfd','null','sdfsd'),
 (28,1111111127,'asda','sefs',21,'1981-12-12','asdf','sdas','asedas','12121','dszd','sda','null','asdasda'),
 (29,1111111128,'mani','sadf',12,'1982-12-12','sddf','sdfd','sdfd','12121','sdfsd','fsdsd','null','gfehgr');
/*!40000 ALTER TABLE `registration` ENABLE KEYS */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
