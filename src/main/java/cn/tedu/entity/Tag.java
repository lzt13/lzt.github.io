package cn.tedu.entity;

public class Tag {
      private int oid;//标签id
      private int referenceCount;//引用次数
      private String title;//标签名称
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public int getReferenceCount() {
		return referenceCount;
	}
	public void setReferenceCount(int referenceCount) {
		this.referenceCount = referenceCount;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
      public Tag() {
		// TODO Auto-generated constructor stub
	}
	public Tag(int oid, int referenceCount, String title) {
		this.oid = oid;
		this.referenceCount = referenceCount;
		this.title = title;
	}
	@Override
	public String toString() {
		return "Tag [oid=" + oid + ", referenceCount=" + referenceCount + ", title=" + title + "]";
	}
      
}
