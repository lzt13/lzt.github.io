package cn.tedu.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ��������ʵ����
 */
public class Comment {
private int oid;
private String content;//��������
private long created;//����ʱ��
private String name;//��������
private String createStr;//�ַ���ʱ��
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
	//ͨ�������ȡ��ʱ��ƫ����(create)����ʱ��
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