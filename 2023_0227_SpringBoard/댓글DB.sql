/*
 
 --�Ϸù�ȣ������ü
 create sequence seq_comment_tb_cmt_idx
 
 --���̺����
 create table comment_tb
 (
 	cmt_idx 		int, 					--�Ϸù�ȣ
 	cmt_content		varchar2(2000),			--����
 	cmt_ip			varchar2(100),			--������
 	cmt_regdate		date,					--�������
 	b_idx			int,					--�Խù���ȣ
 	mem_idx			int,					--������ȣ
 	mem_id			varchar2(100),			--�������̵�
 	mem_name		varchar2(100)			--�����̸�
 
 
 )
 
 --�⺻Ű����
 alter table comment_tb
 	add constraint pk_comment_tb_cmt_idx primary key(cmt_idx);
 
--�ܷ�Ű(����Ű) ����
alter table comment_tb
	add constraint fk_comment_tb_b_idx foreign key(b_idx)
								references board(b_idx);


-mybatis mapper�� �߰� SQL
insert into comment_tb values(seq_comment_tb_cmt_idx.nextVal,
							 #{cmt_content},
							 #{cmt_ip},
							 sysdate,
							 #{b_idx},
							 #{mem_idx},
							 #{mem_id},
							 #{mem_name}
							 )
			
						
 
 
 
 
 
 
 select * from comment_tb
 
 --1. ����
 select * from comment_tb where b_idx=43 order by cmt_idx desc
 
 --��� paging ó�� SQL

 select * from
 (
   select 
 	rank() over (order by cmt_idx desc) as no,
 	c.*
 	from
 	(select * from comment_tb where b_idx=43) c
 )	
 	where no between 11 and 15
 
 --b_idx�� ��ü �Խù���
 select nvl(count(*),0) from comment_tb where b_idx=50
 
 
 
 
 
 
 
 */

