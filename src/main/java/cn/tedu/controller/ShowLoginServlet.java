package cn.tedu.controller;

import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.entity.User;
import cn.tedu.utils.THUtils;

/**
 * Servlet implementation class ShowLoginServlet
 */
public class ShowLoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//之前已经在浏览前端保存了用户信息
		//获取一次会话
		HttpSession session=req.getSession();
		User u=(User)session.getAttribute("user");
		//判断用户登录的状态 如果已登录直接跳转到HomeServlet
		if(u!=null) {
			resp.sendRedirect(req.getContextPath()+"/HomeServlet");
			return;
		}
		Context context=new Context();
		 //如果Cookie中存有用户数据
		//则将用户登录信息保存到context对象中
		  Cookie[] cookies= req.getCookies();
		  if(cookies!=null) {
			  for(Cookie c:cookies) {
				  //如果当前的cookie值是用户名的话取出value,存放到Context中
				  if(c.getName().equals("name")) {
					  String name=URLDecoder.decode(c.getValue(),"utf-8");
					  context.setVariable("name", name);
				  }
				 //如果当前的cookie的pwd值是密码的话取出value,存放到Context中
				  if(c.getName().equals("pwd")) {
					  String pwd=c.getValue();
					  context.setVariable("pwd",pwd);
				  }
			  }
		  }
	     THUtils.print("blog/login.html", context, resp);
	     
	}
}
