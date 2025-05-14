-- 문제1. 다음을 처리하는 쿼리문을 작성하세요
-- 현재 서버에 존재하는 데이터페이스 확인
show databases;
-- 현재 데이터베이스를 employees로 설정하기
use employees;
-- employees 데이터베이스의 테이블 목록 보기
show table status;
-- employees 테이블의 열 목록 출력하기
describe employees;
show columns from employees;

-- 문제2. employees 테이블에서 다음 쿼리를 작성하세요
-- titles 테이블의 데이터 출력하기
select * from titles;
-- employees 테이블에서 first_name 칼럼만 출력하기
select first_name from employees;
-- employees 테이블에서 first_name 칼럼, last_name 칼럼, gender 칼럼 출력하기
select first_name, last_name, gender from employees;

-- 문제3. employees 테이블 출력 시 다음과 같이 나오도록 쿼리를 작성하세요
select first_name as '이름', gender as '성별', hire_date as '회사 입사일' from employees;

-- 문제4. sqldb.sql 파일을 이용해 sqldb 데이터베이스를 구축하세요
create database sqldb;
use sqldb;

CREATE TABLE usertbl -- 회원 테이블
( userID  	CHAR(8) NOT NULL PRIMARY KEY, -- 사용자 아이디(PK)
  name    	VARCHAR(10) NOT NULL, -- 이름
  birthYear   INT NOT NULL,  -- 출생년도
  addr	  	CHAR(2) NOT NULL, -- 지역(경기,서울,경남 식으로 2글자만입력)
  mobile1	CHAR(3), -- 휴대폰의 국번(011, 016, 017, 018, 019, 010 등)
  mobile2	CHAR(8), -- 휴대폰의 나머지 전화번호(하이픈제외)
  height    	SMALLINT,  -- 키
  mDate    	DATE  -- 회원 가입일
);
CREATE TABLE buytbl -- 회원 구매 테이블(Buy Table의 약자)
(  num 		INT AUTO_INCREMENT NOT NULL PRIMARY KEY, -- 순번(PK)
   userID  	CHAR(8) NOT NULL, -- 아이디(FK)
   prodName 	CHAR(6) NOT NULL, --  물품명
   groupName 	CHAR(4)  , -- 분류
   price     	INT  NOT NULL, -- 단가
   amount    	SMALLINT  NOT NULL, -- 수량
   FOREIGN KEY (userID) REFERENCES usertbl(userID)
);

INSERT INTO usertbl VALUES('LSG', '이승기', 1987, '서울', '011', '1111111', 182, '2008-8-8');
INSERT INTO usertbl VALUES('KBS', '김범수', 1979, '경남', '011', '2222222', 173, '2012-4-4');
INSERT INTO usertbl VALUES('KKH', '김경호', 1971, '전남', '019', '3333333', 177, '2007-7-7');
INSERT INTO usertbl VALUES('JYP', '조용필', 1950, '경기', '011', '4444444', 166, '2009-4-4');
INSERT INTO usertbl VALUES('SSK', '성시경', 1979, '서울', NULL  , NULL      , 186, '2013-12-12');
INSERT INTO usertbl VALUES('LJB', '임재범', 1963, '서울', '016', '6666666', 182, '2009-9-9');
INSERT INTO usertbl VALUES('YJS', '윤종신', 1969, '경남', NULL  , NULL      , 170, '2005-5-5');
INSERT INTO usertbl VALUES('EJW', '은지원', 1972, '경북', '011', '8888888', 174, '2014-3-3');
INSERT INTO usertbl VALUES('JKW', '조관우', 1965, '경기', '018', '9999999', 172, '2010-10-10');
INSERT INTO usertbl VALUES('BBK', '바비킴', 1973, '서울', '010', '0000000', 176, '2013-5-5');
INSERT INTO buytbl VALUES(NULL, 'KBS', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'KBS', '노트북', '전자', 1000, 1);
INSERT INTO buytbl VALUES(NULL, 'JYP', '모니터', '전자', 200,  1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '모니터', '전자', 200,  5);
INSERT INTO buytbl VALUES(NULL, 'KBS', '청바지', '의류', 50,   3);
INSERT INTO buytbl VALUES(NULL, 'BBK', '메모리', '전자', 80,  10);
INSERT INTO buytbl VALUES(NULL, 'SSK', '책'    , '서적', 15,   5);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '청바지', '의류', 50,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);
INSERT INTO buytbl VALUES(NULL, 'EJW', '책'    , '서적', 15,   1);
INSERT INTO buytbl VALUES(NULL, 'BBK', '운동화', NULL   , 30,   2);

