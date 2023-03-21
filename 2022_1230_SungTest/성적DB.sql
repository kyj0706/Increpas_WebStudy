/*
--시퀀스 
	1. 절대변경되지 않음
	2. 수정할수 없음 
	3. 최대 20자리 
--시퀀스(Sequence) : 일련번호관리객체
				(시퀀스명 : seq_table명_컬럼명)
create sequence seq_sungtb_idx



--시퀀스삭제
drop sequence seq_sungtb_idx

--시퀀스 사용방법
select seq_sungtb_idx.nextVal, seq_sungtb_idx.currVal from dual

--#######################################################################



--성적테이블

create table sungtb
(
	idx 	int, 					--일련번호
	name 	varchar2(100) not null,	--이름
	kor		int default 0,			--국어
	eng		int default 0,			--영어
	mat		int	default 0			--수학

)

--기본키설정
	alter table sungtb
		add constraint pk_sungtb_idx primary key(idx);


--check제약(국어/영어/수학 0~100)
	alter table sungtb
		add constraint ck_sungtb_kor check( kor between 0 and 100); 
	
	alter table sungtb
		add constraint ck_sungtb_eng check( eng between 0 and 100); 
	
	alter table sungtb
		add constraint ck_sungtb_mat check( mat between 0 and 100); 

--sample data
	insert into sungtb values( seq_sungtb_idx.nextVal, '일길동', 88,99,77 ) ;
	insert into sungtb values( seq_sungtb_idx.nextVal, '이길동', 98,99,77 ) ;
	insert into sungtb values( seq_sungtb_idx.nextVal, '삼길동', 98,99,97 ) ;
	insert into sungtb values( seq_sungtb_idx.nextVal, '사길동', 100,100,100 ) ;
	insert into sungtb values( seq_sungtb_idx.nextVal, '오길동', 78,99,77 ) ;

	commit

	select * from sungtb
	
	
	--이렇게 하면 성능순으로 좋지 않다.
	select 
		s.*,
		rank() over(order by tot desc) as rank
	from
	(
		select 
			idx,name,kor,eng,mat,
			(kor+eng+mat) as tot,
		 	round((kor+eng+mat)/3,1) as avg
		  	
		from sungtb
	) s
	
--##########################################################

	create or replace view sungtb_view
	as
		select 
			idx,name,kor,eng,mat,
			(kor+eng+mat) as tot,
		 	round((kor+eng+mat)/3,1) as avg,
		 	rank() over(order by (kor+eng+mat) desc) as rank
		from sungtb
		order by idx
	

	select * from sungtb_view 
	
	

 update sungtb set kor=100
 where idx = 1;
 
 update sungtb set name='테스트2',kor=90, eng=80, mat=100 where idx =50;



delete from sungtb where idx =7;

select * from sungtb_view where idx=45;



*/