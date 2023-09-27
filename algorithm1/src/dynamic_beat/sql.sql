show tables;

create table dynamicUser(
	id varchar(20) primary key,
	password varchar(20) not null,
	age int not null,
	email varchar(30) not null,
	admin boolean default false,
	certification boolean default false
);

desc dynamicUser;
drop table dynamicUser;
insert into dynamicUser values('admin','1234',32,'wlsl3472@naver.com',true,true);
select * from dynamicUser;
select * from dynamicUser where id = 'wlsl9411';

create table playRecord(
	idx int auto_increment primary key,
	id varchar(20) default 'logoutuser',
	title varchar(50) not null,
	playtime datetime default now(),
	score int default 0
);

show tables;




);