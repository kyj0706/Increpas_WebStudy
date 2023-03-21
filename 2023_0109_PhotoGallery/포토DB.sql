/*

--�Ϸù�ȣ ������ü

create sequence seq_photo_p_idx

--���̺� ����
create table photo
(
	p_idx 			int,						--�Ϸù�ȣ
	p_title			varchar2(2000) 	not null,	--����
	p_content		varchar2(2000) 	not null,	--����
	p_filename		varchar2(200)	not null,	--���ϸ�
	p_ip			varchar2(100)	not null,	--������
	p_regdate 		date,						--�������
	p_modifydate	date,						--�ֱټ�������
	mem_idx			int							--���ȸ����ȣ

);
--�ķ����� Ʋ����.... ������ ..~
alter table photo
rename column p_modifyfate to p_modifydate



--�⺻Ű����
alter table photo
	add constraint pk_photo_p_idx primary key(p_idx);


--�ܷ�Ű ����
alter table photo
	add constraint fk_photo_mem_idx	foreign key(mem_idx)
									references member(mem_idx);
									
---##########################################################################################									
--�θ�Ű ���Ž� �����ϴ� �ڽ������� ��� �����ϴ� ��� DB�� ���� �ȴ�.? [������ �̷��� ���� �ʴ´� .]
	�ܷ�Ű���� on delelt cascade
	--�̷��� �Ҽ� �ִµ� �������ƶ�  !!! 
	alter table photo
	add constraint fk_photo_mem_idx	foreign key(mem_idx)
									references member(mem_idx)
									on delelt cascade;
---##########################################################################################									

--��ȸ 

select * from photo
						
select * from photo	

--�߰�
insert into photo values(seq_photo_p_idx.nextVal,?,?,?,?,sysdate,sysdate,?)								
																																				
--������Ʈ
update photo set p_title='��������',p_content='�������� ~ ',p_modifydate=sysdate, p_ip='192.168.0.19' where p_idx =1;

update photo set p_title=?,p_content=?,p_content=?,p_modifydate=sysdate where p_idx=?


*/