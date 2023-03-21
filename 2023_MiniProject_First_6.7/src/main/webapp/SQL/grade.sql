--grade 일련번호
create sequence seq_grade_idx;

--grade table 생성
CREATE TABLE Grade (
	grade_idx	int	NOT NULL,
	grade	NVARCHAR2(30)	NULL,
	grade_rate	FLOAT	NULL
);

ALTER TABLE Grade ADD CONSTRAINT PK_GRADE PRIMARY KEY (
	grade_idx
);

--관리자 등급 생성
insert into grade values (
	seq_grade_idx.nextval,
	'관리자',
	1
);

--판매자 등급 생성
insert into grade values (
	seq_grade_idx.nextval,
	'판매자',
	0.1
);

--일반회원 등급 생성
insert into grade values (
	seq_grade_idx.nextval,
	'일반회원',
	0.05
);

/*

select * from grade
drop table grade
DROP SEQUENCE seq_grade_idx
 */