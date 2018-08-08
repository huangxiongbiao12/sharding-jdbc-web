# sharding-jdbc-web

####数据库准备
sql文件夹下有相关的建表语句
新建两个数据库test_msg1，test_msg2分别建立两张表

```
use test_msg1;
DROP TABLE IF EXISTS `t_user_0`;
CREATE TABLE `t_user_0` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `order_id` varchar(32) DEFAULT NULL COMMENT '顺序编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_user_1`;
CREATE TABLE `t_user_1` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `order_id` varchar(32) DEFAULT NULL COMMENT '顺序编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `test`;
CREATE TABLE `test` (
  `id` int(11) NOT NULL,
  `name` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `age` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;



use test_msg2;
DROP TABLE IF EXISTS `t_user_0`;
CREATE TABLE `t_user_0` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `order_id` varchar(32) DEFAULT NULL COMMENT '顺序编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `t_user_1`;
CREATE TABLE `t_user_1` (
  `id` bigint(20) NOT NULL COMMENT '主键id',
  `order_id` varchar(32) DEFAULT NULL COMMENT '顺序编号',
  `user_id` varchar(32) DEFAULT NULL COMMENT '用户编号',
  `userName` varchar(32) DEFAULT NULL COMMENT '用户名',
  `passWord` varchar(32) DEFAULT NULL COMMENT '密码',
  `user_sex` varchar(32) DEFAULT NULL,
  `nick_name` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
```

####运行测试接口测试效果
>保存数据：http://localhost:8888/user/save?nickName=ni&passWord=897&userName=dajiahao

>查询数据分页3条id desc排序：http://localhost:8888/user/getUsers
