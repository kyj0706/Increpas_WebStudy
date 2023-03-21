/*
 
select * from bmember;
drop table bmember;
rename table member_test to member;
DROP SEQUENCE seq_bmember_idx
*/

--일련번호
create sequence seq_member_idx;

--테이블
create table bmember
(
	member_idx			int,							--회원번호
	member_name			nvarchar2(100)	not null,		--회원이름
	member_id			nvarchar2(100)	not null,		--아이디
	member_pwd			nvarchar2(100)	not null,		--비밀번호
	member_email		nvarchar2(100)	not null,		--이메일
	member_post			nvarchar2(100)	not null,		--주소
	member_address		nvarchar2(100)	not null,		--우편번호
	member_address2		nvarchar2(100)	not null,		--우편번호
	member_aggrement	nvarchar2(100)	default '동의',	--약관동의
	member_regdate		date			default sysdate,--가입일자
	member_modifydate	date			default sysdate,--수정일자
	grade_idx			int				NOT NULL REFERENCES grade(grade_idx)
);

--기본키
alter table bmember
	add constraint	pk_member_idx  primary key(member_idx);
	
--unique
alter table bmember
	add constraint	unique_bmember_member_id  unique(member_id);

--member 삽입
insert into bmember values (
	seq_bmember_idx.nextval,
	'일길동',
	'one',
	111,
	'one@gmail.com',
	11111,
	'서울시 구로구 구로1동',
	'101호',
	'동의',
	sysdate,
	sysdate,
	3
);

insert into bmember values (
	seq_bmember_idx.nextval,
	'이길동',
	'two',
	222,
	'two@gmail.com',
	22222,
	'서울시 구로구 구로2동',
	'202호',
	'동의',
	sysdate,
	sysdate,
	3
);

insert into bmember values (
	seq_bmember_idx.nextval,
	'관리자',
	'admin',
	900,
	'admin@gmail.com',
	99999,
	'서울시 구로구 구로동',
	'admin',
	'동의',
	sysdate,
	sysdate,
	1
);

insert into bmember values (
	seq_bmember_idx.nextval,
	'판매자',
	'seller',
	800,
	'seller@gmail.com',
	88888,
	'서울시 구로구 구로동',
	'seller',
	'동의',
	sysdate,
	sysdate,
	2
);

commit;