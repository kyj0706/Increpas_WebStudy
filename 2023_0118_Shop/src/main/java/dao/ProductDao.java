package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;

public class ProductDao {

	SqlSessionFactory factory;
	//single-ton pattern
	static ProductDao single = null;
	
	public static ProductDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new ProductDao();

		return single;
	}

	//왜? : 외부에서 new ProductDao()생성하지 못하도록
	private ProductDao() {
		// TODO Auto-generated constructor stub
		
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	
	//카테고리별 조회
	public List<ProductVo> selectList(String category){
		
		List<ProductVo> list = null;
		
		SqlSession sqlSession =factory.openSession();
		
		list =sqlSession.selectList("product.product_list",category);
		
		sqlSession.close();
		
		
		return list;
	}

	public ProductVo selectOne(int p_idx) {
		// TODO Auto-generated method stub
		ProductVo vo = null;
		
		SqlSession sqlSession =factory.openSession();
		
		vo = sqlSession.selectOne("product.product_one",p_idx);
		
		sqlSession.close();
		
		return vo;
	}
	
	//추가
	public int insert(ProductVo vo) {
		
		int res = 0;
		SqlSession sqlSession =factory.openSession(true);
		
		res = sqlSession.insert("product.product_insert",vo);
		
		sqlSession.close();
		
		
		return res;
	}
	
	//제품번호 ajax으로 중복 검사용
	public ProductVo selectOne(String p_num) {
		ProductVo vo = null;
		SqlSession sqlSession =factory.openSession();
		
		vo = sqlSession.selectOne("product.product_num_check", p_num);
		
		sqlSession.close();
		
		
		return vo;
	}
	
}
