/*
	--�Ϸù�ȣ ������ü
	create sequence seq_category_idx
	
	--���̺� 
	
	  create table category
  (
     category_idx   int ,  			--ī�װ���ȣ
     category_code  varchar2(100), 	--ī�װ��ڵ��ȣ
     category_name  varchar2(100)	--ī�װ��̸�     
  )
	

	  --�⺻Ű
  alter table category 
     add constraint  pk_category_idx  primary key(category_idx) ;  
     
  --unique
  alter table category
     add constraint  unique_category_code  unique(category_code) ;      

  --sample data
  insert into category values(seq_category_idx.nextVal,'com001','��ǻ��');
  insert into category values(seq_category_idx.nextVal,'ele002','������ǰ');
  insert into category values(seq_category_idx.nextVal,'sp003','������');
  insert into category values(seq_category_idx.nextVal,'acc004','��Ÿ');
  commit
  
  select * from category
  
  select * from product
select * from cart_view;
select * from category

*/