package cn.tedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * ����DB���ݲ���,���ٴ�������;
 * @author ui-cgb
 *
 */
public class DBUtils {
     //����һ����������ÿ���������ݿⶼҪд�Ĵ���
	//����Ҫ�������ʱ���������������
	//����������ص������õ����Ӷ��� ���Է���ֵ��Connection����
	public static Connection getConn() throws Exception {
		Connection conn=null;
		//�������ݿ���������Ĳ�������
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql:///smartblogs";
		String username="root";
		String pwd="1234";
		//��װ����
		Class.forName(driver);
		//�������ݿ�
		conn=DriverManager.getConnection(url,username,pwd);
		//�������Ӷ���
		  return conn;
	}

}
