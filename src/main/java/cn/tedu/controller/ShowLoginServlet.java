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
		//֮ǰ�Ѿ������ǰ�˱������û���Ϣ
		//��ȡһ�λỰ
		HttpSession session=req.getSession();
		User u=(User)session.getAttribute("user");
		//�ж��û���¼��״̬ ����ѵ�¼ֱ����ת��HomeServlet
		if(u!=null) {
			resp.sendRedirect(req.getContextPath()+"/HomeServlet");
			return;
		}
		Context context=new Context();
		 //���Cookie�д����û�����
		//���û���¼��Ϣ���浽context������
		  Cookie[] cookies= req.getCookies();
		  if(cookies!=null) {
			  for(Cookie c:cookies) {
				  //�����ǰ��cookieֵ���û����Ļ�ȡ��value,��ŵ�Context��
				  if(c.getName().equals("name")) {
					  String name=URLDecoder.decode(c.getValue(),"utf-8");
					  context.setVariable("name", name);
				  }
				 //�����ǰ��cookie��pwdֵ������Ļ�ȡ��value,��ŵ�Context��
				  if(c.getName().equals("pwd")) {
					  String pwd=c.getValue();
					  context.setVariable("pwd",pwd);
				  }
			  }
		  }
	     THUtils.print("blog/login.html", context, resp);
	     
	}
}
