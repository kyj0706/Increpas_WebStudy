/*


--���̺� ����
create table member
(
   mem_idx      int,							--ȸ����ȣ(�Ϸù�ȣ)
   mem_name     varchar2(100) not null,			--ȸ����
   mem_id		varchar2(100) not null,			--���̵�
   mem_pwd		varchar2(100) not null,			--��й�ȣ
   mem_zipcode	varchar2(10)  not null,			--�����ȣ
   mem_address	varchar2(500) not null,			--�ּ�
   mem_grade	varchar2(100) default '�Ϲ�',	--ȸ�����(�Ϲ�/������)
   mem_regdate	date          default sysdate	--��������     
)

--�⺻Ű
alter table member
  add constraint  pk_member_mem_idx  primary key(mem_idx) ;

--unique
alter table member
  add constraint  unique_member_mem_id  unique(mem_id) ;

--check����
alter table member
  add constraint  check_member_mem_grade check( mem_grade in('�Ϲ�','������') );


--sample data
insert into  member values( (select nvl(max(mem_idx),0)+1 from member),
                            '�ϱ浿',
                            'one',
                            '1234',
                            '12345',
                            '����� ���Ǳ� ������552',
                            default,
                            default  
                           ); 
                           
--JDBC�� SQL
insert into  member values( (select nvl(max(mem_idx),0)+1 from member),?,?,?,?,?,default,default)                           

insert into  member values( (select nvl(max(mem_idx),0)+1 from member),
                            '�����',
                            'admin',
                            '1234',
                            '12345',
                            '����� ���Ǳ� ������552',
                            '������',
                            default  
                           );

select * from member

select * from member where mem_idx=1

select * from member where mem_id='admin'

select * from member where mem_id='one'


update member set mem_name=?,mem_pwd=?,mem_zipcode=?,mem_address=?,mem_grade=? where mem_idx=? 








*/