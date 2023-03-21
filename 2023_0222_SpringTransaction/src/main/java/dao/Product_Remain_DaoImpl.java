package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVo;

public class Product_Remain_DaoImpl implements ProductDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ProductVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_remain.product_remain_list");
	}

	@Override
	public ProductVo selectOne(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product_remain.product_remain_one_idx", idx);
	}
	

	@Override
	public ProductVo selectOne(String name) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product_remain.product_remain_one_name", name);
	}

	@Override
	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("product_remain.product_remain_insert", vo);
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("product_remain.product_remain_delete", idx);
	}

	@Override
	public int update(ProductVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("product_remain.product_remain_update", vo);
	}

}
