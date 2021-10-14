package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Tag;
import cn.tedu.utils.DBUtils;

/**
 * Tag的数据层
 * @author ui-cgb
 *
 */
public class TagDao {
     //根据文章id查询这个文章关联的标签列表
	public List<Tag> getTagsByArticleId(int oid){
		List<Tag> list=new ArrayList<Tag>();
		try (Connection conn=DBUtils.getConn()){
		//根据文章的oid标签编号 select tag_oid from tag_article where article_oid=
	    //根据标签编号获取标签列表  select oid ,referenceCount, title from tag where
			//oid in(12,25,49)
			//子查询语句当中查询到标签编号
			//主查询语句当中根据查询到的标签编号得到标签列表
		String sql="select oid,referenceCount,title from tag where oid in"
				+"(select tag_oid from tag_article where article_oid=?)";
	       PreparedStatement ps=conn.prepareStatement(sql);
	        ps.setInt(1, oid);
	        ResultSet rs= ps.executeQuery();
	        while(rs.next()) {
	        	int tagoid=rs.getInt(1);
	        	int count=rs.getInt(2);
	        	String title= rs.getString(3);
	        	Tag t=new Tag(tagoid,count,title);
	        	list.add(t);
	        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//编写查询标签名和引用次数(只查询5次)
	//select oid,referenceCount,title from tag;
	public List<Tag> getList(){
		List<Tag> list=new ArrayList<Tag>();
		try (Connection conn=DBUtils.getConn()){
			String sql="select oid,referenceCount,title from tag "
					+" order by referenceCount desc limit 0,5";
		        PreparedStatement ps=conn.prepareStatement(sql);
		       ResultSet rs=ps.executeQuery();
		       while(rs.next()) {
		    	   int oid=rs.getInt(1);
		    	   int referenceCount= rs.getInt(2);
		    	   String name=rs.getString(3);
		    	  list.add(new Tag(oid,referenceCount,name));
		       }
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
	}
}
