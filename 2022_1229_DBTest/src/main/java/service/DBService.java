package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBService {
	
	DataSource ds;
	
	
	//single-ton pattern
	static DBService single = null;

	public static DBService getInstance() {
		//�������� �ʾ����� �����ض�
		if (single == null)
			single = new DBService();

		return single;
	}

	//��? : �ܺο��� new DBService()�������� ���ϵ���
	private DBService() {
		// TODO Auto-generated constructor stub
		//JNDI�� �̿��ؼ� ds������ ���ðŴ�.
		
		try {
			InitialContext ic = new InitialContext();
			Context context = (Context) ic.lookup("java:comp/env");
			//lookupdms Object�̴�. �׷��� Context�� ���´� �ٿ��ɽ�������...���
			//�� Object�̳� ? ��Ÿ� ������ �𸣴ϱ� 
			ds				= (DataSource) context.lookup("jdbc/oracle_test");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Connection getConnection() throws SQLException {
		
		Connection conn = null;
		
		conn = ds.getConnection();
		
		
		return conn;
		
	}

}
