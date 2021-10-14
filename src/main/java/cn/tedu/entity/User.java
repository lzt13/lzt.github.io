package cn.tedu.entity;
/**
 *对应库中的user表
 * @author ui-cgb
 *
 */
public class User {
  private int oid;
  private String email;
  private String userName;
  private String password;
public User(int oid, String email, String userName, String password) {
	this.oid = oid;
	this.email = email;
	this.userName = userName;
	this.password = password;
}

  public User(String userName, String password) {
	super();
	this.userName = userName;
	this.password = password;
}

public User() {
	// TODO Auto-generated constructor stub
}
public int getOid() {
	return oid;
}
public void setOid(int oid) {
	this.oid = oid;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "User [oid=" + oid + ", email=" + email + ", userName=" + userName + ", password=" + password + "]";
}
  
}
