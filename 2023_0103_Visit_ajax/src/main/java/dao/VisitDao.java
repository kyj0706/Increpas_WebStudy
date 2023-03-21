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
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new VisitDao();

		return single;
	}

	//��? : �ܺο��� new VisitDao()�������� ���ϵ���
	private VisitDao() {
		// TODO Auto-generated constructor stub
	}
	
	
	//��ȸ
	public List<VisitVo> selectList() {

		List<VisitVo> list = new ArrayList<VisitVo>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit order by idx desc";

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
				//rs�� ����Ű�� ���ڵ忡�� �ʵ������� ���´� + VisitVo�� ����
				//VisitVo�� ����
				VisitVo vo = new VisitVo();
				
				vo.setIdx(rs.getInt("idx"));
				vo.setName(rs.getString("name"));	
				vo.setContent(rs.getString("content"));
				vo.setPwd(rs.getString("pwd"));
				vo.setIp(rs.getString("ip"));
				vo.setRegdate(rs.getString("regdate"));
				vo.setModifydate(rs.getString("modifydate"));
				
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
	

	
	//idx�� �ش�Ǵ� �Խù� 1�� ��ȸ
	public VisitVo selectOne(int idx) {

		VisitVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from visit where idx=?";
		System.out.println(idx);
		
		try {
			//1.Connection������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement������
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ����
			pstmt.setInt(1, idx);
			
			//4.ResultSet������
			rs = pstmt.executeQuery();

			if (rs.next()) {

				//���� rs : Data������ ����Ų��(Record�� ����Ų��)
				//rs�� ����Ű�� ���ڵ忡�� �ʵ������� ���´� + VisitVo�� ����
				//VisitVo�� ����
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
		return vo;
	}
	
//_update_delete
	//�߰� ���� ���� �ϱ�
	public int insert(VisitVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into visit values(seq_visit_idx.nextVal,?,?,?,?,sysdate,sysdate)";
		
		
		
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ������ ä���
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());

			//4.DML���ó��
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//������������ �ݱ�
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
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ������ ä���
			pstmt.setInt(1, idx);

			//4.DML���ó��
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//������������ �ݱ�
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
		System.out.println("������Ʈ"+res);
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update visit set name=?,content=?, pwd=?, ip=?, modifydate=sysdate where idx =?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ������ ä���
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getPwd());
			pstmt.setString(4, vo.getIp());
			pstmt.setInt(5, vo.getIdx());
			
			//4.DML���ó��
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//������������ �ݱ�
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
