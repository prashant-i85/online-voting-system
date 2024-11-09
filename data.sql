--creating database
create database database1;


--creating user table
create table database1.user1( id int primary key,
                                username varchar(50) not null,
								password varchar(20) not null,
								email varchar(15) not null);
								
								
								
--showing schema of user table

desc database1.user1;
								
								
								
								
								
								
								