/*
drop table c_board;
drop sequence seq_c_board_c_b_idx;

--�Ϸù�ȣ������ü
create sequence seq_c_board_c_b_idx;

--���̺����
  create table c_board
  (
      c_b_idx  int,					--�Ϸù�ȣ
      c_b_subject varchar2(200),		--����
      c_b_content clob,				--����
      c_b_ip      varchar2(100),		--������
      c_b_regdate date,				--�ۼ�����
      c_b_readhit int,				--��ȸ��
      c_b_use    char(1) default 'y',	--�������(��������)
      c_mem_idx   int,				--ȸ����ȣ(FK)
      c_mem_name  varchar2(100),		--ȸ����
      c_b_ref     int,				--�����۹�ȣ
      c_b_step    int,				--�ۼ���
      c_b_depth   int					--�۱���
  );

--�⺻Ű
  alter table c_board
     add constraint  pk_c_board_c_b_idx  primary key(c_b_idx);
     
--�ܷ�Ű
  alter table c_board
     add constraint  fk_c_board_c_mem_idx  foreign key(c_mem_idx) 
                                       references c_member(c_mem_idx); 
                                       
------------------------------------------------------------------------------------------------------------------------------------------------------------------------                                                                            
                                       

                                                                                   
--���۾���
  insert into c_board values( seq_c_board_c_b_idx.nextVal,
                            '���� 1���̴�!!',
                            '�̹����� 1���̳�',
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
        
--��۾���
    insert into c_board values( seq_c_board_c_b_idx.nextVal,
                            '�ƽ��� ���� 1���Ҽ� �־��µ�',
                            '�������� ���� 1���ؾ���',
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