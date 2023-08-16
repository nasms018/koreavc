


파일 전부 연습용
--전부 연습용임 --

--테이블 만들기
create table T_I1(id varchar(8));
--  테이블 전체 출력하기
select * from T_I1    
drop table T_I1
--1개인걸 찾아라
select * from T_I1
where length(id) = 1;   

--1개인걸 없애라
delete from T_I1
where length(id) = 2;  


CONCAT(str1, str2, ...)

--카티션 프로덕트
select * from T_I1 as a, T_I1 as b; 


--자료의 연결
insert into T_I1(id)
select CONCAT(a.id, b.id) 
from T_I1 as a, T_I1 as b; 




-- 3줄짜리
insert into T_I1(id)
select CONCAT(a.id, b.id, c.id) 
from T_I1 as a, T_I1 as b,T_I1 as c;




insert into T_I1(id)
select CONCAT(a.id, b.id) 
from T_I1 a, T_I1 b
where length(a.id) = 2 
  and length(b.id) = 1



delete
from T_I1 a, T_I1 b
where length(a.id)<3


--앞에 primary key 로 번호 추가
--텅텅빈 칼럼 만들기
alter table T_I1 add column (num integer);

alter table T_I1 drop column no;




SELECT tid.*, @ROWNUM:=@ROWNUM+1 AS rowNum
FROM T_I1 as tid, (SELECT @ROWNUM:=0) AS R



--t2에 부여한 숫자를 t1.num에 집어 넣기
UPDATE T_I1 t1, (
SELECT tid.id iid, @ROWNUM:=@ROWNUM+1 AS rowNum
FROM T_I1 as tid, (SELECT @ROWNUM:=0) AS R
order by iid asc
) t2 SET t1.num = t2.rowNum
WHERE t1.id = t2.iid;



select *
from T_I1
where num > 1000000









--3000보다 큰 값 검색
SELECT * FROM T_I1
WHERE num > 3000;


--같은 숫자 부여된게 있는지 
SELECT * FROM T_I1 WHERE num



select id, num, count(*) dup_cnt
from T_I1
group by num
having dup_cnt>1


--num을 기본키 부여하기
alter table T_I1 add primary key (num);






--iid로 정렬하기
SELECT tid.id iid, @ROWNUM:=@ROWNUM+1 AS rowNum
FROM T_I1 as tid, (SELECT @ROWNUM:=0) AS R
order by iid asc;








---FROM 절 에서 초기화 후 사용
SELECT @ROWNUM:=@ROWNUM+1 AS rowNum
FROM 테이블명, (SELECT @ROWNUM:=0) AS R



---WHERE 절 에서 초기화 후 사용
SELECT @ROWNUM:=@ROWNUM+1 AS rowNum
FROM 테이블명
WHERE (@ROWNUM:=0)=0;



---INNER JOIN에 초기화 후 사용
SELECT 컬럼명, @ROWNUM:=@ROWNUM+1 AS rowNum
FROM 테이블명
INNER JOIN (SELECT @rownum:=0) R



---개수 제한하기
---LIMIT 사용
SELECT *
FROM(SELECT 컬럼명 ,@ROWNUM:=@ROWNUM+1 as rowNum
     FROM 테이블명 ,(SELECT @ROWNUM:=0) AS R ) T

LIMIT 0,14

