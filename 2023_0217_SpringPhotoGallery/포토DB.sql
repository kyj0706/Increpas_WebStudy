/*

--일련번호관리객체
create sequence  seq_photo_p_idx

--테이블생성
create table photo
(
   p_idx      int,						--일련번호
   p_title    varchar2(200) not null,	--제목
   p_content  varchar2(2000) not null,	--내용
   p_filename varchar2(200) not null,	--화일명
   p_ip	      varchar2(100) not null,	--아이피
   p_regdate    date,					--등록일자
   p_modifydate date,					--최근수정일자
   mem_idx    int                       --등록회원번호
)

--JDBC용 insert
insert into photo values(seq_photo_p_idx.nextVal , ? , ? , ? , ? , sysdate , sysdate , ?)


--기본키
alter table photo
  add constraint  pk_photo_p_idx  primary key(p_idx) ;
  
--외래키
alter table photo
  add constraint  fk_photo_mem_idx  foreign key(mem_idx)
                                    references  member(mem_idx); 
                                    

--부모키 제거시 참조하는 자식정보를 모두 삭제(할 수 있다)
(X)alter table photo
     add constraint  fk_photo_mem_idx  foreign key(mem_idx)
                                    references  member(mem_idx)
                                    on delete cascade
  

select * from photo





*/