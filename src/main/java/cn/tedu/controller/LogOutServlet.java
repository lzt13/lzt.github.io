package cn.tedu.controller;
/**
 * �û��ǳ�
 * ���֮ǰloginServlet�����ڷ������ϵ��û���������
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
	 //ɾ���Ի���Ϣ
	 session.removeAttribute("user");
	  response.sendRedirect(request.getContextPath()+"/ShowLoginServlet");
	}

}
