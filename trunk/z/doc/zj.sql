/*
SQLyog Ultimate v8.32 
MySQL - 5.1.41-community : Database - zhenjia
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`zhenjia` /*!40100 DEFAULT CHARACTER SET utf8 */;

/*Table structure for table `t_comment` */

DROP TABLE IF EXISTS `t_comment`;

CREATE TABLE `t_comment` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `questionid` int(11) NOT NULL COMMENT 'refer t_question',
  `comment` mediumtext NOT NULL,
  `creatorId` int(11) NOT NULL DEFAULT '0' COMMENT '创建者Id,refer t_user',
  `creattime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `opinion` tinyint(4) NOT NULL COMMENT '1同意真，0同意假',
  `creatorip` char(20) NOT NULL COMMENT '创建者ip',
  `hasfollow` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否有跟随评论',
  `followid` int(11) NOT NULL DEFAULT '0' COMMENT '更随Id,refer t_comment',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_comment` */

/*Table structure for table `t_opinion` */

DROP TABLE IF EXISTS `t_opinion`;

CREATE TABLE `t_opinion` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `questionid` int(10) unsigned NOT NULL COMMENT 'refer t_question',
  `opinion` tinyint(3) unsigned NOT NULL DEFAULT '0' COMMENT '真假，0假，1真',
  `userid` int(11) NOT NULL COMMENT '用户id',
  `createtime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `creatorip` char(20) NOT NULL DEFAULT '0',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_opinion` */

/*Table structure for table `t_question` */

DROP TABLE IF EXISTS `t_question`;

CREATE TABLE `t_question` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `question` mediumtext NOT NULL COMMENT '问题的正文',
  `tags` varchar(200) NOT NULL DEFAULT '' COMMENT '问题的标签',
  `truenum` mediumint(9) NOT NULL DEFAULT '0' COMMENT '支持真的数量',
  `falsenum` mediumint(9) NOT NULL DEFAULT '0' COMMENT '支持假的数量',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建的时间',
  `creatorip` char(20) NOT NULL DEFAULT '0' COMMENT '创建时的ip',
  `enable` tinyint(1) NOT NULL DEFAULT '1',
  `editable` tinyint(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `t_question` */

insert  into `t_question`(`tid`,`question`,`tags`,`truenum`,`falsenum`,`updatetime`,`createtime`,`creatorip`,`enable`,`editable`) values (1,'碘盐能防辐射吗，是真是假？碘盐能防辐射吗665d，是真是假？碘盐能防辐射吗，是真是假？','辐射',1,0,'2011-04-10 13:17:33','0000-00-00 00:00:00','0',1,1),(2,'碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？','辐射',0,0,'2011-04-09 18:30:48','0000-00-00 00:00:00','0',1,1),(3,'碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？','辐射',0,0,'2011-04-09 18:30:48','0000-00-00 00:00:00','0',1,1),(4,'碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？','辐射',0,0,'2011-04-09 18:30:48','0000-00-00 00:00:00','0',1,1),(5,'碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？','辐射',0,0,'2011-04-09 18:30:48','0000-00-00 00:00:00','0',1,1),(6,'碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？','辐射',0,0,'2011-04-09 18:30:48','0000-00-00 00:00:00','0',1,1),(7,'碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？碘盐能防辐射吗，是真是假？','辐射',0,0,'2011-04-09 18:30:48','0000-00-00 00:00:00','0',1,1);

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` char(30) NOT NULL COMMENT '登录名，邮箱',
  `password` char(20) NOT NULL,
  `enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可用',
  `bindtype` tinyint(4) NOT NULL DEFAULT '0' COMMENT '0没有绑定，1qq，2sina',
  `bindId` varchar(50) NOT NULL COMMENT '绑定的第三方Id',
  `displayname` varchar(30) NOT NULL COMMENT '显示的用户名',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`tid`,`name`,`password`,`enable`,`bindtype`,`bindId`,`displayname`) values (54,'QQQQ','123',1,0,'','evan12'),(55,'QQQQ','123',1,0,'','evan12'),(56,'QQQQ','123',1,0,'','evan12'),(57,'QQQQ','123',1,0,'','evan12'),(58,'QQQQ','123',1,0,'','evan12'),(59,'QQQQ','123',1,0,'','evan12'),(70,'QQQQ','123',1,0,'','evan12'),(73,'QQQQ','123',1,0,'','evan12'),(80,'QQQQ','123',1,0,'','evan12'),(81,'QQQQ','123',1,0,'','evan12'),(82,'QQQQ','123',1,0,'','evan12'),(83,'QQQQ','123',1,0,'','evan12'),(84,'QQQQ','123',1,0,'','evan12');

/*Table structure for table `users` */

DROP TABLE IF EXISTS `users`;

CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(30) NOT NULL,
  `userPassword` varchar(30) DEFAULT NULL,
  `userSex` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

/*Data for the table `users` */

insert  into `users`(`userId`,`userName`,`userPassword`,`userSex`) values (17,'eeevan','a','a'),(18,'eeevan','a','a'),(19,'dfa','123','23'),(20,'dfa','123','23'),(21,'dfa','123','23');

/* Procedure structure for procedure `test_sp1` */

/*!50003 DROP PROCEDURE IF EXISTS  `test_sp1` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `test_sp1`( )
BEGIN  
    DECLARE t_error INTEGER DEFAULT 0;  
    DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error=1;  
  
        START TRANSACTION;  
            INSERT INTO users VALUES(NULL, 'eeevan','a','a');   /* 第一条 insert 能执行 */  
            INSERT INTO users VALUES(NULL, NULL,'a','a');  /* 第二条 insert，不能执行 */   
  
        IF t_error = 1 THEN  
            ROLLBACK;  
        ELSE  
            COMMIT;  
        END IF;  
  
    END */$$
DELIMITER ;

/* Procedure structure for procedure `userTest` */

/*!50003 DROP PROCEDURE IF EXISTS  `userTest` */;

DELIMITER $$

/*!50003 CREATE DEFINER=`root`@`localhost` PROCEDURE `userTest`()
BEGIN  
	DECLARE t_error INTEGER DEFAULT 0;  
	DECLARE CONTINUE HANDLER FOR SQLEXCEPTION SET t_error=1;  
        START TRANSACTION;  
            INSERT INTO users VALUES(NULL, 'eeevan','a','a');   /* 第一条 insert 能执行 */  
            INSERT INTO users VALUES(NULL, 'eeevan','a','a');  /* 第二条 insert，不能执行 */   
  
        IF  t_error = 1 THEN  
            ROLLBACK;  
        ELSE  
            COMMIT;  
        END IF;   
  
    END */$$
DELIMITER ;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
