/*

--방명록 생성 
create sequence seq_visit_idx



--테이블 생성 
create table visit
(
	idx			int, 					  --일련번호
	name 		varchar2(100) 	not null, --작성자
	content		varchar2(2000) 	not null, --내용
	pwd			varchar2(100)	not null, --비밀번호
	ip			varchar2(100)	not null, --아이피
	regdate		date			not null, --최초작성일자
	modifydate  date			not null  --최근수정일자
)

--기본키 제약작성(생성)
alter table visit
	add constraint pk_visit_idx primary key(idx);


--데이터 입력 
insert into visit values(seq_visit_idx.nextVal,
							'일길동',
							'내용은 내가 1등',
							'1234',
							'192.168.0.19',
							sysdate,
							sysdate
						);
insert into visit values(seq_visit_idx.nextVal,
							'이길동',
							'내용은 난 2등이네..',
							'1234',
							'192.168.0.19',
							sysdate,
							sysdate
						);

insert into visit values(seq_visit_idx.nextVal,
							'테스트',
							'내용은 난 3등이네..',
							'1234',
							'192.168.0.19',
							sysdate,
							sysdate
						);

insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate,sysdate);

commit


select * from visit order by idx desc


--1건조회
select * from visit where idx=1;



delete from visit where idx =?;
update visit set name='테r',content='dad', pwd='1234', ip='0:0:0:0:0:0:0:1', modifydate=sysdate  where idx =26;

select * from all_tab_comments where table_type ='TABLE'
SELECT * FROM USER_TABLES

select * from ALL_TAB_COLUMNS where TABLE_NAME = 'sungtb'





*/