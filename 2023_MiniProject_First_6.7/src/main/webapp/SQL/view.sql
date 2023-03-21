--member와 grade를 보여주는 view 생성
create view member_grade_view
as
	SELECT member_idx, member_id, member_pwd, member_name, member_email, member_address, member_address2, member_regdate, member_modifydate, m.grade_idx, grade, grade_rate
	FROM bmember m
	JOIN grade g ON m.grade_idx = g.grade_idx;

--member_grade_view
select * from member_grade_view order by member_idx asc;




--product와 category를 보여주는 view 생성
create view product_category_view
as
	SELECT	product_idx, product_name, product_price, product_image1, product_regdate, 
			c.category_idx, category_name, category_code, member_idx
	FROM product p
	JOIN category c ON p.category_idx = c.category_idx
	where p.category_idx = c.category_idx;

--product_category_view
select * from product_category_view




--product category member를 한번에 보여주는 view
create view product_view
as
	SELECT	product_idx, product_name, product_content, product_price, product_image1, product_image2, product_image3, product_image4, product_regdate,
			category_idx, category_name, mg.*
	FROM product_category_view pc
	JOIN member_grade_view mg ON pc.member_idx = mg.member_idx
	where pc.member_idx = mg.member_idx;

--product_view
select * from product_view;



--auction와 product를 보여주는 view 생성
create view auction_product_view
as
	SELECT	auction_idx, auction_startprice, auction_high, auction_start, auction_end, auction_times, auction_status, p.*
	FROM auction a
	JOIN product p ON p.product_idx = a.product_idx
	where p.product_idx = a.product_idx;

--product_category_view
select * from auction_product_view;

select * from auction_order;


select ((auction_end-auction_start)*24*60*60) as period from auction;
select (TO_CHAR(auction_end,'YYYY-MM-DD HH24:MI:SS') - TO_CHAR(auction_start,'YYYY-MM-DD HH24:MI:SS'))*24*60*60 as period from auction;
select TO_CHAR(auction_end, 'YYYY-MM-DD HH24:MI:SS') from auction;


/*

select * from product;
select * from category;

drop view product_category_view

*/