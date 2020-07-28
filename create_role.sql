/*
DROP TABLE IF EXISTS `role`;

CREATE TABLE `role`(
	`id` int(11) NOT NULL COMMENT '编号',
    `role_name` varchar(30) DEFAULT NULL COMMENT '角色名称',
    `role_desc` varchar(60) DEFAULT NULL COMMENT '角色描述',
	PRIMARY KEY (`id`)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `role`(`id`,`role_name`,`role_desc`) values (1,'院长','管理整个学院'), (2,'总裁','管理整个公司'), (3,'校长','管理整个学校');
*/

/*使用2个左外连接实现对表的 多对多 操作
select u.*, r.id as rid, r.role_name, r.role_desc
from role r
left outer join user_role ur on r.id=ur.rid
left outer join user u on u.id=ur.uid;*/

select u.*, r.id as rid, r.role_name, r.role_desc
from user u
left outer join user_role ur on u.id=ur.uid
left outer join role r on r.id=ur.rid;