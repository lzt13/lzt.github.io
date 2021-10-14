package cn.tedu.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;
import cn.tedu.entity.User;
/**
 * ���������µ�����
 * @author ui-cgb
 *
 */
public class SendActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //�Ӹ���ҳ���ȡ�û�������û���Ϣ
		String title=request.getParameter("title");
		String abs=request.getParameter("abs");
		String content=request.getParameter("content");
		String imgName=request.getParameter("imgName");
		String putTop=request.getParameter("putTop");
		  //�ж�putTop��ֵ�Ƿ��ǿ�ֵ
		  //����ǿ�ֵ�Ͳ��ö�,������ǿ�ֵ���ö�
		  //���ݿ��� 1��ʾ�ö� 0��ʾ���ö�
		  //����һ������
		int isPutTop=putTop==null?0:1;
		System.out.println(title);
		System.out.println(abs);
		System.out.println(content);
		System.out.println(imgName);
		System.out.println(isPutTop);
		//���ʱ��ƫ����
		long created=System.currentTimeMillis();
		//��װ����ʵ����
		Article a=new Article(0, title, abs, 0, 0, content, isPutTop, created, imgName, null);
		//��ȡ��¼�û���id���ķ����������ߵ�id
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		//ʵ������������
		ArticleDao ad=new ArticleDao();
			ad.AddArticle(a,u.getOid());
		//�����ɹ� �ض��������б�
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}

}
