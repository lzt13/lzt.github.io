package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import cn.tedu.entity.User;
import cn.tedu.utils.DBUtils;

/**
 * 处理用户注册和用户登录的用户数据
 * @author ui-cgb
 *
 */
public class UserDao {
     public void save(User user) {
    	 try (Connection conn=DBUtils.getConn()){
         String sql="insert into user(userName,password,email) values(?,?,?)";
         PreparedStatement ps=conn.prepareStatement(sql);
           ps.setString(1,user.getUserName());
           ps.setString(2, user.getPassword());
           ps.setString(3,user.getEmail());
           ps.executeUpdate();
           System.out.println("注册成功了");
    	 } catch (Exception e) {
			e.printStackTrace();
		}
     }
     public User login(String name,String pwd) {
    	 try (Connection conn=DBUtils.getConn()){
         String sql="select oId from user where userName=? and password=?";
         PreparedStatement ps=conn.prepareStatement(sql);
           ps.setString(1,name);
           ps.setString(2, pwd);
           ResultSet rs=ps.executeQuery();
           while(rs.next()) {
        	  int oid=rs.getInt(1);
        	 User u= new User(oid,null,name,pwd);
        	 return u;
           }
           //System.out.println("登录成功了");
    	 } catch (Exception e) {
			e.printStackTrace();
		}
		return null;
    }
}
