/*
drop table star;
drop sequence seq_star_s_idx;

--�Ϸù�ȣ������ü
create sequence seq_star_s_idx;


--���̺� ����
create table star
(  
   s_idx int, --�ǵ�� ��ȣ
   s_no  int  --���� ��
) ;

insert into star values( 
	seq_star_s_idx.nextVal,
	5
);

select * from star







*/