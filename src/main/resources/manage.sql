/*
SQLyog Ultimate - MySQL GUI v8.2 
MySQL - 5.5.27 : Database - manage
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`manage` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `manage`;

/*Table structure for table `admin` */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '管理员编码',
  `name` varchar(50) NOT NULL COMMENT '用户名',
  `password` varchar(200) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Data for the table `admin` */

insert  into `admin`(`id`,`name`,`password`) values (1,'王','1234567');

/*Table structure for table `apply` */

DROP TABLE IF EXISTS `apply`;

CREATE TABLE `apply` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '申请表编号',
  `reason` varchar(500) NOT NULL COMMENT '申请理由',
  `income` varchar(200) NOT NULL COMMENT '家庭年收入',
  `money` varchar(200) NOT NULL COMMENT '资助金额',
  `father_name` varchar(200) NOT NULL COMMENT '父亲姓名',
  `father_profe` varchar(200) NOT NULL COMMENT '父亲职业',
  `father_phone` varchar(50) NOT NULL COMMENT '父亲电话',
  `mother_name` varchar(200) NOT NULL COMMENT '母亲姓名',
  `mother_profe` varchar(200) NOT NULL COMMENT '母亲职业',
  `mother_phone` varchar(50) NOT NULL COMMENT '母亲电话',
  `student_name` varchar(200) NOT NULL COMMENT '姓名',
  `student_num` varchar(200) NOT NULL COMMENT '学号',
  `apply_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '申请时间',
  `type_id` int(50) NOT NULL COMMENT '资助类型编号',
  `status` int(11) NOT NULL COMMENT '0 正在辅导员审核，1正在管理员审核 2辅导员审核未通过 3管理员审核未通过 4 管理员审核通过 5其他 ',
  `image_add` varchar(500) NOT NULL COMMENT '家庭情况调查表地址',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

/*Data for the table `apply` */

insert  into `apply`(`id`,`reason`,`income`,`money`,`father_name`,`father_profe`,`father_phone`,`mother_name`,`mother_profe`,`mother_phone`,`student_name`,`student_num`,`apply_time`,`type_id`,`status`,`image_add`) values (5,'家里穷','1','1','刘强东','英语老师','71915318818','刘青','务农','1442543532','王刚','3156017003','2019-06-07 05:34:48',1,4,'1559835164028QQ图片20190606233102.jpg'),(7,'缺钱','2','2','林秦姐','务农','133508826436','林依霖','web前端','134028492894','王立','3156017001','2019-06-07 05:34:46',1,4,'1559839664412FED1BBD0910AF10D59229C67ED266ECE.jpg'),(8,'哈哈哈哈哈哈哈哈','3','3','刘强东','英语老师','71917118818','刘青','务农','1423423532','杨丽','3156017011','2019-06-07 05:20:12',1,4,'1559855973409FED1BBD0910AF10D59229C67ED266ECE.jpg'),(9,'黄飞鸿是否还是大','3','5','刘强东','英语老师','71917118818','刘青','务农','1423423532','琴姐','3156017004','2019-06-07 05:34:49',3,4,'1559852040322QQ图片20190606233102.jpg');

/*Table structure for table `class` */

DROP TABLE IF EXISTS `class`;

CREATE TABLE `class` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '班级编号',
  `name` varchar(200) NOT NULL COMMENT '班级名称',
  `special_id` int(50) NOT NULL COMMENT '专业编号',
  `depatment_id` int(50) NOT NULL COMMENT '系别编号',
  `instructor_id` int(50) NOT NULL COMMENT '辅导员工号',
  `grade` varchar(200) DEFAULT NULL COMMENT '年级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

/*Data for the table `class` */

insert  into `class`(`id`,`name`,`special_id`,`depatment_id`,`instructor_id`,`grade`) values (1,'2016级(1)班',10,2,3,'16级'),(2,'2015级(2)班',2,1,1,'15级'),(3,'2016级(1)班',2,1,1,'16级'),(4,'2016级(2)班',2,1,1,'16级'),(5,'2017级(1)班',2,1,1,'17级'),(6,'2018级(1)班',2,1,1,'18级'),(7,'2018级(2)班',2,1,1,'18级'),(9,'2015级(2)班',8,2,1,'15级'),(10,'2016级(1)班',8,2,1,'16级'),(11,'2016级(2)班',8,2,1,'16级'),(12,'2017级(1)班',8,2,1,'17级'),(13,'2017级(2)班',8,2,3,'17级'),(14,'2018级(1)班',8,2,3,'18级'),(15,'（1）班',8,2,3,'16级'),(16,'2016级(1)班',7,1,1,'16级');

/*Table structure for table `depatment` */

DROP TABLE IF EXISTS `depatment`;

CREATE TABLE `depatment` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '系别编号',
  `name` varchar(200) NOT NULL COMMENT '系别名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `depatment` */

insert  into `depatment`(`id`,`name`) values (1,'人文系'),(2,'计算机科学系'),(3,'会计系');

/*Table structure for table `instructor` */

DROP TABLE IF EXISTS `instructor`;

CREATE TABLE `instructor` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '辅导员编号',
  `phone` varchar(50) DEFAULT NULL COMMENT '联系电话',
  `qq` varchar(200) DEFAULT NULL COMMENT 'qq',
  `sex` int(50) NOT NULL COMMENT '1 男 2 女',
  `name` varchar(200) NOT NULL COMMENT '姓名',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `number` varchar(200) DEFAULT NULL COMMENT '管理员工号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `instructor` */

insert  into `instructor`(`id`,`phone`,`qq`,`sex`,`name`,`password`,`number`) values (1,'18305993311','1615630473',2,'穆明1','123456','BSGUFE01'),(3,'15392123620','11111111111',1,'林秦杰','111111','BSGUFE03'),(5,'18306993318','1235456',1,'陈建威','111111','BSGUFE06');

/*Table structure for table `notice` */

DROP TABLE IF EXISTS `notice`;

CREATE TABLE `notice` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '公告编号',
  `title` varchar(200) NOT NULL COMMENT '公告标题',
  `publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `content` varchar(500) DEFAULT NULL COMMENT '内容',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

