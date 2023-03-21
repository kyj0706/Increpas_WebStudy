package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.MemberVo;

public class MemberDao {
	
	//single-ton pattern
	static MemberDao single = null;

	public static MemberDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new MemberDao();

		return single;
	}

	//왜? : 외부에서 new MemberDao()생성하지 못하도록
	private MemberDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	//list 
	public List<MemberVo> selectList() {

		List<MemberVo> list = new ArrayList<MemberVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member";

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
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + MemberVo로 포장
				//MemberVo로 포장
				MemberVo vo = new MemberVo();
				
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_address(rs.getString("mem_address"));
				vo.setMem_grade(rs.getString("mem_grade"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				

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
	
	
	//update
	//member에서 해당되는 1명의 정보  
	public MemberVo selectOne(int mem_idx) {

		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where mem_idx=?";

		try {
			//1.Connection얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 설정
			pstmt.setInt(1, mem_idx);

			//4.ResultSet얻어오기
			rs = pstmt.executeQuery();

			if (rs.next()) {

				//현재 rs : Data영역을 가리킨다(Record를 가리킨다)
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + MemberVo로 포장
				//MemberVo로 포장
				vo = new MemberVo();
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_address(rs.getString("mem_address"));
				vo.setMem_grade(rs.getString("mem_grade"));
				vo.setMem_regdate(rs.getString("mem_regdate"));

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
	
	//로그인 하기 위한 
	//member에서 해당되는 1명의 정보  
	public MemberVo selectOne(String mem_id) {
		
		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where mem_id=?";
		
		try {
			//1.Connection얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3.pstmt parameter 설정
			pstmt.setString(1, mem_id);
			
			//4.ResultSet얻어오기
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				//현재 rs : Data영역을 가리킨다(Record를 가리킨다)
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + MemberVo로 포장
				//MemberVo로 포장
				vo = new MemberVo();
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_address(rs.getString("mem_address"));
				vo.setMem_grade(rs.getString("mem_grade"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				
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
	
	
	//insert
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into member values((select nvl(max(mem_idx),0)+1 from member),?,?,?,?,?,default,default)";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pwd());
			pstmt.setString(4, vo.getMem_zipcode());
			pstmt.setString(5, vo.getMem_address());
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
	
	
	
	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update member set mem_name=?, mem_pwd=?, mem_zipcode=?, mem_address=?, mem_grade=? where mem_idx=?	";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_pwd());
			pstmt.setString(3, vo.getMem_zipcode());
			pstmt.setString(4, vo.getMem_address());
			pstmt.setString(5, vo.getMem_grade());
			pstmt.setInt(6, vo.getMem_idx());
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
	
	public int delete(int mem_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		System.out.println("삭제 결과"+res);
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from member where mem_idx=?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setInt(1, mem_idx);
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
