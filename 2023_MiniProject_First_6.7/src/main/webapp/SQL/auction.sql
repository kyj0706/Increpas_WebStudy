--auction 일련번호
create sequence seq_auction_idx;

CREATE TABLE Auction (
	auction_idx			int		NOT NULL,	--경매일련번호
	auction_price		int		NULL,		--입찰희망가격
	auction_startdate	DATE	NULL,		--경매시작일자
	auction_enddate		DATE	NULL,		--경매종료일자
	auction_times		int	NULL,			--입찰횟수
	auction_status		NVARCHAR2(30)	NOT NULL,
	product_idx			int	NOT NULL REFERENCES bproduct(product_idx)
);

ALTER TABLE Auction ADD CONSTRAINT PK_AUCTION PRIMARY KEY (
	auction_idx
);

insert into auction values (
	seq_auction_idx.nextval,
	15000000,
	(sysdate+1/24/6),
	sysdate+3,
	1,
	'시작전',
	1
);

insert into auction values (
	seq_auction_idx.nextval,
	2500000, 
	(sysdate+1/24),
	sysdate+3,
	1,
	'시작전',
	2
);

select * from auction;