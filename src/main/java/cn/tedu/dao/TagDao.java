package cn.tedu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.tedu.entity.Tag;
import cn.tedu.utils.DBUtils;

/**
 * Tag�����ݲ�
 * @author ui-cgb
 *
 */
public class TagDao {
     //��������id��ѯ������¹����ı�ǩ�б�
	public List<Tag> getTagsByArticleId(int oid){
		List<Tag> list=new ArrayList<Tag>();
		try (Connection conn=DBUtils.getConn()){
		//�������µ�oid��ǩ��� select tag_oid from tag_article where article_oid=
	    //���ݱ�ǩ��Ż�ȡ��ǩ�б�  select oid ,referenceCount, title from tag where
			//oid in(12,25,49)
			//�Ӳ�ѯ��䵱�в�ѯ����ǩ���
			//����ѯ��䵱�и��ݲ�ѯ���ı�ǩ��ŵõ���ǩ�б�
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
	//��д��ѯ��ǩ�������ô���(ֻ��ѯ5��)
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
