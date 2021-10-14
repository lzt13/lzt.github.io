package cn.tedu.controller;
/**
 * ���Ʋ�
 * �����ȡ����������Ϣ������ getHomeList()
 */
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.dao.LinkDao;
import cn.tedu.dao.TagDao;
import cn.tedu.entity.Article;
import cn.tedu.entity.Link;
import cn.tedu.entity.Tag;
import cn.tedu.entity.User;
import cn.tedu.utils.THUtils;
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           //���session�Ի�
		    HttpSession session=request.getSession();
		    //��ȡ�Ự�д洢��user��Ϣ  ͨ��keyֵuser
	        User user=(User)session.getAttribute("user");
//	        //�ж��û��Ƿ��¼
//	        if(user==null) {
//	        	//û�е�½�ͽ�ҳ�����¶��򵽵�¼ҳ��
//	        	response.sendRedirect(request.getContextPath()+"/ShowLoginServlet");
//	        	return;//�����дreturn ��������ݻ���Ҫִ�е�
//	        }
		ArticleDao ad=new ArticleDao();
          //��ѯ1-8ƪ����
          List<Article> homeList=ad.getHomeList();
          //���������Ķ���
          Context context=new Context();
        //first�洢�Ĳ��Ǽ����Ƕ���; ����������Ϣ��article����
          //1ƪ
        context.setVariable("first", homeList.get(0));
        //2-4ƪ
        context.setVariable("head", homeList.subList(1, 4));
        //ʣ�����ƪ 5-8
        context.setVariable("body", homeList.subList(4, homeList.size()));
        //��ȡ�Ҳ�����
        //����ʱ�併���ȡ����
        List<Article> timeList=ad.getListByType("created");
        //���������������ȡ����
        List<Article> commentList=ad.getListByType("commentcount");
        //��������������ȡ����
        List<Article> viewList=ad.getListByType("viewcount");
        context.setVariable("timeList", timeList);
        context.setVariable("commentList", commentList);
        context.setVariable("viewList", viewList);
        //���÷����ǩ������
          TagDao td=new TagDao();
          List<Tag> tags=td.getList();
          context.setVariable("tags", tags);
          LinkDao ld=new LinkDao();
          List<Link> links=ld.getList();
          context.setVariable("links", links);
        //System.out.println(timeList);
        //System.out.println(commentList);
        //System.out.println(viewList);
          //����session�еõ��ĵ�¼�û����󱣴浽context����,�Ա�ҳ����ʾ
          context.setVariable("user",user);
        //ʹ��Thymeleafģ���������ҳ��
        THUtils.print("blog/index.html",context,response);
	}
       
}
