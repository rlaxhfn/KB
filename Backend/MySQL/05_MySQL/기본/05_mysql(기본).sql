-- 문제 1
create database tabledb;
use tabledb;
-- 문제 2
create table usertbl(userID char(8) not null primary key,name varchar(10) not null,birthyear int not null,addr char(2) not null,mobile1 char(3) null,mobile2 char(8) null,height smallint null,mDate date null);
-- 문제 3
create table buytbl(num int auto_increment not null primary key,userID char(8) not null,prodName char(6) not null,groupName char(4) null,price int not null,amount smallint not null,foreign key(userID) references usertbl(userID));
-- 문제 4
insert into usertbl values('LSG','이승기',1987,'서울','011','11111111',182,'2008-8-8');
insert into usertbl values('KBS','김범수',1979,'경남','011','22222222',173,'2012-4-4');
insert into usertbl values('KKH','김경호',1971,'전남','019','33333333',177,'2007-7-7');
-- 문제 5
-- insert into buytbl values('KBS','운동화',null,30,2); error code:1136 value 일치 X
insert into buytbl values(null, 'KBS','운동화',null,30,2);
insert into buytbl values(null, 'KBS','노트북','전자',1000,1);
-- insert into buytbl values(null, 'JYP','모니터',null,200,1); error code:1452 참조 무결성
-- 문제 6
drop table if exists buytbl; -- 참조 테이블 먼저 삭제
drop table if exists usertbl;
create table usertbl(userID char(8) not null,name varchar(10) not null,birthyear int not null,constraint primary key PK_usertbl_userID(userID));
-- 문제 7
drop table if exists prodtbl;
create table prodtbl(prodCode char(3) not null,prodID char(4) not null,prodDate datetime not null,prodCur char(10) null,constraint PK_prodtbl_prodCode_prodID primary key(prodCode,prodID));
-- 문제 8
use sqldb;
create view tblview as select u.userId,u.name,b.prodName,u.addr,concat(u.mobile1,u.mobile2) as '연락처' from usertbl u join buytbl b on u.userId=b.userId;
-- 문제 9
select * from tblview where name='김범수';