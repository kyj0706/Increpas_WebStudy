
--�԰�
create sequence seq_product_in_idx

create table product_in
(
   idx   int,			  --�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --�԰����	
   regdate date           --�԰�����
)

alter table product_in
  add constraint pk_product_in_idx primary key(idx);
  
 

--���
create sequence seq_product_out_idx

create table product_out
(
   idx   int ,            --�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --������	
   regdate date           --�������
)

alter table product_out
  add constraint pk_product_out_idx primary key(idx);



--���
create sequence seq_product_remain_idx

create table product_remain
(
   idx   int          ,   --�Ϸù�ȣ
   name  varchar2(255),   --��ǰ�� 
   cnt   int,			  --������	
   regdate date           --�������
)

alter table product_remain
  add constraint pk_product_remain_idx primary key(idx);

alter table product_remain
  add constraint unique_product_remain_name unique(name);
  
  
  
  