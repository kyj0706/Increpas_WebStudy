package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import service.DBService;
import vo.SawonVo;

public class SawonDao {


	//single-ton pattern
	static SawonDao single = null;

	public static SawonDao getInstance() {
		//생성되지 않았으면 생성해라
		if (single == null)
			single = new SawonDao();

		return single;
	}

	//왜? : 외부에서 new SawonDao()생성하지 못하도록
	private SawonDao() {
		// TODO Auto-generated constructor stub
	}
	
	public List<SawonVo> selectList() {

		List<SawonVo> list = new ArrayList<SawonVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sawon";

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
				//rs가 가리키는 레코드에서 필드정보를 얻어온다 + SawonVo로 포장
				//SawonVo로 포장
				SawonVo vo = new SawonVo();
				
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				
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
	
	
}
