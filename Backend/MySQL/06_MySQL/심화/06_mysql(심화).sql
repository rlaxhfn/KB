-- 문제 1
use sqldb;
select * from usertbl;
show index from usertbl;
show table status like 'usertbl';
-- 문제 2
create index idx_usertbl_addr on usertbl(addr);
show index from usertbl;
-- 문제 3
show table status like 'usertbl';
analyze table usertbl;
-- 문제 4
create index idx_usertbl_birthYear on usertbl(birthYear); -- 중복
create unique index idx_usertbl_name on usertbl(name);
show index from usertbl;
-- 문제 5
drop index idx_usertbl_name on usertbl;
create unique index idx_usertbl_name_birthYear on usertbl(name,birthYear);
show index from usertbl;
-- 문제 6
drop index idx_usertbl_name_birthYear on usertbl;
drop index idx_usertbl_addr on usertbl;
show index from usertbl;
-- 문제 7
create database scoula_db;
create user 'scoula'@'%' identified by '1234';
grant all privileges on scoula_db.* to 'scoula'@'%';
flush privileges;