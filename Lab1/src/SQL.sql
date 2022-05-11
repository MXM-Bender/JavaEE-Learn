create table student
(
	name varchar(30),
	sex varchar(20),
	s_class varchar(30),
	birthday varchar(30),
	num varchar(30)
) primary key(num);

create table user(id varchar(30),passwd varchar(30))

insert into user(id,passwd) values("admin","admin");

insert into student values("小明","男","信1905-2班","2000年12月13日","20194033");
insert into student values("小红","女","信1905-2班","2000年1月13日","20194044");
insert into student values("小张","男","信1905-2班","2000年2月13日","20194047");