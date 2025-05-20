use sqldb;
describe usertbl;
describe buytbl;
-- 문제 1
select name,height from usertbl where height=(select min(height) from usertbl) or height=(select max(height) from usertbl);
-- 문제 2
select count(mobile1) as '휴대폰이 있는 사용자' from usertbl;
-- 문제 3
select userId as '사용자',sum(price*amount) as '총구매액' from buytbl group by userId;
select userId as '사용자' from buytbl group by userId having sum(price*amount)>1000;

use world;
describe city;
describe country;
-- 문제 4
select sum(Population) as '총인구' from city where CountryCode='KOR';
select min(Population) as '최소값' from city where CountryCode='KOR';
select max(Population) as '최대값' from city where CountryCode='KOR';
select char_length(Name) as '글자수' from country;
select upper(substring(Name,1,3)) as '나라명' from country;
select round(LifeExpectancy, 1) as '기대수명' from country;

use employees;
-- 문제 5
select e.emp_no,e.first_name,e.last_name,m.dept_no from employees e join dept_manager m on e.emp_no=m.emp_no where m.to_date='9999-01-01';
-- 문제 6
select e.emp_no,e.first_name,e.last_name,m.dept_no from employees e join dept_manager m on e.emp_no=m.emp_no where m.to_date='9999-01-01' and dept_no='d005';
-- 문제 7
select * from employees order by hire_date limit 20 offset 140;
-- 문제 8
select count(*) as '재직자수' from employees e join titles t on e.emp_no=t.emp_no where t.to_date='9999-01-01';
-- 문제 9
select avg(salary) as '평균급여' from salaries where to_date='9999-01-01';
select format(avg(salary),1) as '평균급여' from salaries where to_date='9999-01-01';
-- 문제 10
select s.emp_no,e.first_name,e.last_name,s.salary from employees e join salaries s on e.emp_no=s.emp_no where s.to_date='9999-01-01' and s.salary>(select avg(salary) from salaries where to_date='9999-01-01');
-- 문제 11
select dept_no,count(*) as '재직자수' from dept_emp group by dept_no order by dept_no asc;