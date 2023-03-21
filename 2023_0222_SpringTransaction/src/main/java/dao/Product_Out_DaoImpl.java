package dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import vo.ProductVo;

public class Product_Out_DaoImpl implements ProductDao {

	SqlSession sqlSession;
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public List<ProductVo> selectList() {
		// TODO Auto-generated method stub
		return sqlSession.selectList("product_out.product_out_list");
	}

	@Override
	public ProductVo selectOne(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("product_out.product_out_one_idx", idx);
	}

	@Override
	public int insert(ProductVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.insert("product_out.product_out_insert", vo);
	}

	@Override
	public int delete(int idx) {
		// TODO Auto-generated method stub
		return sqlSession.delete("product_out.product_out_delete", idx);
	}

	@Override
	public int update(ProductVo vo) {
		// TODO Auto-generated method stub
		return sqlSession.update("product_out.product_out_update", vo);
	}

}
