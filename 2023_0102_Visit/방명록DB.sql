/*

--���� ���� 
create sequence seq_visit_idx



--���̺� ���� 
create table visit
(
	idx			int, 					  --�Ϸù�ȣ
	name 		varchar2(100) 	not null, --�ۼ���
	content		varchar2(2000) 	not null, --����
	pwd			varchar2(100)	not null, --��й�ȣ
	ip			varchar2(100)	not null, --������
	regdate		date			not null, --�����ۼ�����
	modifydate  date			not null  --�ֱټ�������
)

--�⺻Ű �����ۼ�(����)
alter table visit
	add constraint pk_visit_idx primary key(idx);


--������ �Է� 
insert into visit values(seq_visit_idx.nextVal,
							'�ϱ浿',
							'������ ���� 1��',
							'1234',
							'192.168.0.19',
							sysdate,
							sysdate
						);
insert into visit values(seq_visit_idx.nextVal,
							'�̱浿',
							'������ �� 2���̳�..',
							'1234',
							'192.168.0.19',
							sysdate,
							sysdate
						);

insert into visit values(seq_visit_idx.nextVal,
							'�׽�Ʈ',
							'������ �� 3���̳�..',
							'1234',
							'192.168.0.19',
							sysdate,
							sysdate
						);

insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate,sysdate);

commit


select * from visit order by idx desc


--1����ȸ
select * from visit where idx=1;



delete from visit where idx =?;
update visit set name='��r',content='dad', pwd='1234', ip='0:0:0:0:0:0:0:1', modifydate=sysdate  where idx =26;

select * from all_tab_comments where table_type ='TABLE'
SELECT * FROM USER_TABLES

select * from ALL_TAB_COLUMNS where TABLE_NAME = 'sungtb'





*/