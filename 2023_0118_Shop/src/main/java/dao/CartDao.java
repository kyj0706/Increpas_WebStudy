package dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import service.MyBatisConnector;
import vo.CartVo;

public class CartDao {
	
	SqlSessionFactory factory;
	//single-ton pattern
	static CartDao single = null;

	public static CartDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new CartDao();

		return single;
	}

	//왜? : 외부에서 new CartDao()생성하지 못하도록
	private CartDao() {
		// TODO Auto-generated constructor stub
		factory = MyBatisConnector.getInstance().getSqlSessionFactory();
	}
	
	public List<CartVo> selectList(int mem_idx){
		List<CartVo> list = null;
		
		SqlSession sqlSession = factory.openSession();
		
		list = sqlSession.selectList("cart.cart_list", mem_idx);
		
		sqlSession.close();
		
		return list;
	}
	
	//mem_idx별 총액을 얻어옵니다.
	public int selectTotalAmount(int mem_idx) {
		int total =0;
		
		SqlSession sqlSession = factory.openSession();
		
		total = sqlSession.selectOne("cart.cart_total_amount", mem_idx);
		
		sqlSession.close();
		
		
		return total;
	}

	public CartVo selectOne(CartVo vo) {
		// TODO Auto-generated method stub
		CartVo resVo = null;
		SqlSession sqlSession = factory.openSession();
		
		resVo = sqlSession.selectOne("cart.cart_one", vo);
		
		sqlSession.close();
		
		return resVo;
	}

	public int insert(CartVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.insert("cart.cart_insert", vo);
		
		sqlSession.close();
		
		
		
		return res;
	}

	public int update(CartVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		
		res = sqlSession.update("cart.cart_update", vo);
		
		sqlSession.close();
		
		
		return res;
	}

	public int delete(CartVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		res= sqlSession.delete("cart.cart_delete", vo);
		
		return 0;
	}

	public int delete(int c_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		SqlSession sqlSession = factory.openSession(true);
		res= sqlSession.delete("cart.cart_delete", c_idx);
		
		return 0;
	}
	
	/*
	 * public List<CartVo> delete_all(Map<String, String> map) { // TODO
	 * Auto-generated method stub List<CartVo> list = null;
	 * 
	 * SqlSession sqlSession = factory.openSession();
	 * 
	 * list = sqlSession.selectList("cart.cart_one", map);
	 * 
	 * sqlSession.close();
	 * 
	 * return list; }
	 */

}
