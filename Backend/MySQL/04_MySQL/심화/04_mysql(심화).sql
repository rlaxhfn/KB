-- 문제 1
use sqldb;
CREATE TABLE stdtbl (
stdName VARCHAR(10) NOT NULL PRIMARY KEY,
addr CHAR(4) NOT NULL
);
CREATE TABLE clubtbl (
clubName VARCHAR(10) NOT NULL PRIMARY KEY,
roomNo CHAR(4) NOT NULL
);
CREATE TABLE stdclubtbl(
num int AUTO_INCREMENT NOT NULL PRIMARY KEY,
stdName VARCHAR(10) NOT NULL,
clubName VARCHAR(10) NOT NULL,
FOREIGN KEY(stdName) REFERENCES stdtbl(stdName),
FOREIGN KEY(clubName) REFERENCES clubtbl(clubName)
);
INSERT INTO stdtbl VALUES ('김범수','경남'), ('성시경','서울'), ('조용필','경기'), ('은지원','경북'), ('바비킴','서울');
INSERT INTO clubtbl VALUES ('수영','101호'), ('바둑','102호'), ('축구','103호'), ('봉사','104호');
INSERT INTO stdclubtbl VALUES (NULL,'김범수','바둑'), (NULL,'김범수','축구'), (NULL,'조용필','축구'), (NULL,'은지원','축구'), (NULL,'은지원','봉사'), (NULL,'바비킴','봉사');
-- 문제 2
select s.stdName,s.addr,c.clubName,c.roomNo from stdtbl s join stdclubtbl sc on s.stdName=sc.stdName join clubtbl c on sc.clubName=c.clubName order by s.stdName;
select c.clubName,c.roomNo,s.stdName,s.addr from stdtbl s join stdclubtbl sc on s.stdName=sc.stdName join clubtbl c on sc.clubName=c.clubName order by c.clubName;
-- 문제 3
CREATE TABLE emptbl(emp CHAR(3), manager CHAR(3), empTel VARCHAR(8));
INSERT INTO emptbl(emp, manager, empTel) VALUES
('나사장', NULL, '0000'),
('김재무', '나사장', '2222'),
('김부장', '김재무', '2222-1'),
('이부장', '김재무', '2222-2'),
('우대리', '이부장', '2222-2-1'),
('지사원', '이부장', '2222-2-2'),
('이영업', '나사장', '1111'),
('한과장', '이영업', '1111-1'),
('최정보', '나사장', '5355'),
('윤차장', '최정보', '3355-1'),
('이주임', '윤자장', '5335-1-1');
-- 문제 4
select a.emp as '부하직원',b.emp as '직속상관',b.empTel as '직속상관연락처' from emptbl a join emptbl b on a.manager=b.emp where a.emp='우대리';

use employees;
-- 문제 5
select e.emp_no,first_name,last_name,t.title from employees e join titles t on e.emp_no=t.emp_no where t.to_date='9999-01-01';
-- 문제 6
select e.*,t.title,s.salary from titles t join employees e on t.emp_no=e.emp_no join salaries s on e.emp_no=s.emp_no where t.to_date='9999-01-01' and s.to_date='9999-01-01';
-- 문제 7
select e.emp_no,e.first_name,e.last_name,d.dept_name from employees e join dept_emp de on e.emp_no=de.emp_no join departments d on de.dept_no=d.dept_no where de.to_date='9999-01-01' order by e.emp_no;
-- 문제 8
select d.dept_no,d.dept_name,count(*) from departments d join dept_emp de on d.dept_no=de.dept_no where de.to_date='9999-01-01' group by d.dept_no order by d.dept_no;
-- 문제 9
select e.emp_no,e.first_name,e.last_name,d.dept_name,de.from_date,de.to_date from employees e join dept_emp de on e.emp_no=de.emp_no join departments d on de.dept_no=d.dept_no where e.emp_no='10209' order by de.from_date;