package cn.tedu.utils;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * 方便DB数据操作,减少代码冗余;
 * @author ui-cgb
 *
 */
public class DBUtils {
     //定义一个方法含有每次连接数据库都要写的代码
	//当需要这个方法时调用这个方法即可
	//这个方法返回的是有用的连接对象 所以返回值是Connection类型
	public static Connection getConn() throws Exception {
		Connection conn=null;
		//定义数据库连接所需的参数变量
		String driver="com.mysql.jdbc.Driver";
		String url="jdbc:mysql:///smartblogs";
		String username="root";
		String pwd="1234";
		//安装驱动
		Class.forName(driver);
		//连接数据库
		conn=DriverManager.getConnection(url,username,pwd);
		//返回连接对象
		  return conn;
	}

}
