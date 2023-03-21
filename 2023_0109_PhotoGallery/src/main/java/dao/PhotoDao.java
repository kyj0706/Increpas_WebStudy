package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.PhotoVo;

public class PhotoDao {

	//single-ton pattern
	static PhotoDao single = null;

	public static PhotoDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new PhotoDao();

		return single;
	}

	//왜? : 외부에서 new PhotoDao()생성하지 못하도록
	private PhotoDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<PhotoVo> selectList() {

		List<PhotoVo> list = new ArrayList<PhotoVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from photo order by p_idx desc";

		try {
			//1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet얻어오기
			rs = pstmt.executeQuery();

			//처음~끝까지 반복해라
			while (rs.next()) {

				//현재 rs : Data영역을 가리킨다(Record를 가리킨다)
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + PhotoVo로 포장
				//PhotoVo로 포장
				PhotoVo vo = new PhotoVo();
				
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setP_regdate(rs.getString("p_regdate"));
				vo.setP_modifydate(rs.getString("p_modifydate"));
				
				vo.setMem_idx(rs.getInt("mem_idx"));
				
				

				//ArrayList추가
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			try {
				//사용된 자원 반환(닫기): 열린 역순
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public PhotoVo selectOne(int p_idx) {

		PhotoVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from photo where p_idx=?";

		try {
			//1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 설정
			pstmt.setInt(1, p_idx);

			//4.ResultSet얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				//현재 rs : Data영역을 가리킨다(Record를 가리킨다)
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + PhotoVo로 포장
				//PhotoVo로 포장
				vo = new PhotoVo();
				
				vo.setP_idx(rs.getInt("p_idx"));
				vo.setP_title(rs.getString("p_title"));
				vo.setP_content(rs.getString("p_content"));
				vo.setP_filename(rs.getString("p_filename"));
				vo.setP_ip(rs.getString("p_ip"));
				vo.setP_regdate(rs.getString("p_regdate"));
				vo.setP_modifydate(rs.getString("p_modifydate"));
				
				vo.setMem_idx(rs.getInt("mem_idx"));

			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			try {
				//사용된 자원 반환(닫기): 열린 역순
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return vo;
	}
	
	public int insert(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into photo values(seq_photo_p_idx.nextVal,?,?,?,?,sysdate,sysdate,?)";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setString(1, vo.getP_title());
			pstmt.setString(2, vo.getP_content());
			pstmt.setString(3, vo.getP_filename());
			pstmt.setString(4, vo.getP_ip());
			pstmt.setInt(5, vo.getMem_idx());

			//4.DML명령처리
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순으로 닫기
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
	public int update(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update photo set p_title=?,p_content=?,p_ip=?,p_modifydate=sysdate where p_idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setString(1, vo.getP_title());
			pstmt.setString(2, vo.getP_content());
			pstmt.setString(3, vo.getP_ip());
			pstmt.setInt(4, vo.getP_idx());
			

			//4.DML명령처리
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순으로 닫기
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	public int delete(int p_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from photo where p_idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setInt(1, p_idx);

			//4.DML명령처리
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순으로 닫기
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	public int update_filename(PhotoVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update photo set p_filename=?, p_modifydate=sysdate where p_idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setString(1, vo.getP_filename());
			pstmt.setInt(2, vo.getP_idx());
			
			//4.DML명령처리
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순으로 닫기
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}
	
}
