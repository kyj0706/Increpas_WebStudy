/*
 
select * from bmember;
drop table bmember;
rename table member_test to member;
DROP SEQUENCE seq_bmember_idx
*/

--�Ϸù�ȣ
create sequence seq_member_idx;

--���̺�
create table bmember
(
	member_idx			int,							--ȸ����ȣ
	member_name			nvarchar2(100)	not null,		--ȸ���̸�
	member_id			nvarchar2(100)	not null,		--���̵�
	member_pwd			nvarchar2(100)	not null,		--��й�ȣ
	member_email		nvarchar2(100)	not null,		--�̸���
	member_post			nvarchar2(100)	not null,		--�ּ�
	member_address		nvarchar2(100)	not null,		--�����ȣ
	member_address2		nvarchar2(100)	not null,		--�����ȣ
	member_aggrement	nvarchar2(100)	default '����',	--�������
	member_regdate		date			default sysdate,--��������
	member_modifydate	date			default sysdate,--��������
	grade_idx			int				NOT NULL REFERENCES grade(grade_idx)
);

--�⺻Ű
alter table bmember
	add constraint	pk_member_idx  primary key(member_idx);
	
--unique
alter table bmember
	add constraint	unique_bmember_member_id  unique(member_id);

--member ����
insert into bmember values (
	seq_bmember_idx.nextval,
	'�ϱ浿',
	'one',
	111,
	'one@gmail.com',
	11111,
	'����� ���α� ����1��',
	'101ȣ',
	'����',
	sysdate,
	sysdate,
	3
);

insert into bmember values (
	seq_bmember_idx.nextval,
	'�̱浿',
	'two',
	222,
	'two@gmail.com',
	22222,
	'����� ���α� ����2��',
	'202ȣ',
	'����',
	sysdate,
	sysdate,
	3
);

insert into bmember values (
	seq_bmember_idx.nextval,
	'������',
	'admin',
	900,
	'admin@gmail.com',
	99999,
	'����� ���α� ���ε�',
	'admin',
	'����',
	sysdate,
	sysdate,
	1
);

insert into bmember values (
	seq_bmember_idx.nextval,
	'�Ǹ���',
	'seller',
	800,
	'seller@gmail.com',
	88888,
	'����� ���α� ���ε�',
	'seller',
	'����',
	sysdate,
	sysdate,
	2
);

commit;