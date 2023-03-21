/*

--장바구니 일련번호
create sequence seq_cart_idx

--장바구니 테이블
create table cart
(
  c_idx  int,   --장바구니일련번호
  c_cnt  int,	--수량
  p_idx  int,	--제품번호
  mem_idx int	--회원번호
)

--기본키
alter table cart
 add constraint pk_cart_c_idx primary key(c_idx);


--상품테이블(product)의 idx와 p_idx간의 외래키 설정
alter table cart
  add constraint fk_cart_p_idx foreign key(p_idx) 
                               references product(p_idx)
                               on delete cascade;

--회원테이블 mem_idx와 mem_idx간의 외래키 설정
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

-- Join을 통해서 조회정보를 추출

create or replace view cart_view
as
	select
	   c_idx, 	p.p_idx, 	p_num,	p_name,		p_price,	p_saleprice,
	   c_cnt, 	c_cnt* p_saleprice amount,	mem_idx
	   
	from product p inner join  cart c
		
		on p.p_idx = c.p_idx  

select * from cart_view;

select * from cart_view where mem_idx=2;

--장바구니 상품의 총계
select sum(amount) from cart_view;
select sum(amount) from cart_view where mem_idx=2;
select nvl(sum(amount),0) from cart_view where mem_idx=1;





update cart set c_cnt=#{c_cnt} where c_idx=#{c_idx} 

deled



select * from sawon


SELECT 
    TABLE_NAME
    ,COLUMN_NAME    -- 컬럼 명
    ,DATA_TYPE      -- 유형
    ,DATA_LENGTH    -- 데이터 길이
    ,DATA_PRECISION -- NUMBER 전체 자릿수
    ,DATA_SCALE     -- NUMBER 소수점이하 표현 자릿수
    ,NULLABLE       -- NULL 여부
    ,COLUMN_ID      -- 컬럼 순서
    ,DATA_DEFAULT   -- 기본 값   
  FROM user_tab_columns -- 해당 계정에 속한 테이블 
   --  dba_tab_columns 전체 테이블의 경우 
 WHERE TABLE_NAME = 'cart'   -- 조회 할 테이블 명


select 
    a.table_name        -- 테이블
    ,a.constraint_name  -- 제약 조건 명
    ,b.constraint_type  -- P,R,U,C 
    ,a.column_name      -- 해당 컬럼
    ,a.position         -- 제약 조건 순서    
 from user_cons_columns a   -- 제약 컬럼
    , user_constraints b    -- 제약 조건
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