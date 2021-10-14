package cn.tedu.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class SetSessionServlet extends HttpServlet {
  @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            //getSession()  获得session   默认值为null
	   HttpSession session=req.getSession();
	        //给session赋值
	   session.setAttribute("cn", "中华人民共和国");
	   
  }
}
