/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.6.20-log : Database - mto_local
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mto_local` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mto_local`;

/*Table structure for table `jt_sys_pref` */

DROP TABLE IF EXISTS `jt_sys_pref`;

CREATE TABLE `jt_sys_pref` (
  `ROW_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` datetime DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `LAST_UPD_DATE` datetime DEFAULT NULL,
  `LAST_UPD_BY` varchar(255) DEFAULT NULL,
  `MODIFICATION_NUM` bigint(20) DEFAULT NULL,
  `CONFLICT_ID` varchar(255) DEFAULT NULL,
  `PAR_ROW_ID` bigint(20) DEFAULT NULL,
  `DB_LAST_UPD` datetime DEFAULT NULL,
  `DB_LAST_UPD_SRC` varchar(255) DEFAULT NULL,
  `NAME` varchar(255) DEFAULT NULL,
  `VAL` varchar(255) DEFAULT NULL,
  `COMMENTS` varchar(255) DEFAULT NULL,
  `TYPE` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROW_ID`),
  UNIQUE KEY `jt_sys_pref_u1` (`NAME`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `jt_sys_pref` */

insert  into `jt_sys_pref`(`ROW_ID`,`CREATE_DATE`,`CREATED_BY`,`LAST_UPD_DATE`,`LAST_UPD_BY`,`MODIFICATION_NUM`,`CONFLICT_ID`,`PAR_ROW_ID`,`DB_LAST_UPD`,`DB_LAST_UPD_SRC`,`NAME`,`VAL`,`COMMENTS`,`TYPE`) values (8,'2016-10-27 15:54:06','','2016-10-27 15:54:06','',1,'',NULL,'2016-10-27 15:54:06','Script','JT_SERVER_REQ_URL','http://10.5.172.150:8080/j101-mto','系统请求地址','SERVER_INIT'),(9,'2016-10-27 15:54:07','','2016-10-27 15:54:07','',1,'',NULL,'2016-10-27 15:54:07','Script','JT_FILE_PATH','D:/apache-tomcat-mto/webapps/mtofs','附件存储地址','SERVER_INIT'),(10,'2016-10-27 15:54:07','','2016-10-27 15:54:07','',1,'',NULL,'2016-10-27 15:54:07','Script','JT_FILE_URL','http://10.5.172.150:8080/mtofs','附件请求地址','SERVER_INIT'),(11,'2016-10-27 15:54:08','','2016-10-27 15:54:08','',1,'',NULL,'2016-10-27 15:54:08','Script','JT_SERVER_REQ_URL3','http://localhost:8077/johnny','系统请求地址','SERVER_INIT'),(12,'2016-10-27 15:54:08',NULL,'2016-10-27 15:54:08','',1,NULL,NULL,'2016-10-27 15:54:08','Script','C_MAIL_URL','http://itpmail.zte.com.cn/mailService/services/MailTemplateService','邮件地址',NULL);

/*Table structure for table `jt_system_group` */

DROP TABLE IF EXISTS `jt_system_group`;

CREATE TABLE `jt_system_group` (
  `ROW_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `SYS_TYPE` varchar(255) DEFAULT NULL,
  `SYS_CODE` varchar(255) DEFAULT NULL,
  `SYS_NAME` varchar(255) DEFAULT NULL,
  `CLASS_NAME` varchar(255) DEFAULT NULL,
  `DEV_MAILTO` varchar(255) DEFAULT NULL,
  `TEST_MAILTO` varchar(255) DEFAULT NULL,
  `REC_MAILTO` varchar(255) DEFAULT NULL,
  `PRO_DMAILTO` varchar(255) DEFAULT NULL,
  `URL_PARAM` varchar(255) DEFAULT NULL,
  `ORDER_BY` int(11) DEFAULT NULL,
  `ENABLE_FLAG` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

/*Data for the table `jt_system_group` */

insert  into `jt_system_group`(`ROW_ID`,`SYS_TYPE`,`SYS_CODE`,`SYS_NAME`,`CLASS_NAME`,`DEV_MAILTO`,`TEST_MAILTO`,`REC_MAILTO`,`PRO_DMAILTO`,`URL_PARAM`,`ORDER_BY`,`ENABLE_FLAG`) values (1,'Application','SmartSales','SmartSales应用','com.johnny.monitor.business.service.MonitorTomcatServer','','','','','clue/servicess.jssm',1,'Y'),(2,'Application','SiebelCRM','SiebelTomcat应用','com.johnny.monitor.business.service.MonitorTomcatServer','','','','',':8088/siebel/compsearch/servicess.jssm',2,'Y'),(3,'Application','SiebelCRM','Siebel应用','com.johnny.monitor.business.service.MonitorSiebelWeb','','','','',NULL,3,'Y'),(4,'Application','MSM','MSM应用','com.johnny.monitor.business.service.MonitorWasServer','','','','','RTC.html',4,'Y'),(5,'Application','Platform','平台应用','com.johnny.monitor.business.service.MonitorTomcatServer','','','','','token/service.jssm',5,'Y'),(6,'DataBase','SmartSales','SmartSales数据库','com.johnny.monitor.business.service.MonitorMysql','','','','',NULL,6,'Y'),(7,'DataBase','SiebelCRM','Siebel数据库','com.johnny.monitor.business.service.MonitorOracle','','','','',NULL,7,'Y'),(8,'DataBase','MSM','MSM数据库','com.johnny.monitor.business.service.MonitorOracle','','','','',NULL,8,'Y'),(9,'Group','SmartSales',NULL,NULL,'huang.fuqiang@zte.com.cn;','','','',NULL,9,'Y'),(10,'Group','SiebelCRM',NULL,NULL,'huang.fuqiang@zte.com.cn;','','','',NULL,10,'Y'),(11,'Group','MSM',NULL,NULL,'huang.fuqiang@zte.com.cn;','','','',NULL,11,'Y'),(12,'Group','Platform',NULL,NULL,'huang.fuqiang@zte.com.cn;','','','',NULL,12,'Y'),(13,'Application','SmartSales','CMS服务','com.johnny.monitor.business.service.MonitorCMSWeb','huang.fuqiang@zte.com.cn;',NULL,NULL,NULL,NULL,13,'Y'),(14,'Application','SmartSales','HR服务','com.johnny.monitor.business.service.MonitorHRWeb','huang.fuqiang@zte.com.cn;',NULL,NULL,NULL,NULL,14,'Y'),(15,'Application','SmartSales','SMS服务','com.johnny.monitor.business.service.MonitorSMSWeb','huang.fuqiang@zte.com.cn;',NULL,NULL,NULL,NULL,15,'Y');

/*Table structure for table `jt_system_info` */

DROP TABLE IF EXISTS `jt_system_info`;

CREATE TABLE `jt_system_info` (
  `ROW_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` varchar(255) DEFAULT NULL,
  `ENVIROMENT_TYPE` varchar(255) DEFAULT NULL,
  `ENVIROMENT_NAME` varchar(255) DEFAULT NULL,
  `IP_ADDR` varchar(255) DEFAULT NULL,
  `ORDERBY` int(11) DEFAULT NULL,
  `ENABLE_FLAG` varchar(255) DEFAULT NULL,
  `USERNAME` varchar(255) DEFAULT NULL,
  `PASSWORD` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8;

/*Data for the table `jt_system_info` */

insert  into `jt_system_info`(`ROW_ID`,`GROUP_ID`,`ENVIROMENT_TYPE`,`ENVIROMENT_NAME`,`IP_ADDR`,`ORDERBY`,`ENABLE_FLAG`,`USERNAME`,`PASSWORD`) values (1,'1','测试','测试环境1','10.5.7.150/MCRMDev/',1,'Y',NULL,NULL),(2,'1','仿真','仿真环境1','10.88.144.240/MCRMTest/',2,'Y',NULL,NULL),(3,'1','仿真','仿真环境2','10.3.64.175/MCRM/',3,'Y',NULL,NULL),(4,'1','生产','生产环境1','10.30.7.221/MCRM/',4,'Y',NULL,NULL),(5,'1','生产','生产环境2','10.30.7.222/MCRM/',5,'Y',NULL,NULL),(6,'1','生产','生产灰度1','10.30.15.121/HMCRM/',6,'Y',NULL,NULL),(7,'1','生产','生产线程1','10.30.15.124:8080/MCRMThread/',7,'Y',NULL,NULL),(8,'1','生产','生产域名1','mdm.zte.com.cn/MCRM/',8,'Y',NULL,NULL),(9,'1','生产','生产Nginx代理1','10.30.15.119/MCRM/',9,'Y',NULL,NULL),(10,'1','生产','生产Nginx代理2','10.30.15.120/MCRM/',10,'Y',NULL,NULL),(11,'2','测试','测试环境1','10.5.172.82',11,'Y',NULL,NULL),(12,'2','仿真','仿真环境1','10.5.6.196',12,'Y',NULL,NULL),(13,'2','仿真','仿真环境2','10.5.7.161',13,'Y',NULL,NULL),(14,'2','仿真','仿真环境3','10.3.64.180',14,'Y',NULL,NULL),(15,'2','生产','生产环境1','10.31.7.24',15,'Y',NULL,NULL),(16,'2','生产','生产环境2','10.31.7.25',16,'Y',NULL,NULL),(17,'2','生产','生产灰度1','10.30.15.122',17,'Y',NULL,NULL),(18,'2','生产','生产域名1','scrm.zte.com.cn',18,'Y',NULL,NULL),(20,'3','测试','测试环境1','10.5.172.82',20,'Y',NULL,NULL),(21,'3','仿真','仿真环境1','10.5.6.196',21,'Y',NULL,NULL),(22,'3','仿真','仿真环境1','10.5.7.161',22,'Y',NULL,NULL),(23,'3','仿真','仿真环境1','10.3.64.180',23,'Y',NULL,NULL),(24,'3','生产','生产环境1','10.31.7.24',24,'Y',NULL,NULL),(25,'3','生产','生产环境2','10.31.7.25',25,'Y',NULL,NULL),(26,'3','生产','生产灰度1','10.30.15.122',26,'Y',NULL,NULL),(27,'3','生产','生产域名1','scrm.zte.com.cn',27,'Y',NULL,NULL),(28,'4','测试','测试环境1','10.5.172.107:9095/MrktTest/',28,'Y',NULL,NULL),(29,'4','测试','测试线程1','10.5.172.107:9081/MrktTest/',29,'Y',NULL,NULL),(30,'4','仿真','仿真环境1','10.5.172.86:9085/MrktTest/',30,'Y',NULL,NULL),(31,'4','仿真','仿真线程1','10.5.172.86:9081/MrktTest/',31,'N',NULL,NULL),(32,'4','仿真','验收环境1','10.89.208.202:9080/MrktTest/',32,'Y',NULL,NULL),(33,'4','仿真','验收线程1','10.89.208.202:9081/MrktTest/',33,'Y',NULL,NULL),(34,'4','生产','生产环境1','10.30.7.47/marketing/',34,'Y',NULL,NULL),(35,'4','生产','生产环境2','10.30.7.48/marketing/',35,'Y',NULL,NULL),(36,'4','生产','生产环境3','10.30.7.49/marketing/',36,'Y',NULL,NULL),(37,'4','生产','生产线程1','10.30.7.107:9085/marketing/',37,'Y',NULL,NULL),(38,'4','生产','生产域名1','msm.zte.com.cn/marketing/',38,'Y',NULL,NULL),(39,'5','生产','生产环境1','192.168.164.242/emm/',39,'Y',NULL,NULL),(40,'7','开发','开发环境1','10.5.6.118:1521:ztedev',40,'Y','SIEBEL','SIEBEL'),(41,'7','测试','测试环境1','10.5.7.116:1521:ZTETEST',41,'Y','SIEBEL','SIEBEL'),(42,'7','仿真','仿真环境1','10.5.6.195:1521:SIEBELINT',42,'Y','SIEBEL','SIEBEL'),(43,'7','生产','生产环境1','10.31.4.58:1521:scrmprod',43,'N','SIEBEL','SIEBEL'),(44,'7','生产','生产环境2','10.31.5.58:1521:scrmprod',44,'N','SIEBEL','SIEBEL'),(45,'6','测试','测试环境1','10.5.7.149',45,'Y','mcrm','123456'),(46,'6','仿真','仿真环境1','10.88.144.239',46,'Y','mcrm','2015_mcrm'),(47,'6','生产','生产环境1',NULL,47,'N','mcrm','mcrm'),(48,'8','测试','测试环境1','10.41.252.65:1521:ltcdb',48,'Y','ecc','test_120921'),(49,'8','仿真','仿真环境1','10.41.253.16:1521:ltcdb',49,'Y','ecc','ECC_FZ_2015'),(50,'8','生产','生产环境1','10.30.1.111:1521:eccsys',50,'N','ecc','ecc'),(51,'13','测试','测试环境1','10.5.4.11:7780',51,'Y',NULL,NULL),(52,'13','生产','生产环境1','10.30.13.31:7780',52,'Y',NULL,NULL),(53,'14','测试','测试环境1','10.41.223.246:8001',53,'Y',NULL,NULL),(54,'14','生产','生产环境1','soa.zte.com.cn:8001',54,'Y',NULL,NULL),(55,'15','测试','测试环境1','10.41.223.246:8001',55,'Y',NULL,NULL),(56,'15','生产','生产环境1','soa.zte.com.cn:8001',56,'Y',NULL,NULL);

/*Table structure for table `jt_system_monitor_instance` */

DROP TABLE IF EXISTS `jt_system_monitor_instance`;

CREATE TABLE `jt_system_monitor_instance` (
  `ROW_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `GROUP_ID` bigint(20) DEFAULT NULL,
  `BATCH_NUM` varchar(255) DEFAULT NULL,
  `SYSTEM_ID` bigint(20) DEFAULT NULL,
  `RESULT` varchar(255) DEFAULT NULL,
  `RESULT_MESSAGE` longtext,
  `CREATE_DATE` datetime DEFAULT NULL,
  `LAST_UPD_DATE` datetime DEFAULT NULL,
  PRIMARY KEY (`ROW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=110531 DEFAULT CHARSET=utf8;

/*Data for the table `jt_system_monitor_instance` */

insert  into `jt_system_monitor_instance`(`ROW_ID`,`GROUP_ID`,`BATCH_NUM`,`SYSTEM_ID`,`RESULT`,`RESULT_MESSAGE`,`CREATE_DATE`,`LAST_UPD_DATE`) values (110421,1,'20161209122334678',1,'正常','','2016-12-09 12:23:35',NULL),(110422,1,'20161209122334678',2,'正常','','2016-12-09 12:23:36',NULL),(110423,1,'20161209122334678',3,'正常','','2016-12-09 12:23:36',NULL),(110424,1,'20161209122334678',4,'正常','','2016-12-09 12:23:36',NULL),(110425,1,'20161209122334678',5,'正常','','2016-12-09 12:23:36',NULL),(110426,1,'20161209122334678',6,'正常','','2016-12-09 12:23:36',NULL),(110427,1,'20161209122334678',7,'正常','','2016-12-09 12:23:36',NULL),(110428,1,'20161209122334678',8,'正常','','2016-12-09 12:23:36',NULL),(110429,1,'20161209122334678',9,'正常','','2016-12-09 12:23:36',NULL),(110430,1,'20161209122334678',10,'正常','','2016-12-09 12:23:37',NULL),(110431,2,'20161209122334678',11,'正常','','2016-12-09 12:23:37',NULL),(110432,2,'20161209122334678',12,'正常','','2016-12-09 12:23:37',NULL),(110433,2,'20161209122334678',13,'正常','','2016-12-09 12:23:37',NULL),(110434,2,'20161209122334678',14,'正常','','2016-12-09 12:23:37',NULL),(110435,2,'20161209122334678',15,'正常','','2016-12-09 12:23:37',NULL),(110436,2,'20161209122334678',16,'正常','','2016-12-09 12:23:37',NULL),(110437,2,'20161209122334678',17,'正常','','2016-12-09 12:23:37',NULL),(110438,2,'20161209122334678',18,'正常','','2016-12-09 12:23:37',NULL),(110439,3,'20161209122334678',20,'正常','','2016-12-09 12:23:38',NULL),(110440,3,'20161209122334678',21,'正常','','2016-12-09 12:23:39',NULL),(110441,3,'20161209122334678',22,'正常','','2016-12-09 12:23:39',NULL),(110442,3,'20161209122334678',23,'正常','','2016-12-09 12:23:40',NULL),(110443,3,'20161209122334678',24,'正常','','2016-12-09 12:23:40',NULL),(110444,3,'20161209122334678',25,'正常','','2016-12-09 12:23:40',NULL),(110445,3,'20161209122334678',26,'正常','','2016-12-09 12:23:40',NULL),(110446,3,'20161209122334678',27,'正常','','2016-12-09 12:23:40',NULL),(110447,4,'20161209122334678',28,'正常','','2016-12-09 12:23:42',NULL),(110448,4,'20161209122334678',29,'正常','','2016-12-09 12:23:43',NULL),(110449,4,'20161209122334678',30,'正常','','2016-12-09 12:23:43',NULL),(110450,4,'20161209122334678',31,'暂不监控','','2016-12-09 12:23:43',NULL),(110451,4,'20161209122334678',32,'错误','错误:应用无法访问！java.lang.Exception: 404 Error\r\n	at com.johnny.monitor.business.service.MonitorWasServer.execute(MonitorWasServer.java:28)\r\n	at com.johnny.monitor.common.run.SystemMonitorTask$1.call(SystemMonitorTask.java:103)\r\n	at com.johnny.monitor.common.run.SystemMonitorTask$1.call(SystemMonitorTask.java:1)\r\n	at java.util.concurrent.FutureTask.run(FutureTask.java:262)\r\n	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1145)\r\n	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:615)\r\n	at java.lang.Thread.run(Thread.java:745)\r\n\n','2016-12-09 12:23:43',NULL),(110452,4,'20161209122334678',33,'正常','','2016-12-09 12:23:44',NULL),(110453,4,'20161209122334678',34,'正常','','2016-12-09 12:23:44',NULL),(110454,4,'20161209122334678',35,'正常','','2016-12-09 12:23:44',NULL),(110455,4,'20161209122334678',36,'正常','','2016-12-09 12:23:44',NULL),(110456,4,'20161209122334678',37,'正常','','2016-12-09 12:23:44',NULL),(110457,4,'20161209122334678',38,'正常','','2016-12-09 12:23:44',NULL),(110458,5,'20161209122334678',39,'正常','','2016-12-09 12:23:44',NULL),(110459,6,'20161209122334678',45,'正常','','2016-12-09 12:23:44',NULL),(110460,6,'20161209122334678',46,'正常','','2016-12-09 12:23:45',NULL),(110461,6,'20161209122334678',47,'暂不监控','','2016-12-09 12:23:45',NULL),(110462,7,'20161209122334678',40,'正常','','2016-12-09 12:23:45',NULL),(110463,7,'20161209122334678',41,'正常','','2016-12-09 12:23:46',NULL),(110464,7,'20161209122334678',42,'正常','','2016-12-09 12:23:46',NULL),(110465,7,'20161209122334678',43,'暂不监控','','2016-12-09 12:23:46',NULL),(110466,7,'20161209122334678',44,'暂不监控','','2016-12-09 12:23:46',NULL),(110467,8,'20161209122334678',48,'正常','','2016-12-09 12:23:47',NULL),(110468,8,'20161209122334678',49,'正常','','2016-12-09 12:23:47',NULL),(110469,8,'20161209122334678',50,'暂不监控','','2016-12-09 12:23:47',NULL),(110470,13,'20161209122334678',51,'正常','','2016-12-09 12:23:47',NULL),(110471,13,'20161209122334678',52,'正常','','2016-12-09 12:23:48',NULL),(110472,14,'20161209122334678',53,'正常','','2016-12-09 12:23:49',NULL),(110473,14,'20161209122334678',54,'正常','','2016-12-09 12:23:50',NULL),(110474,15,'20161209122334678',55,'正常','','2016-12-09 12:23:51',NULL),(110475,15,'20161209122334678',56,'正常','','2016-12-09 12:23:52',NULL),(110476,1,'20161209124424609',1,'正常','','2016-12-09 12:44:25',NULL),(110477,1,'20161209124424609',2,'正常','','2016-12-09 12:44:26',NULL),(110478,1,'20161209124424609',3,'正常','','2016-12-09 12:44:26',NULL),(110479,1,'20161209124424609',4,'正常','','2016-12-09 12:44:26',NULL),(110480,1,'20161209124424609',5,'正常','','2016-12-09 12:44:26',NULL),(110481,1,'20161209124424609',6,'正常','','2016-12-09 12:44:26',NULL),(110482,1,'20161209124424609',7,'正常','','2016-12-09 12:44:27',NULL),(110483,1,'20161209124424609',8,'正常','','2016-12-09 12:44:27',NULL),(110484,1,'20161209124424609',9,'正常','','2016-12-09 12:44:27',NULL),(110485,1,'20161209124424609',10,'正常','','2016-12-09 12:44:27',NULL),(110486,2,'20161209124424609',11,'正常','','2016-12-09 12:44:27',NULL),(110487,2,'20161209124424609',12,'正常','','2016-12-09 12:44:27',NULL),(110488,2,'20161209124424609',13,'正常','','2016-12-09 12:44:27',NULL),(110489,2,'20161209124424609',14,'正常','','2016-12-09 12:44:27',NULL),(110490,2,'20161209124424609',15,'正常','','2016-12-09 12:44:28',NULL),(110491,2,'20161209124424609',16,'正常','','2016-12-09 12:44:28',NULL),(110492,2,'20161209124424609',17,'正常','','2016-12-09 12:44:28',NULL),(110493,2,'20161209124424609',18,'正常','','2016-12-09 12:44:28',NULL),(110494,3,'20161209124424609',20,'正常','','2016-12-09 12:44:28',NULL),(110495,3,'20161209124424609',21,'正常','','2016-12-09 12:44:29',NULL),(110496,3,'20161209124424609',22,'正常','','2016-12-09 12:44:30',NULL),(110497,3,'20161209124424609',23,'正常','','2016-12-09 12:44:31',NULL),(110498,3,'20161209124424609',24,'正常','','2016-12-09 12:44:31',NULL),(110499,3,'20161209124424609',25,'正常','','2016-12-09 12:44:31',NULL),(110500,3,'20161209124424609',26,'正常','','2016-12-09 12:44:31',NULL),(110501,3,'20161209124424609',27,'正常','','2016-12-09 12:44:31',NULL),(110502,4,'20161209124424609',28,'正常','','2016-12-09 12:44:31',NULL),(110503,4,'20161209124424609',29,'正常','','2016-12-09 12:44:32',NULL),(110504,4,'20161209124424609',30,'正常','','2016-12-09 12:44:32',NULL),(110505,4,'20161209124424609',31,'暂不监控','','2016-12-09 12:44:32',NULL),(110506,4,'20161209124424609',32,'正常','','2016-12-09 12:44:32',NULL),(110507,4,'20161209124424609',33,'正常','','2016-12-09 12:44:32',NULL),(110508,4,'20161209124424609',34,'正常','','2016-12-09 12:44:32',NULL),(110509,4,'20161209124424609',35,'正常','','2016-12-09 12:44:32',NULL),(110510,4,'20161209124424609',36,'正常','','2016-12-09 12:44:32',NULL),(110511,4,'20161209124424609',37,'正常','','2016-12-09 12:44:32',NULL),(110512,4,'20161209124424609',38,'正常','','2016-12-09 12:44:32',NULL),(110513,5,'20161209124424609',39,'正常','','2016-12-09 12:44:32',NULL),(110514,6,'20161209124424609',45,'正常','','2016-12-09 12:44:33',NULL),(110515,6,'20161209124424609',46,'正常','','2016-12-09 12:44:33',NULL),(110516,6,'20161209124424609',47,'暂不监控','','2016-12-09 12:44:33',NULL),(110517,7,'20161209124424609',40,'正常','','2016-12-09 12:44:34',NULL),(110518,7,'20161209124424609',41,'正常','','2016-12-09 12:44:34',NULL),(110519,7,'20161209124424609',42,'正常','','2016-12-09 12:44:34',NULL),(110520,7,'20161209124424609',43,'暂不监控','','2016-12-09 12:44:34',NULL),(110521,7,'20161209124424609',44,'暂不监控','','2016-12-09 12:44:34',NULL),(110522,8,'20161209124424609',48,'正常','','2016-12-09 12:44:35',NULL),(110523,8,'20161209124424609',49,'正常','','2016-12-09 12:44:35',NULL),(110524,8,'20161209124424609',50,'暂不监控','','2016-12-09 12:44:35',NULL),(110525,13,'20161209124424609',51,'正常','','2016-12-09 12:44:36',NULL),(110526,13,'20161209124424609',52,'正常','','2016-12-09 12:44:36',NULL),(110527,14,'20161209124424609',53,'正常','','2016-12-09 12:44:37',NULL),(110528,14,'20161209124424609',54,'正常','','2016-12-09 12:44:38',NULL),(110529,15,'20161209124424609',55,'正常','','2016-12-09 12:44:39',NULL),(110530,15,'20161209124424609',56,'正常','','2016-12-09 12:44:41',NULL);

/*Table structure for table `jt_task` */

DROP TABLE IF EXISTS `jt_task`;

CREATE TABLE `jt_task` (
  `ROW_ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CREATE_DATE` datetime DEFAULT NULL,
  `CREATED_BY` varchar(255) DEFAULT NULL,
  `LAST_UPD_DATE` datetime DEFAULT NULL,
  `LAST_UPD_BY` varchar(255) DEFAULT NULL,
  `MODIFICATION_NUM` bigint(20) DEFAULT NULL,
  `CONFLICT_ID` varchar(255) DEFAULT NULL,
  `ACTL_END_DT` datetime DEFAULT NULL,
  `ACTL_START_DT` datetime DEFAULT NULL,
  `DB_LAST_UPD` datetime DEFAULT NULL,
  `EXPIRATION_DT` datetime DEFAULT NULL,
  `SCHED_START_DT` datetime DEFAULT NULL,
  `SUBMIT_DATE` datetime DEFAULT NULL,
  `CLASS_NAME` varchar(255) DEFAULT NULL,
  `COMPLETION_CD` varchar(255) DEFAULT NULL,
  `COMPLETION_TEXT` varchar(255) DEFAULT NULL,
  `DB_LAST_UPD_SRC` varchar(255) DEFAULT NULL,
  `DESC_TEXT` varchar(255) DEFAULT NULL,
  `EXEC_SRVR_NAME` varchar(255) DEFAULT NULL,
  `METHOD` varchar(255) DEFAULT NULL,
  `TMODEL` varchar(255) DEFAULT NULL,
  `RPT_FLAG` varchar(255) DEFAULT NULL,
  `RPT_INTERVAL` varchar(255) DEFAULT NULL,
  `RPT_UOM` varchar(255) DEFAULT NULL,
  `STATUS` varchar(255) DEFAULT NULL,
  `PAR_ROW_ID` bigint(20) DEFAULT NULL,
  `DURATION` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ROW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2449 DEFAULT CHARSET=utf8;

/*Data for the table `jt_task` */

insert  into `jt_task`(`ROW_ID`,`CREATE_DATE`,`CREATED_BY`,`LAST_UPD_DATE`,`LAST_UPD_BY`,`MODIFICATION_NUM`,`CONFLICT_ID`,`ACTL_END_DT`,`ACTL_START_DT`,`DB_LAST_UPD`,`EXPIRATION_DT`,`SCHED_START_DT`,`SUBMIT_DATE`,`CLASS_NAME`,`COMPLETION_CD`,`COMPLETION_TEXT`,`DB_LAST_UPD_SRC`,`DESC_TEXT`,`EXEC_SRVR_NAME`,`METHOD`,`TMODEL`,`RPT_FLAG`,`RPT_INTERVAL`,`RPT_UOM`,`STATUS`,`PAR_ROW_ID`,`DURATION`) values (1,'2016-10-26 18:23:24',NULL,'2016-10-26 18:23:24',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-10-25 08:00:00',NULL,'testTask',NULL,'下一次：2016-10-28 12:55:00+4.98分',NULL,'测试任务------',NULL,NULL,NULL,'Y','300','S','新建',NULL,NULL),(2,'2016-10-26 18:23:30',NULL,'2016-10-26 18:23:30',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-10-25 08:00:00',NULL,'systemMonitorTask',NULL,'下一次：2016-12-09 12:44:45+19.25小时',NULL,'服务器监控定时任务------1天',NULL,'monitorDaily',NULL,'Y','86400','S','活动',NULL,NULL),(3,'2016-10-26 18:23:30',NULL,'2016-10-26 18:23:30',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-10-25 08:00:00',NULL,'systemMonitorTask',NULL,'下一次：2016-12-09 12:44:24+15.58分',NULL,'服务器监控定时任务------20分钟',NULL,'MonitorMinutely',NULL,'Y','1200','S','活动',NULL,NULL),(2447,'2016-12-09 12:23:34','JohnnyHuang 黄福强','2016-12-09 12:23:34','JohnnyHuang 黄福强',0,NULL,'2016-12-09 12:24:01','2016-12-09 12:23:35',NULL,NULL,'2016-12-09 12:23:34','2016-12-09 12:23:34','systemMonitorTask',NULL,NULL,NULL,NULL,'WIN-UBAB4A2G6F1.zte.intra_10.5.181.58_Thread-6','MonitorMinutely',NULL,NULL,NULL,NULL,'成功',3,'26.091'),(2448,'2016-12-09 12:44:24','JohnnyHuang 黄福强','2016-12-09 12:44:24','JohnnyHuang 黄福强',0,NULL,'2016-12-09 12:44:45','2016-12-09 12:44:25',NULL,NULL,'2016-12-09 12:44:24','2016-12-09 12:44:24','systemMonitorTask',NULL,NULL,NULL,NULL,'WIN-UBAB4A2G6F1.zte.intra_10.5.181.58_Thread-5','monitorDaily',NULL,NULL,NULL,NULL,'成功',2,'20.898');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