SELECT * FROM usertbl;
SELECT * FROM buytbl;

-- 문제5. usertbl 테이블에서 이름이 '김경호'인 행을 출력하세요
select * from usertbl where name='김경호';

-- 문제6. usertbl 테이블에서 생년이 1970 이상이고 키가 182 이상인 데이터를 출력하세요
select * from usertbl where birthYear>=1970 and height>=182;

-- 문제7. usertbl 테이블에서 키가 180~183 범위인 데이터를 출력하세요
select * from usertbl where height between 180 and 183;

-- 문제8. usertbl 테이블에서 주소가 '경남' 또는 '전남' 또는 '경북'인 데이터를 출력하세요
select * from usertbl where addr='경남' or addr='전남' or addr='경북';
select * from usertbl where addr in ('경남', '전남', '경북');

-- 문제9. usertbl 테이블에서 이름이 '김'으로 시작하는 데이터를 출력하세요
select * from usertbl where name like '김%';

-- 문제10. usertbl에서 김경호보다 큰 사람들의 이름과 키를 출력하세요
select name, height from usertbl where height>(select height from usertbl where name='김경호');

-- 문제11. usertbl을 mdate의 오름차순으로 정렬해 출력하세요
select * from usertbl order by mDate;

-- 문제12. usertbl을 mdate의 내림차순으로 정렬해 출력하세요
select * from usertbl order by mDate desc;

-- 문제13. usertbl을 height의 내림차순으로 정렬하고, 동률인 경우 name의 내림차순으로 정렬해 출력하세요
select * from usertbl order by height desc, name desc;

-- 문제14. usertbl의 주소지를 중복없이 오름차순으로 출력하세요
select distinct addr from usertbl order by addr;

-- 문제 15. world 데이터베이스에서 다음 질문을 처리하세요
use world;

-- 국가 코드가 'KOR'인 도시를 찾아 인구수를 역순으로 표시하세요
select Name, Population from city where CountryCode='KOR' order by Population desc;

-- city 테이블에서 국가코드와 인구 수를 출력하세요. 정렬은 국가코드 별로 오름차순으로, 동일한 코드(국가) 안에서는 인구 수의 역순으로 표시하세요.
select CountryCode, Population from city order by CountryCode asc, Population desc;

-- city 테이블에서 국가코드가 'KOR'인 도시의 수를 표시하세요
select count(*) as '도시 수' from city where CountryCode='KOR';

-- city 테이블에서 국가코드가 'KOR', 'CHN', 'JPN'인 도시를 찾으세요.
select Name from city where CountryCode in ('KOR', 'CHN', 'JPN');

-- 국가코드가 'KOR'이면서 인구가 100만 이상인 도시를 찾으세요
select Name from city where CountryCode='KOR' and Population>=1000000;

-- 국가코드가 'KOR'인 도시 중 인구 수가 많은 순서로 상위 10개만 표시하세요
select Name from city where CountryCode='KOR' order by Population desc limit 10;

-- city 테이블에서 국가코드가 'KOR'이고, 인구가 100만 이상 500만 이하인 도시를 찾으세요
select Name from city where CountryCode='KOR'and Population between 1000000 and 5000000;