package cn.tedu.controller;
/**
 * ����ע������
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
	     //�ַ���
		req.setCharacterEncoding("utf-8");
	    String name=req.getParameter("name");
	    String pwd=req.getParameter("pwd");
	    String email=req.getParameter("email");
	   UserDao ud=new UserDao();
	   // uid  �Զ����� 0 ��Ĭ��ֵ
	   ud.save(new User(0,name,email,pwd));
	   //��ת����¼ҳ��
	   resp.sendRedirect(req.getContextPath()+"/ShowLoginServlet");
	}
}
