--grade �Ϸù�ȣ
create sequence seq_grade_idx;

--grade table ����
CREATE TABLE Grade (
	grade_idx	int	NOT NULL,
	grade	NVARCHAR2(30)	NULL,
	grade_rate	FLOAT	NULL
);

ALTER TABLE Grade ADD CONSTRAINT PK_GRADE PRIMARY KEY (
	grade_idx
);

--������ ��� ����
insert into grade values (
	seq_grade_idx.nextval,
	'������',
	1
);

--�Ǹ��� ��� ����
insert into grade values (
	seq_grade_idx.nextval,
	'�Ǹ���',
	0.1
);

--�Ϲ�ȸ�� ��� ����
insert into grade values (
	seq_grade_idx.nextval,
	'�Ϲ�ȸ��',
	0.05
);

/*

select * from grade
drop table grade
DROP SEQUENCE seq_grade_idx
 */