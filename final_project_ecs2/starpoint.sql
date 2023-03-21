/*
drop table star;
drop sequence seq_star_s_idx;

--일련번호관리객체
create sequence seq_star_s_idx;


--테이블 생성
create table star
(  
   s_idx int, --피드백 번호
   s_no  int  --별점 수
) ;

insert into star values( 
	seq_star_s_idx.nextVal,
	5
);

select * from star







*/