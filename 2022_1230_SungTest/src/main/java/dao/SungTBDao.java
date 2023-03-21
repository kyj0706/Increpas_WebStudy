package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SungVo;

public class SungTBDao {
	
	//single-ton pattern
	static SungTBDao single = null;

	public static SungTBDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new SungTBDao();

		return single;
	}

	//왜? : 외부에서 new SungTBDao()생성하지 못하도록
	private SungTBDao() {
		// TODO Auto-generated constructor stub
	}
	
	//성적조회 
	public List<SungVo> selectList(){
		
		List<SungVo> list = new ArrayList<SungVo>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		String sql = "select * from sungtb_view";
		
		try {
			//1.Connection얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement얻어오기
			pstmt = conn.prepareStatement(sql);
			
			//3.ResultSet얻어오기
			rs = pstmt.executeQuery();
			
			//처음~끝까지 반복해라
			while(rs.next()) {
				
				//현재 rs : Data영역을 가리킨다(Record를 가리킨다)
				//rs가 가리키는 레코드에서 필드정보를 얻어온다
				int    idx 	= rs.getInt("idx");
				String name = rs.getString("name");
				int    kor  = rs.getInt("kor");
				int    eng  = rs.getInt("eng");
				int    mat  = rs.getInt("mat");
				String tot  = rs.getString("tot");
				String avg  = rs.getString("avg");
				String rank = rs.getString("rank");
					
				//SungVo로 포장
				SungVo vo = new SungVo();
				vo.setIdx(idx);
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);
				vo.setTot(tot);
				vo.setAvg(avg);
				vo.setRank(rank);
				
				//ArrayList추가
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			try {
				//사용된 자원 반환(닫기): 열린 역순
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn!=null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}//end :selectList

	public int insert(SungVo vo) {
		// TODO Auto-generated method stub
		int res =0;
		
		Connection 			conn  = null;
		PreparedStatement	pstmt = null;
		//															    1 2 3 4  <=Parameter index라고 한다.
		String sql = "insert into sungtb values( seq_sungtb_idx.nextVal,?,?,?,? )";
		 
		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);
			
			//3.patmt Parameter 정보를 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			
			//4.DML명령 처리
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
				//열린역순으로 닫는다.
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		return res;
	}
	
	//수정
	public int update(SungVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		System.out.println("업데이트 결과"+res);
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update sungtb set name=?,kor=?, eng=?, mat=? where idx =?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());

			//4.DML명령처리
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//열린역순으로 닫기
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

/* 221201[기존]
	public int delete(SungVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from sungtb where idx =?";

		try {
			//1.Connection 얻어오기
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter 정보를 채우기
			pstmt.setInt(1, vo.getIdx());

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
*/
	//221201[수정]
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		System.out.println("삭제 결과"+res);
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from sungtb where idx =?";

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

	public SungVo selectOne(int idx) {

		SungVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sungtb_view where idx=?";

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
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + SungVo로 포장
				//SungVo로 포장
				vo = new SungVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));
				vo.setKor(rs.getInt("kor"));
				vo.setEng(rs.getInt("eng"));
				vo.setMat(rs.getInt("mat"));
				
				vo.setTot(rs.getString("tot"));
				vo.setAvg(rs.getString("avg"));
				vo.setRank(rs.getString("rank"));
				
				
				
				

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
	
	
	
	
	
	
	
}
