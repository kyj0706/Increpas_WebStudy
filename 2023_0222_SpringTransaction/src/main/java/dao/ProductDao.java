package dao;

import java.util.List;

import vo.ProductVo;

public interface ProductDao {

	List<ProductVo> 	selectList();
	ProductVo       	selectOne(int idx);
	//JDK 1.8 laterÁö¿ø
	default ProductVo   selectOne(String name) {return null;}
		
	int insert(ProductVo vo);
	int delete(int idx);
	int update(ProductVo vo);
	
}
