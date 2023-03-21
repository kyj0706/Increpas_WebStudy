package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.ProductDao;
import vo.ProductVo;

public class ProductServiceImpl implements ProductService {

	ProductDao  product_in_dao;    //�԰�
	ProductDao  product_out_dao;   //���
	ProductDao  product_remain_dao;//���
	
	
	public ProductServiceImpl(ProductDao product_in_dao, ProductDao product_out_dao, ProductDao product_remain_dao) {
		super();
		this.product_in_dao = product_in_dao;
		this.product_out_dao = product_out_dao;
		this.product_remain_dao = product_remain_dao;
	}

	@Override
	public Map selectTotalList() {
		// TODO Auto-generated method stub
		List<ProductVo> in_list 	= product_in_dao.selectList();    //�԰�
		List<ProductVo> out_list 	= product_out_dao.selectList();   //���
		List<ProductVo> remain_list = product_remain_dao.selectList();//���
		
		Map map = new HashMap();
		map.put("in_list", in_list);
		map.put("out_list", out_list);
		map.put("remain_list", remain_list);
		
		return map;
	}

	@Override
	public int insert_in(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		//�԰���
		int res = product_in_dao.insert(vo);
		
		//������̺� ���� �԰��ǰ�� �ִ°� ?
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		
		if(remainVo == null) { //��ϵȻ�ǰ�� ������ ?
			//������̺� ����ض�
			res = product_remain_dao.insert(vo);
			
		}else {//��ǰ�� ��ϵǾ� ������ �����ض�
			
			int cnt = remainVo.getCnt() + vo.getCnt();
			remainVo.setCnt(cnt);
			
			res = product_remain_dao.update(remainVo);
			
		}
		
		return 0;
	}

	@Override
	public int insert_out(ProductVo vo) throws Exception {
		// TODO Auto-generated method stub
		//�����
		
		/*
		//���콺Ÿ��_230222
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
		
		//�����_230223_AOP���
		int res = product_out_dao.insert(vo);
		
		ProductVo remainVo = product_remain_dao.selectOne(vo.getName());
		
		//����� ��ǰ�� ���� ���
		if(remainVo == null) { //��ϵȻ�ǰ�� ������ ?
			//���ܸ� �߻�
			throw new Exception("remain_not");
		}
		
		//�������� �� ū ���
		if(vo.getCnt() > remainVo.getCnt()) {
			//���ܸ� �߻�
			throw new Exception("remain_lack");
		}
		
		//��� ���� ���ó��
		//			 ����������   -   ������
		int cnt = remainVo.getCnt() - vo.getCnt();
		remainVo.setCnt(cnt);
		
		res = product_remain_dao.update(remainVo);
		
		
		
		return res;
	}
	
	//�԰����
	@Override
	public int delete_in(int idx) throws Exception {
		// TODO Auto-generated method stub
		//1. idx�� �ش�Ǵ� �԰��ǰ���� ���´�.
		ProductVo inVo = product_in_dao.selectOne(idx);
		//System.out.println(inVo);
		
		//2. �԰����� ����
		int res = product_in_dao.delete(idx);
		
		//3. ��ǰ���� �̿��� ��� ��ǰ���� ���´�.
		ProductVo remainVo =product_remain_dao.selectOne(inVo.getName());
		
		
		//4. �԰���Ҽ����� > ������ �̸� ���ó�� : in_remain_lack(�޼���)
		if(inVo.getCnt() > remainVo.getCnt()) {
			throw new Exception("in_remain_lack");
		}
		
		//5. ������ ����
		int re_cnt = remainVo.getCnt() - inVo.getCnt();
		remainVo.setCnt(re_cnt);
		res = product_remain_dao.update(remainVo);
		
		return res;
	}

	
	
	//������
	@Override
	public int delete_out(int idx) throws Exception {
		// TODO Auto-generated method stub
		ProductVo outVo = product_out_dao.selectOne(idx); 
		
		int res = product_out_dao.delete(idx);
		
		ProductVo remainVo =product_remain_dao.selectOne(outVo.getName());
		
		
		
		//5. ������ ����
		int re_cnt =  outVo.getCnt() + remainVo.getCnt();
		remainVo.setCnt(re_cnt);
		res = product_remain_dao.update(remainVo);
		
		return 0;
	}

}
