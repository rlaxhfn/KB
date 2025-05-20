use tabledb;
-- 문제 1
drop table if exists usertbl,buytbl;
create table usertbl(userID char(8) not null primary key,name varchar(10) not null,birthyear int not null);
create table buytbl(num int auto_increment not null primary key,userID char(8) not null,prodName char(6) not null);
alter table buytbl add constraint FK_usertbl_buytbl foreign key(userID) references usertbl(userID);
-- 문제 2
drop table if exists usertbl,buytbl;
create table usertbl(userID char(8) not null primary key,name varchar(10) not null,birthyear int not null,email char(30) null unique);
-- 문제 3
drop table if exists usertbl;
create table usertbl(userID char(8) not null primary key,name varchar(10),birthyear int check(birthyear>=1900 and birthyear<=2023),mobile char(3) not null);
-- 문제 4
drop table if exists usertbl;
create table usertbl(userID char(8) not null primary key,name varchar(10) not null,birthyear int not null default -1,addr char(2) not null default '서울',mobile1 char(3) null,mobile2 char(8) null,height smallint null default 170,mDate date null);
insert into usertbl values('SISA','시사',default,'일본',null,null,default,null);
insert into usertbl(userID,name) values('KBS','김범수');
select * from usertbl;
-- 문제 5
alter table usertbl drop column mobile1;
alter table usertbl change column name uName varchar(10) not null;
alter table usertbl drop primary key;

use employees;
-- 문제 6
create view employees_info as select e.*,t.title,t.from_date as 't_from',t.to_date as 't_to',s.salary,s.from_date as 's_from',s.to_date as 's_to' from titles t join employees e on t.emp_no=e.emp_no join salaries s on e.emp_no=s.emp_no where t.to_date='9999-01-01';
-- 문제 7
select * from employees_info where s_to='9999-01-01';
-- 문제 8
create view emp_dept_info as select e.emp_no,d.dept_no,d.dept_name,de.from_date,de.to_date from departments d join dept_emp de on d.dept_no=de.dept_no join employees e on de.emp_no=e.emp_no;
-- 문제 9
select * from emp_dept_info where to_date='9999-01-01' order by emp_no;