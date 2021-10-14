package cn.tedu.controller;
/**
 * 处理注册请求
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class RegServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	     //字符集
		req.setCharacterEncoding("utf-8");
	    String name=req.getParameter("name");
	    String pwd=req.getParameter("pwd");
	    String email=req.getParameter("email");
	   UserDao ud=new UserDao();
	   // uid  自动增长 0 是默认值
	   ud.save(new User(0,name,email,pwd));
	   //跳转到登录页面
	   resp.sendRedirect(req.getContextPath()+"/ShowLoginServlet");
	}
}
