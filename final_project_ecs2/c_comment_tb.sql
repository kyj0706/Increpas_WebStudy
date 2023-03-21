/*

--일련번호 관리객체
create sequence seq_comment_tb_c_cmt_idx;

--테이블생성
create table c_comment_tb
(
	c_cmt_idx     int,            --일련번호
	c_cmt_content varchar2(2000), --내용
	c_cmt_ip      varchar2(100),  --아이피
	c_cmt_regdate date,           --등록일자
	c_b_idx       int,            --게시물 번호
	c_mem_idx     int,            --멤버 번호
	c_mem_id      varchar2(100),  --멤버 아이디
	c_mem_name    varchar2(100)   --멤버 이름
);

--기본키
alter table c_comment_tb
	add constraint pk_c_comment_tb_c_cmt_idx primary key(c_cmt_idx);


select * from c_comment_tb;

------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                            


insert into c_comment_tb values(seq_comment_tb_c_cmt_idx.nextVal,
								'내가1등',
								'192.168.0.19',
								sysdate,
								3,
								3,
								'qwer',
								'전민제'
								);
				



*/