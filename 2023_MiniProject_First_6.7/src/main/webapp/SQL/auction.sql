--auction �Ϸù�ȣ
create sequence seq_auction_idx;

CREATE TABLE Auction (
	auction_idx			int		NOT NULL,	--����Ϸù�ȣ
	auction_price		int		NULL,		--�����������
	auction_startdate	DATE	NULL,		--��Ž�������
	auction_enddate		DATE	NULL,		--�����������
	auction_times		int	NULL,			--����Ƚ��
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
	'������',
	1
);

insert into auction values (
	seq_auction_idx.nextval,
	2500000, 
	(sysdate+1/24),
	sysdate+3,
	1,
	'������',
	2
);

select * from auction;