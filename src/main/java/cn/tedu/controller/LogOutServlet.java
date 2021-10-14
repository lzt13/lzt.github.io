package cn.tedu.controller;
/**
 * 用户登出
 * 清楚之前loginServlet保存在服务器上的用户名和密码
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 HttpSession session=request.getSession();
	 //删除对话信息
	 session.removeAttribute("user");
	  response.sendRedirect(request.getContextPath()+"/ShowLoginServlet");
	}

}
