/*
SQLyog Community v13.0.1 (64 bit)
MySQL - 8.0.31 : Database - javamusic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`javamusic` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `javamusic`;

/*Table structure for table `t_song` */

DROP TABLE IF EXISTS `t_song`;

CREATE TABLE `t_song` (
  `id` int NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌名',
  `singer` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌手姓名',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '歌曲文件路径',
  `cover` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '封面图',
  `lyric` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '歌词',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

/*Data for the table `t_song` */

insert  into `t_song`(`id`,`name`,`singer`,`path`,`cover`,`lyric`,`create_time`) values 
(12,'悬溺','葛东琪','悬溺.mp3','song1.jpg','我主张制止不了就放任','2023-09-20 16:00:25'),
(13,'凄美地','郭顶','凄美地.mp3','song2.jpg','曾经我是不安河水，穿过森林误入你心','2023-09-20 16:01:19'),
(14,'哪里都是你','队长','哪里都是你.mp3','song3.png','从不在意别人口中的自己','2023-09-20 16:01:22'),
(15,'罗生门follow','张子豪','罗生门.mp3','song4.jpg','我没转身，一直走一直梦，一直疯一直没停留，那些美好的，越靠近越沉溺，越来越不想放手，Whereveryougo，Whereveryougo，Follow，每到晚上理智变得感性，我编了这条短信，说不在乎不过是我嘴硬，总是期待你有什么反应。','2023-09-20 16:01:25'),
(16,'多远都要在一起','邓紫棋','多远都要在一起.mp3','song5.jpg','想听你听过的音乐','2023-09-20 16:01:27');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
