
--DROP TABLE T_personaltag
--DROP TABLE T_hashtag
--DROP TABLE T_comp_hierarch
--DROP TABLE T_tgt_tag
--DROP TABLE T_tag
--DROP TABLE T_reply
--DROP TABLE T_CODE
--DROP TABLE T_contact_point
--DROP TABLE T_party
--DROP TABLE T_bulitine_board

--ID/이름/설명/게시글수 id, name, descrip, post_cnt
create table T_bulitine_board(
	id			char(4) primary key,
	name		varchar(255) not null,
	descrip		varchar(255),
	post_cnt	long default 0 comment '총 게시물 개수'
);

insert into T_bulitine_board(id, name, descrip) values(NEXT_PK('t_bulitine_board'), '자유게시판', '자유롭죠');

--ID/내용/글쓴시간,수정시간 T_party(id, descrim, name, nick, pwd, reg_dt, upt_dt, sex)
CREATE TABLE T_party(
	id		CHAR(4) PRIMARY KEY,
	descrim	varchar(255) not null, /*Person, Organization*/
	name 	varchar(255) not null,
	nick	varchar(255) not null comment 'login Id', /*로그인 아이디*/
	pwd		varchar(255) not null,

	reg_dt	TIMESTAMP DEFAULT current_TIMESTAMP,
	upt_dt	TIMESTAMP ON UPDATE current_TIMESTAMP,
	/*Person*/
	sex		boolean comment '1: F, 0: M'
);
-- 로그인시 비교 대상인 암호까지 index에서 제공하여 테이블에 대한 접근을 방어하여 성능을 높임
create index idx_party_nick on T_party(nick);
-- drop index idx_party_nick on t_party;
--alter TABLE t_party ADD COLUMN alive	boolean DEFAULT true comment '활동여부 > 1: 회원, 0: 비회원';


INSERT INTO t_party(id, descrim, NAME, nick, pwd)
 VALUES ('0001','Organization','Dream Company', 'sys', 'sys');

--관계 유형 --id ,account_type, owner_id, respons_id, alive, reg_dt, upt_dt	
CREATE TABLE T_Accountability(
	id				CHAR(4) PRIMARY KEY,
	account_type	varchar(255),
	owner_id		CHAR(4) comment '주인으로서',
	respons_id		CHAR(4) comment '대상으로서',
	alive			boolean DEFAULT true comment '활동여부 > 1: 회원, 0: 비회원',
	reg_dt			TIMESTAMP DEFAULT current_TIMESTAMP comment '등록일',
	upt_dt			TIMESTAMP ON UPDATE current_TIMESTAMP comment '수정일'
);





/* 연락처 유형 정의 */
CREATE TABLE T_CODE(
	Code_type	varchar(255) not null,
	Code_val	varchar(255)
);

insert into T_CODE values('accountability type','manager');
insert into T_CODE values('accountability type','member');


insert into T_CODE values('contect point type','hand phon');
insert into T_CODE values('contect point type','home address');
--insert into T_CODE values('contect point type','email address');
--insert into T_CODE values('contect point type','본적');

insert into T_CODE values('rel target tag','post');
insert into T_CODE values('rel target tag','party');

/* T_contact_point(Owner_id, cp_type, cp_val) */
CREATE TABLE T_contact_point(
	owner_id	CHAR(4),
	cp_type		varchar(255),
	cp_val		varchar(255),
	PRIMARY KEY(owner_id, cp_type)
);

--글ID/글쓴이ID/내용/글쓴시간,수정시간/보드ID/제목/조회수/좋아요/싫어요 id, h_tier, descrim, writer_id, content, reg_dt, upt_dt, bb_id, title, read_cnt, like_cnt, dis_cnt
CREATE TABLE T_reply(
	id			varCHAR(255) PRIMARY KEY,
	h_tier		int comment '층 번호. 게시글 - 0, 댓글 1, 대댓 2',
	descrim		varchar(255) not null  comment 'reply, post 구분자', /*  */ /*230809추가*/
	writer_id	char(4),
	content		TEXT(65535),
	reg_dt		TIMESTAMP DEFAULT current_TIMESTAMP,
	upt_dt		TIMESTAMP ON UPDATE current_TIMESTAMP,
	/* 아래 속성은 게시글 일때만 활용되는 */
	bb_id		char(4),
	title		varchar(255),
	read_cnt	int default 0,
	like_cnt	int default 0,
	dis_cnt		int default 0
);

create index idx_post_board on T_reply(bb_id);

--통합 검색 체계
--df : 특정 단어 t가 등장한 문서의 수.
/*태그ID/단어/설명/특정단어가등장한문서수  id, word, description, df   */
CREATE TABLE T_tag(
	id			CHAR(4) PRIMARY KEY,
	word		varchar(255),
	description	TEXT(65000),
	df			long comment 'document frequency'
);

--PRIMARY KEY(속도때문에 순서가 중요함)
/*태그ID/단어/설명/특정단어가등장한문서수  id, word, description, df   */
CREATE TABLE T_tgt_tag(
	tgt_name	varchar(255),	/* post, party */
	tgt_id		CHAR(4),
	tag_id		CHAR(4),
	tf			int,
	PRIMARY KEY(tgt_name ,tag_id, tgt_id) /* post */
);
--반대순서 색인--
create index idx_tgt_tag on T_tgt_tag(tgt_name , tgt_id, tag_id)

/* top2bottom bottom2top 천장~바닥, 바닥~천장  */
CREATE TABLE T_comp_hierarch(
	id				char(4) PRIMARY KEY, /*230809추가*/
	comp_hierarch	varchar(255),
	kind			char(3)
);

create index idx_comp_hier on T_comp_hierarch(comp_hierarch)

/* 이부분 사용되지 않음
--tf : 특정 문서 d에서의 특정 단어 t의 등장 횟수.
/* (포스트/파티)/게시글ID/태그ID/빈도   tgt_name, post_id, tag_id, tf  */
CREATE TABLE T_hashtag(
	tgt_name	varchar(255),
	post_id		CHAR(4),
	tag_id		CHAR(4),
	tf			int()
);
/* 게시글ID/태그ID/빈도    post_id, tag_id, tf  */
CREATE TABLE T_personaltag(
	party_id	CHAR(4),
	tag_id		CHAR(4),
				
);
*/


