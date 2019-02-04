/*
Navicat MySQL Data Transfer

Source Server         : 我
Source Server Version : 50722
Source Host           : 47.98.114.197:3306
Source Database       : rxpbdb

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2018-12-22 22:28:07
*/

SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for `rxpb_company_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_company_info`;
CREATE TABLE `rxpb_company_info`
(
  `company_id`     int(11)     NOT NULL AUTO_INCREMENT,
  `company_name`   varchar(45) NOT NULL COMMENT '参选单位名',
  `competition_id` int(11)     NOT NULL DEFAULT '1' COMMENT '参赛企业所属的比赛,同一企业在不同的赛事中保持独立',
  `avatar_url`     varchar(255)         DEFAULT NULL COMMENT '参选单位头像URL',
  `create_date`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user`    varchar(45)          DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user`    varchar(45)          DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `company_name_UNIQUE` (`company_name`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='企业信息表';

-- ----------------------------
-- Records of rxpb_company_info
-- ----------------------------

-- ----------------------------
-- Table structure for `rxpb_competition_config`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_competition_config`;
CREATE TABLE `rxpb_competition_config`
(
  `id`             int(11)  NOT NULL AUTO_INCREMENT COMMENT '自动,正常情况下始终为一条\n',
  `competition_id` int(11)  NOT NULL DEFAULT '1' COMMENT '此处设置的是当前正在进行的比赛\n',
  `create_date`    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user`    varchar(45)       DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date`    datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user`    varchar(45)       DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8 COMMENT ='当前大赛配置\r\n正常情况下始终为一条\r\n';

-- ----------------------------
-- Records of rxpb_competition_config
-- ----------------------------
INSERT INTO `rxpb_competition_config`
VALUES ('1', '1', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');

-- ----------------------------
-- Table structure for `rxpb_competition_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_competition_info`;
CREATE TABLE `rxpb_competition_info`
(
  `competition_id`   int(11)     NOT NULL AUTO_INCREMENT,
  `competition_year` varchar(45) NOT NULL COMMENT '赛事的年份\nxxxx',
  `var_fatness_m`    float       NOT NULL COMMENT '雄蟹肥满度参数',
  `var_fatness_f`    float       NOT NULL COMMENT '雌蟹肥满度参数',
  `var_weight_m`     float       NOT NULL COMMENT '雄蟹体重参数',
  `var_weight_f`     float       NOT NULL COMMENT '雌蟹体重参数',
  `var_mfatness_sd`  float       NOT NULL COMMENT '雄蟹肥满度标准差参数',
  `var_mweight_sd`   float       NOT NULL COMMENT '雄蟹体重参数',
  `var_ffatness_sd`  float       NOT NULL COMMENT '雌蟹肥满度标准差参数',
  `var_fweight_sd`   float       NOT NULL COMMENT '雌蟹体重标准差参数',
  `result_fatness`   int(11)     NOT NULL DEFAULT '0' COMMENT '1:允许查看排名,0不允许查看排名',
  `result_quality`   int(11)     NOT NULL DEFAULT '0' COMMENT '1:允许查看排名,0不允许查看排名',
  `result_taste`     int(11)     NOT NULL DEFAULT '0' COMMENT '1:允许查看排名,0不允许查看排名',
  `note`             varchar(225)         DEFAULT NULL COMMENT '注备',
  `status`           int(11)     NOT NULL DEFAULT '1' COMMENT '1：可用 0：禁用',
  `avatar_url`       varchar(255)         DEFAULT NULL COMMENT '大赛图片URL',
  `create_date`      datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user`      varchar(45)          DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date`      datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user`      varchar(45)          DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`competition_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8 COMMENT ='大赛信息表';

-- ----------------------------
-- Records of rxpb_competition_info
-- ----------------------------
INSERT INTO `rxpb_competition_info`
VALUES ('1', '2017', '0.9', '1', '0.09', '0.1', '0.1', '0.09', '0.1', '0.1', '0', '0', '0', null, '1', null,
        '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');

-- ----------------------------
-- Table structure for `rxpb_crab_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_crab_info`;
CREATE TABLE `rxpb_crab_info`
(
  `crab_id`        int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_id`       int(10) unsigned NOT NULL,
  `crab_sex`       int(1)           NOT NULL COMMENT '0:雌 1：雄',
  `crab_label`     varchar(10)      NOT NULL COMMENT '四位的蟹标识',
  `crab_weight`    float                     DEFAULT NULL COMMENT '体重',
  `crab_length`    float                     DEFAULT NULL COMMENT '壳长',
  `crab_fatness`   float                     DEFAULT NULL COMMENT '肥满度',
  `create_date`    datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `avatar_url`     varchar(255)              DEFAULT NULL COMMENT '螃蟹图片URL',
  `create_user`    varchar(45)               DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date`    datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user`    varchar(45)               DEFAULT 'admin' COMMENT '数据更新用户',
  `competition_id` int(11)          NOT NULL DEFAULT '1' COMMENT '比赛ID',
  PRIMARY KEY (`crab_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='蟹基本信息表,肥满度表';

-- ----------------------------
-- Records of rxpb_crab_info
-- ----------------------------

-- ----------------------------
-- Table structure for `rxpb_group_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_group_info`;
CREATE TABLE `rxpb_group_info`
(
  `group_id`        int(10) unsigned NOT NULL AUTO_INCREMENT COMMENT '组ID',
  `company_id`      int(11)          NOT NULL,
  `competition_id`  int(11)          NOT NULL DEFAULT '1' COMMENT '比赛ID',
  `fatness_score_m` float                     DEFAULT NULL COMMENT '雄蟹肥满度评分',
  `quality_score_m` float                     DEFAULT NULL COMMENT '雄蟹种质评分',
  `taste_score_m`   float                     DEFAULT NULL COMMENT '雄蟹口感评分\n',
  `fatness_score_f` float                     DEFAULT NULL COMMENT '雌蟹肥满度评分\n',
  `quality_score_f` float                     DEFAULT NULL COMMENT '雌蟹种质评分\n',
  `taste_score_f`   float                     DEFAULT NULL COMMENT '雌蟹口感评分\n',
  `create_date`     datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user`     varchar(45)               DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date`     datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user`     varchar(45)               DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`group_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='组信息数表';

-- ----------------------------
-- Records of rxpb_group_info
-- ----------------------------

-- ----------------------------
-- Table structure for `rxpb_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_role_info`;
CREATE TABLE `rxpb_role_info`
(
  `role_id`     int(11)     NOT NULL AUTO_INCREMENT COMMENT '"角色ID:1：管理员\n 2：评委 3：工作人员 4:参选单位"\n',
  `role_name`   varchar(15) NOT NULL,
  `create_date` datetime    DEFAULT NULL COMMENT '数据创建日期',
  `create_user` varchar(45) DEFAULT NULL COMMENT '数据创建用户',
  `update_date` datetime    DEFAULT NULL COMMENT '数据更新日期',
  `update_user` varchar(45) DEFAULT NULL COMMENT '数据更新用户',
  PRIMARY KEY (`role_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 5
  DEFAULT CHARSET = utf8 COMMENT ='用户组信息表';

-- ----------------------------
-- Records of rxpb_role_info
-- ----------------------------
INSERT INTO `rxpb_role_info`
VALUES ('1', '管理员', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');
INSERT INTO `rxpb_role_info`
VALUES ('2', '评委', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');
INSERT INTO `rxpb_role_info`
VALUES ('3', '工作人员', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');
INSERT INTO `rxpb_role_info`
VALUES ('4', '参选单位', '2018-12-22 14:20:16', 'manual', '2018-12-22 14:20:16', 'manual');

-- ----------------------------
-- Table structure for `rxpb_score_quality`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_score_quality`;
CREATE TABLE `rxpb_score_quality`
(
  `score_id`       int(11)          NOT NULL AUTO_INCREMENT,
  `group_id`       int(10) unsigned NOT NULL,
  `crab_sex`       int(1)           NOT NULL,
  `user_id`        int(11)          NOT NULL,
  `score_fin`      float                     DEFAULT NULL COMMENT '最终给分',
  `score_bts`      float                     DEFAULT NULL COMMENT '体色(背)',
  `score_fts`      float                     DEFAULT NULL COMMENT '体色(腹)',
  `score_ec`       float                     DEFAULT NULL COMMENT '额齿',
  `score_dscc`     float                     DEFAULT NULL COMMENT '第4侧齿',
  `score_bbyzt`    float                     DEFAULT NULL COMMENT '背部疣状突',
  `create_date`    datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user`    varchar(45)               DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date`    datetime         NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user`    varchar(45)               DEFAULT 'admin' COMMENT '数据更新用户',
  `competition_id` int(11)          NOT NULL DEFAULT '1' COMMENT '比赛ID',
  PRIMARY KEY (`score_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8 COMMENT ='种质评分表';

-- ----------------------------
-- Records of rxpb_score_quality
-- ----------------------------

-- ----------------------------
-- Table structure for `rxpb_score_taste`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_score_taste`;
CREATE TABLE `rxpb_score_taste`
(
  `score_id`       int(11)          NOT NULL AUTO_INCREMENT,
  `group_id`       int(10) unsigned NOT NULL,
  `crab_sex`       int(1)           NOT NULL,
  `user_id`        int(11)          NOT NULL,
  `score_fin`      float                          DEFAULT NULL COMMENT '最终给分',
  `score_ygys`     float                          DEFAULT NULL COMMENT '蟹盖颜色',
  `score_sys`      float                          DEFAULT NULL COMMENT '鳃颜色',
  `score_ghys`     float                          DEFAULT NULL COMMENT '膏、黄颜色',
  `score_xwxw`     float                          DEFAULT NULL COMMENT '腥味、香味',
  `score_gh`       float                          DEFAULT NULL COMMENT '膏、黄',
  `score_fbjr`     float                          DEFAULT NULL COMMENT '腹部肌肉',
  `score_bzjr`     float                          DEFAULT NULL COMMENT '第二、三步足肌肉',
  `create_date`    datetime         NOT NULL      DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user`    varchar(45) CHARACTER SET utf8 DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date`    datetime         NOT NULL      DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user`    varchar(45) CHARACTER SET utf8 DEFAULT 'admin' COMMENT '数据更新用户',
  `competition_id` int(11)          NOT NULL      DEFAULT '1' COMMENT '比赛ID',
  PRIMARY KEY (`score_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = sjis COMMENT ='口感奖评分表';

-- ----------------------------
-- Records of rxpb_score_taste
-- ----------------------------

-- ----------------------------
-- Table structure for `rxpb_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_user_info`;
CREATE TABLE `rxpb_user_info`
(
  `user_id`        int(11)     NOT NULL AUTO_INCREMENT,
  `company_id`     int(11)              DEFAULT NULL COMMENT '对应的参选单位',
  `user_name`      varchar(45) NOT NULL COMMENT '用户名,登录名',
  `password`       varchar(45) NOT NULL COMMENT '密码',
  `display_name`   varchar(45) NOT NULL DEFAULT '未命名用户' COMMENT '显示名称，姓名或单位名',
  `role_id`        int(11)     NOT NULL COMMENT '角色ID:1-管理员 2-工作人员 3-企业',
  `status`         int(11)     NOT NULL DEFAULT '0' COMMENT '用户状态 1：可用 0：禁用',
  `email`          varchar(45)          DEFAULT NULL,
  `competition_id` int(11)     NOT NULL DEFAULT '1' COMMENT '''赛事信息（为0时代表永久有效）\n',
  `create_date`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user`    varchar(45)          DEFAULT 'admin' COMMENT '创建用户',
  `update_date`    datetime    NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user`    varchar(45)          DEFAULT 'admin' COMMENT '更新用户',
  `avatar_url`     varchar(255)         DEFAULT NULL COMMENT '用户头像URL',
  PRIMARY KEY (`user_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 2
  DEFAULT CHARSET = utf8 COMMENT ='用户信息表';

-- ----------------------------
-- Records of rxpb_user_info
-- ----------------------------
INSERT INTO `rxpb_user_info`
VALUES ('1', null, 'admin', '21232F297A57A5A743894A0E4A801FC3', 'admin', '1', '1', 'admin@xxx.com', '1',
        '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual', null);
