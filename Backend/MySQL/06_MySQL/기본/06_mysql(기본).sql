-- 문제 1
use sqldb;
create table tbl1(a int primary key,b int,c int);
show index from tbl1; -- a
-- 문제 2
create table tbl2(a int primary key,b int unique,c int unique,d int);
show index from tbl2; -- a,b,c
-- 문제 3
create table tbl3(a int unique,b int unique,c int unique,d int);
show index from tbl3; -- a,b,c
-- 문제 4
create table tbl4(a int unique not null,b int unique,c int unique,d int);
show index from tbl4; -- a,b,c
-- 문제 5
create table tbl5(a int unique not null,b int unique,c int unique,d int primary key);
show index from tbl5; -- d,a,b,c
-- 문제 6
create database if not exists testdb;
use testdb;
create table usertbl(userID char(8) not null primary key,name varchar(10) not null,birthYear int not null,addr nchar(2) not null);
-- 문제 7
insert into usertbl values('LSG','이승기',1987,'서울');
insert into usertbl values('KBS','김범수',1979,'경남');
insert into usertbl values('KKH','김경호',1971,'전남');
insert into usertbl values('JYP','조용필',1950,'경기');
insert into usertbl values('SSK','성시경',1979,'서울');
select * from usertbl;
show index from usertbl;
-- 문제 8
alter table usertbl drop primary key;
alter table usertbl add constraint pk_name primary key(name);
-- 문제 9
select * from usertbl;
show index from usertbl;