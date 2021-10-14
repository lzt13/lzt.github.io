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
 * 处理发布文章的请求
 * @author ui-cgb
 *
 */
public class SendActionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //从副本页面获取用户输入的用户信息
		String title=request.getParameter("title");
		String abs=request.getParameter("abs");
		String content=request.getParameter("content");
		String imgName=request.getParameter("imgName");
		String putTop=request.getParameter("putTop");
		  //判断putTop的值是否是空值
		  //如果是空值就不置顶,如果不是空值就置顶
		  //数据库中 1表示置顶 0表示不置顶
		  //定义一个变量
		int isPutTop=putTop==null?0:1;
		System.out.println(title);
		System.out.println(abs);
		System.out.println(content);
		System.out.println(imgName);
		System.out.println(isPutTop);
		//获得时间偏移量
		long created=System.currentTimeMillis();
		//封装文章实体类
		Article a=new Article(0, title, abs, 0, 0, content, isPutTop, created, imgName, null);
		//获取登录用户的id作文发布文章作者的id
		HttpSession session=request.getSession();
		User u=(User)session.getAttribute("user");
		//实例化文章数据
		ArticleDao ad=new ArticleDao();
			ad.AddArticle(a,u.getOid());
		//发布成功 重定向到文章列表
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}

}
