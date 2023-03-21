/*
	 
	select * from product_test;
	drop table product_test;
	drop sequence seq_product_test_idx;
	ALTER TABLE product DROP COLUMN product_enddate;
	
	*/
	
	--�Ϸù�ȣ
	create sequence seq_product_test_idx;
	
	--���̺�
	create table product_test
	(
		product_idx			int,							--��ǰ��ȣ
		product_name		nvarchar2(100)	not null, 		--��ǰ�̸�
		product_content		clob,	          				--��ǰ����
		product_price       int				not null, 		--�ǸŰ���
		
		product_company	    nvarchar2(100)	not null, 
		product_category    nvarchar2(100)	not null, 
		
		product_image1		nvarchar2(500)	not null, 		--�̹���1
		product_image2		nvarchar2(500)	not null, 		--�̹���2
		product_image3		nvarchar2(500)	not null, 		--�̹���3
		product_image4		nvarchar2(500)	not null, 		--�̹���4
		
		product_regdate		date 	default sysdate	     --��ǰ�������
		
		--category_idx		int		not null	REFERENCES category(category_idx),	--ī�װ���ȣ
		--user_idx			int		not null	REFERENCES user_test(user_idx)		--ȸ����ȣ
	);
	
	--�⺻Ű
	alter table product
		add constraint	pk_product_idx  primary key(product_idx);
	
	/*
	--unique
	alter table user_test
		add constraint	unique_user_test_user_id  unique(user_id);
		
	--check
	alter table user_test
		add constraint check_user_test_user_grade check(user_grade in('ȸ��', '������','�Ǹ���'));
	*/	

	--������ �־��
	insert into product_test values
		(seq_product_test_idx.nextVal,
		 'EXCALIBUR BLACKLIGHT', 
 		 '�Ŀ������� 72H (RD720SQ) ȭ��Ʈ���� ���̽������� ���̾Ƹ��� �ϼ��� ���̽� ���ݻ����� �����̾�ũ����Ż �������̽��� 42MM 5 BAR (50M) ��� �۾��� ���� ��Ʈ��,ȭ��Ʈ��� Ʈ���� ���� ��Ŭ, ���� ��ü ���� �߷� �� 152g, ������ ������',
		 14500000, 
		 'ROGER DUBUIS',
		 'Accessory',
		 'RogerDubuis1.png', 
		 'RogerDubuis2.webp', 
		 'RogerDubuis3.webp', 
		 'RogerDubuis4.webp',
		 default
		 );
	     
	insert into product_test values
		(seq_product_test_idx.nextVal,
		 'METRO DATE POWER RESERVE', 
		 '���� ���õ� ��ũ�ٿ��� ������, �Ŀ������� �ε�������, �������� �̽�������, Į���� DUW4401, �����̾��, ���� �����̾� ũ����Ż, 37mm, 3���, 18mm����',
		 2000000, 
		 'NOMOS',
		 'Accessory',
		 'nomos1.jpg', 
		 'nomos2.jpg', 
		 'nomos3.jpg', 
		 'nomos4.jpg',
		 default
		 );
     
	commit;
	
	select * from PRODUCT_TEST;