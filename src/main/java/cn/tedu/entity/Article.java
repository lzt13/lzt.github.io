package cn.tedu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * article表的实体类
 * 实体类中的属性对应表中的字段
 * 实体类中的对象对应表中的一行信息
 * @author ui-cgb
 *
 */
public class Article {
 private int oid;//对象id
 private String title;//标题
 private String abs;//摘要
 private int commentcount;//评论数量
 private int viewcount;//评论数量
 private String content;//正文
 private int putTop;//是否置顶
 private long created;//创建时间
 private String imgname;//图片名称
 private String username;//作者名称
 //创建集合 存放这个文档行关联的标签对象
 private List<Tag> tags;
 //设置年月日时间
 private String createStr;
 
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public String getTitle() {
	return title;
}
public void setTitle(String title) {
	this.title = title;
}
public String getAbs() {
	return abs;
}
public void setAbs(String abs) {
	this.abs = abs;
}

public int getCommentcount() {
	return commentcount;
}
public void setCommentcount(int commentcount) {
	this.commentcount = commentcount;
}
public int getViewcount() {
	return viewcount;
}
public void setViewcount(int viewcount) {
	this.viewcount = viewcount;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public int getPutTop() {
	return putTop;
}
public void setPutTop(int putTop) {
	this.putTop = putTop;
}
public long getCreated() {
	return created;
}
public void setCreated(long created) {
	this.created = created;
}

public String getImgname() {
	return imgname;
}
public void setImgname(String imgname) {
	this.imgname = imgname;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public List<Tag> getTags() {
	return tags;
}
public void setTags(List<Tag> tags) {
	this.tags = tags;
}
//可以通过调用createStr的get方法来获得年月日时间;
//在这个方法中可以编写把从库里拿来的时间偏移量
//转换成具体的时间格式
public String getCreateStr() {
	//使用SimpleDateFormat对象
	//将一个date对象装换成String
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//通过库里获取的时间偏移量(create)定义时间
	Date date=new Date(created);
	return sdf.format(date);
}
public void setCreateStr(String createStr) {
	this.createStr = createStr;
}

public Article(int oid, String title, String abs, int commentcount, int viewcount, String content, int puttop,
		Long created, String imgname, String username) {
		  super();
		  this.oid = oid;
		  this.title = title;
		  this.abs = abs;
		  this.commentcount = commentcount;
		  this.viewcount = viewcount;
		  this.content =content;
		  this.putTop = putTop;
		  this.created = created;
		  this.imgname = imgname;
		  this.username = username;
	// TODO Auto-generated constructor stub
}

public Article(int oid, String title) {
	super();
	this.oid = oid;
	this.title = title;
}
@Override
public String toString() {
	return "Article [oid=" + oid + ", title=" + title + ", abs=" + abs + ", commentcount=" + commentcount
			+ ", viewcount=" + viewcount + ", content=" + content + ", putTop=" + putTop + ", created=" + created
			+ ", imgName=" + imgname + ", userName=" + username + "]";
}
 
}
