USE myDB;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user`(
	`id` int(11)    			NOT NULL    	AUTO_INCREMENT,
    `username` varchar(32)    	NOT NULL    	COMMENT'用户名称',
    `birthday` datetime    		DEFAULT NULL    COMMENT'生日',
    `sex` char(1)    			DEFAULT NULL    COMMENT'性别',
    `address` varchar(256) 		DEFAULT NULL 	COMMENT'地址',
    
    PRIMARY KEY (`id`)
)character set utf8 collate utf8_general_ci;


INSERT INTO `user`(`username`,`birthday`,`sex`,`address`) VALUES('老王','2018-02-27 17:47:08','男','北京');
INSERT INTO `user`(`username`,`birthday`,`sex`,`address`) VALUES('老李','2016-04-01 12:42:01','男','上海');
INSERT INTO `user`(`username`,`birthday`,`sex`,`address`) VALUES('小赵','2017-07-03 13:21:03','女','广州');
INSERT INTO `user`(`username`,`birthday`,`sex`,`address`) VALUES('小陈','2018-01-29 17:33:05','女','深圳');
INSERT INTO `user`(`username`,`birthday`,`sex`,`address`) VALUES('老刘','2019-10-22 08:47:07','男','长沙');
INSERT INTO `user`(`username`,`birthday`,`sex`,`address`) VALUES('老张','2019-12-27 04:47:09','男','西安');
