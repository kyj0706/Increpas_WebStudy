/*

--�Ϸù�ȣ ������ü
create sequence seq_comment_tb_c_cmt_idx;

--���̺����
create table c_comment_tb
(
	c_cmt_idx     int,            --�Ϸù�ȣ
	c_cmt_content varchar2(2000), --����
	c_cmt_ip      varchar2(100),  --������
	c_cmt_regdate date,           --�������
	c_b_idx       int,            --�Խù� ��ȣ
	c_mem_idx     int,            --��� ��ȣ
	c_mem_id      varchar2(100),  --��� ���̵�
	c_mem_name    varchar2(100)   --��� �̸�
);

--�⺻Ű
alter table c_comment_tb
	add constraint pk_c_comment_tb_c_cmt_idx primary key(c_cmt_idx);


select * from c_comment_tb;

------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                            


insert into c_comment_tb values(seq_comment_tb_c_cmt_idx.nextVal,
								'����1��',
								'192.168.0.19',
								sysdate,
								3,
								3,
								'qwer',
								'������'
								);
				



*/