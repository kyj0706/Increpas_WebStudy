/*

--�Ϸù�ȣ������ü
create sequence  seq_photo_p_idx

--���̺����
create table photo
(
   p_idx      int,						--�Ϸù�ȣ
   p_title    varchar2(200) not null,	--����
   p_content  varchar2(2000) not null,	--����
   p_filename varchar2(200) not null,	--ȭ�ϸ�
   p_ip	      varchar2(100) not null,	--������
   p_regdate    date,					--�������
   p_modifydate date,					--�ֱټ�������
   mem_idx    int                       --���ȸ����ȣ
)

--JDBC�� insert
insert into photo values(seq_photo_p_idx.nextVal , ? , ? , ? , ? , sysdate , sysdate , ?)


--�⺻Ű
alter table photo
  add constraint  pk_photo_p_idx  primary key(p_idx) ;
  
--�ܷ�Ű
alter table photo
  add constraint  fk_photo_mem_idx  foreign key(mem_idx)
                                    references  member(mem_idx); 
                                    

--�θ�Ű ���Ž� �����ϴ� �ڽ������� ��� ����(�� �� �ִ�)
(X)alter table photo
     add constraint  fk_photo_mem_idx  foreign key(mem_idx)
                                    references  member(mem_idx)
                                    on delete cascade
  

select * from photo





*/