/*Data for the table `notice` */

insert  into `notice`(`id`,`title`,`publish_time`,`content`) values (2,'1.公告','2019-06-05 22:21:43','1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告1公告'),(5,'3.公告','2019-06-05 22:22:06','3公3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告3公告告3公告3公告3公告3公告3公告3公告3公告'),(7,'深入理解js闭包和作用域','2019-06-02 20:02:55','深入理解js闭包和作用域深入理解js闭包和作用域深入理解js闭包和作用域深入理解js闭包和作用域'),(8,'哈哈哈哈','2019-06-05 21:00:50','哈哈哈哈哈哈');

/*Table structure for table `special` */

DROP TABLE IF EXISTS `special`;

CREATE TABLE `special` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '专业编号',
  `depatment_id` int(50) NOT NULL COMMENT '系别编号',
  `name` varchar(200) NOT NULL COMMENT '专业名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

/*Data for the table `special` */

insert  into `special`(`id`,`depatment_id`,`name`) values (2,1,'汉语言文学'),(4,1,'法学'),(7,1,'商务英语'),(8,2,'电子商务'),(9,2,'市场营销'),(10,2,'计算机科学与技术'),(11,2,'工程管理'),(12,2,'信息管理与信息系统'),(13,3,'会计学'),(14,3,'财务管理'),(15,3,'审计学');

/*Table structure for table `standard` */

DROP TABLE IF EXISTS `standard`;

CREATE TABLE `standard` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '审核标准编号',
  `content` varchar(3000) NOT NULL COMMENT '内容',
  `publish_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

/*Data for the table `standard` */

insert  into `standard`(`id`,`content`,`publish_time`) values (1,'综测成绩排名专业前15%','2019-06-07 03:36:53'),(6,'大学期间没有重大违规记录','2019-06-07 03:37:07'),(7,'学习认真，尊老爱幼，团结同学，热爱党和人民','2019-06-07 03:39:37');

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '贫困生id',
  `student_num` varchar(200) NOT NULL COMMENT '学号',
  `name` varchar(100) NOT NULL COMMENT '姓名',
  `sex` int(20) NOT NULL COMMENT '性别：1男 2女',
  `password` varchar(200) NOT NULL COMMENT '密码',
  `special_id` int(50) NOT NULL COMMENT '专业编号',
  `class_id` int(50) NOT NULL COMMENT '班级编号',
  `address` varchar(500) DEFAULT NULL COMMENT '家庭住址',
  `depatment_id` int(50) NOT NULL COMMENT '系别编号',
  `grade` varchar(200) NOT NULL COMMENT '年级名称',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`student_num`,`name`,`sex`,`password`,`special_id`,`class_id`,`address`,`depatment_id`,`grade`) values (6,'3156017005','琴姐',2,'123456',8,11,'北京大学',2,'2016级'),(7,'3156017004','琴姐',2,'123456',8,11,'北京大学',2,'2018级'),(8,'3156017011','杨丽',2,'123456',10,1,'福建农林大学',2,'2016级'),(9,'3156017019','琴姐',1,'111111',2,3,'北京大学',1,'2015级');

/*Table structure for table `type` */

DROP TABLE IF EXISTS `type`;

CREATE TABLE `type` (
  `id` int(50) NOT NULL AUTO_INCREMENT COMMENT '资助类型编号',
  `name` varchar(200) NOT NULL COMMENT '资助类型名称',
  `conditional` varchar(1000) NOT NULL COMMENT '条件描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `type` */

insert  into `type`(`id`,`name`,`conditional`) values (1,'国家助学金A等','国家助学金A等'),(2,'国家助学金B等','国家助学金B等'),(3,'国家助学金C等','国家助学金C等'),(4,'国家励志奖学金','国家励志奖学金'),(5,'精准扶贫','精准扶贫');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
