package dao;

import java.util.List;

import vo.PhotoVo;

public interface PhotoDao {

	
	public List<PhotoVo> selectList();
	
	public PhotoVo selectOne(int p_idx);
	
	public int insert(PhotoVo vo);

	public int update(PhotoVo vo);

	public int delete(int p_idx);

	public int update_filename(PhotoVo vo);

}
