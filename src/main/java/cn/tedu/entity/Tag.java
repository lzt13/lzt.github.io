package cn.tedu.entity;

public class Tag {
      private int oid;//��ǩid
      private int referenceCount;//���ô���
      private String title;//��ǩ����
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
