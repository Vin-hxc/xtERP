/*
Navicat MySQL Data Transfer

Source Server         : snow
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : erp

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2019-12-20 11:37:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `account`
-- ----------------------------
DROP TABLE IF EXISTS `account`;
CREATE TABLE `account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `supplier` bigint(20) NOT NULL COMMENT '供应商编号',
  `date_created` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `remark` varchar(200) DEFAULT NULL COMMENT '描述',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '删除标记 0未删除 1删除',
  `cardNumber` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_supplier` (`supplier`),
  CONSTRAINT `fk_supplier` FOREIGN KEY (`supplier`) REFERENCES `supplier` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of account
-- ----------------------------

-- ----------------------------
-- Table structure for `applyfor`
-- ----------------------------
DROP TABLE IF EXISTS `applyfor`;
CREATE TABLE `applyfor` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `type` varchar(20) DEFAULT NULL COMMENT '申请类型',
  `productId` bigint(20) DEFAULT NULL COMMENT '产品编号',
  `number` bigint(20) DEFAULT NULL COMMENT '数量',
  `itemDescribe` varchar(200) DEFAULT NULL COMMENT '物品描述',
  `approval` int(5) NOT NULL DEFAULT '0' COMMENT '默认0；1审批通过，2不通过审批',
  `proposer` bigint(20) DEFAULT NULL COMMENT '申请人',
  `auditor` bigint(20) DEFAULT NULL COMMENT '审批人',
  `deleteflag` int(1) DEFAULT NULL COMMENT '标记删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of applyfor
-- ----------------------------

-- ----------------------------
-- Table structure for `assemble`
-- ----------------------------
DROP TABLE IF EXISTS `assemble`;
CREATE TABLE `assemble` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `productId` bigint(20) DEFAULT NULL COMMENT '产品编号',
  `pickingId` bigint(20) DEFAULT NULL COMMENT '领料编号',
  `assembyTime` datetime DEFAULT NULL COMMENT '组装时间',
  `assembyendTime` datetime DEFAULT NULL COMMENT '组装结束时间',
  `assembledProducts` varchar(20) DEFAULT NULL COMMENT '组装成品',
  `qualityTesting` int(4) DEFAULT NULL COMMENT '派工审核是否通过0-通过，1-不通过',
  `deleteAsse` int(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of assemble
-- ----------------------------

-- ----------------------------
-- Table structure for `cost`
-- ----------------------------
DROP TABLE IF EXISTS `cost`;
CREATE TABLE `cost` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `orderId` bigint(20) DEFAULT NULL COMMENT '外键,采购订单',
  `costtype` varchar(100) DEFAULT NULL COMMENT '支出项目',
  `costprice` decimal(24,6) DEFAULT NULL COMMENT '支出费用',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cost
-- ----------------------------
INSERT INTO `cost` VALUES ('1', '1001', 'aaa', '1500000.000000');
INSERT INTO `cost` VALUES ('2', '1002', 'bbb', '2500000.000000');
INSERT INTO `cost` VALUES ('3', '1003', 'ccc', '850000.000000');

-- ----------------------------
-- Table structure for `depot`
-- ----------------------------
DROP TABLE IF EXISTS `depot`;
CREATE TABLE `depot` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(20) DEFAULT NULL COMMENT '仓库名称',
  `address` varchar(50) DEFAULT NULL COMMENT '仓库地址',
  `truckage` decimal(24,6) DEFAULT NULL COMMENT '搬运费',
  `type` varchar(20) DEFAULT NULL,
  `sort` varchar(10) DEFAULT NULL COMMENT '排序',
  `remark` varchar(100) DEFAULT NULL COMMENT '描述',
  `principal` bigint(20) DEFAULT NULL COMMENT '负责人',
  `deleteFlag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  `isDefault` bit(1) DEFAULT NULL COMMENT '是否默认',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depot
-- ----------------------------
INSERT INTO `depot` VALUES ('1', '长沙总仓', '岳麓区A区一栋', '400.000000', '商品存储库', '一', '用于存放成品，与商品', '797', '0', '');
INSERT INTO `depot` VALUES ('2', '岳麓零件仓', '岳麓区A区二栋', '450.000000', '零件存储库', '二', '采购之后存入此库，用于存放零件', '10086', '0', '');
INSERT INTO `depot` VALUES ('3', '废品仓', '岳麓区A区三栋', '390.000000', '报废品存储库', '三', '用于存放废品，生产报废物件', '1001', '0', '');

-- ----------------------------
-- Table structure for `depothead`
-- ----------------------------
DROP TABLE IF EXISTS `depothead`;
CREATE TABLE `depothead` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `Type` varchar(50) DEFAULT NULL COMMENT '类型(出库/入库)',
  `Number` varchar(50) DEFAULT NULL COMMENT '票据号',
  `OperPersonName` varchar(50) DEFAULT NULL COMMENT '操作员名字',
  `CreateTime` datetime DEFAULT NULL COMMENT '创建时间',
  `OperTime` datetime DEFAULT NULL COMMENT '出入库时间',
  `OrganId` bigint(20) DEFAULT NULL COMMENT '供应商Id',
  `HandsPersonId` bigint(20) DEFAULT NULL COMMENT '采购/领料-经手人Id',
  `AccountId` bigint(20) DEFAULT NULL COMMENT '账户Id',
  `ChangeAmount` decimal(24,6) DEFAULT NULL COMMENT '变动金额(收款/付款)',
  `TotalPrice` decimal(24,6) DEFAULT NULL COMMENT '合计金额',
  `PayType` varchar(50) DEFAULT NULL COMMENT '付款类型(现金、记账等)',
  `Remark` varchar(1000) DEFAULT NULL COMMENT '备注',
  `AccountDay` int(10) DEFAULT NULL COMMENT '结算天数',
  `Status` varchar(1) DEFAULT '0' COMMENT '状态，0未审核、1已审核、2已转采购|销售',
  `deleteFlag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  `materialId` int(20) DEFAULT NULL COMMENT '材料id',
  `amount` int(20) DEFAULT NULL COMMENT '数量',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depothead
-- ----------------------------
INSERT INTO `depothead` VALUES ('1', '零件入库', 'lj1000', '张三', '2010-02-18 09:40:16', '2010-02-23 09:40:35', '1', '1', null, '30.000000', '3000.000000', '银联', '123', '360', '1', '0', '1001', '200');
INSERT INTO `depothead` VALUES ('2', '零件入库', 'lj1001', '张三', '2011-03-16 09:47:54', '2011-03-01 09:48:07', '2', '2', null, '60.000000', '6000.000000', '银联', '456', '100', '1', '0', '1002', '300');
INSERT INTO `depothead` VALUES ('3', '零件出库', 'ljc1002', '李四', '2012-01-18 09:50:24', '2012-01-18 09:50:34', null, '3', null, '15.000000', '150.000000', null, '用于生产', '100', '1', '0', '1003', '16');
INSERT INTO `depothead` VALUES ('4', '成品出库', 'cpc1000', '王五', '2019-12-18 11:40:32', '2019-12-18 14:06:56', null, '1005', null, '100.000000', '10000.000000', '银联', '客户的货', '100', '1', '0', '1005', '300');
INSERT INTO `depothead` VALUES ('5', '零件出库', '10252', '张三', '2010-01-18 17:06:38', '2010-01-19 17:06:49', null, null, null, '30.000000', '15000.000000', null, '0000', '360', '1', '0', '1010', '500');
INSERT INTO `depothead` VALUES ('6', '成品入库', '12211', '张三', '2019-12-18 17:10:16', '2019-12-18 17:10:22', null, null, null, '30.000000', '9000.000000', null, '2222', '1000', '1', '0', '1005', '300');
INSERT INTO `depothead` VALUES ('7', '零件出库', '8554', '李四', '2019-12-19 10:15:16', null, null, null, null, '200.000000', '20000.000000', null, '尔特', '360', '0', '0', '1013', '100');
INSERT INTO `depothead` VALUES ('8', '成品出库', '2054', '王五', '2019-12-19 10:20:56', null, null, null, null, '5400.000000', '540000.000000', null, '事实上', '360', '1', '0', '1009', '100');

-- ----------------------------
-- Table structure for `depotitem`
-- ----------------------------
DROP TABLE IF EXISTS `depotitem`;
CREATE TABLE `depotitem` (
  `Id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `HeaderId` bigint(20) DEFAULT NULL COMMENT '表头Id',
  `MaterialId` bigint(20) NOT NULL COMMENT '材料Id',
  `BasicNumber` int(24) DEFAULT NULL COMMENT '基础数量，如kg、瓶',
  `UnitPrice` decimal(24,6) DEFAULT NULL COMMENT '单价',
  `AllPrice` decimal(24,6) DEFAULT NULL COMMENT '金额',
  `Remark` varchar(200) DEFAULT NULL COMMENT '描述',
  `Img` varchar(50) DEFAULT NULL COMMENT '图片',
  `DepotId` bigint(20) DEFAULT NULL COMMENT '仓库ID（库存是统计出来的）',
  `deleteFlag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depotitem
-- ----------------------------
INSERT INTO `depotitem` VALUES ('1', null, '1000', '100', '60.000000', '6000.000000', '000', 'df68bca5-23ca-4734-99cf-f252c1b6dde4.jpeg', '2', '0');
INSERT INTO `depotitem` VALUES ('2', null, '1001', '60', '30.000000', '1800.000000', '000', '88a8fd1a-d540-4ecc-9a62-54d11d6b6c28.jpeg', '2', '0');
INSERT INTO `depotitem` VALUES ('3', null, '1002', '70', '30.000000', '2100.000000', '000', 'c4e67c8a-c8af-499b-b76c-06cdd916a65d.jpeg', '2', '1');
INSERT INTO `depotitem` VALUES ('4', null, '1003', '45', '60.000000', '2700.000000', '000', '0', '2', '0');
INSERT INTO `depotitem` VALUES ('5', '4', '1005', '100', '100.000000', '10000.000000', null, '0', '1', '0');

-- ----------------------------
-- Table structure for `detailed`
-- ----------------------------
DROP TABLE IF EXISTS `detailed`;
CREATE TABLE `detailed` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `orderid` bigint(20) DEFAULT NULL COMMENT '采购订单编号',
  `storehouseid` bigint(20) DEFAULT NULL COMMENT '仓库表编号',
  `goodsid` bigint(20) DEFAULT NULL COMMENT '商品明细',
  `number` int(5) DEFAULT NULL COMMENT '数量',
  `tax` int(5) DEFAULT NULL COMMENT '税率',
  `price` decimal(24,6) DEFAULT NULL COMMENT '物品单价',
  `remarks` varchar(200) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of detailed
-- ----------------------------
INSERT INTO `detailed` VALUES ('1', '1001', '1', '1', '2000', '100', '20000.000000', '电脑');
INSERT INTO `detailed` VALUES ('2', '1002', '2', '2', '500', '100', '5000.000000', '手机');
INSERT INTO `detailed` VALUES ('3', '1003', '3', '3', '1000', '100', '6300.000000', '手机');

-- ----------------------------
-- Table structure for `dispatchedworker`
-- ----------------------------
DROP TABLE IF EXISTS `dispatchedworker`;
CREATE TABLE `dispatchedworker` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `dispatchedNo` bigint(20) DEFAULT NULL COMMENT '派工id',
  `monitor` bigint(20) DEFAULT NULL COMMENT '负责班长id',
  `dispatchingTime` datetime DEFAULT NULL COMMENT '派工时间',
  `dispatchedAudits` int(4) DEFAULT NULL COMMENT '派工审核是否通过0-通过，1-不通过',
  `deleteDw` int(1) DEFAULT NULL COMMENT '删除标记',
  `pickingid` int(20) DEFAULT NULL COMMENT '领料id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dispatchedworker
-- ----------------------------

-- ----------------------------
-- Table structure for `expenditure`
-- ----------------------------
DROP TABLE IF EXISTS `expenditure`;
CREATE TABLE `expenditure` (
  `expenditureId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `type` varchar(20) DEFAULT NULL,
  `paymentAmount` decimal(24,6) NOT NULL COMMENT '支付金额',
  `actualPayment` decimal(24,6) DEFAULT NULL COMMENT '实际金额',
  `balancePayment` decimal(24,6) DEFAULT NULL COMMENT '尾款',
  `dateReceopt` datetime DEFAULT NULL COMMENT '出账时间',
  `account` varchar(20) NOT NULL COMMENT '收款方账户',
  `confirmPayment` int(1) NOT NULL COMMENT '是否确认收款 0：未收款；1：确认；默认：0；审批字段',
  `remark` varchar(200) DEFAULT NULL COMMENT '描述',
  `principal` bigint(20) DEFAULT NULL COMMENT '负责人 用户编号',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '删除 0未删除 1已删除',
  `stateClose` int(1) DEFAULT NULL,
  PRIMARY KEY (`expenditureId`),
  KEY `fk_account` (`account`),
  KEY `fk_principal_expenditure` (`principal`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of expenditure
-- ----------------------------
INSERT INTO `expenditure` VALUES ('1', '1', '10000.000000', '10000.000000', '0.000000', '2010-06-07 14:24:02', '123456789', '1', '1024578', '1', '0', '1');
INSERT INTO `expenditure` VALUES ('2', '2', '3040.000000', '3040.000000', '0.000000', '2010-01-07 14:24:57', '0', '1', '123456789', '1', '0', '1');
INSERT INTO `expenditure` VALUES ('3', '3', '657000.000000', '657000.000000', '0.000000', '2010-12-30 14:26:01', '12355888888', '1', '老板大气！！！', '1', '0', '1');
INSERT INTO `expenditure` VALUES ('4', '3', '389450.000000', '389450.000000', '0.000000', '2011-12-07 15:03:12', '12358796', '1', '11212121212', '1', '0', '1');
INSERT INTO `expenditure` VALUES ('5', '2', '450000.000000', '450000.000000', '0.000000', '2011-01-07 15:04:45', '257863555', '1', null, '1', '0', '1');
INSERT INTO `expenditure` VALUES ('6', '采购', '3000.000000', '3000.000000', '0.000000', '2019-12-13 10:15:38', '156156156', '1', '无法可说', '0', '0', '0');
INSERT INTO `expenditure` VALUES ('7', '采购', '8000.000000', '8000.000000', '0.000000', '2019-12-19 15:49:32', '156156156', '0', '123131213232', '1', '0', '0');

-- ----------------------------
-- Table structure for `financialsettlement`
-- ----------------------------
DROP TABLE IF EXISTS `financialsettlement`;
CREATE TABLE `financialsettlement` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `totalMoney` decimal(24,6) NOT NULL COMMENT '总金额',
  `balanceDate` datetime NOT NULL COMMENT '结算时间',
  `userId` bigint(20) NOT NULL COMMENT '负责人 用户编号',
  `remark` varchar(200) DEFAULT NULL COMMENT '描述',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '删除标记 0未删除 1删除',
  `type` int(1) DEFAULT NULL COMMENT '结算类型 1支出 2收入',
  PRIMARY KEY (`id`),
  KEY `fk_user_gross` (`userId`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of financialsettlement
-- ----------------------------
INSERT INTO `financialsettlement` VALUES ('0', '200000.000000', '2010-11-01 11:56:59', '0', '', '0', '2');
INSERT INTO `financialsettlement` VALUES ('1', '135702.000000', '2010-12-07 12:09:27', '0', null, '0', '1');
INSERT INTO `financialsettlement` VALUES ('2', '500000.000000', '2011-12-07 12:24:39', '1', null, '0', '2');
INSERT INTO `financialsettlement` VALUES ('3', '342507.000000', '2011-03-11 10:32:05', '1', null, '0', '1');
INSERT INTO `financialsettlement` VALUES ('4', '259401.000000', '2013-01-11 10:33:22', '2', null, '0', '1');
INSERT INTO `financialsettlement` VALUES ('5', '401525.000000', '2013-12-11 10:33:56', '2', null, '0', '2');
INSERT INTO `financialsettlement` VALUES ('6', '201440.000000', '2019-12-14 20:16:51', '1008611', '123132132132', '0', '2');

-- ----------------------------
-- Table structure for `functions`
-- ----------------------------
DROP TABLE IF EXISTS `functions`;
CREATE TABLE `functions` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `number` varchar(50) DEFAULT NULL COMMENT '编码',
  `name` varchar(50) DEFAULT NULL COMMENT '名称',
  `parentId` varchar(50) DEFAULT NULL COMMENT '上级编码',
  `url` varchar(255) DEFAULT NULL COMMENT '链接',
  `state` bit(1) DEFAULT NULL COMMENT '是否收缩',
  `sort` varchar(50) DEFAULT NULL COMMENT '排序',
  `enabled` bit(1) DEFAULT NULL COMMENT '是否启用',
  `ioce` varchar(50) DEFAULT NULL COMMENT '图标名',
  `deleteFlag` varchar(1) DEFAULT '0' COMMENT '删除标记 0未删除 1未删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `number` (`number`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of functions
-- ----------------------------
INSERT INTO `functions` VALUES ('1', '001', '小三', '002', '168.128.11', '', '20', '', '1', '0');
INSERT INTO `functions` VALUES ('2', '002', '小四', '003', '128.156.11', '', '20', '', '1', '0');
INSERT INTO `functions` VALUES ('3', '003', '小五', '004', '128.154.11', '', '10', '', '1', '0');

-- ----------------------------
-- Table structure for `income`
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `incomeId` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `clientid` bigint(20) NOT NULL COMMENT '客户编号',
  `payable` decimal(24,6) NOT NULL COMMENT '应付金额',
  `actualPayment` decimal(24,6) DEFAULT NULL COMMENT '实际金额',
  `balancePayment` decimal(24,6) DEFAULT NULL COMMENT '尾款',
  `dateRecorded` datetime DEFAULT NULL,
  `confirmReceipt` int(1) NOT NULL COMMENT '是否确认收款 0：未收款；1：确认；默认：0；审批字段',
  `remark` varchar(200) DEFAULT NULL COMMENT '描述',
  `principal` bigint(20) DEFAULT NULL COMMENT '负责人 用户编号',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '删除 0未删除 1已删除',
  `paymentMethod` varchar(20) DEFAULT NULL,
  `stateClose` int(1) DEFAULT NULL,
  PRIMARY KEY (`incomeId`),
  KEY `fk_principal_income` (`principal`),
  KEY `fk_client` (`clientid`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES ('1', '0', '10000.000000', '10000.000000', '0.000000', '2011-02-14 12:10:31', '1', '感谢老板', '0', '0', '全款', '1');
INSERT INTO `income` VALUES ('2', '0', '600000.000000', '310000.000000', '290000.000000', '2011-12-07 14:20:32', '1', '谢谢老板', '0', '0', '记账', '1');
INSERT INTO `income` VALUES ('3', '0', '987456.000000', '987456.000000', '0.000000', '2012-12-07 14:21:44', '1', null, '0', '0', '全款', '1');
INSERT INTO `income` VALUES ('4', '0', '653400.000000', '653400.000000', '0.000000', '2011-12-07 15:07:58', '1', null, '0', '0', '全款', '1');
INSERT INTO `income` VALUES ('5', '0', '223560.000000', '223560.000000', '0.000000', '2010-06-09 15:09:36', '1', null, '0', '0', '全款', '1');
INSERT INTO `income` VALUES ('6', '4', '10000.000000', '9500.000000', '500.000000', '2019-12-13 15:03:21', '0', '不知道把钱一起结了', '10086', '0', '定金', '1');
INSERT INTO `income` VALUES ('7', '7', '201440.000000', '201440.000000', null, '2015-12-14 17:11:06', '1', '1111', '10086', '0', '全款', '1');

-- ----------------------------
-- Table structure for `leave`
-- ----------------------------
DROP TABLE IF EXISTS `leave`;
CREATE TABLE `leave` (
  `leaveId` int(5) NOT NULL AUTO_INCREMENT COMMENT '请假编号',
  `userId` int(5) NOT NULL COMMENT '员工编号',
  `reason` varchar(200) NOT NULL COMMENT '请假原因',
  `startTime` datetime DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '结束时间',
  `allHour` decimal(5,2) DEFAULT NULL COMMENT '总时长（天）如：0.5半天',
  `verifyStatus` int(2) DEFAULT NULL COMMENT '是否同意请假',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`leaveId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of leave
-- ----------------------------

-- ----------------------------
-- Table structure for `log`
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `userID` bigint(20) DEFAULT NULL COMMENT '操作用户ID',
  `operation` varchar(500) DEFAULT NULL COMMENT '操作模块名称',
  `clientIP` varchar(50) DEFAULT NULL COMMENT '客户端IP',
  `createtime` datetime DEFAULT NULL COMMENT '创建时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '操作状态 0==成功，1==失败',
  `contentdetails` varchar(1000) DEFAULT NULL COMMENT '操作详情',
  `remark` varchar(500) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES ('1', '1', '小三', '168.154.11', '2019-12-02 11:52:12', '0', '无', '111');
INSERT INTO `log` VALUES ('2', '2', '小四', '128.146.11', '2019-12-01 11:53:08', '0', '完美', '222');
INSERT INTO `log` VALUES ('3', '3', '小五', '168.112.11', '2019-12-09 11:53:56', '0', '123', '333');

-- ----------------------------
-- Table structure for `materials`
-- ----------------------------
DROP TABLE IF EXISTS `materials`;
CREATE TABLE `materials` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT '材料id',
  `mName` varchar(20) NOT NULL COMMENT '名称',
  `remark` varchar(500) DEFAULT NULL COMMENT '描述',
  `mtype` varchar(20) DEFAULT NULL,
  `mUnit` varchar(20) DEFAULT NULL,
  `price` double(10,3) NOT NULL,
  `designation` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1014 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of materials
-- ----------------------------
INSERT INTO `materials` VALUES ('1000', 'CPU', 'cpu类型，归类编号', '零件', '个', '1000.000', '英特尔（Intel）i5 9400F 酷睿六核 盒装CPU处理器');
INSERT INTO `materials` VALUES ('1001', '主板', '主板类型编号', '零件', '个', '3000.000', '玩家国度ROG STRIX Z390-E GAMING 主板（Intel Z390/LGA 1151)');
INSERT INTO `materials` VALUES ('1002', '内存条', '内存条类型编号', '零件', '个', '200.000', '金士顿(Kingston) DDR4 2666 8GB 台式机内存条 骇客神条 Fury雷电系列');
INSERT INTO `materials` VALUES ('1003', '集成显卡', '集成显卡类型编号', '零件', '个', '1500.000', '影驰 GeForce GTX1660TI 6G/1660/1660S 台式机电脑主机独立游戏吃鸡显卡 GTX1660 6G 大将');
INSERT INTO `materials` VALUES ('1004', '独立显卡', '独立显卡类型编号', '零件', '个', '2000.000', '华硕（ASUS）ROG-STRIX-GeForce RTX2060-O6G-GAMING 1365-1860MHz 14000MHz猛禽游戏电竞显卡');
INSERT INTO `materials` VALUES ('1005', '鼠标', '鼠标类型', '成品', '个', '90.000', '罗技（G）G102有线鼠标 8000DPI');
INSERT INTO `materials` VALUES ('1006', '键盘', '键盘类型', '成品', '个', '30.000', '罗技（Logitech）MK120 键鼠套装');
INSERT INTO `materials` VALUES ('1007', '耳机', '耳机类型', '成品', '只', '2000.000', '索尼（SONY）WH-1000XM3');
INSERT INTO `materials` VALUES ('1008', '笔记本', '笔记本类型', '成品', '个', '5700.000', '联想ThinkPad 翼490(E490 25CD)英特尔酷睿i5 14英寸轻薄笔记本电脑(i5-8265U 8G 512GSSD 2G独显 FHD)冰原银');
INSERT INTO `materials` VALUES ('1009', '台式组装成品', '台式电脑', '成品', '台', '5400.000', '联想(Lenovo)天逸510 Pro英特尔酷睿i5 台式机电脑整机(i5-9400F 16G 256G SSD+1T RX550X 4G 独显)23英寸');
INSERT INTO `materials` VALUES ('1010', '风扇', '风扇类型', '零件', '个', '15.000', 'ARCTIC 8cm风扇 （电脑机箱CPU散热风扇/FDB液态轴承/2000转/3pin/F8）');
INSERT INTO `materials` VALUES ('1011', '显示器', '显示器类型规定，编号', '零件', '个', '600.000', 'AOC 27英寸玄英质感黑 微框 IPS技术屏 广视角 低蓝光爱眼 可壁挂 电脑办公液晶显示器 27B2H');
INSERT INTO `materials` VALUES ('1012', '散热器', '散热器类型规定', '零件', '个', '1300.000', '美商海盗船 (USCORSAIR) H150i PRO RGB冷头 一体式CPU水冷散热器');
INSERT INTO `materials` VALUES ('1013', '机箱', '机箱类型归类', '零件', '个', '200.000', '爱国者（aigo）炫影黑京东专供版 电脑机箱（配3把发光风扇/支持ATX主板/蜂窝玻璃面板/背线）');

-- ----------------------------
-- Table structure for `materielz`
-- ----------------------------
DROP TABLE IF EXISTS `materielz`;
CREATE TABLE `materielz` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `name` varchar(100) NOT NULL COMMENT '名称',
  `category` varchar(100) DEFAULT NULL COMMENT '类别',
  `Number` bigint(100) DEFAULT NULL COMMENT '数量',
  `catname` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of materielz
-- ----------------------------

-- ----------------------------
-- Table structure for `menuinfo`
-- ----------------------------
DROP TABLE IF EXISTS `menuinfo`;
CREATE TABLE `menuinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '权限编号',
  `prentId` bigint(20) DEFAULT NULL COMMENT '父级权限',
  `menuName` varchar(20) NOT NULL COMMENT '权限名称',
  `desciption` varchar(255) DEFAULT NULL COMMENT '权限描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of menuinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `number`
-- ----------------------------
DROP TABLE IF EXISTS `number`;
CREATE TABLE `number` (
  `id` int(10) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `materialsId` int(10) NOT NULL COMMENT '材料编号',
  `numbersl` varchar(200) NOT NULL COMMENT '数量',
  `pickid` int(10) NOT NULL COMMENT '领料编号',
  `catname` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of number
-- ----------------------------

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `orderId` bigint(20) DEFAULT NULL COMMENT '单据编号',
  `supplierid` bigint(20) DEFAULT NULL COMMENT '供应商外键',
  `rebate` int(5) DEFAULT NULL COMMENT '折扣率默认100(100%)',
  `paytype` bigint(20) DEFAULT NULL COMMENT '付款方式 外键',
  `total` decimal(24,6) DEFAULT NULL COMMENT '物品总金额',
  `amount_paid` decimal(24,6) DEFAULT NULL COMMENT '已付金额',
  `total_tax` decimal(24,6) DEFAULT NULL COMMENT '价税合计',
  `orderstate` int(5) DEFAULT NULL COMMENT '单据状态关联状态表 1未审核 2已审核 3已转采购',
  `preferential` decimal(24,6) DEFAULT NULL COMMENT '优惠金额',
  `costid` bigint(20) DEFAULT NULL COMMENT '采购支出表',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '采购订单创建时间',
  `purchaserid` int(10) DEFAULT NULL COMMENT '采购人员id',
  `finance` int(1) NOT NULL COMMENT '财务记录添加状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1001', '1', '1', '100', '2000.000000', '2000.000000', '2100.000000', '1', '0.000000', '1', '2019-12-12 11:20:12', '1', '0');
INSERT INTO `orders` VALUES ('2', '1002', '2', '2', '100', '3000.000000', '3000.000000', '3100.000000', '2', '0.000000', '1', '2019-12-12 11:20:12', '2', '0');
INSERT INTO `orders` VALUES ('3', '1003', '3', '3', '100', '4000.000000', '4000.000000', '4100.000000', '3', '0.000000', '1', '2019-12-12 11:20:12', '3', '0');
INSERT INTO `orders` VALUES ('4', '1004', '2', '3', '200', '8000.000000', '8000.000000', '8100.000000', '2', null, '1', '2015-07-13 15:08:00', '4', '1');

-- ----------------------------
-- Table structure for `payment`
-- ----------------------------
DROP TABLE IF EXISTS `payment`;
CREATE TABLE `payment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `type` varchar(10) NOT NULL COMMENT '付款类型 现金 支付宝 微信',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of payment
-- ----------------------------
INSERT INTO `payment` VALUES ('1', '现金');
INSERT INTO `payment` VALUES ('2', '支付宝');
INSERT INTO `payment` VALUES ('3', '微信');

-- ----------------------------
-- Table structure for `picking`
-- ----------------------------
DROP TABLE IF EXISTS `picking`;
CREATE TABLE `picking` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `pickingNo` bigint(20) DEFAULT NULL,
  `materialParts` varchar(500) DEFAULT NULL COMMENT '物料零件',
  `startTime` datetime DEFAULT NULL COMMENT '出库时间',
  `productionAudit` int(4) DEFAULT NULL COMMENT '物料审核是否通过0-通过，1-不通过',
  `deletePick` int(1) DEFAULT NULL COMMENT '删除标记',
  `productionid` int(20) DEFAULT NULL COMMENT '生产id',
  `materialNumber` varchar(200) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of picking
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '产品编号',
  `product_name` varchar(50) DEFAULT NULL COMMENT '产品名称',
  `product_model` bigint(20) DEFAULT NULL COMMENT '产品型号',
  `product_type` bigint(20) DEFAULT NULL COMMENT '产品类别',
  `product_unit` varchar(5) DEFAULT NULL COMMENT '产品单位',
  `product_stock` int(5) DEFAULT NULL COMMENT '产品库存',
  `retail_price` decimal(24,6) DEFAULT NULL COMMENT '零售价',
  `min_price` decimal(24,6) DEFAULT NULL COMMENT '最低售价',
  `cost_price` decimal(24,6) DEFAULT NULL COMMENT '预计成本价格',
  `trade_price` decimal(24,6) DEFAULT NULL COMMENT '销售价格',
  `product_state` int(4) DEFAULT NULL COMMENT '产品状态',
  `serial_number` varchar(20) DEFAULT NULL COMMENT '产品序列号',
  `status` varchar(1) NOT NULL DEFAULT '0' COMMENT '产品审核 0未审核，1已审核，默认0',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '产品创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `serial_number` (`serial_number`),
  KEY `fk_product_type` (`product_type`),
  KEY `fk_product_model` (`product_model`),
  CONSTRAINT `fk_product_model` FOREIGN KEY (`product_model`) REFERENCES `product_model` (`id`),
  CONSTRAINT `fk_product_type` FOREIGN KEY (`product_type`) REFERENCES `product_type` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------

-- ----------------------------
-- Table structure for `productionplan`
-- ----------------------------
DROP TABLE IF EXISTS `productionplan`;
CREATE TABLE `productionplan` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `productId` bigint(20) DEFAULT NULL COMMENT '产品编号',
  `startTime` datetime DEFAULT NULL COMMENT '开始时间',
  `endTime` datetime DEFAULT NULL COMMENT '预计结束时间',
  `personCharge` bigint(20) DEFAULT NULL COMMENT '负责人id',
  `productionAudit` int(4) DEFAULT NULL COMMENT '生产计划审核是否通过0-通过，1-不通过',
  `deleteProd` int(1) DEFAULT NULL COMMENT '删除标记',
  `prquantity` int(200) DEFAULT NULL COMMENT '生产数量',
  `pickingid` int(20) DEFAULT NULL COMMENT '领料id',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productionplan
-- ----------------------------

-- ----------------------------
-- Table structure for `product_model`
-- ----------------------------
DROP TABLE IF EXISTS `product_model`;
CREATE TABLE `product_model` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `brand` varchar(50) DEFAULT NULL COMMENT '品牌',
  `model_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `motherboard` varchar(255) DEFAULT NULL COMMENT '主板',
  `cpu` varchar(50) DEFAULT NULL COMMENT 'cpu',
  `memories` varchar(50) DEFAULT NULL COMMENT '内存条',
  `video_card` varchar(50) DEFAULT NULL COMMENT '显卡',
  `disks` varchar(50) DEFAULT NULL COMMENT '硬盘',
  `ssd` varchar(50) DEFAULT NULL COMMENT '固态硬盘',
  `size` varchar(50) DEFAULT NULL COMMENT '尺寸',
  `color` varchar(50) DEFAULT NULL COMMENT '颜色',
  `weight` decimal(24,6) DEFAULT NULL COMMENT '裸机重量',
  `model_type` varchar(50) DEFAULT NULL COMMENT '产品类别 游戏本/商务本/其他',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_model
-- ----------------------------

-- ----------------------------
-- Table structure for `product_type`
-- ----------------------------
DROP TABLE IF EXISTS `product_type`;
CREATE TABLE `product_type` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `type_name` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `remake` varchar(255) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product_type
-- ----------------------------

-- ----------------------------
-- Table structure for `recruit`
-- ----------------------------
DROP TABLE IF EXISTS `recruit`;
CREATE TABLE `recruit` (
  `recruitId` int(5) NOT NULL AUTO_INCREMENT COMMENT '招聘编号',
  `title` varchar(100) DEFAULT NULL COMMENT '招聘标题',
  `content` varchar(500) DEFAULT NULL COMMENT '招聘内容',
  `position` varchar(50) DEFAULT NULL COMMENT '招聘职位',
  `salary` varchar(50) DEFAULT NULL COMMENT '招聘薪资,如:5000-6000工资面议',
  `phone` varchar(11) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(200) DEFAULT NULL COMMENT '公司地址',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`recruitId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of recruit
-- ----------------------------

-- ----------------------------
-- Table structure for `roleinfo`
-- ----------------------------
DROP TABLE IF EXISTS `roleinfo`;
CREATE TABLE `roleinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '角色编号',
  `parentId` bigint(20) DEFAULT NULL COMMENT '父级角色',
  `roleName` varchar(20) NOT NULL COMMENT '角色名称',
  `creationTime` datetime NOT NULL COMMENT '创建时间',
  `desciption` varchar(20) DEFAULT NULL COMMENT '角色描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roleinfo
-- ----------------------------

-- ----------------------------
-- Table structure for `role_menu`
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `menuId` bigint(20) NOT NULL COMMENT '权限编号',
  `menuType` int(4) NOT NULL COMMENT '权限类型 0可以访问 1可以授权',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_menu
-- ----------------------------

-- ----------------------------
-- Table structure for `sale`
-- ----------------------------
DROP TABLE IF EXISTS `sale`;
CREATE TABLE `sale` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `userid` bigint(20) DEFAULT NULL COMMENT '用户编号',
  `productId` bigint(20) NOT NULL COMMENT '产品编号',
  `depotId` bigint(20) NOT NULL COMMENT '仓库编号',
  `depotheadId` bigint(20) NOT NULL COMMENT '单据编号',
  `state` int(10) NOT NULL COMMENT '状态 0审核；1审核中；2转销售出库；3销售退货',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '删除标记',
  `clientId` bigint(20) DEFAULT NULL COMMENT '客户编号',
  `number` bigint(20) DEFAULT NULL COMMENT '数量',
  `discounts` decimal(8,2) DEFAULT NULL COMMENT '优惠率',
  `money` decimal(20,2) DEFAULT NULL COMMENT '总金额',
  `reality` decimal(20,2) DEFAULT NULL COMMENT '实际付款金额',
  `commission` double(10,3) DEFAULT NULL COMMENT '销售提成',
  `finance` int(1) NOT NULL COMMENT '财务记录添加状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sale
-- ----------------------------
INSERT INTO `sale` VALUES ('1', '1', '1', '1', '1001', '2', '0', '4', '10', '0.00', '10000.00', '9500.00', '100.000', '1');
INSERT INTO `sale` VALUES ('2', '2', '2', '2', '1002', '2', '0', '4', '20', '0.00', '45120.00', '45120.00', '1000.000', '0');
INSERT INTO `sale` VALUES ('3', '3', '3', '3', '1003', '2', '0', null, null, null, null, null, null, '0');

-- ----------------------------
-- Table structure for `summarizing`
-- ----------------------------
DROP TABLE IF EXISTS `summarizing`;
CREATE TABLE `summarizing` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `total_expenditure` bigint(20) NOT NULL COMMENT '总支出编号',
  `income` bigint(20) NOT NULL COMMENT '总收益编号',
  `collect_date` datetime DEFAULT NULL COMMENT '汇总时间',
  `principal` bigint(20) NOT NULL COMMENT '负责人 用户id',
  `describe` varchar(20) DEFAULT NULL COMMENT '描述',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '是否删除 0是1否,默认0',
  PRIMARY KEY (`id`),
  KEY `fk_expenditure` (`total_expenditure`),
  KEY `fk_income` (`income`),
  KEY `fk_principal` (`principal`),
  CONSTRAINT `fk_gross_return` FOREIGN KEY (`income`) REFERENCES `financialsettlement` (`id`),
  CONSTRAINT `fk_principal` FOREIGN KEY (`principal`) REFERENCES `userinfo` (`id`),
  CONSTRAINT `fk_total_expenditure` FOREIGN KEY (`total_expenditure`) REFERENCES `total_expenditure` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of summarizing
-- ----------------------------

-- ----------------------------
-- Table structure for `supplier`
-- ----------------------------
DROP TABLE IF EXISTS `supplier`;
CREATE TABLE `supplier` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `supplier` varchar(255) NOT NULL COMMENT '供应商/会员/客户 名称',
  `contacts` varchar(100) DEFAULT NULL COMMENT '联系人',
  `phoneNum` varchar(30) DEFAULT NULL COMMENT '联系电话',
  `email` varchar(50) DEFAULT NULL COMMENT '电子邮箱',
  `isystem` tinyint(4) DEFAULT NULL COMMENT '是否系统自带 0==系统 1==非系统',
  `type` varchar(20) DEFAULT NULL COMMENT '类型',
  `enabled` bit(1) DEFAULT NULL COMMENT '启用',
  `AdvanceIn` decimal(24,6) DEFAULT '0.000000' COMMENT '预收款',
  `BeginNeedGet` decimal(24,6) DEFAULT NULL COMMENT '期初应收',
  `BeginNeedPay` decimal(24,6) DEFAULT NULL COMMENT '期初应付',
  `AllNeedGet` decimal(24,6) DEFAULT NULL COMMENT '累计应收',
  `AllNeedPay` decimal(24,6) DEFAULT NULL COMMENT '累计应付',
  `fax` varchar(30) DEFAULT NULL COMMENT '传真',
  `telephone` varchar(30) DEFAULT NULL COMMENT '手机',
  `address` varchar(50) DEFAULT NULL COMMENT '地址',
  `taxNum` varchar(50) DEFAULT NULL COMMENT '纳税人识别号',
  `bankName` varchar(50) DEFAULT NULL COMMENT '开户行',
  `accountNumber` varchar(50) DEFAULT NULL COMMENT '账号',
  `taxRate` decimal(24,6) DEFAULT NULL COMMENT '税率',
  `delete_Flag` varchar(1) DEFAULT '0' COMMENT '删除标记，0未删除，1删除',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of supplier
-- ----------------------------
INSERT INTO `supplier` VALUES ('1', '小三', '张三', '15555555', '1283038032@qq.com', '0', '供应商', '', '0.000000', '22000.000000', '33000.000000', '45000.000000', '55000.000000', '1200', '1452222000', '长沙市', '20', '10', '168168168', '10.000000', '0');
INSERT INTO `supplier` VALUES ('2', '小四', '李四', '16666666', '1285695000', '0', '供应商', '', '0.000000', '12000.000000', '22000.000000', '25000.000000', '35000.000000', '1300', '1165550000', '岳麓区', '30', '5', '156156156', '5.000000', '0');
INSERT INTO `supplier` VALUES ('3', '小五', '王五', '17777777', '128544847', '0', '会员', '', '0.000000', '55000.000000', '66000.000000', '75000.000000', '85000.000000', '1500', '1564440000', '上海', '40', '20', '186186186', '30.000000', '0');
INSERT INTO `supplier` VALUES ('4', '赵六', '赵六', '21358585', '1254@163.com', '0', '客户', '', '0.000000', '12555.000000', '45555.000000', '24558.000000', '12345.000000', '1240', '1223566635', '广东', '10', '5', '123456789', '25.000000', '0');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '用户编号',
  `loginName` varchar(20) NOT NULL COMMENT '登录名',
  `password` varchar(50) NOT NULL COMMENT '登录密码',
  `userName` varchar(20) NOT NULL COMMENT '真实姓名',
  `gender` char(2) NOT NULL DEFAULT '男' COMMENT '性别',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件地址',
  `phone` varchar(20) DEFAULT NULL COMMENT '联系电话',
  `address` varchar(255) DEFAULT NULL COMMENT '联系地址',
  `birthday` datetime DEFAULT NULL COMMENT '出生日期',
  `hireDate` datetime NOT NULL COMMENT '入职时间',
  `deptNo` bigint(20) DEFAULT NULL COMMENT '部门编号',
  `mar` bigint(20) DEFAULT NULL COMMENT '上级编号',
  `sal` decimal(10,2) DEFAULT NULL COMMENT '工资',
  `comm` decimal(10,2) DEFAULT NULL COMMENT '奖金',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('1', 'admin', '123456', '诺曼', '男', '947264959@qq.com', '13400000000', 'Grace Field第3农园', '2000-03-21 00:00:00', '2019-10-22 00:00:00', '1', null, null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `roleId` bigint(20) NOT NULL COMMENT '角色编号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------

-- ----------------------------
-- Table structure for `workattendance`
-- ----------------------------
DROP TABLE IF EXISTS `workattendance`;
CREATE TABLE `workattendance` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键编号',
  `userId` bigint(20) NOT NULL COMMENT '用户编号',
  `attendanceDate` date DEFAULT NULL COMMENT '考勤日期 如 2019-01-01',
  `week` varchar(20) DEFAULT NULL COMMENT '星期几 如周一至周末',
  `startTime` time DEFAULT NULL COMMENT '开始时间 如 10:36:00',
  `endTime` time DEFAULT NULL COMMENT '结束时间',
  `allHour` time DEFAULT NULL COMMENT '总时长(小时长) 如 24:00:00',
  `state` int(5) DEFAULT NULL COMMENT '考勤状态 0早卡，1工时不足，2全勤，3缺勤,4未打晚卡，5未打早卡',
  `deleteFlag` int(1) DEFAULT NULL COMMENT '删除标记',
  PRIMARY KEY (`id`),
  KEY `fk_user` (`userId`),
  CONSTRAINT `fk_user` FOREIGN KEY (`userId`) REFERENCES `userinfo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of workattendance
-- ----------------------------
