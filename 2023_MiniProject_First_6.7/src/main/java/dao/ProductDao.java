package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.ProductVo;
import vo.UserVo;

public class ProductDao {
	
	SqlSessionFactory factory;
	
	static ProductDao single = null;
	
	public static ProductDao getInstance() {
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new ProductDao();

		return single;
	}
	
	private ProductDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<ProductVo> selectList() {

		List<ProductVo> list = null;
		//System.out.println("product_list_dao");
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession();
		
		//System.out.println(sqlSession);
		//2.�۾�����
		list = sqlSession.selectList("product.product_list");
		
		//System.out.println(sqlSession.selectList("product.product_list"));
		
		//3.�ݱ�
		sqlSession.close();
		
		return list;
	}
	
	public ProductVo selectOne(int product_idx) {

		ProductVo vo = null;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession();
		//2.�۾�����
		vo = sqlSession.selectOne("product.product_one_idx", product_idx);
		
		//3.�ݱ�
		sqlSession.close();
		return vo;
	}

	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		System.out.println("insertProduct�� �Խ��ϱ� ?");
		
		int res = 0;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession(true);
		//2.�۾�����
		res = sqlSession.insert("product.product_insert", vo);
		//3.�ݱ�
		sqlSession.close();
		
		return res;
	}
	
	public int update(ProductVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession(true);
		//2.�۾�����
		res = sqlSession.update("product.product_update", vo);
		//3.�ݱ�
		sqlSession.close();
		
		return res;
	}
	
	public int delete(int product_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		
		//1.SqlSession���
		SqlSession sqlSession = factory.openSession(true);
		//2.�۾�����
		res = sqlSession.delete("product.product_delete", product_idx);
		//3.�ݱ�
		sqlSession.close();
				
		return res;
	}
}
