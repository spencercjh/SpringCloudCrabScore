/*
Navicat MySQL Data Transfer

Source Server         : 我
Source Server Version : 50724
Source Host           : 47.98.114.197:3306
Source Database       : rxpbdb

Target Server Type    : MYSQL
Target Server Version : 50724
File Encoding         : 65001

Date: 2019-03-11 22:15:41
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `rxpb_company_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_company_info`;
CREATE TABLE `rxpb_company_info` (
  `company_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_name` varchar(45) NOT NULL COMMENT '参选单位名',
  `competition_id` int(11) NOT NULL DEFAULT '1' COMMENT '参赛企业所属的比赛,同一企业在不同的赛事中保持独立',
  `avatar_url` varchar(255) NOT NULL DEFAULT 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg' COMMENT '参选单位头像URL',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user` varchar(45) DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user` varchar(45) DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`company_id`),
  UNIQUE KEY `company_name_UNIQUE` (`company_name`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='企业信息表';

-- ----------------------------
-- Records of rxpb_company_info
-- ----------------------------
INSERT INTO `rxpb_company_info` VALUES ('1', '昆山常氏蟹业有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-10 00:00:00', 'admin', '2018-02-10 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('2', '昆山淀山湖永兴虾蟹养殖农民专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-02-11 00:00:00', 'admin', '2018-02-11 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('3', '安庆市皖宜季牛水产养殖有限责任公司 ', '1', 'http://spencercjh.top/timg.jpg', '2018-02-12 00:00:00', 'admin', '2018-02-12 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('4', '安徽省五河县大杨湖水产养殖有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-13 00:00:00', 'admin', '2018-02-13 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('5', '霍邱县城东湖生态水产养殖有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-14 00:00:00', 'admin', '2018-02-14 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('6', '江苏省盐城市陈长荣大纵湖大闸蟹有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-15 00:00:00', 'admin', '2018-02-15 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('7', '江苏水景园蟹业有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-16 00:00:00', 'admin', '2018-02-16 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('8', '江西国营九江县赛城湖水产场', '1', 'http://spencercjh.top/timg.jpg', '2018-02-17 00:00:00', 'admin', '2018-02-17 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('9', '江西映虹水产集团有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-18 00:00:00', 'admin', '2018-02-18 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('10', '泰兴江源农牧有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-19 00:00:00', 'admin', '2018-02-19 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('11', '上海惠信水产养殖合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-02-20 00:00:00', 'admin', '2018-02-20 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('12', '江西省进贤县皖赣特种水产开发有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-21 00:00:00', 'admin', '2018-02-21 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('13', '上海松江区水产良种场', '1', 'http://spencercjh.top/timg.jpg', '2018-02-22 00:00:00', 'admin', '2018-02-22 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('14', '安徽望江县武昌湖生态渔业有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-23 00:00:00', 'admin', '2018-02-23 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('15', '九江鄱源生态农业科技发展有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-24 00:00:00', 'admin', '2018-02-24 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('16', '苏州工业园区唯亭镇鸿澄阳澄湖大闸蟹养殖场', '1', 'http://spencercjh.top/timg.jpg', '2018-02-25 00:00:00', 'admin', '2018-02-25 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('17', '安徽当涂县苦莱圩水产养殖有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-26 00:00:00', 'admin', '2018-02-26 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('18', '常州市双丰水产养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-02-27 00:00:00', 'admin', '2018-02-27 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('19', '苏州横冠水产有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-02-28 00:00:00', 'admin', '2018-02-28 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('20', '东太湖徐福林', '1', 'http://spencercjh.top/timg.jpg', '2018-03-01 00:00:00', 'admin', '2018-03-01 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('21', '宝应湖李国庆', '1', 'http://spencercjh.top/timg.jpg', '2018-03-02 00:00:00', 'admin', '2018-03-02 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('22', '扬州高邮湖生态渔业公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-03 00:00:00', 'admin', '2018-03-03 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('23', '江西军山湖生态农业发展有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-04 00:00:00', 'admin', '2018-03-04 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('24', '江西省进贤县军山湖鱼蟹开发公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-05 00:00:00', 'admin', '2018-03-05 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('25', '江西省进贤军山湖毛家渡水产有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-06 00:00:00', 'admin', '2018-03-06 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('26', '扬州湖泊渔业专业合作联社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-07 00:00:00', 'admin', '2018-03-07 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('27', '上海春润水产养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-08 00:00:00', 'admin', '2018-03-08 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('28', '浙江省嘉善县特种水产有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-09 00:00:00', 'admin', '2018-03-09 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('29', '丰收蟹庄太湖养殖基地', '1', 'http://spencercjh.top/timg.jpg', '2018-03-10 00:00:00', 'admin', '2018-03-10 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('30', '上海崇东水产养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-11 00:00:00', 'admin', '2018-03-11 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('31', '浙江省长兴洪桥漾荡牌河蟹专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-12 00:00:00', 'admin', '2018-03-12 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('32', '当涂县花津湖水产品有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-13 00:00:00', 'admin', '2018-03-13 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('33', '微山县永胜河蟹养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-14 00:00:00', 'admin', '2018-03-14 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('34', '上海瀛生实业有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-15 00:00:00', 'admin', '2018-03-15 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('35', '江苏省苏州市吴中区临湖现代渔业发展有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-16 00:00:00', 'admin', '2018-03-16 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('36', '兴化市科兴水产养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-17 00:00:00', 'admin', '2018-03-17 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('37', '宜兴市高胜滆湖渔场', '1', 'http://spencercjh.top/timg.jpg', '2018-03-18 00:00:00', 'admin', '2018-03-18 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('38', '上海杨超水产养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-19 00:00:00', 'admin', '2018-03-19 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('39', '江苏泗洪县金水集团    ', '1', 'http://spencercjh.top/timg.jpg', '2018-03-20 00:00:00', 'admin', '2018-03-20 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('40', '江西九江市赤湖水产场', '1', 'http://spencercjh.top/timg.jpg', '2018-03-21 00:00:00', 'admin', '2018-03-21 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('41', '江苏水仙实业有限公司 ', '1', 'http://spencercjh.top/timg.jpg', '2018-03-22 00:00:00', 'admin', '2018-03-22 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('42', '上海市瑞华实业公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-23 00:00:00', 'admin', '2018-03-23 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('43', '重庆渔乐园水产养殖有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-24 00:00:00', 'admin', '2018-03-24 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('44', '安徽省宣城市金水源农业综合开发有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-25 00:00:00', 'admin', '2018-03-25 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('45', '湖北汉川天歌螃蟹养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-26 00:00:00', 'admin', '2018-03-26 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('46', '昆山市锦溪镇新东方水产养殖农民专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-27 00:00:00', 'admin', '2018-03-27 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('47', '安徽省蒙城县远大河蟹养殖合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-28 00:00:00', 'admin', '2018-03-28 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('48', '江苏省太仓市十八湾生态水产养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-29 00:00:00', 'admin', '2018-03-29 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('49', '江西省进贤县陶氏生态水产有限公司', '1', 'http://spencercjh.top/timg.jpg', '2018-03-30 00:00:00', 'admin', '2018-03-30 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('50', '上海沪宝水产养殖专业合作社', '1', 'http://spencercjh.top/timg.jpg', '2018-03-31 00:00:00', 'admin', '2018-03-31 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('51', '台湾苗栗县政府', '1', 'http://spencercjh.top/timg.jpg', '2018-04-01 00:00:00', 'admin', '2018-04-01 00:00:00', 'admin');
INSERT INTO `rxpb_company_info` VALUES ('52', '台湾苗栗大闸蟹养殖协会', '1', 'http://spencercjh.top/timg.jpg', '2018-04-02 00:00:00', 'admin', '2018-04-02 00:00:00', 'admin');

-- ----------------------------
-- Table structure for `rxpb_competition_config`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_competition_config`;
CREATE TABLE `rxpb_competition_config` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自动,正常情况下始终为一条\n',
  `competition_id` int(11) NOT NULL DEFAULT '1' COMMENT '此处设置的是当前正在进行的比赛\n',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='当前大赛配置\r\n正常情况下始终为一条\r\n';

-- ----------------------------
-- Records of rxpb_competition_config
-- ----------------------------
INSERT INTO `rxpb_competition_config` VALUES ('1', '1', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');

-- ----------------------------
-- Table structure for `rxpb_competition_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_competition_info`;
CREATE TABLE `rxpb_competition_info` (
  `competition_id` int(11) NOT NULL AUTO_INCREMENT,
  `competition_year` varchar(45) NOT NULL COMMENT '赛事的年份\nxxxx',
  `var_fatness_m` float NOT NULL COMMENT '雄蟹肥满度参数',
  `var_fatness_f` float NOT NULL COMMENT '雌蟹肥满度参数',
  `var_weight_m` float NOT NULL COMMENT '雄蟹体重参数',
  `var_weight_f` float NOT NULL COMMENT '雌蟹体重参数',
  `var_mfatness_sd` float NOT NULL COMMENT '雄蟹肥满度标准差参数',
  `var_mweight_sd` float NOT NULL COMMENT '雄蟹体重参数',
  `var_ffatness_sd` float NOT NULL COMMENT '雌蟹肥满度标准差参数',
  `var_fweight_sd` float NOT NULL COMMENT '雌蟹体重标准差参数',
  `result_fatness` int(11) NOT NULL DEFAULT '0' COMMENT '1:允许查看排名,0不允许查看排名',
  `result_quality` int(11) NOT NULL DEFAULT '0' COMMENT '1:允许查看排名,0不允许查看排名',
  `result_taste` int(11) NOT NULL DEFAULT '0' COMMENT '1:允许查看排名,0不允许查看排名',
  `note` varchar(225) DEFAULT NULL COMMENT '注备',
  `status` int(11) NOT NULL DEFAULT '1' COMMENT '1：可用 0：禁用',
  `avatar_url` varchar(255) NOT NULL DEFAULT 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg' COMMENT '大赛图片URL',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`competition_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='大赛信息表';

-- ----------------------------
-- Records of rxpb_competition_info
-- ----------------------------
INSERT INTO `rxpb_competition_info` VALUES ('1', '2017', '0.9', '1', '0.09', '0.1', '0.1', '0.09', '0.1', '0.1', '1', '1', '1', null, '1', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');

-- ----------------------------
-- Table structure for `rxpb_crab_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_crab_info`;
CREATE TABLE `rxpb_crab_info` (
  `crab_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `group_id` int(10) unsigned NOT NULL,
  `crab_sex` int(1) NOT NULL COMMENT '0:雌 1：雄',
  `crab_label` varchar(10) NOT NULL COMMENT '四位的蟹标识',
  `crab_weight` float DEFAULT NULL COMMENT '体重',
  `crab_length` float DEFAULT NULL COMMENT '壳长',
  `crab_fatness` float DEFAULT NULL COMMENT '肥满度',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `avatar_url` varchar(255) DEFAULT 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg' COMMENT '螃蟹图片URL',
  `create_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据更新用户',
  `competition_id` int(11) NOT NULL DEFAULT '1' COMMENT '比赛ID',
  PRIMARY KEY (`crab_id`)
) ENGINE=InnoDB AUTO_INCREMENT=172 DEFAULT CHARSET=utf8 COMMENT='蟹基本信息表,肥满度表';

-- ----------------------------
-- Records of rxpb_crab_info
-- ----------------------------
INSERT INTO `rxpb_crab_info` VALUES ('146', '1', '0', '11100', '184.5', '6.52', '66.5662', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('147', '1', '0', '11101', '179', '6.48', '65.7852', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('148', '1', '0', '11102', '188.9', '6.72', '62.2478', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('149', '1', '0', '11103', '180.1', '6.4', '68.7027', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('150', '1', '0', '11104', '151.5', '6.58', '53.1784', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('151', '1', '0', '11105', '185', '6.54', '66.1361', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('152', '1', '0', '11106', '184', '6.47', '67.9368', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('156', '1', '1', '11110', '268.9', '7.14', '66.4873', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('157', '1', '1', '11111', '274.9', '7.06', '70.3077', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('158', '1', '1', '11112', '280', '7.13', '69.5236', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('159', '1', '1', '11113', '273.6', '7.17', '66.8038', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('160', '1', '1', '11114', '279.7', '7.09', '70.6311', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('161', '1', '1', '11115', '273.6', '6.95', '73.3507', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('162', '1', '1', '11116', '266.3', '7.15', '65.5685', '2019-01-12 15:12:41', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'staff', '2019-01-12 15:12:41', 'staff', '1');
INSERT INTO `rxpb_crab_info` VALUES ('166', '1', '0', '11107', '190.1', '6.77', '61.2655', '2019-02-06 02:46:16', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'admin', '2019-02-06 02:46:16', 'admin', '1');
INSERT INTO `rxpb_crab_info` VALUES ('167', '1', '0', '11108', '178.8', '6.42', '67.5713', '2019-02-06 02:46:16', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'admin', '2019-02-06 02:46:16', 'admin', '1');
INSERT INTO `rxpb_crab_info` VALUES ('168', '1', '0', '11109', '192.2', '6.58', '67.4646', '2019-02-06 02:46:16', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'admin', '2019-02-06 02:46:16', 'admin', '1');
INSERT INTO `rxpb_crab_info` VALUES ('169', '1', '1', '11117', '269.7', '7.01', '70.4643', '2019-02-06 02:46:17', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'admin', '2019-02-06 02:46:17', 'admin', '1');
INSERT INTO `rxpb_crab_info` VALUES ('170', '1', '1', '11118\r\n', '260.2', '6.94', '70.0602', '2019-02-06 02:46:18', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'admin', '2019-02-06 02:46:18', 'admin', '1');
INSERT INTO `rxpb_crab_info` VALUES ('171', '1', '1', '11119', '275.4', '7.04', '71.0376', '2019-02-06 02:46:18', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg', 'admin', '2019-02-06 02:46:18', 'admin', '1');

-- ----------------------------
-- Table structure for `rxpb_group_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_group_info`;
CREATE TABLE `rxpb_group_info` (
  `group_id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '组ID',
  `company_id` int(11) NOT NULL,
  `competition_id` int(11) NOT NULL DEFAULT '1' COMMENT '比赛ID',
  `fatness_score_m` float DEFAULT NULL COMMENT '雄蟹肥满度评分',
  `quality_score_m` float DEFAULT NULL COMMENT '雄蟹种质评分',
  `taste_score_m` float DEFAULT NULL COMMENT '雄蟹口感评分\n',
  `fatness_score_f` float DEFAULT NULL COMMENT '雌蟹肥满度评分\n',
  `quality_score_f` float DEFAULT NULL COMMENT '雌蟹种质评分\n',
  `taste_score_f` float DEFAULT NULL COMMENT '雌蟹口感评分\n',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`group_id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8 COMMENT='组信息数表';

-- ----------------------------
-- Records of rxpb_group_info
-- ----------------------------
INSERT INTO `rxpb_group_info` VALUES ('1', '1', '1', '91.1209', '89.8', '81.8', '77.269', '86.8', '84', '2018-02-10 00:00:00', 'admin', '2019-03-11 16:11:54', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('2', '2', '1', '87.4878', '88.2', '82.9', '87.4878', '88.2', '82.9', '2018-02-11 00:00:00', 'admin', '2018-02-11 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('3', '3', '1', '86.4716', '91.4', '84.1', '86.4716', '91.4', '84.1', '2018-02-12 00:00:00', 'admin', '2018-02-12 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('4', '4', '1', '84.0597', '90.1', '0', '84.0597', '90.1', '0', '2018-02-13 00:00:00', 'admin', '2018-02-13 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('5', '5', '1', '86.7645', '91.6', '88.3', '86.7645', '91.6', '88.3', '2018-02-14 00:00:00', 'admin', '2018-02-14 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('6', '6', '1', '81.0454', '88.7', '0', '81.0454', '88.7', '0', '2018-02-15 00:00:00', 'admin', '2018-02-15 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('7', '7', '1', '85.3841', '88.8', '80.8', '85.3841', '88.8', '80.8', '2018-02-16 00:00:00', 'admin', '2018-02-16 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('8', '8', '1', '88.6023', '92.1', '91.4', '88.6023', '92.1', '91.4', '2018-02-17 00:00:00', 'admin', '2018-02-17 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('9', '9', '1', '80.0982', '90.5', '0', '80.0982', '90.5', '0', '2018-02-18 00:00:00', 'admin', '2018-02-18 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('10', '10', '1', '87.9889', '89', '79', '87.9889', '89', '79', '2018-02-19 00:00:00', 'admin', '2018-02-19 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('11', '11', '1', '84.106', '83.1', '0', '84.106', '83.1', '0', '2018-02-20 00:00:00', 'admin', '2018-02-20 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('12', '12', '1', '87.3817', '90.8', '88.8', '87.3817', '90.8', '88.8', '2018-02-21 00:00:00', 'admin', '2018-02-21 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('13', '13', '1', '88.5933', '90.5', '83', '88.5933', '90.5', '83', '2018-02-22 00:00:00', 'admin', '2018-02-22 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('14', '14', '1', '88.4937', '92.3', '84.7', '88.4937', '92.3', '84.7', '2018-02-23 00:00:00', 'admin', '2018-02-23 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('15', '15', '1', '87.3257', '93', '0', '87.3257', '93', '0', '2018-02-24 00:00:00', 'admin', '2018-02-24 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('16', '16', '1', '82.1029', '89.5', '0', '82.1029', '89.5', '0', '2018-02-25 00:00:00', 'admin', '2018-02-25 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('17', '17', '1', '83.8107', '88.8', '0', '83.8107', '88.8', '0', '2018-02-26 00:00:00', 'admin', '2018-02-26 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('18', '18', '1', '84.6261', '88.6', '0', '84.6261', '88.6', '0', '2018-02-27 00:00:00', 'admin', '2018-02-27 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('19', '19', '1', '89.067', '88.2', '82', '89.067', '88.2', '82', '2018-02-28 00:00:00', 'admin', '2018-02-28 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('20', '20', '1', '83.929', '89.5', '90.3', '83.929', '89.5', '90.3', '2018-03-01 00:00:00', 'admin', '2018-03-01 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('21', '21', '1', '85.6621', '89.1', '83.3', '85.6621', '89.1', '83.3', '2018-03-02 00:00:00', 'admin', '2018-03-02 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('22', '22', '1', '84.0706', '88.5', '0', '84.0706', '88.5', '0', '2018-03-03 00:00:00', 'admin', '2018-03-03 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('23', '23', '1', '0', '93.8', '0', '0', '93.8', '0', '2018-03-04 00:00:00', 'admin', '2018-03-04 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('24', '24', '1', '85.6706', '92.3', '85', '85.6706', '92.3', '85', '2018-03-05 00:00:00', 'admin', '2018-03-05 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('25', '25', '1', '87.2084', '92.3', '85.6', '87.2084', '92.3', '85.6', '2018-03-06 00:00:00', 'admin', '2018-03-06 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('26', '26', '1', '83.5071', '89.9', '0', '83.5071', '89.9', '0', '2018-03-07 00:00:00', 'admin', '2018-03-07 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('27', '27', '1', '82.4457', '87.8', '0', '82.4457', '87.8', '0', '2018-03-08 00:00:00', 'admin', '2018-03-08 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('28', '28', '1', '82.0186', '87.9', '0', '82.0186', '87.9', '0', '2018-03-09 00:00:00', 'admin', '2018-03-09 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('29', '29', '1', '83.4857', '89.8', '89.3', '83.4857', '89.8', '89.3', '2018-03-10 00:00:00', 'admin', '2018-03-10 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('30', '30', '1', '81.123', '91', '0', '81.123', '91', '0', '2018-03-11 00:00:00', 'admin', '2018-03-11 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('31', '31', '1', '0', '89.7', '0', '0', '89.7', '0', '2018-03-12 00:00:00', 'admin', '2018-03-12 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('32', '32', '1', '82.0972', '90.2', '0', '82.0972', '90.2', '0', '2018-03-13 00:00:00', 'admin', '2018-03-13 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('33', '33', '1', '82.1046', '91.5', '0', '82.1046', '91.5', '0', '2018-03-14 00:00:00', 'admin', '2018-03-14 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('34', '34', '1', '85.3201', '90.2', '84.7', '85.3201', '90.2', '84.7', '2018-03-15 00:00:00', 'admin', '2018-03-15 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('35', '35', '1', '85.939', '91', '87.2', '85.939', '91', '87.2', '2018-03-16 00:00:00', 'admin', '2018-03-16 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('36', '36', '1', '84.7419', '90', '87.6', '84.7419', '90', '87.6', '2018-03-17 00:00:00', 'admin', '2018-03-17 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('37', '37', '1', '82.636', '89.2', '0', '82.636', '89.2', '0', '2018-03-18 00:00:00', 'admin', '2018-03-18 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('38', '38', '1', '82.8243', '88.6', '0', '82.8243', '88.6', '0', '2018-03-19 00:00:00', 'admin', '2018-03-19 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('39', '39', '1', '84.1961', '88.7', '0', '84.1961', '88.7', '0', '2018-03-20 00:00:00', 'admin', '2018-03-20 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('40', '40', '1', '81.3935', '91.5', '0', '81.3935', '91.5', '0', '2018-03-21 00:00:00', 'admin', '2018-03-21 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('41', '41', '1', '83.9987', '90.1', '0', '83.9987', '90.1', '0', '2018-03-22 00:00:00', 'admin', '2018-03-22 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('42', '42', '1', '84.733', '89.1', '0', '84.733', '89.1', '0', '2018-03-23 00:00:00', 'admin', '2018-03-23 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('43', '43', '1', '83.6622', '87.7', '0', '83.6622', '87.7', '0', '2018-03-24 00:00:00', 'admin', '2018-03-24 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('44', '44', '1', '83.7594', '89.2', '0', '83.7594', '89.2', '0', '2018-03-25 00:00:00', 'admin', '2018-03-25 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('45', '45', '1', '84.6367', '87.6', '0', '84.6367', '87.6', '0', '2018-03-26 00:00:00', 'admin', '2018-03-26 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('46', '46', '1', '0', '88.2', '0', '0', '88.2', '0', '2018-03-27 00:00:00', 'admin', '2018-03-27 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('47', '47', '1', '83.4818', '89.4', '0', '83.4818', '89.4', '0', '2018-03-28 00:00:00', 'admin', '2018-03-28 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('48', '48', '1', '82.3038', '89.5', '0', '82.3038', '89.5', '0', '2018-03-29 00:00:00', 'admin', '2018-03-29 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('49', '49', '1', '85.6693', '93.1', '0', '85.6693', '93.1', '0', '2018-03-30 00:00:00', 'admin', '2018-03-30 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('50', '50', '1', '86.881', '90.6', '83.1', '86.881', '90.6', '83.1', '2018-03-31 00:00:00', 'admin', '2018-03-31 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('51', '51', '1', '80.3688', '86.1', '86.6', '80.3688', '86.1', '86.6', '2018-04-01 00:00:00', 'admin', '2018-04-01 00:00:00', 'admin');
INSERT INTO `rxpb_group_info` VALUES ('52', '52', '1', '76.7784', '86.2', '0', '76.7784', '86.2', '0', '2018-04-02 00:00:00', 'admin', '2018-04-02 00:00:00', 'admin');

-- ----------------------------
-- Table structure for `rxpb_role_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_role_info`;
CREATE TABLE `rxpb_role_info` (
  `role_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '"角色ID:1：管理员\n 2：评委 3：工作人员 4:参选单位"\n',
  `role_name` varchar(15) NOT NULL,
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据更新用户',
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COMMENT='用户组信息表';

-- ----------------------------
-- Records of rxpb_role_info
-- ----------------------------
INSERT INTO `rxpb_role_info` VALUES ('1', '管理员', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');
INSERT INTO `rxpb_role_info` VALUES ('2', '评委', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');
INSERT INTO `rxpb_role_info` VALUES ('3', '工作人员', '2017-01-01 00:00:00', 'manual', '2017-01-01 00:00:00', 'manual');
INSERT INTO `rxpb_role_info` VALUES ('4', '参选单位', '2018-12-22 14:20:16', 'manual', '2018-12-22 14:20:16', 'manual');

-- ----------------------------
-- Table structure for `rxpb_score_quality`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_score_quality`;
CREATE TABLE `rxpb_score_quality` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `crab_id` int(11) NOT NULL COMMENT '螃蟹id',
  `group_id` int(11) NOT NULL,
  `crab_sex` int(1) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `score_fin` float DEFAULT NULL COMMENT '最终给分',
  `score_bts` float DEFAULT NULL COMMENT '体色(背)',
  `score_fts` float DEFAULT NULL COMMENT '体色(腹)',
  `score_ec` float DEFAULT NULL COMMENT '额齿',
  `score_dscc` float DEFAULT NULL COMMENT '第4侧齿',
  `score_bbyzt` float DEFAULT NULL COMMENT '背部疣状突',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '数据更新用户',
  `competition_id` int(11) NOT NULL DEFAULT '1' COMMENT '比赛ID',
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8 COMMENT='种质评分表';

-- ----------------------------
-- Records of rxpb_score_quality
-- ----------------------------
INSERT INTO `rxpb_score_quality` VALUES ('41', '146', '1', '0', null, '88', null, null, null, null, null, '2019-01-12 03:12:42', 'staff', '2019-01-12 16:38:45', 'judge', '1');
INSERT INTO `rxpb_score_quality` VALUES ('42', '147', '1', '0', null, '88', null, null, null, null, null, '2019-01-12 03:12:42', 'staff', '2019-01-12 16:50:41', 'judge', '1');
INSERT INTO `rxpb_score_quality` VALUES ('43', '148', '1', '0', null, '88', null, null, null, null, null, '2019-01-12 15:12:42', 'staff', '2019-01-12 15:12:42', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('44', '149', '1', '0', null, '80', null, null, null, null, null, '2019-01-12 15:12:42', 'staff', '2019-01-12 15:12:42', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('45', '150', '1', '0', null, '80', null, null, null, null, null, '2019-01-12 15:12:42', 'staff', '2019-01-12 15:12:42', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('46', '151', '1', '0', null, '90', null, null, null, null, null, '2019-01-12 15:12:43', 'staff', '2019-01-12 15:12:43', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('47', '152', '1', '0', null, '100', null, null, null, null, null, '2019-01-12 15:12:43', 'staff', '2019-01-12 15:12:43', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('51', '156', '1', '1', null, '90', null, null, null, null, null, '2019-01-12 15:12:43', 'staff', '2019-01-12 15:12:43', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('52', '157', '1', '1', null, '98', null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('53', '158', '1', '1', null, '82', null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('54', '159', '1', '1', null, '92', null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('55', '160', '1', '1', null, '92', null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('56', '161', '1', '1', null, '90', null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1');
INSERT INTO `rxpb_score_quality` VALUES ('57', '162', '1', '1', null, '85', null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1');

-- ----------------------------
-- Table structure for `rxpb_score_taste`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_score_taste`;
CREATE TABLE `rxpb_score_taste` (
  `score_id` int(11) NOT NULL AUTO_INCREMENT,
  `crab_id` int(11) NOT NULL COMMENT '螃蟹id',
  `crab_sex` int(1) NOT NULL,
  `group_id` int(11) NOT NULL,
  `score_fin` float DEFAULT NULL COMMENT '最终给分',
  `score_ygys` float DEFAULT NULL COMMENT '蟹盖颜色',
  `score_sys` float DEFAULT NULL COMMENT '鳃颜色',
  `score_ghys` float DEFAULT NULL COMMENT '膏、黄颜色',
  `score_xwxw` float DEFAULT NULL COMMENT '腥味、香味',
  `score_gh` float DEFAULT NULL COMMENT '膏、黄',
  `score_fbjr` float DEFAULT NULL COMMENT '腹部肌肉',
  `score_bzjr` float DEFAULT NULL COMMENT '第二、三步足肌肉',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据创建日期',
  `create_user` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT 'admin' COMMENT '数据创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '数据更新日期',
  `update_user` varchar(45) CHARACTER SET utf8 NOT NULL DEFAULT 'admin' COMMENT '数据更新用户',
  `competition_id` int(11) NOT NULL DEFAULT '1' COMMENT '比赛ID',
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`score_id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=sjis COMMENT='口感奖评分表';

-- ----------------------------
-- Records of rxpb_score_taste
-- ----------------------------
INSERT INTO `rxpb_score_taste` VALUES ('41', '146', '0', '1', '82', null, null, null, null, null, null, null, '2019-01-12 03:12:42', 'staff', '2019-01-12 16:05:37', 'judge', '1', '2');
INSERT INTO `rxpb_score_taste` VALUES ('42', '147', '0', '1', '80', null, null, null, null, null, null, null, '2019-01-12 15:12:42', 'staff', '2019-01-12 15:12:42', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('43', '148', '0', '1', '93', null, null, null, null, null, null, null, '2019-01-12 15:12:42', 'staff', '2019-01-12 15:12:42', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('44', '149', '0', '1', '88', null, null, null, null, null, null, null, '2019-01-12 15:12:42', 'staff', '2019-01-12 15:12:42', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('45', '150', '0', '1', '87', null, null, null, null, null, null, null, '2019-01-12 15:12:42', 'staff', '2019-01-12 15:12:42', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('46', '151', '0', '1', '81', null, null, null, null, null, null, null, '2019-01-12 15:12:43', 'staff', '2019-01-12 15:12:43', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('47', '152', '0', '1', '82', null, null, null, null, null, null, null, '2019-01-12 15:12:43', 'staff', '2019-01-12 15:12:43', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('51', '156', '1', '1', '81', null, null, null, null, null, null, null, '2019-01-12 15:12:43', 'staff', '2019-01-12 15:12:43', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('52', '157', '1', '1', '80', null, null, null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('53', '158', '1', '1', '89', null, null, null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('54', '159', '1', '1', '92', null, null, null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('55', '160', '1', '1', '82', null, null, null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('56', '161', '1', '1', '77', null, null, null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1', null);
INSERT INTO `rxpb_score_taste` VALUES ('57', '162', '1', '1', '68', null, null, null, null, null, null, null, '2019-01-12 15:12:44', 'staff', '2019-01-12 15:12:44', 'staff', '1', null);

-- ----------------------------
-- Table structure for `rxpb_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `rxpb_user_info`;
CREATE TABLE `rxpb_user_info` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `company_id` int(11) DEFAULT NULL COMMENT '对应的参选单位',
  `user_name` varchar(45) NOT NULL COMMENT '用户名,登录名',
  `password` varchar(45) NOT NULL COMMENT '密码',
  `display_name` varchar(45) NOT NULL DEFAULT '未命名用户' COMMENT '显示名称，姓名或单位名',
  `role_id` int(11) NOT NULL COMMENT '角色ID:1-管理员 2-工作人员 3-企业',
  `status` int(11) NOT NULL DEFAULT '0' COMMENT '用户状态 1：可用 0：禁用',
  `email` varchar(45) DEFAULT NULL,
  `competition_id` int(11) NOT NULL DEFAULT '1' COMMENT '''赛事信息（为0时代表永久有效）\n',
  `create_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `create_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '创建用户',
  `update_date` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '更新时间',
  `update_user` varchar(45) NOT NULL DEFAULT 'admin' COMMENT '更新用户',
  `avatar_url` varchar(255) NOT NULL DEFAULT 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg' COMMENT '用户头像URL',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=58 DEFAULT CHARSET=utf8 COMMENT='用户信息表';

-- ----------------------------
-- Records of rxpb_user_info
-- ----------------------------
INSERT INTO `rxpb_user_info` VALUES ('1', null, 'admin', '827CCB0EEA8A706C4C34A16891F84E7B', '管理员1', '1', '1', '15000131965', '1', '2017-01-01 12:00:00', 'manual', '2019-02-05 05:47:26', 'admin1', 'http://spencercjh.top/4afc5e42-bb2f-456d-ab4a-77e2249ede47');
INSERT INTO `rxpb_user_info` VALUES ('2', null, 'judge', '827CCB0EEA8A706C4C34A16891F84E7B', '评委1', '2', '1', '15000131965', '1', '2018-12-22 23:42:57', 'manual', '2018-12-22 23:42:57', 'manual', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('3', null, 'staff', '827CCB0EEA8A706C4C34A16891F84E7B', '工作人员1', '3', '1', '15000131965', '1', '2018-12-22 23:49:34', 'manual', '2018-12-22 23:49:34', 'manual', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('4', null, 'company', '827CCB0EEA8A706C4C34A16891F84E7B', '参选单位1', '4', '1', '15000131965', '1', '2018-12-22 23:50:29', 'admin', '2018-12-22 23:50:29', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('5', null, '15000131965', '827CCB0EEA8A706C4C34A16891F84E7B', '用户15000131965', '4', '0', '15000131965', '1', '2018-12-23 01:09:44', '15000131965', '2018-12-23 01:09:44', '15000131965', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('6', '1', 'comany1', '827CCB0EEA8A706C4C34A16891F84E7B', '昆山常氏蟹业有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('7', '2', 'comany2', '827CCB0EEA8A706C4C34A16891F84E7B', '昆山淀山湖永兴虾蟹养殖农民专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('8', '3', 'company3', '827CCB0EEA8A706C4C34A16891F84E7B', '安庆市皖宜季牛水产养殖有限责任公司 ', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('9', '4', 'company4', '827CCB0EEA8A706C4C34A16891F84E7B', '安徽省五河县大杨湖水产养殖有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('10', '5', 'company5', '827CCB0EEA8A706C4C34A16891F84E7B', '霍邱县城东湖生态水产养殖有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('11', '6', 'company6', '827CCB0EEA8A706C4C34A16891F84E7B', '江苏省盐城市陈长荣大纵湖大闸蟹有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('12', '7', 'company7', '827CCB0EEA8A706C4C34A16891F84E7B', '江苏水景园蟹业有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('13', '8', 'company8', '827CCB0EEA8A706C4C34A16891F84E7B', '江西国营九江县赛城湖水产场', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('14', '9', 'company9', '827CCB0EEA8A706C4C34A16891F84E7B', '江西映虹水产集团有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('15', '10', 'company10', '827CCB0EEA8A706C4C34A16891F84E7B', '泰兴江源农牧有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('16', '11', 'company11\r\n', '827CCB0EEA8A706C4C34A16891F84E7B', '上海惠信水产养殖合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('17', '12', 'company12', '827CCB0EEA8A706C4C34A16891F84E7B', '江西省进贤县皖赣特种水产开发有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('18', '13', 'company13', '827CCB0EEA8A706C4C34A16891F84E7B', '上海松江区水产良种场', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('19', '14', 'company14', '827CCB0EEA8A706C4C34A16891F84E7B', '安徽望江县武昌湖生态渔业有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('20', '15', 'company15', '827CCB0EEA8A706C4C34A16891F84E7B', '九江鄱源生态农业科技发展有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('21', '16', 'company16', '827CCB0EEA8A706C4C34A16891F84E7B', '苏州工业园区唯亭镇鸿澄阳澄湖大闸蟹养殖场', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('22', '17', 'company17', '827CCB0EEA8A706C4C34A16891F84E7B', '安徽当涂县苦莱圩水产养殖有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:15', 'admin', '2018-12-30 01:06:15', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('23', '18', 'company18', '827CCB0EEA8A706C4C34A16891F84E7B', '常州市双丰水产养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('24', '19', 'company19', '827CCB0EEA8A706C4C34A16891F84E7B', '苏州横冠水产有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('25', '20', 'company20', '827CCB0EEA8A706C4C34A16891F84E7B', '东太湖徐福林', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('26', '21', 'company21', '827CCB0EEA8A706C4C34A16891F84E7B', '宝应湖李国庆', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('27', '22', 'company22', '827CCB0EEA8A706C4C34A16891F84E7B', '扬州高邮湖生态渔业公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('28', '23', 'company23', '827CCB0EEA8A706C4C34A16891F84E7B', '江西军山湖生态农业发展有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('29', '24', 'company24', '827CCB0EEA8A706C4C34A16891F84E7B', '江西省进贤县军山湖鱼蟹开发公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('30', '25', 'company25', '827CCB0EEA8A706C4C34A16891F84E7B', '江西省进贤军山湖毛家渡水产有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('31', '26', 'company26', '827CCB0EEA8A706C4C34A16891F84E7B', '扬州湖泊渔业专业合作联社', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('32', '27', 'company27', '827CCB0EEA8A706C4C34A16891F84E7B', '上海春润水产养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('33', '28', 'company28', '827CCB0EEA8A706C4C34A16891F84E7B', '浙江省嘉善县特种水产有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('34', '29', 'company29', '827CCB0EEA8A706C4C34A16891F84E7B', '丰收蟹庄太湖养殖基地', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('35', '30', 'company30', '827CCB0EEA8A706C4C34A16891F84E7B', '上海崇东水产养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('36', '31', 'company31', '827CCB0EEA8A706C4C34A16891F84E7B', '浙江省长兴洪桥漾荡牌河蟹专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('37', '32', 'company32', '827CCB0EEA8A706C4C34A16891F84E7B', '当涂县花津湖水产品有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('38', '33', 'company33', '827CCB0EEA8A706C4C34A16891F84E7B', '微山县永胜河蟹养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('39', '34', 'company34', '827CCB0EEA8A706C4C34A16891F84E7B', '上海瀛生实业有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('40', '35', 'company35', '827CCB0EEA8A706C4C34A16891F84E7B', '江苏省苏州市吴中区临湖现代渔业发展有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('41', '36', 'company36', '827CCB0EEA8A706C4C34A16891F84E7B', '兴化市科兴水产养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('42', '37', 'company37', '827CCB0EEA8A706C4C34A16891F84E7B', '宜兴市高胜滆湖渔场', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('43', '38', 'company38', '827CCB0EEA8A706C4C34A16891F84E7B', '上海杨超水产养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('44', '39', 'company39', '827CCB0EEA8A706C4C34A16891F84E7B', '江苏泗洪县金水集团    ', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('45', '40', 'company40', '827CCB0EEA8A706C4C34A16891F84E7B', '江西九江市赤湖水产场', '4', '1', '15000131965', '1', '2018-12-30 01:06:16', 'admin', '2018-12-30 01:06:16', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('46', '41', 'company41', '827CCB0EEA8A706C4C34A16891F84E7B', '江苏水仙实业有限公司 ', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('47', '42', 'company42', '827CCB0EEA8A706C4C34A16891F84E7B', '上海市瑞华实业公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('48', '43', 'company43', '827CCB0EEA8A706C4C34A16891F84E7B', '重庆渔乐园水产养殖有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('49', '44', 'company44', '827CCB0EEA8A706C4C34A16891F84E7B', '安徽省宣城市金水源农业综合开发有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('50', '45', 'company45', '827CCB0EEA8A706C4C34A16891F84E7B', '湖北汉川天歌螃蟹养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('51', '46', 'company46', '827CCB0EEA8A706C4C34A16891F84E7B', '昆山市锦溪镇新东方水产养殖农民专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('52', '47', 'company47', '827CCB0EEA8A706C4C34A16891F84E7B', '安徽省蒙城县远大河蟹养殖合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('53', '48', 'company48', '827CCB0EEA8A706C4C34A16891F84E7B', '江苏省太仓市十八湾生态水产养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('54', '49', 'company49', '827CCB0EEA8A706C4C34A16891F84E7B', '江西省进贤县陶氏生态水产有限公司', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('55', '50', 'company50', '827CCB0EEA8A706C4C34A16891F84E7B', '上海沪宝水产养殖专业合作社', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('56', '51', 'company51', '827CCB0EEA8A706C4C34A16891F84E7B', '台湾苗栗县政府', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
INSERT INTO `rxpb_user_info` VALUES ('57', '52', 'company52', '827CCB0EEA8A706C4C34A16891F84E7B', '台湾苗栗大闸蟹养殖协会', '4', '1', '15000131965', '1', '2018-12-30 01:06:17', 'admin', '2018-12-30 01:06:17', 'admin', 'http://spencercjh.top/%E4%B8%8A%E6%B5%B7%E6%B5%B7%E6%B4%8B%E5%A4%A7%E5%AD%A6%E6%A0%A1%E5%BE%BD.jpg');
