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
               //��ȡsession����
		     HttpSession session=req.getSession();
		     //ͨ���Ự�����ȡ֮ǰ�����ڶ��������ֵ
		     String str=(String)session.getAttribute("cn");
		     System.out.println(str);
	
	}
}
