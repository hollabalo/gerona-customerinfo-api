drop table customer if exists;

create table customer (
	id integer identity primary key, 
	last_name varchar(50) not null, 
	first_name varchar(50) not null, 
	middle_name varchar(50), 
	house_brgy varchar(60) not null, 
	city varchar(30) not null,
	province varchar(30) not null,
	telephone varchar(15)
);

