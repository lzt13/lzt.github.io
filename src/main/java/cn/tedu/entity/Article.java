package cn.tedu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * article���ʵ����
 * ʵ�����е����Զ�Ӧ���е��ֶ�
 * ʵ�����еĶ����Ӧ���е�һ����Ϣ
 * @author ui-cgb
 *
 */
public class Article {
 private int oid;//����id
 private String title;//����
 private String abs;//ժҪ
 private int commentcount;//��������
 private int viewcount;//��������
 private String content;//����
 private int putTop;//�Ƿ��ö�
 private long created;//����ʱ��
 private String imgname;//ͼƬ����
 private String username;//��������
 //�������� �������ĵ��й����ı�ǩ����
 private List<Tag> tags;
 //����������ʱ��
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
//����ͨ������createStr��get���������������ʱ��;
//����������п��Ա�д�Ѵӿ���������ʱ��ƫ����
//ת���ɾ����ʱ���ʽ
public String getCreateStr() {
	//ʹ��SimpleDateFormat����
	//��һ��date����װ����String
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	//ͨ�������ȡ��ʱ��ƫ����(create)����ʱ��
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
