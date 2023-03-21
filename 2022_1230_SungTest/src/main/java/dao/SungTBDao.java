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
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new SungTBDao();

		return single;
	}

	//��? : �ܺο��� new SungTBDao()�������� ���ϵ���
	private SungTBDao() {
		// TODO Auto-generated constructor stub
	}
	
	//������ȸ 
	public List<SungVo> selectList(){
		
		List<SungVo> list = new ArrayList<SungVo>();
		Connection        conn  = null;
		PreparedStatement pstmt = null;
		ResultSet         rs    = null;
		
		String sql = "select * from sungtb_view";
		
		try {
			//1.Connection������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement������
			pstmt = conn.prepareStatement(sql);
			
			//3.ResultSet������
			rs = pstmt.executeQuery();
			
			//ó��~������ �ݺ��ض�
			while(rs.next()) {
				
				//���� rs : Data������ ����Ų��(Record�� ����Ų��)
				//rs�� ����Ű�� ���ڵ忡�� �ʵ������� ���´�
				int    idx 	= rs.getInt("idx");
				String name = rs.getString("name");
				int    kor  = rs.getInt("kor");
				int    eng  = rs.getInt("eng");
				int    mat  = rs.getInt("mat");
				String tot  = rs.getString("tot");
				String avg  = rs.getString("avg");
				String rank = rs.getString("rank");
					
				//SungVo�� ����
				SungVo vo = new SungVo();
				vo.setIdx(idx);
				vo.setName(name);
				vo.setKor(kor);
				vo.setEng(eng);
				vo.setMat(mat);
				vo.setTot(tot);
				vo.setAvg(avg);
				vo.setRank(rank);
				
				//ArrayList�߰�
				list.add(vo);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} finally {
			
			try {
				//���� �ڿ� ��ȯ(�ݱ�): ���� ����
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
		//															    1 2 3 4  <=Parameter index��� �Ѵ�.
		String sql = "insert into sungtb values( seq_sungtb_idx.nextVal,?,?,?,? )";
		 
		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();
			
			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);
			
			//3.patmt Parameter ������ ä���
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			
			//4.DML��� ó��
			res = pstmt.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			
			try {
				//������������ �ݴ´�.
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		return res;
	}
	
	//����
	public int update(SungVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		System.out.println("������Ʈ ���"+res);
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "update sungtb set name=?,kor=?, eng=?, mat=? where idx =?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ������ ä���
			pstmt.setString(1, vo.getName());
			pstmt.setInt(2, vo.getKor());
			pstmt.setInt(3, vo.getEng());
			pstmt.setInt(4, vo.getMat());
			pstmt.setInt(5, vo.getIdx());

			//4.DML���ó��
			res = pstmt.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {

			try {
				//������������ �ݱ�
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return res;
	}

/* 221201[����]
	public int delete(SungVo vo) {
		// TODO Auto-generated method stub
		int res = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from sungtb where idx =?";

		try {
			//1.Connection ������
			conn = DBService.getInstance().getConnection();

			//2.PreparedStatement
			pstmt = conn.prepareStatement(sql);

			//3.pstmt parameter ������ ä���
			pstmt.setInt(1, vo.getIdx());

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
*/
	//221201[����]
	public int delete(int idx) {
		// TODO Auto-generated method stub
		int res = 0;
		System.out.println("���� ���"+res);
		Connection conn = null;
		PreparedStatement pstmt = null;

		String sql = "delete from sungtb where idx =?";

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

	public SungVo selectOne(int idx) {

		SungVo vo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		String sql = "select * from sungtb_view where idx=?";

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
				//rs�� ����Ű�� ���ڵ忡�� �ʵ������� ���´� + SungVo�� ����
				//SungVo�� ����
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
	
	
	
	
	
	
	
}
