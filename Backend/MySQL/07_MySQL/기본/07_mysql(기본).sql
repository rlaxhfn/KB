-- 문제 1
create database jdbc_ex;
create user 'scoula'@'%' identified by '1234';
grant all privileges on jdbc_ex.* to 'scoula'@'%';
-- IntelliJ Console
-- 문제 3
create table users(id varchar(12) primary key,password varchar(12) not null,name varchar(30) not null,role varchar(6) not null);
-- 문제 4
insert into users values ('guest','guest123','방문자','USER');
insert into users values ('admin','admin123','관리자','ADMIN');
insert into users values ('member','member123','일반회원','USER');