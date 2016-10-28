/*
SQLyog Ultimate v10.00 Beta1
MySQL - 5.1.62-community : Database - mto
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`mto` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `mto`;

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
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8;

/*Data for the table `jt_sys_pref` */

insert  into `jt_sys_pref`(`ROW_ID`,`CREATE_DATE`,`CREATED_BY`,`LAST_UPD_DATE`,`LAST_UPD_BY`,`MODIFICATION_NUM`,`CONFLICT_ID`,`PAR_ROW_ID`,`DB_LAST_UPD`,`DB_LAST_UPD_SRC`,`NAME`,`VAL`,`COMMENTS`,`TYPE`) values (8,'2016-10-27 15:54:06','','2016-10-27 15:54:06','',1,'',NULL,'2016-10-27 15:54:06','Script','JT_SERVER_REQ_URL2','http://10.5.6.119:8080/j101-mto','系统请求地址','SERVER_INIT'),(9,'2016-10-27 15:54:07','','2016-10-27 15:54:07','',1,'',NULL,'2016-10-27 15:54:07','Script','JT_FILE_PATH','D:/apache-tomcat-mto/webapps/mtofs','附件存储地址','SERVER_INIT'),(10,'2016-10-27 15:54:07','','2016-10-27 15:54:07','',1,'',NULL,'2016-10-27 15:54:07','Script','JT_FILE_URL','http://localhost:8096/mtofs','附件请求地址','SERVER_INIT'),(11,'2016-10-27 15:54:08','','2016-10-27 15:54:08','',1,'',NULL,'2016-10-27 15:54:08','Script','JT_SERVER_REQ_URL','http://localhost:8077/johnny','系统请求地址','SERVER_INIT');

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
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `jt_system_group` */

insert  into `jt_system_group`(`ROW_ID`,`SYS_TYPE`,`SYS_CODE`,`SYS_NAME`,`CLASS_NAME`,`DEV_MAILTO`,`TEST_MAILTO`,`REC_MAILTO`,`PRO_DMAILTO`,`URL_PARAM`,`ORDER_BY`,`ENABLE_FLAG`) values (1,'Application','SmartSales','SmartSales','com.johnny.monitor.business.service.MonitorTomcatServer','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','clue/servicess.jssm',1,'Y'),(2,'Application','SiebelCRM','SiebelTomcat','com.johnny.monitor.business.service.MonitorTomcatServer','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn',':8088/siebel/compsearch/servicess.jssm',2,'Y'),(3,'Application','SiebelCRM','SiebelApp','com.johnny.monitor.business.service.MonitorSiebelWeb','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn',NULL,3,'Y'),(4,'Application','MSM','MSM','com.johnny.monitor.business.service.MonitorWasServer','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','RTC.html',4,'Y'),(5,'Application','Platform','平台','com.johnny.monitor.business.service.MonitorTomcatServer','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','token/service.jssm',5,'Y'),(6,'DataBase','SmartSales','SmartSales数据库','com.johnny.monitor.business.service.MonitorMysql','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn',NULL,6,'Y'),(7,'DataBase','SiebelCRM','Siebel数据库','com.johnny.monitor.business.service.MonitorOracle','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn',NULL,7,'Y'),(8,'DataBase','MSM','MSM数据库','com.johnny.monitor.business.service.MonitorOracle','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn','huang.fuqiang1@zte.com.cn',NULL,8,'Y');

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
) ENGINE=InnoDB AUTO_INCREMENT=51 DEFAULT CHARSET=utf8;

/*Data for the table `jt_system_info` */

