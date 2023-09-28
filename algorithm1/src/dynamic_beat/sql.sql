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
	idx int auto_increment primary key not null,
	id varchar(20) default 'anonymousUser',
	title varchar(50) not null,
	difficulty varchar(10) not null,
	playtime datetime default now(),
	score int default 0
);
insert into playRecord values(default,'anonymousUser','Joakim karud - Mighty Love','Hard',default,1800)
drop table playRecord;
desc playRecord;
select * from playRecord;
ALTER TABLE `playRecord` MODIFY `difficulty` varchar(10) DEFAULT '';
show tables;

;


);