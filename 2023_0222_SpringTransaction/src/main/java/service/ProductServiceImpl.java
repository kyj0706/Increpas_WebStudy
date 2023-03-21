package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import vo.ProductVo;

public class ProductServiceImpl implements ProductService {

	ProductDao  product_in_dao;    //입고
	ProductDao  product_out_dao;   //출고
	ProductDao  product_remain_dao;//재고
	
	
	public ProductServiceImpl(ProductDao product_in_dao, ProductDao product_out_dao, ProductDao product_remain_dao) {
		super();
		this.product_in_dao = product_in_dao;
		this.product_out_dao = product_out_dao;
		this.product_remain_dao = product_remain_dao;
	}

	@Override
	public Map selectTotalList() {
		// TODO Auto-generated method stub
		List<ProductVo> in_list 	= product_in_dao.selectList();    //입고
		List<ProductVo> out_list 	= product_out_dao.selectList();   //출고
		List<ProductVo> remain_list = product_remain_dao.selectList();//재고
		
		Map map = new HashMap();
		map.put("in_list", in_list);
		map.put("out_list", out_list);
		map.put("remain_list", remain_list);
		
		return map;
	}

	@Override
	public int insert_in(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		//입고등록
		int res = product_in_dao.insert(vo);
		
		//재고테이블에 현재 입고상품이 있는가 ?
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		
		if(remainVo == null) { //등록된사품이 없으면 ?
			//재고테이블에 등록해라
			res = product_remain_dao.insert(vo);
			
		}else {//상품이 등록되어 있으면 수정해라
			
			int cnt = remainVo.getCnt() + vo.getCnt();
			remainVo.setCnt(cnt);
			
			res = product_remain_dao.update(remainVo);
			
		}
		
		return 0;
	}

	@Override
	public int insert_out(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		//출고등록
		
		/*
		//진우스타일_230222
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		if(remainVo.getCnt() >= vo.getCnt()) {
			int res = product_out_dao.insert(vo);
			int cnt = remainVo.getCnt() - vo.getCnt();
			remainVo.setCnt(cnt);
			res = product_remain_dao.update(remainVo);
		}else{
			return 0;
		}
		if(remainVo.getCnt() == 0) {
			int cnt0 = remainVo.getIdx();
			int res = product_remain_dao.delete(cnt0);
			res = product_remain_dao.update(remainVo);
		}
		*/
		
		//강사님_230223_AOP방식
		int res = product_out_dao.insert(vo);
		
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		
		//출고할 상품이 없는 경우
		if(remainVo == null) { //등록된사품이 없으면 ?
			//예외를 발생
			throw new Exception("remain_not");
		}
		
		//출고수량이 더 큰 경우
		if(vo.getCnt() > remainVo.getCnt()) {
			//예외를 발생
			throw new Exception("remain_lack");
		}
		
		//출고에 대한 재고처리
		//			 기존재고수량   -   출고수량
		int cnt = remainVo.getCnt() - vo.getCnt();
		remainVo.setCnt(cnt);
		
		res = product_remain_dao.update(remainVo);
		
		
		
		return res;
	}
	
	//입고취소
	@Override
	public int delete_in(int idx) throws Exception {
		// TODO Auto-generated method stub
		//1. idx에 해당되는 입고상품정보 얻어온다.
		ProductVo inVo = product_in_dao.selectOne(idx);
		//System.out.println(inVo);
		
		//2. 입고정보 삭제
		int res = product_in_dao.delete(idx);
		
		//3. 상품명을 이용한 재고 상품정보 얻어온다.
		ProductVo remainVo =product_remain_dao.selectOne(inVo.getName());
		
		
		//4. 입고취소수량이 > 재고수량 이면 취소처리 : in_remain_lack(메세지)
		if(inVo.getCnt() > remainVo.getCnt()) {
			throw new Exception("in_remain_lack");
		}
		
		//5. 재고수량 수정
		int re_cnt = remainVo.getCnt() - inVo.getCnt();
		remainVo.setCnt(re_cnt);
		res = product_remain_dao.update(remainVo);
		
		return res;
	}

	
	
	//출고취소
	@Override
	public int delete_out(int idx) throws Exception {
		// TODO Auto-generated method stub
		ProductVo outVo = product_out_dao.selectOne(idx); 
		
		int res = product_out_dao.delete(idx);
		
		ProductVo remainVo =product_remain_dao.selectOne(outVo.getName());
		
		
		
		//5. 재고수량 수정
		int re_cnt =  outVo.getCnt() + remainVo.getCnt();
		remainVo.setCnt(re_cnt);
		res = product_remain_dao.update(remainVo);
		
		return 0;
	}

}
