/* 
*创建数据库 CREATE DATABASE DEMO，使用数据库 USE DEMO
*COMMENT  comment (注释意思)
NOT NULL 非空 AUTO_INCREMENT auto increment 自增
CHARSET 编码字符集
*INNODB 支持行级锁
*/
 CREATE DATABASE demo;
 USE DEMO;
 DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` INT(10) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `area_name` VARCHAR(200) NOT NULL  UNIQUE  COMMENT '区域名称', 
  `priorty` INT(10) NOT NULL DEFAULT'0'  COMMENT '权重，权重越大越往前排显示' ,
  `creat_time` DATETIME DEFAULT NULL  COMMENT '创建时间',
  `last_edit_time` DATETIME DEFAULT NULL  COMMENT '更新时间',
   PRIMARY KEY (`area_id`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='区域表';

SELECT * FROM tb_area;
--#添加 列数必须一致，否则报错。
INSERT INTO `tb_area` VALUES ('1', '东苑',  '3', NULL,NULL);
INSERT INTO `tb_area` VALUES ('2', '西苑',  '2', NULL,NULL);
INSERT INTO `tb_area` VALUES ('3', '北苑',  '2', NULL,NULL);
INSERT INTO `tb_area` VALUES ('4', '南苑',  '2', NULL,NULL);
INSERT INTO `tb_area` VALUES ('5', '中苑',  '1', NULL,NULL);

UPDATE 

DELETE  tb_area

SELECT * FROM tb_area   t FOR UPDATE WHERE  t.area_id ='' ; 



/* 
## 此行建表语句 唯一键去掉了 
DROP TABLE IF EXISTS `tb_area`;
CREATE TABLE `tb_area` (
  `area_id` INT(10) NOT NULL AUTO_INCREMENT,
  `area_name` VARCHAR(200) NOT NULL    COMMENT '区域名称', 
  `priorty` INT(10) NOT NULL DEFAULT'0',
  `creat_name` DATETIME DEFAULT NULL,
  PRIMARY KEY (`area_id`)
  #,
  ##UNIQUE KEY 'UK_AREA' (`area_name`)
) ENGINE=INNODB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 COMMENT='区域表';
# 执行完成后增加 Alter tb_area user add unique('area_name')不一定有效。

*/
/*
CREATE TABLE `tb_area` (
  `area_id` INT(10) NOT NULL AUTO_INCREMENT,
  `area_name` VARCHAR(200) NOT NULL COMMENT '区域名称',
  `type_code` VARCHAR(64) DEFAULT NULL COMMENT '数据字典类型代码',
  `ddkey` VARCHAR(6) NOT NULL COMMENT '数据键',
  `ddvalue` VARCHAR(12) NOT NULL COMMENT '数据值',
  `is_show` INT(1) NOT NULL COMMENT '是否显示，1：显示；2：不显示',
  PRIMARY KEY (`id`)
) ENGINE=INNODB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 COMMENT='数据字典表';
*/
