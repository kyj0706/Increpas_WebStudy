/*
 
 --일련번호관리객체
 create sequence seq_comment_tb_cmt_idx
 
 --테이블생성
 create table comment_tb
 (
 	cmt_idx 		int, 					--일련번호
 	cmt_content		varchar2(2000),			--내용
 	cmt_ip			varchar2(100),			--아이피
 	cmt_regdate		date,					--등록일자
 	b_idx			int,					--게시물번호
 	mem_idx			int,					--유저번호
 	mem_id			varchar2(100),			--유저아이디
 	mem_name		varchar2(100)			--유저이름
 
 
 )
 
 --기본키설정
 alter table comment_tb
 	add constraint pk_comment_tb_cmt_idx primary key(cmt_idx);
 
--외래키(참조키) 설정
alter table comment_tb
	add constraint fk_comment_tb_b_idx foreign key(b_idx)
								references board(b_idx);


-mybatis mapper용 추가 SQL
insert into comment_tb values(seq_comment_tb_cmt_idx.nextVal,
							 #{cmt_content},
							 #{cmt_ip},
							 sysdate,
							 #{b_idx},
							 #{mem_idx},
							 #{mem_id},
							 #{mem_name}
							 )
			
						
 
 
 
 
 
 
 select * from comment_tb
 
 --1. 조건
 select * from comment_tb where b_idx=43 order by cmt_idx desc
 
 --댓글 paging 처리 SQL

 select * from
 (
   select 
 	rank() over (order by cmt_idx desc) as no,
 	c.*
 	from
 	(select * from comment_tb where b_idx=43) c
 )	
 	where no between 11 and 15
 
 --b_idx의 전체 게시물수
 select nvl(count(*),0) from comment_tb where b_idx=50
 
 
 
 
 
 
 
 */

