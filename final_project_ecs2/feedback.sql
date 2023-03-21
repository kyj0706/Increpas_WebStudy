/*
drop table feedback;
drop sequence seq_feedback_f_idx;

--�Ϸù�ȣ������ü
create sequence seq_feedback_f_idx;

--���̺� ����
create table feedback
(
   f_idx     	 int,					 --�ǵ�� ��ȣ
   c_mem_idx     int,					 --ȸ����ȣ(�Ϸù�ȣ)
   c_mem_name	 varchar2(100) not null, --ȸ����
   s_idx     int,						 --������ȣ(�Ϸù�ȣ)
   s_no	 int,							 --���� ��
   f_content     clob,				     --����
   f_regdate date,				         --�ۼ�����
   f_statNm varchar2(500) not null --������ ��
);

--�⺻Ű
alter table feedback
  add constraint  pk_feedback_f_idx  primary key(f_idx) ;

--check����

--�ܷ�Ű
alter table feedback
  add constraint  fk_feedback_c_mem_idx  foreign key(c_mem_idx) 
                                       references c_member(c_mem_idx);


--sample data
insert into feedback values( seq_feedback_f_idx.nextVal,
                            1,
                            '�ϱ浿',
                            1,
                            5,
                            '����',
                            sysdate,
                            '��ȭ����'
);                          
  
insert into feedback values( seq_feedback_f_idx.nextVal,
                            1,
                            '�ϱ浿',
                            1,
                            4,
                            '��1��',
                            sysdate,
                            '��ȭ����'
);  
        
                                                               
--JDBC�� SQL
insert into  feedback values( (select nvl(max(f_idx),0)+1 from fber),?,?,?,?,?,default,default)                           



select * from feedback;

select * from feedback where f_idx=1;

select * from feedback where c_mem_idx='�̱浿';

select * from feedback where f_statNm = '��ȭ����';

select * from feedback
where f_chargingname in 
('��ȭ����')

select SUM(s_no) from feedback; 
select avg(s_no) from feedback; 

select 
avg(s_no) 
from feedback
where
f_statNm='��ȭ����';


update fber set f_name=?,f_pwd=?,f_zipcode=?,f_address=?,f_grade=? where f_idx=? 









*/