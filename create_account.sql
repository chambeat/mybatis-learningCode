/*
DROP TABLE IF EXISTS `account`;

CREATE TABLE `account`(
	`id` int(11) NOT NULL PRIMARY KEY COMMENT '编号',
    `uid` int(11) DEFAULT NULL COMMENT '用户编号',
    `money` double DEFAULT NULL COMMENT '金额',
    CONSTRAINT `FK_user` FOREIGN KEY (uid) REFERENCES `user` (id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert into `account`(`id`,`uid`,`money`) values(1,8,1000),(2,7,3000),(3,8,5000);
*/


/*连接查询(一对一)*/
/*select u.*, a.id as aid, a.uid, a.money
from account a, user u 
where a.uid=u.id*/

/*左外连接(一对多)*/
select * from `user` u left outer join `account` a on u.id=a.uid