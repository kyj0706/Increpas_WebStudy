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
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new MemberDao();

		return single;
	}

	//��? : �ܺο��� new MemberDao()�������� ���ϵ���
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
			//1.Connection������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement������
			pstmt = conn.prepareStatement(sql);

			//3.ResultSet������
			rs = pstmt.executeQuery();

			//ó��~������ �ݺ��ض�
			while (rs.next()) {

				//���� rs : Data������ ����Ų��(Record�� ����Ų��)
				//rs�� ����Ű�� ���ڵ忡�� �ʵ������� ���´� + MemberVo�� ����
				//MemberVo�� ����
				MemberVo vo = new MemberVo();
				
				vo.setMem_idx(rs.getInt("mem_idx"));
				vo.setMem_name(rs.getString("mem_name"));
				vo.setMem_id(rs.getString("mem_id"));
				vo.setMem_pwd(rs.getString("mem_pwd"));
				vo.setMem_zipcode(rs.getString("mem_zipcode"));
				vo.setMem_address(rs.getString("mem_address"));
				vo.setMem_grade(rs.getString("mem_grade"));
				vo.setMem_regdate(rs.getString("mem_regdate"));
				

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
	
	
	//update
	//member���� �ش�Ǵ� 1���� ����  
	public MemberVo selectOne(int mem_idx) {

		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from member where mem_idx=?";

		try {
			//1.Connection������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement������
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ����
			pstmt.setInt(1, mem_idx);

			//4.ResultSet������
			rs = pstmt.executeQuery();

			if (rs.next()) {

				//���� rs : Data������ ����Ų��(Record�� ����Ų��)
				//rs�� ����Ű�� ���ڵ忡�� �ʵ������� ���´� + MemberVo�� ����
				//MemberVo�� ����
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
	
	//�α��� �ϱ� ���� 
	//member���� �ش�Ǵ� 1���� ����  
	public MemberVo selectOne(String mem_id) {
		
		MemberVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from member where mem_id=?";
		
		try {
			//1.Connection������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement������
			pstmt = conn.prepareStatement(sql);
			
			//3.pstmt parameter ����
			pstmt.setString(1, mem_id);
			
			//4.ResultSet������
			rs = pstmt.executeQuery();
			
			if (rs.next()) {
				
				//���� rs : Data������ ����Ų��(Record�� ����Ų��)
				//rs�� ����Ű�� ���ڵ忡�� �ʵ������� ���´� + MemberVo�� ����
				//MemberVo�� ����
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
	
	
	//insert
	public int insert(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "insert into member values((select nvl(max(mem_idx),0)+1 from member),?,?,?,?,?,default,default)";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ������ ä���
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_id());
			pstmt.setString(3, vo.getMem_pwd());
			pstmt.setString(4, vo.getMem_zipcode());
			pstmt.setString(5, vo.getMem_address());
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
	
	
	
	public int update(MemberVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update member set mem_name=?, mem_pwd=?, mem_zipcode=?, mem_address=?, mem_grade=? where mem_idx=?	";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ������ ä���
			pstmt.setString(1, vo.getMem_name());
			pstmt.setString(2, vo.getMem_pwd());
			pstmt.setString(3, vo.getMem_zipcode());
			pstmt.setString(4, vo.getMem_address());
			pstmt.setString(5, vo.getMem_grade());
			pstmt.setInt(6, vo.getMem_idx());
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
	
	public int delete(int mem_idx) {
		// TODO Auto-generated method stub
		int res = 0;
		System.out.println("���� ���"+res);
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from member where mem_idx=?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ������ ä���
			pstmt.setInt(1, mem_idx);
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
