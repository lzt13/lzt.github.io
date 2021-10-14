package cn.tedu.entity;

public class Link {
   private int oid;
   private String title;
   private String address;
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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
   public Link() {
	// TODO Auto-generated constructor stub
}
public Link(int oid, String title, String address) {
	super();
	this.oid = oid;
	this.title = title;
	this.address = address;
}
@Override
public String toString() {
	return "Link [oid=" + oid + ", title=" + title + ", address=" + address + "]";
}
   
}
