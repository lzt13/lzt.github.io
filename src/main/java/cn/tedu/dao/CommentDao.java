package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import cn.tedu.entity.Comment;
import cn.tedu.entity.User;
import cn.tedu.utils.DBUtils;

/**
 * 文章详情数据层
 * @author ui-cgb
 *
 */
public class CommentDao {
     //按照文章id查询这篇文章的所有评论
	public List<Comment> GetCommentByArticleId(int aid){
		List<Comment> list=new ArrayList();
		try(Connection conn=DBUtils.getConn()){
			String sql="select oid,content,created,name from comment "
					+"where onid=?";
	    PreparedStatement ps=conn.prepareStatement(sql);
	    ps.setInt(1, aid);
	    ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				int oid=rs.getInt(1);
				String content=rs.getString(2);
				long created=rs.getLong(3);
				String name=rs.getString(4);
				Comment c=new Comment(oid, content, created, name);
				list.add(c);
			}
		} catch (Exception e) {
                   e.printStackTrace();
		}
		return list;
	}
	 public void save(String articleId,String commentContent,String userName) {
    	 try (Connection conn=DBUtils.getConn()){
         String sql="insert into comment(content,name,created,onId) values(?,?,?,?)";
         PreparedStatement ps=conn.prepareStatement(sql);
           ps.setString(1,commentContent);
           ps.setString(2, userName);
           ps.setLong(3,System.currentTimeMillis());
           ps.setInt(4, Integer.parseInt(articleId));
           ps.executeUpdate();
           System.out.println("评论完成");
    	 } catch (Exception e) {
			e.printStackTrace();
		}
     }
}
