/*
--일련번호관리 객체생성
	create sequence seq_board_b_idx

--테이블 생성
	  create table board
  (
      b_idx  int,					--일련번호
      b_subject varchar2(200),		--제목
      b_content clob,				--내용
      b_ip      varchar2(100),		--아이피
      b_regdate date,				--작성일자
      b_readhit int,				--조회수
      b_use    char(1) default 'y',	--사용유무(삭제유무)
      mem_idx   int,				--회원번호(FK)
      mem_name  varchar2(100),		--회원명
      b_ref     int,				--참조글번호
      b_step    int,				--글순서
      b_depth   int					--글깊이
  )
	
--기본키
 alter table board
 	add constraint pk_board_b_idx primary key(b_idx);
 	
--외래키
 alter table board
 	add constraint fk_boart_mem_idx foreign key(mem_idx)
 									references member(mem_idx);
 									

						
select * from member																		
--새글쓰기
insert into board values( 
	seq_board_b_idx.nextVal,
	'내가 1등이다!!',
	'이번에도 1등이네',						
	'192.168.0.19',
	 sysdate,
	 0,
	 'y',
	 7,
	 'test',
	 seq_board_b_idx.currVal,
	 0,
	 0				
);

select * from board order by b_ref desc, b_step asc


--답글쓰기
insert into board values( 
	seq_board_b_idx.nextVal,
	'1등할수 있었는데',
	'2등했네',						
	'192.168.0.19',
	 sysdate,
	 0,
	 'y',
	 2,
	 '홍관리',
	 1,
	 1,
	 1				
);

--답글쓰기(1개더 달기)
insert into board values( 
	seq_board_b_idx.nextVal,
	'훗 넌 1등안되',
	'불가능해.',						
	'192.168.0.19',
	 sysdate,
	 0,
	 'y',
	 7,
	 'test',
	 1,
	 2,
	 2				
);


commit



select * from board order by b_ref desc, b_step asc
--Paging 처리를 위한 SQL문
	
	select * from
	(
		select
			rank() over(order by b_ref desc, b_step asc) as no,
			b.*
		from
			(select * from board) b
	)	
	where no between 1 and 10;


--2303036 댓글 갯수의 카운트 

	select 
		bb.*,
		(select count(*) from comment_tb where b_idx =bb.b_idx) as comment_count
	 from
	(
		select
			rank() over(order by b_ref desc, b_step asc) as no,
			b.*
		from
			(select * from board) b
	) bb	
	where no between 1 and 10;




--전체 게시물  역으로

	select 
		(select count(*) - no - 1 from board) no1,
		bb.* 
	from
	(
		select
			rank() over(order by b_ref desc, b_step asc) as no,
			b.*
		from
			(select * from board) b
	) bb	
	where no between 1 and 10;


--전체 게시물수 구하기

	select nvl(count(*),0) from board
	


select * from board;


update board set b_use = 'y';






*/