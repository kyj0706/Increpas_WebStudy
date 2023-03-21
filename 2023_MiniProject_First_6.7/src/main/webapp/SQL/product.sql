/*
	 
	select * from product_test;
	drop table product_test;
	drop sequence seq_product_test_idx;
	ALTER TABLE product DROP COLUMN product_enddate;
	
	*/
	
	--일련번호
	create sequence seq_product_test_idx;
	
	--테이블
	create table product_test
	(
		product_idx			int,							--제품번호
		product_name		nvarchar2(100)	not null, 		--제품이름
		product_content		clob,	          				--제품설명
		product_price       int				not null, 		--판매가격
		
		product_company	    nvarchar2(100)	not null, 
		product_category    nvarchar2(100)	not null, 
		
		product_image1		nvarchar2(500)	not null, 		--이미지1
		product_image2		nvarchar2(500)	not null, 		--이미지2
		product_image3		nvarchar2(500)	not null, 		--이미지3
		product_image4		nvarchar2(500)	not null, 		--이미지4
		
		product_regdate		date 	default sysdate	     --상품등록일자
		
		--category_idx		int		not null	REFERENCES category(category_idx),	--카테고리번호
		--user_idx			int		not null	REFERENCES user_test(user_idx)		--회원번호
	);
	
	--기본키
	alter table product
		add constraint	pk_product_idx  primary key(product_idx);
	
	/*
	--unique
	alter table user_test
		add constraint	unique_user_test_user_id  unique(user_id);
		
	--check
	alter table user_test
		add constraint check_user_test_user_grade check(user_grade in('회원', '관리자','판매자'));
	*/	

	--데이터 넣어보기
	insert into product_test values
		(seq_product_test_idx.nextVal,
		 'EXCALIBUR BLACKLIGHT', 
 		 '파워리저브 72H (RD720SQ) 화이트골드와 케이스라운드컷 다이아몬드로 완성된 케이스 무반사코팅 사파이어크리스탈 오픈케이스백 42MM 5 BAR (50M) 방수 송아지 가죽 스트랩,화이트골드 트리플 폴딩 버클, 빠른 교체 가능 중량 약 152g, 원산지 스위스',
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
		 '젊고 세련된 마크바운의 디자인, 파워리저브 인디케이터, 독점적인 이스케이프, 칼리버 DUW4401, 사파이어백, 돔형 사파이어 크리스탈, 37mm, 3기압, 18mm러그',
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