package cn.tedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.dao.CommentDao;
import cn.tedu.entity.User;

public class CommentServlet extends HttpServlet {
	 @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //��ȡ��ǰ��¼���û�����
		 HttpSession session=req.getSession();
		 User user=(User)session.getAttribute("user");
		 String articleId=req.getParameter("articleId");
		 String commentContent=req.getParameter("commentContent");
		 //����CommentDao�еķ���
		 CommentDao cd=new CommentDao();
		 cd.save(articleId, commentContent, user.getUserName());
		 //�ض�������ҳ������
		 String path=req.getContextPath()+"/DetailServlet?oid="+articleId;
		 System.out.println(path);
		 resp.sendRedirect(path);
	 }
}
