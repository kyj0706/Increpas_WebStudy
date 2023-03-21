/*

--��� ���̺� ����
create table member
(
	mem_idx 	int,							--ȸ����ȣ
	mem_name  	varchar2(100) 	not null,		--�̸�
	mem_id 	  	varchar2(100) 	not null,		--���̵�
	mem_pwd	  	varchar2(100) 	not null,		--��й�ȣ
	mem_zipcode	varchar2(100)	not null,		--�����ȣ	
	mem_address	varchar2(1000)  not null, 		--�ּ�
	mem_grade	varchar2(100)	default '�Ϲ�',	--���
	mem_regdate	date			default sysdate --��������
)

--�ķ����� Ʋ����.... ������ ..~
alter table member
rename column mem_regdata to mem_regdate


--###�������� ����#####

--��� �⺻Ű(primary) ����
alter table member
	add constraint pk_member_mem_idx primary key(mem_idx);
	
--��� ����ũ(unique) ����
alter table member
	add constraint unique_member_mem_id unique(mem_id);

--�ɹ� üũ(check) ���� 
alter table member
	add constraint check_member_mem_grade check(mem_grade in('�Ϲ�','������'));
	
--###############################################################################

--sample data(inline view)

(select nvl(max(mem_idx),0)+1 from member)

insert into member values(
							(select nvl(max(mem_idx),0)+1 from member),
							'�ϱ浿',
							'one',
							'1234',
							'12345',
							'����� ���Ǳ� ��������5�ٱ�',
							default,
							default
						);

insert into member values(
							(select nvl(max(mem_idx),0)+1 from member),
							'ȫ����',
							'admin',
							'1234',
							'12345',
							'����� ���Ǳ� ��������5�ٱ�',
							'������',
							default
						);
						
insert into member values((select nvl(max(mem_idx),0)+1 from member),?,?,?,?,?,default,default);

update member set mem_name=?, mem_pwd=?, mem_zipcode=?, mem_address=?, mem_grade=? where mem_idx=?	


delete from member where mem_idx=?
delelt


--Ȯ��
select * from member





*/