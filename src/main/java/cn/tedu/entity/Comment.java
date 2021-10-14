package cn.tedu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 文章详情实体类
 */
public class Comment {
private int oid;
private String content;//评论内容
private long created;//评论时间
private String name;//评论名字
private String createStr;//字符串时间
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public long getCreated() {
	return created;
}
public void setCreated(long created) {
	this.created = created;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getCreateStr() {
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//通过库里获取的时间偏移量(create)定义时间
	Date date=new Date(created);
	return sdf.format(date);
}
public void setCreateStr(String createStr) {
	this.createStr=createStr;
}
public Comment() {

}
public Comment(int oid, String content, long created, String name){
	this.oid = oid;
	this.content = content;
	this.created = created;
	this.name = name;
}
@Override
public String toString() {
	return "Comment [oid=" + oid + ", content=" + content + ", created=" + created + ", name=" + name
			 +"]";
}
}