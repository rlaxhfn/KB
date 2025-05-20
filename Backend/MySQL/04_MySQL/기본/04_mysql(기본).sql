use sqldb;
-- 문제 1
select * from buytbl b join usertbl u on b.userID=u.userID;
-- 문제 2
select * from buytbl b join usertbl u on b.userID=u.userID where b.userID='JYP';
-- 문제 3
select u.userID, u.name, b.prodName, u.addr, concat(u.mobile1,u.mobile2) as '연락처' from usertbl u left outer join buytbl b on u.userID=b.userID order by u.userID;
-- 문제 4
select name, concat(mobile1,mobile2) as '연락처' from usertbl where name not in(select name from usertbl where mobile1 is null);
-- 문제 5
select name, concat(mobile1,mobile2) as '연락처' from usertbl where mobile1 is null;