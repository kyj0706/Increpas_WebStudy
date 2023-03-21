package service;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


public class MyBatisConnector {
    
	SqlSessionFactory  factory=null;
	private static MyBatisConnector connector; 
	
	public MyBatisConnector()
	{
		try {
			//sqlMapConfig.xml읽어들인다.
			Reader reader = 
				Resources.getResourceAsReader("config/mybatis/sqlMapConfig.xml");
			factory = new SqlSessionFactoryBuilder().build(reader);
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//single-ton
	public static MyBatisConnector getInstance(){
		if(connector==null)
			connector = new MyBatisConnector();
		return connector;
	}
	public SqlSessionFactory  getSqlSessionFactory()
	{
		return factory;
	}
}
