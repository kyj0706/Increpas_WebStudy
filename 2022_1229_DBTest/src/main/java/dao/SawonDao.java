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
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new SawonDao();

		return single;
	}

	//��? : �ܺο��� new SawonDao()�������� ���ϵ���
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
			//1.Connection������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet������
			rs = pstmt.executeQuery();

			//ó��~������ �ݺ��ض�
			while (rs.next()) {

				//���� rs : Data������ ����Ų��(Record�� ����Ų��)
				//rs�� ����Ű�� ���ڵ忡�� �ʵ������� ���´� + SawonVo�� ����
				//SawonVo�� ����
				SawonVo vo = new SawonVo();
				
				vo.setSabun(rs.getInt("sabun"));
				vo.setSaname(rs.getString("saname"));
				vo.setSasex(rs.getString("sasex"));
				vo.setDeptno(rs.getInt("deptno"));
				vo.setSajob(rs.getString("sajob"));
				vo.setSahire(rs.getString("sahire"));
				vo.setSamgr(rs.getInt("samgr"));
				vo.setSapay(rs.getInt("sapay"));
				
				//ArrayList�߰�
				list.add(vo);
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();

		} finally {

			try {
				//���� �ڿ� ��ȯ(�ݱ�): ���� ����
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
