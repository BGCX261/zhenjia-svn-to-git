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

/*Table structure for table `t_role` */

DROP TABLE IF EXISTS `t_role`;

CREATE TABLE `t_role` (
  `tid` smallint(6) NOT NULL,
  `name` varchar(30) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `t_role` */

insert  into `t_role`(`tid`,`name`) values (1,'USER');

/*Table structure for table `t_topic` */

DROP TABLE IF EXISTS `t_topic`;

CREATE TABLE `t_topic` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(200) NOT NULL DEFAULT '' COMMENT '问题的标题',
  `content` mediumtext NOT NULL COMMENT '问题的正文',
  `tags` varchar(200) NOT NULL DEFAULT '' COMMENT '问题的标签',
  `leftnum` mediumint(9) NOT NULL DEFAULT '0' COMMENT '支持左方的数量',
  `rightnum` mediumint(9) NOT NULL DEFAULT '0' COMMENT '支持右方的数量',
  `leftopn` varchar(200) NOT NULL DEFAULT '' COMMENT '左方观点',
  `rightopn` varchar(200) NOT NULL DEFAULT '' COMMENT '右方观点',
  `updatetime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `createtime` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' COMMENT '创建的时间',
  `creatorip` char(20) NOT NULL DEFAULT '0' COMMENT '创建时的ip',
  `creatorid` int(11) NOT NULL COMMENT '创建者id',
  `enable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否启用',
  `editable` tinyint(1) NOT NULL DEFAULT '1' COMMENT '是否可编辑',
  `activity` int(11) NOT NULL DEFAULT '0' COMMENT '活跃度',
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `t_topic` */

insert  into `t_topic`(`tid`,`title`,`content`,`tags`,`leftnum`,`rightnum`,`leftopn`,`rightopn`,`updatetime`,`createtime`,`creatorip`,`creatorid`,`enable`,`editable`,`activity`) values (1,'1','2','',0,0,'3','4','2011-06-12 13:56:27','2011-06-12 13:56:27','11',1,1,1,0),(2,'zz','x','',0,0,'c','v','2011-06-12 14:00:57','2011-06-12 14:00:57','11',1,1,1,0),(3,'d','d','d',0,0,'dd','d','2011-06-12 14:21:39','2011-06-12 14:21:39','0:0:0:0:0:0:0:1',1,1,1,0),(4,'dd','dd','dd',0,0,'dd','dd','2011-06-12 16:04:54','2011-06-12 16:04:54','0:0:0:0:0:0:0:1',1,1,1,0);

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

insert  into `t_user`(`tid`,`name`,`password`,`enable`,`bindtype`,`bindId`,`displayname`) values (1,'e','e',1,0,'','evan'),(55,'QQQQ','123',1,0,'','evan12'),(56,'QQQQ','123',1,0,'','evan12'),(57,'QQQQ','123',1,0,'','evan12'),(58,'QQQQ','123',1,0,'','evan12'),(59,'QQQQ','123',1,0,'','evan12'),(70,'QQQQ','123',1,0,'','evan12'),(73,'QQQQ','123',1,0,'','evan12'),(80,'QQQQ','123',1,0,'','evan12'),(81,'QQQQ','123',1,0,'','evan12'),(82,'QQQQ','123',1,0,'','evan12'),(83,'QQQQ','123',1,0,'','evan12'),(84,'QQQQ','123',1,0,'','evan12');

/*Table structure for table `t_user_role` */

DROP TABLE IF EXISTS `t_user_role`;

CREATE TABLE `t_user_role` (
  `tid` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `userid` int(11) NOT NULL,
  `roleid` smallint(6) NOT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `t_user_role` */

insert  into `t_user_role`(`tid`,`userid`,`roleid`) values (1,1,1);

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

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
