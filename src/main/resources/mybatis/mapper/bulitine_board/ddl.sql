


--4칸짜리 컬럼 만들기
create table T_I1(id varchar(4));



insert into T_I1(id) values ('a');
insert into T_I1(id) values ('b');
insert into T_I1(id) values ('c');
insert into T_I1(id) values ('d');
insert into T_I1(id) values ('e');
insert into T_I1(id) values ('f');
insert into T_I1(id) values ('g');
insert into T_I1(id) values ('h');
insert into T_I1(id) values ('i');
insert into T_I1(id) values ('j');
insert into T_I1(id) values ('k');
insert into T_I1(id) values ('l');
insert into T_I1(id) values ('m');
insert into T_I1(id) values ('n');
insert into T_I1(id) values ('o');
insert into T_I1(id) values ('p');
insert into T_I1(id) values ('q');
insert into T_I1(id) values ('r');
insert into T_I1(id) values ('s');
insert into T_I1(id) values ('t');
insert into T_I1(id) values ('u');
insert into T_I1(id) values ('v');
insert into T_I1(id) values ('w');
insert into T_I1(id) values ('x');
insert into T_I1(id) values ('y');
insert into T_I1(id) values ('z');
insert into T_I1(id) values ('A');
insert into T_I1(id) values ('B');
insert into T_I1(id) values ('C');
insert into T_I1(id) values ('D');
insert into T_I1(id) values ('E');
insert into T_I1(id) values ('F');
insert into T_I1(id) values ('G');
insert into T_I1(id) values ('H');
insert into T_I1(id) values ('I');
insert into T_I1(id) values ('J');
insert into T_I1(id) values ('K');
insert into T_I1(id) values ('L');
insert into T_I1(id) values ('M');
insert into T_I1(id) values ('N');
insert into T_I1(id) values ('O');
insert into T_I1(id) values ('P');
insert into T_I1(id) values ('Q');
insert into T_I1(id) values ('R');
insert into T_I1(id) values ('S');
insert into T_I1(id) values ('T');
insert into T_I1(id) values ('U');
insert into T_I1(id) values ('V');
insert into T_I1(id) values ('W');
insert into T_I1(id) values ('X');
insert into T_I1(id) values ('Y');
insert into T_I1(id) values ('Z');
insert into T_I1(id) values ('0');
insert into T_I1(id) values ('1');
insert into T_I1(id) values ('2');
insert into T_I1(id) values ('3');
insert into T_I1(id) values ('4');
insert into T_I1(id) values ('5');
insert into T_I1(id) values ('6');
insert into T_I1(id) values ('7');
insert into T_I1(id) values ('8');
insert into T_I1(id) values ('9');



--26칸 만들고
 
create table T_I2(id varchar(4));
create table T_I4(id varchar(4));





--2글자짜리 만들기
INSERT INTO T_I2(id)
SELECT CONCAT(a.id, b.id)
FROM T_I1 a, T_I1 b
;
--4글자짜리 만들기
INSERT INTO T_I4(id)
SELECT CONCAT(a.id, b.id)
FROM T_I2 a, T_I2 b
;


--int SEQ를 기본키로 갖고 SEED칼럼을 갖는 테이블만들기
create table T_IDSEED(
	SEQ integer primary key,
	SEED char(4)
	);


	
-- T_I4에 있는 문자랑 순번을  T_ID_SEED테이블에 집어넣기	
insert into T_IDSEED(SEED, SEQ)
	SELECT tid.id iid, @ROWNUM:=@ROWNUM+1 AS rowNum
	FROM T_I4 as tid, (SELECT @ROWNUM:=0) AS R
	order by iid asc;	
	

	
-- 만든테이블 지우기
drop table T_I1;
drop table T_I2;
drop table T_I4;

	


--조회하기
select *
from T_I1
where num > 1600000
	


--만들때 순서 자동입력방식 적용하기--

DELIMITER $$
CREATE OR REPLACE FUNCTION NEXT_PK(t_NAME VARCHAR(255)) RETURNS CHAR(4)
BEGIN
	DECLARE unredcorded boolean;
	DECLARE r_sequence CHAR(4);
	SELECT NOT EXISTS( SELECT NUM FROM t_sequence WHERE NAME = t_NAME) INTO unredcorded;
	IF (unredcorded) THEN
		INSERT INTO t_sequence (NAME) VALUES (t_NAME);
  	END if;
  
		UPDATE t_sequence SET NUM = NUM + 1  WHERE NAME = t_NAME;
		SELECT c.SEED  INTO r_sequence
		 from t_sequence s, T_IDSEED c
		where s.NAME = t_name
		  and s.NUM = c.SEQ;
	RETURN r_sequence;
END;
$$
DELIMITER ;




