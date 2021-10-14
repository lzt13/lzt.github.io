package cn.tedu.controller;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		String name=req.getParameter("name");
		String pwd=req.getParameter("pwd");
		//保存获取的用户信息
		String rem=req.getParameter("rem");
		UserDao ud=new UserDao();
		User u=ud.login(name, pwd);
		if(u==null) {
			//失败
			resp.sendRedirect(req.getContextPath()+"/ShowLoginServlet");
		}else {
			 //如果用户需要保存信息,实例化cookie,并保存到浏览器上
			if(rem!=null) {
				Cookie c1=new Cookie("name",URLEncoder.encode(name, "utf-8"));
				Cookie c2=new Cookie("pwd",pwd);
			    c1.setMaxAge(60);
			    c2.setMaxAge(60);
			    resp.addCookie(c1);
				resp.addCookie(c2);
			}
			//登陆成功之后调转到首页页面
			//获取当前会话对象
			HttpSession session=req.getSession();
			//将登陆成功的用户信息保存在session对象中
			session.setAttribute("user",u);
			resp.sendRedirect(req.getContextPath()+"/HomeServlet");
		}
	}

}
