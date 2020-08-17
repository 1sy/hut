/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : hut

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-08-17 20:43:57
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for book_category
-- ----------------------------
DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目ID',
  `category_type` int(11) NOT NULL COMMENT '类目编号',
  `category_name` varchar(32) DEFAULT NULL COMMENT '类目名称',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`category_id`),
  UNIQUE KEY `uni_category_type` (`category_type`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8mb4 COMMENT='教材类目表';

-- ----------------------------
-- Records of book_category
-- ----------------------------
INSERT INTO `book_category` VALUES ('29', '1', '语文', '2020-02-24 17:17:29', '2020-02-24 17:17:29');
INSERT INTO `book_category` VALUES ('30', '2', '数学', '2020-02-24 17:17:29', '2020-02-24 17:17:29');
INSERT INTO `book_category` VALUES ('31', '3', '英语', '2020-02-24 17:17:29', '2020-02-24 17:17:29');
INSERT INTO `book_category` VALUES ('32', '4', '物理', '2020-02-24 17:17:29', '2020-02-24 17:17:29');
INSERT INTO `book_category` VALUES ('33', '5', '化学', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('34', '6', '生物', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('35', '7', '政治', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('36', '8', '历史', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('37', '9', '地理', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('38', '10', '经济', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('39', '11', '土木', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('40', '12', '外国语', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('41', '13', '计算机', '2020-02-24 17:17:30', '2020-02-24 17:17:30');
INSERT INTO `book_category` VALUES ('47', '99', '99', '2020-08-17 20:31:58', '2020-08-17 20:31:58');

-- ----------------------------
-- Table structure for book_info
-- ----------------------------
DROP TABLE IF EXISTS `book_info`;
CREATE TABLE `book_info` (
  `book_id` varchar(32) NOT NULL COMMENT '教材ID',
  `book_img` varchar(256) DEFAULT NULL COMMENT '教材图片',
  `book_name` varchar(64) DEFAULT NULL COMMENT '教材名称',
  `book_price` decimal(8,2) DEFAULT '0.00' COMMENT '教材价格',
  `book_stock` int(11) DEFAULT '0' COMMENT '库存',
  `book_sales` int(8) DEFAULT '0' COMMENT '教材销量',
  `book_author` varchar(64) DEFAULT NULL COMMENT '教材作者',
  `book_press` varchar(64) DEFAULT NULL COMMENT '出版商',
  `book_introduce` varchar(256) DEFAULT NULL COMMENT '教材简介',
  `book_status` tinyint(1) DEFAULT '1' COMMENT '是否上架',
  `category_type` int(11) DEFAULT '0' COMMENT '类目编号',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`book_id`),
  KEY `index_book_name` (`book_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='教材信息表';

-- ----------------------------
-- Records of book_info
-- ----------------------------
INSERT INTO `book_info` VALUES ('16b00c1cb519451bbcaca08e17d9a271', '/images/bookImg/520315a44ed54750848049ecfa157ecf.jpg', '应用文写作（第四版）', '29.70', '97', '56', '夏晓鸣', '复旦大学出版社', '全国翻译硕士MTI 专业学位考试指定参考书', '1', '1', '2020-03-03 19:45:00', '2020-08-17 20:32:11');
INSERT INTO `book_info` VALUES ('46a10342e11945d78c136340a3af577a', '/images/bookImg/a667981bebe5049ea89f7c5e97d8daf4.jpg', '计算机网络', '99.50', '97', '5', '谢希仁', '电子工业出版社', '“十二五”普通高等教育本科国家级规划教材', '0', '13', '2020-02-21 15:10:45', '2020-05-22 14:25:32');
INSERT INTO `book_info` VALUES ('6a145cb6de8b42048d7be2c8986429c2', '/images/bookImg/e7ffec4aa59e41f0b28e907dfbb311fb.jpg', '政治学', '30.20', '12', '7', '亚里士多德', '台海出版社', '古希腊哲学的集大成者，百科全书式的科学家。亚里士多德关于政体研究的专著，也是西方政治学的开山之作', '1', '7', '2020-03-03 20:30:24', '2020-05-22 14:03:19');
INSERT INTO `book_info` VALUES ('786c6381ec874dec9b6558b5aaae72ba', '/images/bookImg/e40f13bed2674334acc8c8cea434a4f1.jpg', '概率论与数理统计', '42.30', '35', '44', '盛骤', '高等教育出版社', '经典教材，研究生入学考试必备', '1', '2', '2020-03-03 19:22:05', '2020-03-04 09:54:10');
INSERT INTO `book_info` VALUES ('b32095d47f83412d9c8fdfcb662882e5', '/images/bookImg/3de81701d8534c468a2e880ff2ffdf56.jpg', ' 英语笔译实务（二级）', '41.20', '97', '3', '卢敏', '外文出版社', '2017年翻译资格（水平）考试教材全新改版 CATTI应考必备 荟萃专家智慧 紧贴考纲精神', '1', '3', '2020-03-03 19:46:03', '2020-05-22 14:16:15');
INSERT INTO `book_info` VALUES ('c0145ad68690460f811653478e22146c', '/images/bookImg/4ec804f082e946df8de0fda124c9fbec.jpg', '中国地理百科（精装版）', '29.80', '72', '5', '魏红霞', '北京教育出版社', '学生课外必读书', '1', '9', '2020-03-03 20:38:16', '2020-05-17 09:24:52');
INSERT INTO `book_info` VALUES ('c427d2a02d2d42d982f10d500a9253c7', '/images/bookImg/6a360cc88ab9425baa6f32bd3c6a860c.jpg', '线性代数 第六版', '16.90', '87', '1', '同济大学数学系', '高等教育出版社', '同济大学经典教材，近40年畅销不衰，考研必备', '1', '2', '2020-03-03 19:43:08', '2020-03-04 09:54:12');
INSERT INTO `book_info` VALUES ('d8796654d1164179984af423a153bfcb', '/images/bookImg/662fc694c982450ca4c8efcbb6fe871f.jpg', '高等数学', '47.60', '98', '3', '同济大学数学系', '高等教育出版社', '同济大学经典教材，考研参考教材，40年畅销不衰', '1', '2', '2020-03-03 19:40:37', '2020-03-04 09:54:15');
INSERT INTO `book_info` VALUES ('df81d40c22e0478da84a2eca516c59e3', '/images/bookImg/64edf2ba72db42fe80d238970740db7b.jpg', '深入理解JVM&G1GC', '69.00', '48', '105', '周明耀', '电子工业出版社', '计算机优秀读物', '1', '13', '2020-02-24 10:50:13', '2020-03-19 19:54:06');
INSERT INTO `book_info` VALUES ('fda1a8eb17a245e18dad8478dee5406e', '/images/bookImg/9a927b8ecb8e437d9ae6c1e33407b267.jpg', '化学简史', '29.80', '9', '55', 'J.R.柏廷顿', '中国人民大学出版社', '本书脉络清晰，观点客观、公正，目的在于为化学史提供一个简明而权威的综述，以利于读者对化学史产生整体的印象。', '1', '5', '2020-03-03 19:59:42', '2020-08-17 20:30:56');
INSERT INTO `book_info` VALUES ('ff33223409b84ccbb3b4dd8497a6a6c4', '/images/bookImg/1f2205fbc009464f977bf8fe910cd091.jpg', '经济学原理 （第7版）', '128.00', '96', '7', '（美）曼昆', '北京大学出版社', '哈佛大学曼昆教授扛鼎之作，广受欢迎的经济学入门读物，带你迈进经济学的殿堂！', '1', '10', '2020-03-03 19:41:47', '2020-05-21 15:56:53');

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `order_id` varchar(32) NOT NULL COMMENT '订单ID',
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `order_amount` decimal(8,2) DEFAULT '0.00' COMMENT '订单金额',
  `order_status` tinyint(4) DEFAULT '0' COMMENT '订单状态',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单表';

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES ('0c0703bf7ad549b2909e028c23225fad', '16411100214', '29.80', '3', '2020-05-17 09:24:52', '2020-05-17 09:36:23');
INSERT INTO `order` VALUES ('1a8c97f41314464f85cd2adeb09f4327', '16411100211', '209.40', '3', '2020-03-19 15:06:41', '2020-04-12 09:48:53');
INSERT INTO `order` VALUES ('1c36833ce1dd4085a068dda7d0ee685b', '16411100211', '29.80', '2', '2020-03-19 20:04:16', '2020-04-12 08:45:35');
INSERT INTO `order` VALUES ('2c9fb0307bb047488f8174c1d39b634c', '16411100211', '60.00', '3', '2020-04-30 15:35:17', '2020-05-12 16:09:52');
INSERT INTO `order` VALUES ('30e33ad3f49b41298ec7f7938b38f02e', '16411100214', '30.20', '0', '2020-05-20 09:14:39', '2020-05-20 09:14:39');
INSERT INTO `order` VALUES ('4bbb4301d49241358c141d5a2b39a427', '16411100211', '90.60', '2', '2020-03-19 15:05:47', '2020-04-12 08:45:39');
INSERT INTO `order` VALUES ('4e26666e78d14577919d8b7d90233096', '16411100211', '30.20', '1', '2020-03-19 19:57:59', '2020-03-30 09:27:03');
INSERT INTO `order` VALUES ('588acf033aa64cda83f7c5151a00a299', '16411100211', '69.00', '2', '2020-03-19 19:54:06', '2020-04-12 08:45:39');
INSERT INTO `order` VALUES ('793cf1a1b9fc493cb540f7a275bad041', '16411100214', '187.40', '3', '2020-05-20 09:18:38', '2020-05-20 09:20:46');
INSERT INTO `order` VALUES ('82c5988648d640ff8dcbd31f097d5457', '16411100214', '187.40', '3', '2020-05-21 15:56:53', '2020-05-21 15:59:22');
INSERT INTO `order` VALUES ('84be216e76ad49668245fa44a048f283', '16411100211', '199.00', '0', '2020-04-12 15:13:17', '2020-04-12 15:13:17');
INSERT INTO `order` VALUES ('c798181b121c47b6b84130eacc0ad030', '16411100214', '128.00', '0', '2020-05-21 15:56:13', '2020-05-21 15:56:13');
INSERT INTO `order` VALUES ('e940586ac3d9478fa7e3c0374ea0bda3', '16411100211', '29.80', '1', '2020-03-19 20:03:27', '2020-03-28 09:09:34');
INSERT INTO `order` VALUES ('f446184bc3a84519bdaeb4a6bf2550e4', '16411100211', '119.20', '0', '2020-08-17 20:30:56', '2020-08-17 20:30:56');
INSERT INTO `order` VALUES ('fdab8db2fc1744299e837684021a0215', '16411100211', '69.00', '1', '2020-03-19 19:47:29', '2020-03-28 09:10:09');

-- ----------------------------
-- Table structure for order_address
-- ----------------------------
DROP TABLE IF EXISTS `order_address`;
CREATE TABLE `order_address` (
  `order_id` varchar(32) NOT NULL COMMENT '订单ID',
  `addressee_name` varchar(32) DEFAULT NULL COMMENT '姓名',
  `addressee_telephone` varchar(11) DEFAULT NULL COMMENT '手机号码',
  `addressee_address` varchar(256) DEFAULT NULL COMMENT '详细地址',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='收货地址表';

-- ----------------------------
-- Records of order_address
-- ----------------------------
INSERT INTO `order_address` VALUES ('4bbb4301d49241358c141d5a2b39a427', '李世䶮', '13135333565', '河北省武安市', '2020-03-19 15:05:47', '2020-03-19 15:05:47');
INSERT INTO `order_address` VALUES ('1a8c97f41314464f85cd2adeb09f4327', '李', '13135333565', '湖南省株洲市', '2020-03-19 15:06:41', '2020-03-19 15:06:41');
INSERT INTO `order_address` VALUES ('fdab8db2fc1744299e837684021a0215', '张三', '13135333565', '北京市', '2020-03-19 19:47:29', '2020-03-19 19:47:29');
INSERT INTO `order_address` VALUES ('588acf033aa64cda83f7c5151a00a299', 'redisDelete', '11111111111', '1', '2020-03-19 19:54:06', '2020-03-19 19:54:06');
INSERT INTO `order_address` VALUES ('4e26666e78d14577919d8b7d90233096', 'qwe', '11111111111', '1', '2020-03-19 19:57:59', '2020-03-19 19:57:59');
INSERT INTO `order_address` VALUES ('e940586ac3d9478fa7e3c0374ea0bda3', 'qwe', '11111111111', 'qwe', '2020-03-19 20:03:27', '2020-03-19 20:03:27');
INSERT INTO `order_address` VALUES ('1c36833ce1dd4085a068dda7d0ee685b', 'qwe', '11111111111', '1', '2020-03-19 20:04:16', '2020-03-19 20:04:16');
INSERT INTO `order_address` VALUES ('84be216e76ad49668245fa44a048f283', '李', '13135333565', '河北省武安市', '2020-04-12 15:13:17', '2020-04-12 15:13:17');
INSERT INTO `order_address` VALUES ('2c9fb0307bb047488f8174c1d39b634c', '郭', '13135333565', '河北省邢台市', '2020-04-30 15:35:17', '2020-04-30 15:35:17');
INSERT INTO `order_address` VALUES ('0c0703bf7ad549b2909e028c23225fad', '李', '13135333565', '湖南省株洲市', '2020-05-17 09:24:52', '2020-05-17 09:24:52');
INSERT INTO `order_address` VALUES ('30e33ad3f49b41298ec7f7938b38f02e', '李', '13135333565', '河北省武安市', '2020-05-20 09:14:39', '2020-05-20 09:14:39');
INSERT INTO `order_address` VALUES ('793cf1a1b9fc493cb540f7a275bad041', '李', '13135333565', '河北省武安市', '2020-05-20 09:18:38', '2020-05-20 09:18:38');
INSERT INTO `order_address` VALUES ('c798181b121c47b6b84130eacc0ad030', '李', '13135333565', '河北省武安市', '2020-05-21 15:56:13', '2020-05-21 15:56:13');
INSERT INTO `order_address` VALUES ('82c5988648d640ff8dcbd31f097d5457', '李', '13135333565', '河北省武安市', '2020-05-21 15:56:53', '2020-05-21 15:56:53');
INSERT INTO `order_address` VALUES ('f446184bc3a84519bdaeb4a6bf2550e4', 'qwe', '11111111111', 'qwe', '2020-08-17 20:30:56', '2020-08-17 20:30:56');

-- ----------------------------
-- Table structure for order_item
-- ----------------------------
DROP TABLE IF EXISTS `order_item`;
CREATE TABLE `order_item` (
  `order_id` varchar(32) DEFAULT NULL COMMENT '订单ID',
  `book_id` varchar(32) DEFAULT NULL COMMENT '教材ID',
  `buy_number` int(16) DEFAULT NULL COMMENT '购买数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  KEY `order_id` (`order_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='订单明细表';

-- ----------------------------
-- Records of order_item
-- ----------------------------
INSERT INTO `order_item` VALUES ('4bbb4301d49241358c141d5a2b39a427', '6a145cb6de8b42048d7be2c8986429c2', '3', '2020-03-19 15:05:47', '2020-03-19 15:05:47');
INSERT INTO `order_item` VALUES ('1a8c97f41314464f85cd2adeb09f4327', 'c0145ad68690460f811653478e22146c', '5', '2020-03-19 15:06:41', '2020-03-19 15:06:41');
INSERT INTO `order_item` VALUES ('1a8c97f41314464f85cd2adeb09f4327', '6a145cb6de8b42048d7be2c8986429c2', '2', '2020-03-19 15:06:41', '2020-03-19 15:06:41');
INSERT INTO `order_item` VALUES ('fdab8db2fc1744299e837684021a0215', 'df81d40c22e0478da84a2eca516c59e3', '1', '2020-03-19 19:47:29', '2020-03-19 19:47:29');
INSERT INTO `order_item` VALUES ('588acf033aa64cda83f7c5151a00a299', 'df81d40c22e0478da84a2eca516c59e3', '1', '2020-03-19 19:54:06', '2020-03-19 19:54:06');
INSERT INTO `order_item` VALUES ('4e26666e78d14577919d8b7d90233096', '6a145cb6de8b42048d7be2c8986429c2', '1', '2020-03-19 19:57:59', '2020-03-19 19:57:59');
INSERT INTO `order_item` VALUES ('e940586ac3d9478fa7e3c0374ea0bda3', 'c0145ad68690460f811653478e22146c', '1', '2020-03-19 20:03:27', '2020-03-19 20:03:27');
INSERT INTO `order_item` VALUES ('1c36833ce1dd4085a068dda7d0ee685b', 'c0145ad68690460f811653478e22146c', '1', '2020-03-19 20:04:16', '2020-03-19 20:04:16');
INSERT INTO `order_item` VALUES ('84be216e76ad49668245fa44a048f283', '46a10342e11945d78c136340a3af577a', '2', '2020-04-12 15:13:17', '2020-04-12 15:13:17');
INSERT INTO `order_item` VALUES ('2c9fb0307bb047488f8174c1d39b634c', '6a145cb6de8b42048d7be2c8986429c2', '1', '2020-04-30 15:35:17', '2020-04-30 15:35:17');
INSERT INTO `order_item` VALUES ('2c9fb0307bb047488f8174c1d39b634c', 'c0145ad68690460f811653478e22146c', '1', '2020-04-30 15:35:17', '2020-04-30 15:35:17');
INSERT INTO `order_item` VALUES ('0c0703bf7ad549b2909e028c23225fad', 'c0145ad68690460f811653478e22146c', '1', '2020-05-17 09:24:52', '2020-05-17 09:24:52');
INSERT INTO `order_item` VALUES ('30e33ad3f49b41298ec7f7938b38f02e', '6a145cb6de8b42048d7be2c8986429c2', '1', '2020-05-20 09:14:39', '2020-05-20 09:14:39');
INSERT INTO `order_item` VALUES ('793cf1a1b9fc493cb540f7a275bad041', '16b00c1cb519451bbcaca08e17d9a271', '2', '2020-05-20 09:18:38', '2020-05-20 09:18:38');
INSERT INTO `order_item` VALUES ('793cf1a1b9fc493cb540f7a275bad041', 'ff33223409b84ccbb3b4dd8497a6a6c4', '1', '2020-05-20 09:18:38', '2020-05-20 09:18:38');
INSERT INTO `order_item` VALUES ('c798181b121c47b6b84130eacc0ad030', 'ff33223409b84ccbb3b4dd8497a6a6c4', '1', '2020-05-21 15:56:13', '2020-05-21 15:56:13');
INSERT INTO `order_item` VALUES ('82c5988648d640ff8dcbd31f097d5457', 'ff33223409b84ccbb3b4dd8497a6a6c4', '1', '2020-05-21 15:56:53', '2020-05-21 15:56:53');
INSERT INTO `order_item` VALUES ('82c5988648d640ff8dcbd31f097d5457', '16b00c1cb519451bbcaca08e17d9a271', '1', '2020-05-21 15:56:53', '2020-05-21 15:56:53');
INSERT INTO `order_item` VALUES ('f446184bc3a84519bdaeb4a6bf2550e4', 'fda1a8eb17a245e18dad8478dee5406e', '2', '2020-08-17 20:30:56', '2020-08-17 20:30:56');

-- ----------------------------
-- Table structure for shopping_cart
-- ----------------------------
DROP TABLE IF EXISTS `shopping_cart`;
CREATE TABLE `shopping_cart` (
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `book_id` varchar(32) NOT NULL COMMENT '教材ID',
  `buy_number` int(11) DEFAULT '1' COMMENT '购买数量',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='购物车表';

-- ----------------------------
-- Records of shopping_cart
-- ----------------------------

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户ID',
  `user_name` varchar(32) DEFAULT NULL COMMENT '用户昵称',
  `user_password` varchar(128) DEFAULT NULL COMMENT '登录密码',
  `user_img` varchar(256) DEFAULT NULL COMMENT '用户头像',
  `user_email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `user_balance` decimal(10,2) DEFAULT '0.00' COMMENT '余额',
  `user_level` tinyint(1) DEFAULT '0' COMMENT '权限等级 0=学生/1=管理员',
  `create_time` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`user_id`),
  KEY `index_user_name` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=16411100215 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('16411100211', 'qwe', 'qwe', '/images/userImg/f07aee9cc62f423aaf9fcb0037623af7.png', '736165936@qq.com', '9956.00', '0', '2020-02-06 17:28:59', '2020-08-17 20:30:56');
INSERT INTO `user` VALUES ('16411100214', 'asd', 'asd', '/images/userImg/3d6e538074d34b39971fc616e4986e7b.png', null, '9474.60', '1', '2020-02-06 17:36:01', '2020-05-21 15:59:22');
