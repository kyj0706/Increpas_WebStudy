/*

--일련번호 관리객체

create sequence seq_photo_p_idx

--테이블 생성
create table photo
(
	p_idx 			int,						--일련번호
	p_title			varchar2(2000) 	not null,	--제목
	p_content		varchar2(2000) 	not null,	--내용
	p_filename		varchar2(200)	not null,	--파일명
	p_ip			varchar2(100)	not null,	--아이피
	p_regdate 		date,						--등록일자
	p_modifydate	date,						--최근수정일자
	mem_idx			int							--등록회원번호

);
--컴럼명이 틀려서.... 수정함 ..~
alter table photo
rename column p_modifyfate to p_modifydate



--기본키설정
alter table photo
	add constraint pk_photo_p_idx primary key(p_idx);


--외래키 설정
alter table photo
	add constraint fk_photo_mem_idx	foreign key(mem_idx)
									references member(mem_idx);
									
---##########################################################################################									
--부모키 제거시 참조하는 자식정보를 모두 삭제하는 기능 DB만 삭제 된다.? [지금은 이렇게 하지 않는다 .]
	외래키지정 on delelt cascade
	--이렇게 할수 있는데 하지말아라  !!! 
	alter table photo
	add constraint fk_photo_mem_idx	foreign key(mem_idx)
									references member(mem_idx)
									on delelt cascade;
---##########################################################################################									

--조회 

select * from photo
						
select * from photo	

--추가
insert into photo values(seq_photo_p_idx.nextVal,?,?,?,?,sysdate,sysdate,?)								
																																				
--업데이트
update photo set p_title='아이유다',p_content='아이유네 ~ ',p_modifydate=sysdate, p_ip='192.168.0.19' where p_idx =1;

update photo set p_title=?,p_content=?,p_content=?,p_modifydate=sysdate where p_idx=?


*/