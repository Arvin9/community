/*
Navicat MySQL Data Transfer

Source Server         : Tex
Source Server Version : 50173
Source Host           : 
Source Database       : community

Target Server Type    : MYSQL
Target Server Version : 50173
File Encoding         : 65001

Version				  : 1.0 beta

Date: 2016-08-21 11:35:18
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for daily_sentence
-- ----------------------------
DROP TABLE IF EXISTS `daily_sentence`;
CREATE TABLE `daily_sentence` (
  `daily_sentence_id` int(4) NOT NULL AUTO_INCREMENT,
  `daily_sentence` varchar(1024) NOT NULL,
  `daily_sentence_add_time` varchar(20) NOT NULL COMMENT '添加时间',
  `daily_sentence_show_times` int(4) NOT NULL,
  `daily_sentence_url` varchar(128) DEFAULT NULL,
  `daily_sentence_like` int(4) DEFAULT '0',
  `daily_sentence_dislike` int(4) DEFAULT '0',
  PRIMARY KEY (`daily_sentence_id`)
) ENGINE=MyISAM AUTO_INCREMENT=214 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for daily_sentence_hobby
-- ----------------------------
DROP TABLE IF EXISTS `daily_sentence_hobby`;
CREATE TABLE `daily_sentence_hobby` (
  `daily_sentence_hobby_id` int(4) NOT NULL AUTO_INCREMENT,
  `daily_sentence_id` int(4) DEFAULT NULL,
  `user_account` varchar(32) DEFAULT NULL,
  `daily_sentence_hobby_add_time` varchar(20) DEFAULT NULL,
  `daily_sentence_hobby` tinyint(1) DEFAULT NULL COMMENT '喜欢为1，不喜欢为2',
  PRIMARY KEY (`daily_sentence_hobby_id`)
) ENGINE=MyISAM AUTO_INCREMENT=56 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exercises
-- ----------------------------
DROP TABLE IF EXISTS `exercises`;
CREATE TABLE `exercises` (
  `exercises_id` int(4) NOT NULL AUTO_INCREMENT,
  `exercises_title` varchar(64) DEFAULT NULL COMMENT '习题标题',
  `exercises_content` varchar(1024) DEFAULT NULL COMMENT '习题内容',
  `exercises_answer` varchar(64) DEFAULT NULL COMMENT '习题答案',
  `exercises_hint` varchar(64) DEFAULT NULL COMMENT '提示',
  `answer_count` int(4) DEFAULT NULL,
  `answer_correct_count` int(4) DEFAULT NULL,
  PRIMARY KEY (`exercises_id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for exercises_answer
-- ----------------------------
DROP TABLE IF EXISTS `exercises_answer`;
CREATE TABLE `exercises_answer` (
  `exercises_answer_id` int(8) NOT NULL AUTO_INCREMENT,
  `exercises_id` int(4) DEFAULT NULL,
  `user_account` varchar(32) DEFAULT NULL,
  `exercises_answer_time` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`exercises_answer_id`)
) ENGINE=MyISAM AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for log_ask_robot
-- ----------------------------
DROP TABLE IF EXISTS `log_ask_robot`;
CREATE TABLE `log_ask_robot` (
  `log_ask_robot_id` int(4) NOT NULL AUTO_INCREMENT,
  `log_ask_robot_content` varchar(512) DEFAULT NULL,
  `user_account` varchar(32) DEFAULT NULL,
  `log_ask_robot_time` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`log_ask_robot_id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for log_login
-- ----------------------------
DROP TABLE IF EXISTS `log_login`;
CREATE TABLE `log_login` (
  `log_login_id` int(4) NOT NULL AUTO_INCREMENT,
  `user_account` varchar(32) DEFAULT NULL,
  `login_ip` varchar(64) DEFAULT NULL,
  `login_time` varchar(20) DEFAULT NULL,
  `login_state` tinyint(1) DEFAULT NULL COMMENT '1表示成功登陆，2表示密码错误',
  PRIMARY KEY (`log_login_id`)
) ENGINE=MyISAM AUTO_INCREMENT=93 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(8) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `role_id` int(4) DEFAULT NULL COMMENT '角色id',
  `user_account` varchar(32) DEFAULT NULL COMMENT '用户账号名称',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `salt` varchar(64) DEFAULT NULL,
  `real_name` varchar(16) DEFAULT NULL COMMENT '真实姓名',
  `add_time` varchar(32) DEFAULT NULL COMMENT '创建时间',
  `is_lock` smallint(1) DEFAULT NULL COMMENT '是否禁用（1-被禁止）',
  `add_man` varchar(16) DEFAULT NULL COMMENT '创建人',
  `is_delete` smallint(1) DEFAULT '0' COMMENT '1-删除',
  PRIMARY KEY (`user_id`),
  KEY `FK_Reference_14` (`role_id`),
  KEY `Manager` (`user_account`) USING BTREE,
  CONSTRAINT `user_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role_info` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=10067 DEFAULT CHARSET=utf8 COMMENT='管理员';
