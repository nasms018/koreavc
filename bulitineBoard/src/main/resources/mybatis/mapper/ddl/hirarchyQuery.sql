--느려서 성능은 담보하기 힘듬
create table T_H(
	id int primary key,
	hid int,
	name varchar(255) not null
)

insert into T_H(id, hid, name)
 values(0, null, '하나님');
insert into T_H(id, hid, name)
 values(1, 0, '단군 아들');
insert into T_H(id, hid, name)
 values(2, 0, '단군 2nd 아들');
insert into T_H(id, hid, name)
 values(3, 2, '아빠');
insert into T_H(id, hid, name)
 values(4, 3, '나');
insert into T_H(id, hid, name)
 values(5, 3, '내 아들');

select me.*
  from T_H me
 where me.name = '나';
 
 
select me.*, p1.*
  from T_H me, T_H p1
 where me.name = '나'
   and me.hid = p1.id;


select me.*, p1.*, p2
  from T_H me, T_H p1, T_H p2
 where me.name = '나'
   and me.hid = p1.id
   and p1.hid = p2.id


--조상부터 모든 후손
WITH RECURSIVE Tree AS(
	SELECT id, name
		FROM T_H
		WHERE id = 0
		
	UNION ALL
	
	SELECT 
		child.id, child.name
		FROM T_H child
		INNER JOIN tree
		ON tree.id = child.hid
)
SELECT *
FROM tree;













