/*
create sequence seq_c_member_c_mem_idx;


--테이블 생성
create table c_member
(
   c_mem_idx     	 int,							    --회원번호(일련번호)
   c_mem_name    	 varchar2(100) not null,			--회원명
   c_mem_id			 varchar2(100) not null,			--아이디
   c_mem_pwd		 varchar2(100) not null,			--비밀번호
   c_mem_zipcode	 varchar2(10)  not null,			--우편번호
   c_mem_address	 varchar2(500) not null,			--주소
   c_mem_grade		 varchar2(100) default '일반',		--회원등급(일반/관리자)
   c_mem_regdate	 date          default sysdate,	    --가입일자     
   c_mem_mileage	 int ,      					    --마일리지     
   c_mem_chargertype varchar2(100) not null			    --충전기타입
) ;

--기본키
alter table c_member
	add constraint  pk_c_member_c_mem_idx  primary key(c_mem_idx);

--unique
alter table c_member
	add constraint  unique_c_member_c_mem_id  unique(c_mem_id);

--check제약
--회원 등급
alter table c_member
	add constraint  check_c_member_c_mem_grade check( c_mem_grade in('일반','관리자') );


------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                            

--충전기 타입
alter table c_member
	add constraint check_c_member_c_mem_chargertype check( c_mem_chargertype in('01','02','03','04','05','06'));


--sample data
insert into  c_member values( 
								(select nvl(max(c_mem_idx),0)+1 from c_member),
                            	'일길동',
                            	'one',
                            	'1234',
                            	'12345',
                            	'서울시 관악구 시흥대로552',
                           		default,
                          		default,
                            	0,
                            	'06'
                           	 );
                           	 
insert into  c_member values( 
								(select nvl(max(c_mem_idx),0)+1 from c_member),
                            	'이길동',
                            	'2222',
                            	'1234',
                            	'12345',
                            	'서울시 관악구 시흥대로552',
                            	default,
                            	default,
                            	0,
                            	'04' 
                           	 );                           
                           
       









*/