insert  into `jt_system_info`(`ROW_ID`,`GROUP_ID`,`ENVIROMENT_TYPE`,`ENVIROMENT_NAME`,`IP_ADDR`,`ORDERBY`,`ENABLE_FLAG`,`USERNAME`,`PASSWORD`) values (1,'1','TEST','测试环境App1','10.5.7.150/MCRMDev/',1,'Y',NULL,NULL),(2,'1','REC','仿真环境App1','10.88.144.240/MCRMTest/',2,'Y',NULL,NULL),(3,'1','REC','仿真环境App2','10.3.64.175/MCRM/',3,'Y',NULL,NULL),(4,'1','PROD','生产环境App1','10.30.7.221/MCRM/',4,'Y',NULL,NULL),(5,'1','PROD','生产环境App2','10.30.7.222/MCRM/',5,'Y',NULL,NULL),(6,'1','PROD_GRAY','生产灰度环境','10.30.15.121/HMCRM/',6,'Y',NULL,NULL),(7,'1','PROD','生产线程环境','10.30.15.124:8080/MCRMThread/',7,'Y',NULL,NULL),(8,'1','PROD','生产域名','mdm.zte.com.cn/MCRM/',8,'Y',NULL,NULL),(9,'1','PROD','生产Nginx代理1','10.30.15.119/MCRM/',9,'Y',NULL,NULL),(10,'1','PROD','生产Nginx代理2','10.30.15.120/MCRM/',10,'Y',NULL,NULL),(11,'2','TEST','测试环境','10.5.172.82',11,'Y',NULL,NULL),(12,'2','REC','仿真PC端环境','10.5.6.196',12,'Y',NULL,NULL),(13,'2','REC','仿真移动端环境','10.5.7.161',13,'Y',NULL,NULL),(14,'2','REC','仿真灰度环境','10.3.64.180',14,'Y',NULL,NULL),(15,'2','PROD','生产环境App1','10.31.7.24',15,'Y',NULL,NULL),(16,'2','PROD','生产环境App2','10.31.7.25',16,'Y',NULL,NULL),(17,'2','PROD_GRAY','生产灰度环境','10.30.15.122',17,'Y',NULL,NULL),(18,'2','PROD','生产域名','scrm.zte.com.cn',18,'Y',NULL,NULL),(20,'3','TEST','测试环境','10.5.172.82',20,'Y',NULL,NULL),(21,'3','REC','仿真PC端环境','10.5.6.196',21,'Y',NULL,NULL),(22,'3','REC','仿真移动端环境','10.5.7.161',22,'Y',NULL,NULL),(23,'3','REC','仿真灰度环境','10.3.64.180',23,'Y',NULL,NULL),(24,'3','PROD','生产环境App1','10.31.7.24',24,'Y',NULL,NULL),(25,'3','PROD','生产环境App2','10.31.7.25',25,'Y',NULL,NULL),(26,'3','PROD_GRAY','生产灰度环境','10.30.15.122',26,'Y',NULL,NULL),(27,'3','PROD','生产域名','scrm.zte.com.cn',27,'Y',NULL,NULL),(28,'4','TEST','测试环境','10.5.172.107:9095/MrktTest/',28,'Y',NULL,NULL),(29,'4','TEST','测试线程环境','10.5.172.107:9081/MrktTest/',29,'Y',NULL,NULL),(30,'4','REC','仿真环境','10.5.172.86:9085/MrktTest/',30,'Y',NULL,NULL),(31,'4','REC','仿真线程环境','10.5.172.86:9081/MrktTest/',31,'N',NULL,NULL),(32,'4','REC','验收环境','10.89.208.202:9080/MrktTest/',32,'Y',NULL,NULL),(33,'4','REC','验收线程环境','10.89.208.202:9081/MrktTest/',33,'Y',NULL,NULL),(34,'4','PROD','生产环境App1','10.30.7.47/marketing/',34,'Y',NULL,NULL),(35,'4','PROD','生产环境App2','10.30.7.48/marketing/',35,'Y',NULL,NULL),(36,'4','PROD','生产环境App3','10.30.7.49/marketing/',36,'Y',NULL,NULL),(37,'4','PROD','生产线程环境','10.30.7.107:9085/marketing/',37,'Y',NULL,NULL),(38,'4','PROD','生产域名','msm.zte.com.cn/marketing/',38,'Y',NULL,NULL),(39,'5','PROD','生产环境','192.168.164.242/emm/',39,'Y',NULL,NULL),(40,'7','DEV','开发环境','10.5.6.118:1521:ztedev',40,'Y','SIEBEL','SIEBEL'),(41,'7','TEST','测试环境','10.5.7.116:1521:ZTETEST',41,'Y','SIEBEL','SIEBEL'),(42,'7','REC','仿真环境','10.5.6.195:1521:SIEBELINT',42,'Y','SIEBEL','SIEBEL'),(43,'7','PROD','生产环境RAC1','10.31.4.58:1521:scrmprod',43,'N','SIEBEL','SIEBEL'),(44,'7','PROD','生产环境RAC2','10.31.5.58:1521:scrmprod',44,'N','SIEBEL','SIEBEL'),(45,'6','TEST','测试环境','10.5.7.149',45,'Y','mcrm','123456'),(46,'6','REC','仿真环境','10.88.144.239',46,'Y','mcrm','2015_mcrm'),(47,'6','PRDO','生产环境',NULL,47,'N','mcrm','mcrm'),(48,'8','TEST','测试环境','10.41.252.65:1521:ltcdb',48,'Y','ecc','test_120921'),(49,'8','REC','仿真环境','10.41.253.16:1521:ltcdb',49,'Y','ecc','ECC_FZ_2015'),(50,'8','PRDO','生产环境','10.30.1.111:1521:eccsys',50,'N','ecc','ecc');

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
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `jt_system_monitor_instance` */

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
  PRIMARY KEY (`ROW_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=63 DEFAULT CHARSET=utf8;

/*Data for the table `jt_task` */

insert  into `jt_task`(`ROW_ID`,`CREATE_DATE`,`CREATED_BY`,`LAST_UPD_DATE`,`LAST_UPD_BY`,`MODIFICATION_NUM`,`CONFLICT_ID`,`ACTL_END_DT`,`ACTL_START_DT`,`DB_LAST_UPD`,`EXPIRATION_DT`,`SCHED_START_DT`,`SUBMIT_DATE`,`CLASS_NAME`,`COMPLETION_CD`,`COMPLETION_TEXT`,`DB_LAST_UPD_SRC`,`DESC_TEXT`,`EXEC_SRVR_NAME`,`METHOD`,`TMODEL`,`RPT_FLAG`,`RPT_INTERVAL`,`RPT_UOM`,`STATUS`,`PAR_ROW_ID`) values (1,'2016-10-26 18:23:24',NULL,'2016-10-26 18:23:24',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-10-25 10:10:10',NULL,'testTask',NULL,'下一次：2016-10-27 15:42:57+2.03分',NULL,'测试任务------',NULL,NULL,NULL,'Y','300','S','活动',NULL),(2,'2016-10-26 18:23:30',NULL,'2016-10-26 18:23:30',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2016-10-25 10:10:10',NULL,'systemMonitorTask',NULL,'下一次：2016-10-27 10:00:06+9.90分',NULL,'服务器监控定时任务------',NULL,NULL,NULL,'Y','600','S','活动',NULL),(45,'2016-10-27 10:00:00','JohnnyHuang 黄福强','2016-10-27 10:00:00','JohnnyHuang 黄福强',0,NULL,'2016-10-27 10:00:00','2016-10-27 10:00:00',NULL,NULL,'2016-10-27 10:00:00','2016-10-27 10:00:00','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1),(46,'2016-10-27 10:00:00','JohnnyHuang 黄福强','2016-10-27 10:00:00','JohnnyHuang 黄福强',0,NULL,'2016-10-27 10:00:06','2016-10-27 10:00:00',NULL,NULL,'2016-10-27 10:00:00','2016-10-27 10:00:00','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'成功',2),(47,'2016-10-27 15:29:27','JohnnyHuang 黄福强','2016-10-27 15:29:27','JohnnyHuang 黄福强',0,NULL,'2016-10-27 15:29:27','2016-10-27 15:29:27',NULL,NULL,'2016-10-27 15:29:27','2016-10-27 15:29:27','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1),(48,'2016-10-27 15:29:27','JohnnyHuang 黄福强','2016-10-27 15:29:27','JohnnyHuang 黄福强',0,NULL,NULL,'2016-10-27 15:29:27',NULL,NULL,'2016-10-27 15:29:27','2016-10-27 15:29:27','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'活动',2),(49,'2016-10-27 15:31:06','JohnnyHuang 黄福强','2016-10-27 15:31:06','JohnnyHuang 黄福强',0,NULL,NULL,'2016-10-27 15:31:06',NULL,NULL,'2016-10-27 15:31:06','2016-10-27 15:31:06','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'活动',2),(50,'2016-10-27 15:31:06','JohnnyHuang 黄福强','2016-10-27 15:31:06','JohnnyHuang 黄福强',0,NULL,'2016-10-27 15:31:06','2016-10-27 15:31:06',NULL,NULL,'2016-10-27 15:31:06','2016-10-27 15:31:06','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1),(51,'2016-10-27 15:32:57','JohnnyHuang 黄福强','2016-10-27 15:32:57','JohnnyHuang 黄福强',0,NULL,NULL,'2016-10-27 15:32:57',NULL,NULL,'2016-10-27 15:32:57','2016-10-27 15:32:57','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'活动',2),(52,'2016-10-27 15:32:57','JohnnyHuang 黄福强','2016-10-27 15:32:57','JohnnyHuang 黄福强',0,NULL,'2016-10-27 15:32:57','2016-10-27 15:32:57',NULL,NULL,'2016-10-27 15:32:57','2016-10-27 15:32:57','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1),(53,'2016-10-27 15:34:06','JohnnyHuang 黄福强','2016-10-27 15:34:06','JohnnyHuang 黄福强',0,NULL,NULL,'2016-10-27 15:34:06',NULL,NULL,'2016-10-27 15:34:06','2016-10-27 15:34:06','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'活动',2),(54,'2016-10-27 15:34:06','JohnnyHuang 黄福强','2016-10-27 15:34:06','JohnnyHuang 黄福强',0,NULL,'2016-10-27 15:34:06','2016-10-27 15:34:06',NULL,NULL,'2016-10-27 15:34:06','2016-10-27 15:34:06','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1),(55,'2016-10-27 15:35:16','JohnnyHuang 黄福强','2016-10-27 15:35:16','JohnnyHuang 黄福强',0,NULL,NULL,'2016-10-27 15:35:16',NULL,NULL,'2016-10-27 15:35:16','2016-10-27 15:35:16','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'活动',2),(56,'2016-10-27 15:35:16','JohnnyHuang 黄福强','2016-10-27 15:35:16','JohnnyHuang 黄福强',0,NULL,'2016-10-27 15:35:16','2016-10-27 15:35:16',NULL,NULL,'2016-10-27 15:35:16','2016-10-27 15:35:16','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1),(57,'2016-10-27 15:36:15','JohnnyHuang 黄福强','2016-10-27 15:36:15','JohnnyHuang 黄福强',0,NULL,NULL,'2016-10-27 15:36:15',NULL,NULL,'2016-10-27 15:36:15','2016-10-27 15:36:15','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'活动',2),(58,'2016-10-27 15:36:15','JohnnyHuang 黄福强','2016-10-27 15:36:15','JohnnyHuang 黄福强',0,NULL,'2016-10-27 15:36:15','2016-10-27 15:36:15',NULL,NULL,'2016-10-27 15:36:15','2016-10-27 15:36:15','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1),(59,'2016-10-27 15:40:05','JohnnyHuang 黄福强','2016-10-27 15:40:05','JohnnyHuang 黄福强',0,NULL,NULL,'2016-10-27 15:40:05',NULL,NULL,'2016-10-27 15:40:05','2016-10-27 15:40:05','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'活动',2),(60,'2016-10-27 15:40:05','JohnnyHuang 黄福强','2016-10-27 15:40:05','JohnnyHuang 黄福强',0,NULL,'2016-10-27 15:40:05','2016-10-27 15:40:05',NULL,NULL,'2016-10-27 15:40:05','2016-10-27 15:40:05','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1),(61,'2016-10-27 15:42:57','JohnnyHuang 黄福强','2016-10-27 15:42:57','JohnnyHuang 黄福强',0,NULL,NULL,'2016-10-27 15:42:57',NULL,NULL,'2016-10-27 15:42:57','2016-10-27 15:42:57','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-10','',NULL,NULL,NULL,NULL,'活动',2),(62,'2016-10-27 15:42:57','JohnnyHuang 黄福强','2016-10-27 15:42:57','JohnnyHuang 黄福强',0,NULL,'2016-10-27 15:42:57','2016-10-27 15:42:57',NULL,NULL,'2016-10-27 15:42:57','2016-10-27 15:42:57','',NULL,NULL,NULL,NULL,'ZTE-20160803EMK_10.17.183.31_Thread-9','',NULL,NULL,NULL,NULL,'成功',1);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
