package service;

import java.util.Map;

import vo.ProductVo;

public interface ProductService {

	Map selectTotalList();//전체조회
	
	int insert_in (ProductVo vo) throws Exception; //입고정보등록
	int insert_out(ProductVo vo) throws Exception; //출고정보등록
	
	
	//취소
	int delete_in(int idx) throws Exception; 	//입고취소
	int delete_out(int idx) throws Exception; 	//출고취소
	
	
}
