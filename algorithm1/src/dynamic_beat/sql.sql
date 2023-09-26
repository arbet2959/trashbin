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

insert into dynamicUser values(admin,1234,32,'wlsl3472@navar.com',true,true);
select * from dynamicUser;