/*
	--일련번호 관리객체
	create sequence seq_category_idx
	
	--테이블 
	
	  create table category
  (
     category_idx   int ,  			--카테고리번호
     category_code  varchar2(100), 	--카테고리코드번호
     category_name  varchar2(100)	--카테고리이름     
  )
	

	  --기본키
  alter table category 
     add constraint  pk_category_idx  primary key(category_idx) ;  
     
  --unique
  alter table category
     add constraint  unique_category_code  unique(category_code) ;      

  --sample data
  insert into category values(seq_category_idx.nextVal,'com001','컴퓨터');
  insert into category values(seq_category_idx.nextVal,'ele002','가전제품');
  insert into category values(seq_category_idx.nextVal,'sp003','스포츠');
  insert into category values(seq_category_idx.nextVal,'acc004','기타');
  commit
  
  select * from category
  
  select * from product
select * from cart_view;
select * from category

*/