/*
--�Ϸù�ȣ���� ��ü����
	create sequence seq_board_b_idx

--���̺� ����
	  create table board
  (
      b_idx  int,					--�Ϸù�ȣ
      b_subject varchar2(200),		--����
      b_content clob,				--����
      b_ip      varchar2(100),		--������
      b_regdate date,				--�ۼ�����
      b_readhit int,				--��ȸ��
      b_use    char(1) default 'y',	--�������(��������)
      mem_idx   int,				--ȸ����ȣ(FK)
      mem_name  varchar2(100),		--ȸ����
      b_ref     int,				--�����۹�ȣ
      b_step    int,				--�ۼ���
      b_depth   int					--�۱���
  )
	
--�⺻Ű
 alter table board
 	add constraint pk_board_b_idx primary key(b_idx);
 	
--�ܷ�Ű
 alter table board
 	add constraint fk_boart_mem_idx foreign key(mem_idx)
 									references member(mem_idx);
 									

						
select * from member																		
--���۾���
insert into board values( 
	seq_board_b_idx.nextVal,
	'���� 1���̴�!!',
	'�̹����� 1���̳�',						
	'192.168.0.19',
	 sysdate,
	 0,
	 'y',
	 7,
	 'test',
	 seq_board_b_idx.currVal,
	 0,
	 0				
);

select * from board order by b_ref desc, b_step asc


--��۾���
insert into board values( 
	seq_board_b_idx.nextVal,
	'1���Ҽ� �־��µ�',
	'2���߳�',						
	'192.168.0.19',
	 sysdate,
	 0,
	 'y',
	 2,
	 'ȫ����',
	 1,
	 1,
	 1				
);

--��۾���(1���� �ޱ�)
insert into board values( 
	seq_board_b_idx.nextVal,
	'�� �� 1��ȵ�',
	'�Ұ�����.',						
	'192.168.0.19',
	 sysdate,
	 0,
	 'y',
	 7,
	 'test',
	 1,
	 2,
	 2				
);


commit



select * from board order by b_ref desc, b_step asc
--Paging ó���� ���� SQL��
	
	select * from
	(
		select
			rank() over(order by b_ref desc, b_step asc) as no,
			b.*
		from
			(select * from board) b
	)	
	where no between 1 and 10;


--2303036 ��� ������ ī��Ʈ 

	select 
		bb.*,
		(select count(*) from comment_tb where b_idx =bb.b_idx) as comment_count
	 from
	(
		select
			rank() over(order by b_ref desc, b_step asc) as no,
			b.*
		from
			(select * from board) b
	) bb	
	where no between 1 and 10;




--��ü �Խù�  ������

	select 
		(select count(*) - no - 1 from board) no1,
		bb.* 
	from
	(
		select
			rank() over(order by b_ref desc, b_step asc) as no,
			b.*
		from
			(select * from board) b
	) bb	
	where no between 1 and 10;


--��ü �Խù��� ���ϱ�

	select nvl(count(*),0) from board
	


select * from board;


update board set b_use = 'y';






*/