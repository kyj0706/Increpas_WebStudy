/*
--��ǰ�Ϸù�ȣ ������ü
create sequence seq_product_idx
increment by 1
start with 1;

--��ǰ���̺�
CREATE TABLE product	(
p_idx		 int,								--�Ϸù�ȣ
category	 varchar2(100)		Not Null,		--ī�װ�(��ǻ��/������)
p_num		 varchar2(100)		Not Null,		--��ǰ��ȣ(�𵨹�ȣ)
p_name		 varchar2(200)		Not Null,		--��ǰ��
p_company    varchar2(200)		Not Null,		--������
p_price		 int				Not Null,		--����(�ܰ�)
p_saleprice  int				Not Null,		--���ΰ�
p_image_s	 varchar2(255)		Null,			--��ǰ�̹���(��)
p_image_l	 varchar2(255)		Null,			--��ǰ�̹���(��)
p_content	 clob				Not Null,		--��ǰ����
p_date		 date				Not Null		--�������		
) ;

select * from product
select * from cart_view;
select * from category
--�⺻Ű����
alter table product
	add constraint pk_product_p_idx primary key(p_idx);

--unique����	
alter table product
	add constraint unique_product_p_num unique(p_num);


insert into product values(seq_product_idx.nextVal,'sp003', 'RC-113',
'��ü�� �ζ���','��ü��',100000,70000,'pds1.jpg','pds1_z.jpg',
'���̿��ƽ� ��ǳ ���Ϸ�-HGPU SHELL * Ư�� ��� ��� ��â * �Ź߲� �޸� ��Ŭ * �� ���� ���� �ż��� �Ź߲� �ý��� * ���� �޸� ������ ���� ����� ��ǳ���� ������ ���̳� * �� ��ǳ �ý��� * ��ǳ���� ��ü������ �Ź߹�â * �ս��� ��Ʈ�� �ý���(�ű� ���� �Ա�) * ����� �˷�̴� ������ * 80mm 82a hyper dubbs �� * ��ö �����̼� * ABEC-5 ���',sysdate);

insert into product values(seq_product_idx.nextVal,'ele002', 'vC-13',
'���PDP-TV','���',1500000,750000,'pds4.jpg','pds4_z.jpg',
'����~ ����! 
������ ������~ ��ȸ ���� �ʾ�~~',sysdate);


select * from product;

select * from product where category='sp003' 
commit
*/








