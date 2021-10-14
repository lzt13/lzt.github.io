package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Article;
import cn.tedu.entity.Comment;
import cn.tedu.entity.Tag;
import cn.tedu.utils.DBUtils;

/**
 * article的数据层
 * @author ui-cgb
 *
 */
public class ArticleDao {
	//获取8篇左侧文章
   public List<Article> getHomeList(){
	   List<Article> list=new ArrayList<Article>();
	   try(Connection conn=DBUtils.getConn()) {
		   //根据作者的信息查看发布的文章
		   //SELECT a.title,u.username FROM article a INNER JOIN USER u ON
		   //a.authorid=u.oid order by a.puttop desc,a.created desc limit 0,8;
		String sql="SELECT a.oid,a.title,a.abstract,a.commentcount,a.viewcount,\r\n"
				+ " a.puttop,a.created,a.imgname,u.username FROM article a INNER JOIN USER u ON\r\n"
				+ " a.authorid=u.oid ORDER BY a.puttop DESC ,a.created desc  limit 0,8;";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
        while(rs.next()) {
            int oid=rs.getInt(1);
            String title=rs.getString(2);
            String abs=rs.getString(3);
            int commentcount=rs.getInt(4);
            int viewcount=rs.getInt(5);
            int puttop=rs.getInt(6);
            Long created=rs.getLong(7);
            String imgname=rs.getString(8);
            String username=rs.getString(9);
            Article a=new Article(oid, title, abs, commentcount, viewcount, null, puttop, created, imgname, username);
             //先查询文章关联的标签
             TagDao td=new TagDao();
               List<Tag> tags=td.getTagsByArticleId(oid);
               //将查询出来的标签添加给文章
               a.setTags(tags);
               //打桩输出
               System.out.println(a.getTags());
                list.add(a);
        }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	return list;
   }
	//按照指定次序获取右侧文章
   public List<Article> getListByType(String type){
	   List<Article> list=new ArrayList();
	   try(Connection conn=DBUtils.getConn()) {
		String sql="select oid,title from article order by "+type+" desc limit 0,5";
		PreparedStatement ps=conn.prepareStatement(sql);
	ResultSet rs=ps.executeQuery();
	while(rs.next()) {
		int oid=rs.getInt(1);
		String title=rs.getString(2);
		Article a=new Article(oid, title);
		list.add(a);
	}
	} catch (Exception e) {
		e.printStackTrace();
	}
	return list;
   }
   //list.html 需要的文章列表    按照文章的发布时间降序查询
   public List<Article> getArticleList(){
	   List<Article> list=new ArrayList<Article>();
	   try(Connection conn=DBUtils.getConn()) {
		   //根据作者的信息查看发布的文章
		   //SELECT a.title,u.username FROM article a INNER JOIN USER u ON
		   //a.authorid=u.oid order by a.puttop desc,a.created desc limit 0,8;
		String sql="SELECT a.oid,a.title,a.abstract,a.commentcount,a.viewcount,\r\n"
				+ " a.puttop,a.created,a.imgname,u.username FROM article a INNER JOIN USER u ON\r\n"
				+ " a.authorid=u.oid ORDER BY a.created desc  limit 0,8;";
		PreparedStatement ps=conn.prepareStatement(sql);
		ResultSet rs= ps.executeQuery();
        while(rs.next()) {
            int oid=rs.getInt(1);
            String title=rs.getString(2);
            String abs=rs.getString(3);
            int commentcount=rs.getInt(4);
            int viewcount=rs.getInt(5);
            int puttop=rs.getInt(6);
            Long created=rs.getLong(7);
            String imgname=rs.getString(8);
            String username=rs.getString(9);
            Article a=new Article(oid, title, abs, commentcount, viewcount, null, puttop, created, imgname, username);
             //先查询文章关联的标签
             TagDao td=new TagDao();
               List<Tag> tags=td.getTagsByArticleId(oid);
               //将查询出来的标签添加给文章
               a.setTags(tags);
               //打桩输出
               System.out.println(a.getTags());
                list.add(a);
        }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	return list;
   }
   //按照文章的关键字 发布时间降序查询
   public List<Article> getArticleListByKeyword(String keyword){
	   List<Article> list=new ArrayList<Article>();
	   try(Connection conn=DBUtils.getConn()) {
		   //根据作者的信息查看发布的文章
		   //SELECT a.title,u.username FROM article a INNER JOIN USER u ON
		   //a.authorid=u.oid order by a.puttop desc,a.created desc limit 0,8;
		String sql="SELECT a.oid,a.title,a.abstract,a.commentcount,a.viewcount,\r\n"
				+ " a.puttop,a.created,a.imgname,u.username FROM article a INNER JOIN USER u ON\r\n"
				+ " a.authorid=u.oid where a.title like ? ORDER BY a.created desc  limit 0,8;";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1, "%"+keyword+"%");
		ResultSet rs= ps.executeQuery();
        while(rs.next()) {
            int oid=rs.getInt(1);
            String title=rs.getString(2);
            String abs=rs.getString(3);
            int commentcount=rs.getInt(4);
            int viewcount=rs.getInt(5);
            int puttop=rs.getInt(6);
            Long created=rs.getLong(7);
            String imgname=rs.getString(8);
            String username=rs.getString(9);
            Article a=new Article(oid, title, abs, commentcount, viewcount, null, puttop, created, imgname, username);
             //先查询文章关联的标签
             TagDao td=new TagDao();
               List<Tag> tags=td.getTagsByArticleId(oid);
               //将查询出来的标签添加给文章
               a.setTags(tags);
               //打桩输出
               System.out.println(a.getTags());
                list.add(a);
        }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	return list;
   }
   //发布文章的方法
   public void AddArticle(Article a,int authorId){
	   try(Connection conn=DBUtils.getConn()) {
		String sql="insert into article(title,abstract,commentcount,content,viewcount,\r\n"
				+ " puttop,created,imgname,authorId) "
				+ " values(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=conn.prepareStatement(sql);
		ps.setString(1,a.getTitle());
		ps.setString(2, a.getAbs());
		ps.setInt(3, a.getCommentcount());
		ps.setString(4, a.getContent());
		ps.setInt(5, a.getViewcount());
		ps.setInt(6, a.getPutTop());
		ps.setLong(7, a.getCreated());
		ps.setString(8, a.getImgname());
		ps.setInt(9, authorId);
		ps.executeUpdate();
		System.out.println("发布完成");
		// TODO: handle exception
   }catch (Exception e) {
		e.printStackTrace();
	}
}
   //按照文章id查询文章详情
   public Article getArticleById(int oid){
	   try(Connection conn=DBUtils.getConn()) {
		String sql="SELECT a.oid,a.title,a.abstract,a.commentcount,a.viewcount, "
				+ " a.puttop,a.created,a.imgname,u.username,a.content FROM article a INNER JOIN USER u ON "
				+ " a.authorid=u.oid where a.oid=?";
		PreparedStatement ps=conn.prepareStatement(sql);
		//添加查询文章的文章id
		ps.setInt(1,oid);
		ResultSet rs= ps.executeQuery();
        while(rs.next()) {
            int oid1=rs.getInt(1);
            String title=rs.getString(2);
            String abs=rs.getString(3);
            int commentcount=rs.getInt(4);
            int viewcount=rs.getInt(5);
            int puttop=rs.getInt(6);
            Long created=rs.getLong(7);
            String imgname=rs.getString(8);
            String username=rs.getString(9);
            String content=rs.getString(10);
            Article a=new Article(oid1, title, abs, commentcount, viewcount, content, puttop, created, imgname, username);
              //先查询文章关联的标签
              TagDao td=new TagDao();
              List<Tag> tags=td.getTagsByArticleId(oid);
              //将查询出来的标签添加给文章
              a.setTags(tags);
              return a;
        }
	   }catch (Exception e) {
		e.printStackTrace();
	}
	return null;
   }
}