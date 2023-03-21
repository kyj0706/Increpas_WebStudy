/*
drop table c_board;
drop sequence seq_c_board_c_b_idx;

--일련번호관리객체
create sequence seq_c_board_c_b_idx;

--테이블생성
  create table c_board
  (
      c_b_idx  int,					--일련번호
      c_b_subject varchar2(200),		--제목
      c_b_content clob,				--내용
      c_b_ip      varchar2(100),		--아이피
      c_b_regdate date,				--작성일자
      c_b_readhit int,				--조회수
      c_b_use    char(1) default 'y',	--사용유무(삭제유무)
      c_mem_idx   int,				--회원번호(FK)
      c_mem_name  varchar2(100),		--회원명
      c_b_ref     int,				--참조글번호
      c_b_step    int,				--글순서
      c_b_depth   int					--글깊이
  );

--기본키
  alter table c_board
     add constraint  pk_c_board_c_b_idx  primary key(c_b_idx);
     
--외래키
  alter table c_board
     add constraint  fk_c_board_c_mem_idx  foreign key(c_mem_idx) 
                                       references c_member(c_mem_idx); 
                                       
------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                            
                                       

                                                                                   
--새글쓰기
  insert into c_board values( seq_c_board_c_b_idx.nextVal,
                            '내가 1등이다!!',
                            '이번에도 1등이네',
                            '192.168.0.23',
                            sysdate,
                            0,
                            'y',
                            1,
                            'one',
                            seq_c_board_c_b_idx.currVal,
                            0,
                            0
    );                                           
        
--답글쓰기
    insert into c_board values( seq_c_board_c_b_idx.nextVal,
                            '아쉽네 내가 1등할수 있었는데',
                            '다음에는 내가 1등해야지',
                            '192.168.0.23',
                            sysdate,
                            0,
                            'y',
                            2,
                            '2222',
                            1,
                            1,
                            1
    );   
    
*/