--category �Ϸù�ȣ
create sequence seq_category_idx;

--category ���̺� ����
CREATE TABLE Category (
	category_idx	int	NOT NULL,
	category_name	NVARCHAR2(100)	NULL,
	category_code	NVARCHAR2(100)	NULL
);

--category_idx �⺻Ű
ALTER TABLE Category ADD CONSTRAINT PK_CATEGORY PRIMARY KEY (
	category_idx
);

insert into category values (
	seq_category_idx.nextval,
	'fashion',
	'fa'
);

insert into category values (
	seq_category_idx.nextval,
	'electronic',
	'el'
);

insert into category values (
	seq_category_idx.nextval,
	'accessory',
	'ac'
);
commit;
/*
select * from category;
drop table category;
DROP SEQUENCE seq_category_idx
*/