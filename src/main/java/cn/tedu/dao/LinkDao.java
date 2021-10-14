package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Link;
import cn.tedu.entity.Tag;
import cn.tedu.utils.DBUtils;

/**
 * link表的实体类
 * @author ui-cgb
 *
 */
public class LinkDao {
    public List<Link> getList(){
    	List<Link> list=new ArrayList();
    	try(Connection conn=DBUtils.getConn()){
	     String sql="select oid,address,title from link";
		PreparedStatement ps=conn.prepareStatement(sql);
		 ResultSet rs=ps.executeQuery();
		 while(rs.next()) {
		  int oid=rs.getInt(1);
		  String address= rs.getString(2);
		  String title=rs.getString(3);
		  list.add(new Link(oid,address,title));
		       }
		} catch (Exception e) {
              e.printStackTrace();
		}
    
     return list;
}
}