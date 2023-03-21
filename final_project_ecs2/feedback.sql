/*
drop table feedback;
drop sequence seq_feedback_f_idx;

--일련번호관리객체
create sequence seq_feedback_f_idx;

--테이블 생성
create table feedback
(
   f_idx     	 int,					 --피드백 번호
   c_mem_idx     int,					 --회원번호(일련번호)
   c_mem_name	 varchar2(100) not null, --회원명
   s_idx     int,						 --별점번호(일련번호)
   s_no	 int,							 --별점 수
   f_content     clob,				     --내용
   f_regdate date,				         --작성일자
   f_statNm varchar2(500) not null --충전소 명
);

--기본키
alter table feedback
  add constraint  pk_feedback_f_idx  primary key(f_idx) ;

--check제약

--외래키
alter table feedback
  add constraint  fk_feedback_c_mem_idx  foreign key(c_mem_idx) 
                                       references c_member(c_mem_idx);


--sample data
insert into feedback values( seq_feedback_f_idx.nextVal,
                            1,
                            '일길동',
                            1,
                            5,
                            '팝콘',
                            sysdate,
                            '태화빌딩'
);                          
  
insert into feedback values( seq_feedback_f_idx.nextVal,
                            1,
                            '일길동',
                            1,
                            4,
                            '팝1콘',
                            sysdate,
                            '태화빌딩'
);  
        
                                                               
--JDBC용 SQL
insert into  feedback values( (select nvl(max(f_idx),0)+1 from fber),?,?,?,?,?,default,default)                           



select * from feedback;

select * from feedback where f_idx=1;

select * from feedback where c_mem_idx='이길동';

select * from feedback where f_statNm = '태화빌딩';

select * from feedback
where f_chargingname in 
('태화빌딩')

select SUM(s_no) from feedback; 
select avg(s_no) from feedback; 

select 
avg(s_no) 
from feedback
where
f_statNm='태화빌딩';


update fber set f_name=?,f_pwd=?,f_zipcode=?,f_address=?,f_grade=? where f_idx=? 









*/