package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.VisitVo;

public class VisitDao {
	
	//single-ton pattern
	static VisitDao single = null;

	public static VisitDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new VisitDao();

		return single;
	}

	//왜? : 외부에서 new VisitDao()생성하지 못하도록
	private VisitDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	//조회
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit order by idx desc";

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
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + VisitVo로 포장
				//VisitVo로 포장
				VisitVo vo = new VisitVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));	
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));
				
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
	

	
	//idx에 해당되는 게시물 1건 조회
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit where idx=?";
		System.out.println(idx);
		
		try {
			//1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 설정
			pstmt.setInt(1, idx);
			
			//4.ResultSet얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				//현재 rs : Data영역을 가리킨다(Record를 가리킨다)
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + VisitVo로 포장
				//VisitVo로 포장
				vo = new VisitVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));	
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));
				
			

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
	
//_update_delete
	//추가 수정 삭제 하기
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate,sysdate)";
		
		
		
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

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
	
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from visit where idx =?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setInt(1, idx);

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
	
	
	
	
	public int update(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		System.out.println("업데이트"+res);
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update visit set name=?,content=?, pwd=?, ip=?, modifydate=sysdate where idx =?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getIdx());
			
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
