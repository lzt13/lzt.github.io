package cn.tedu.controller2;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class GetSessionServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
               //获取session对象
		     HttpSession session=req.getSession();
		     //通过会话对象获取之前保存在对象里面的值
		     String str=(String)session.getAttribute("cn");
		     System.out.println(str);
	
	}
}
