/* 中间表 (用户多对多操作的表) */
DROP TABLE IF EXISTS `user_role`;

CREATE TABLE `user_role`(
	`uid` int(11) NOT NULL COMMENT '用户编号',
    `rid` int(11) NOT NULL COMMENT '角色编号',
    PRIMARY KEY (`uid`,`rid`),
    KEY `FK_Reference_10` (`rid`),
	CONSTRAINT `FK_Reference_10` FOREIGN KEY (`rid`) REFERENCES `role` (`id`),
	CONSTRAINT `FK_Reference_9` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `user_role`(`uid`,`rid`) values (8,1), (7,1), (8,2);