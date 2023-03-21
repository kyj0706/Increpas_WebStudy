/*

--멤버 테이블 생성
create table member
(
	mem_idx 	int,							--회원번호
	mem_name  	varchar2(100) 	not null,		--이름
	mem_id 	  	varchar2(100) 	not null,		--아이디
	mem_pwd	  	varchar2(100) 	not null,		--비밀번호
	mem_zipcode	varchar2(100)	not null,		--우편번호	
	mem_address	varchar2(1000)  not null, 		--주소
	mem_grade	varchar2(100)	default '일반',	--등급
	mem_regdate	date			default sysdate --가입일자
)

--컴럼명이 틀려서.... 수정함 ..~
alter table member
rename column mem_regdata to mem_regdate


--###제약조건 설정#####

--멤버 기본키(primary) 설정
alter table member
	add constraint pk_member_mem_idx primary key(mem_idx);
	
--멤버 유니크(unique) 설정
alter table member
	add constraint unique_member_mem_id unique(mem_id);

--맴버 체크(check) 설정 
alter table member
	add constraint check_member_mem_grade check(mem_grade in('일반','관리자'));
	
--###############################################################################

--sample data(inline view)

(select nvl(max(mem_idx),0)+1 from member)

insert into member values(
							(select nvl(max(mem_idx),0)+1 from member),
							'일길동',
							'one',
							'1234',
							'12345',
							'서울시 관악구 법원단지5다길',
							default,
							default
						);

insert into member values(
							(select nvl(max(mem_idx),0)+1 from member),
							'홍관리',
							'admin',
							'1234',
							'12345',
							'서울시 관악구 법원단지5다길',
							'관리자',
							default
						);
						
insert into member values((select nvl(max(mem_idx),0)+1 from member),?,?,?,?,?,default,default);

update member set mem_name=?, mem_pwd=?, mem_zipcode=?, mem_address=?, mem_grade=? where mem_idx=?	


delete from member where mem_idx=?
delelt


--확인
select * from member





*/