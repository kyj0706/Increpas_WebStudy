package service;

import java.util.Map;

import vo.ProductVo;

public interface ProductService {

	Map selectTotalList();//��ü��ȸ
	
	int insert_in (ProductVo vo) throws Exception; //�԰��������
	int insert_out(ProductVo vo) throws Exception; //����������
	
	
	//���
	int delete_in(int idx) throws Exception; 	//�԰����
	int delete_out(int idx) throws Exception; 	//������
	
	
}
