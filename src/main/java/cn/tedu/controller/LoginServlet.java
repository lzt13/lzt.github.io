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
		//�����ȡ���û���Ϣ
		String rem=req.getParameter("rem");
		UserDao ud=new UserDao();
		User u=ud.login(name, pwd);
		if(u==null) {
			//ʧ��
			resp.sendRedirect(req.getContextPath()+"/ShowLoginServlet");
		}else {
			 //����û���Ҫ������Ϣ,ʵ����cookie,�����浽�������
			if(rem!=null) {
				Cookie c1=new Cookie("name",URLEncoder.encode(name, "utf-8"));
				Cookie c2=new Cookie("pwd",pwd);
			    c1.setMaxAge(60);
			    c2.setMaxAge(60);
			    resp.addCookie(c1);
				resp.addCookie(c2);
			}
			//��½�ɹ�֮���ת����ҳҳ��
			//��ȡ��ǰ�Ự����
			HttpSession session=req.getSession();
			//����½�ɹ����û���Ϣ������session������
			session.setAttribute("user",u);
			resp.sendRedirect(req.getContextPath()+"/HomeServlet");
		}
	}

}
