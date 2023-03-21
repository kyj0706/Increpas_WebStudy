--auction_order 일련번호
create sequence seq_auction_order_idx;

create table auction_order(
	order_idx	int		not null,
	order_date	date	not null,
	order_price	int		not null,
	order_comment	NVARCHAR2(100)	not null,
	order_receiver	NVARCHAR2(100)	not null,
	order_address	NVARCHAR2(100)	not null,
	order_phone		NVARCHAR2(100)	not null,
	auction_idx	int		not null	references auction(auction_idx),
	member_idx	int		not null	references bmember(member_idx)
);

ALTER TABLE Auction_Order ADD CONSTRAINT PK_AUCTION_ORDER PRIMARY KEY (
	order_idx
);

select * from auction_order;
select * from user_test;

update user_test set user_grade='관리'
where user_idx=6

UPDATE 테이블명
SET 
컬럼1 = 변경할 값,
컬럼2 = 변경할 값
.....
WHERE
조건;

