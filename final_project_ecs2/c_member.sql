/*
create sequence seq_c_member_c_mem_idx;


--���̺� ����
create table c_member
(
   c_mem_idx     	 int,							    --ȸ����ȣ(�Ϸù�ȣ)
   c_mem_name    	 varchar2(100) not null,			--ȸ����
   c_mem_id			 varchar2(100) not null,			--���̵�
   c_mem_pwd		 varchar2(100) not null,			--��й�ȣ
   c_mem_zipcode	 varchar2(10)  not null,			--�����ȣ
   c_mem_address	 varchar2(500) not null,			--�ּ�
   c_mem_grade		 varchar2(100) default '�Ϲ�',		--ȸ�����(�Ϲ�/������)
   c_mem_regdate	 date          default sysdate,	    --��������     
   c_mem_mileage	 int ,      					    --���ϸ���     
   c_mem_chargertype varchar2(100) not null			    --������Ÿ��
) ;

--�⺻Ű
alter table c_member
	add constraint  pk_c_member_c_mem_idx  primary key(c_mem_idx);

--unique
alter table c_member
	add constraint  unique_c_member_c_mem_id  unique(c_mem_id);

--check����
--ȸ�� ���
alter table c_member
	add constraint  check_c_member_c_mem_grade check( c_mem_grade in('�Ϲ�','������') );


------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                            

--������ Ÿ��
alter table c_member
	add constraint check_c_member_c_mem_chargertype check( c_mem_chargertype in('01','02','03','04','05','06'));


--sample data
insert into  c_member values( 
								(select nvl(max(c_mem_idx),0)+1 from c_member),
                            	'�ϱ浿',
                            	'one',
                            	'1234',
                            	'12345',
                            	'����� ���Ǳ� ������552',
                           		default,
                          		default,
                            	0,
                            	'06'
                           	 );
                           	 
insert into  c_member values( 
								(select nvl(max(c_mem_idx),0)+1 from c_member),
                            	'�̱浿',
                            	'2222',
                            	'1234',
                            	'12345',
                            	'����� ���Ǳ� ������552',
                            	default,
                            	default,
                            	0,
                            	'04' 
                           	 );                           
                           
       









*/