/*

--��ٱ��� �Ϸù�ȣ
create sequence seq_cart_idx

--��ٱ��� ���̺�
create table cart
(
  c_idx  int,   --��ٱ����Ϸù�ȣ
  c_cnt  int,	--����
  p_idx  int,	--��ǰ��ȣ
  mem_idx int	--ȸ����ȣ
)

--�⺻Ű
alter table cart
 add constraint pk_cart_c_idx primary key(c_idx);


--��ǰ���̺�(product)�� idx�� p_idx���� �ܷ�Ű ����
alter table cart
  add constraint fk_cart_p_idx foreign key(p_idx) 
                               references product(p_idx)
                               on delete cascade;

--ȸ�����̺� mem_idx�� mem_idx���� �ܷ�Ű ����
alter table cart
	add constraint fk_cart_mem_idx foreign key(mem_idx)
								references member(mem_idx)
								on delete cascade;


select * from product order by p_idx
select * from member order by mem_idx

--											c_cnt p_idx mem_idx
insert into cart values(seq_cart_idx.nextVal, 1, 	1, 	 2	);
insert into cart values(seq_cart_idx.nextVal, 1, 	2, 	 2	);
insert into cart values(seq_cart_idx.nextVal, 1, 	4, 	 5	);

select * from cart
select * from product

select c_idx from cart

commit

-- Join�� ���ؼ� ��ȸ������ ����

create or replace view cart_view
as
	select
	   c_idx, 	p.p_idx, 	p_num,	p_name,		p_price,	p_saleprice,
	   c_cnt, 	c_cnt* p_saleprice amount,	mem_idx
	   
	from product p inner join  cart c
		
		on p.p_idx = c.p_idx  

select * from cart_view;

select * from cart_view where mem_idx=2;

--��ٱ��� ��ǰ�� �Ѱ�
select sum(amount) from cart_view;
select sum(amount) from cart_view where mem_idx=2;
select nvl(sum(amount),0) from cart_view where mem_idx=1;





update cart set c_cnt=#{c_cnt} where c_idx=#{c_idx} 

deled



select * from sawon


SELECT 
    TABLE_NAME
    ,COLUMN_NAME    -- �÷� ��
    ,DATA_TYPE      -- ����
    ,DATA_LENGTH    -- ������ ����
    ,DATA_PRECISION -- NUMBER ��ü �ڸ���
    ,DATA_SCALE     -- NUMBER �Ҽ������� ǥ�� �ڸ���
    ,NULLABLE       -- NULL ����
    ,COLUMN_ID      -- �÷� ����
    ,DATA_DEFAULT   -- �⺻ ��   
  FROM user_tab_columns -- �ش� ������ ���� ���̺� 
   --  dba_tab_columns ��ü ���̺��� ��� 
 WHERE TABLE_NAME = 'cart'   -- ��ȸ �� ���̺� ��


select 
    a.table_name        -- ���̺�
    ,a.constraint_name  -- ���� ���� ��
    ,b.constraint_type  -- P,R,U,C 
    ,a.column_name      -- �ش� �÷�
    ,a.position         -- ���� ���� ����    
 from user_cons_columns a   -- ���� �÷�
    , user_constraints b    -- ���� ����
    -- dba_cons_columns a
    -- , dba_constraints b
where a.owner = b.owner
  and a.table_name = 'sawon'
  and a.constraint_name = b.constraint_name
  and b.constraint_type = 'P'
order by a.constraint_name, a.position


SELECT T1.TABLE_NAME
     , T3.COMMENTS AS TABLE_COMMENTS
     , T1.COLUMN_NAME
     , T2.COMMENTS AS COLUMN_COMMENTS
     , CASE WHEN T1.DATA_TYPE IN ('LONG', 'CLOB', 'DATE') THEN DATA_TYPE
            WHEN T1.DATA_TYPE = 'VARCHAR2' THEN DATA_TYPE || '(' || DATA_LENGTH || ' BYTE)'
            WHEN T1.DATA_TYPE = 'NUMBER'   THEN DATA_TYPE || '(' || DATA_LENGTH || ' BYTE)'
            ELSE T1.DATA_TYPE
             END AS DATA_TYPE
  FROM ALL_TAB_COLUMNS T1
 INNER JOIN USER_COL_COMMENTS T2
    ON T1.TABLE_NAME = T2.TABLE_NAME
   AND T1.COLUMN_NAME = T2.COLUMN_NAME   
 INNER JOIN USER_TAB_COMMENTS T3
    ON T1.TABLE_NAME = T3.TABLE_NAME
 WHERE OWNER = 'scott'
   AND T1.TABLE_NAME = 'sawon'
 ORDER BY T1.TABLE_NAME, T1.COLUMN_ID

*/