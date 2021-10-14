package cn.tedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;
import cn.tedu.entity.User;
import cn.tedu.utils.THUtils;

/**
 * Servlet implementation class ListServlet
 */
public class ListServlet extends HttpServlet {

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
          Context context=new Context();
          ArticleDao ad=new ArticleDao();
          List<Article> list= ad.getArticleList();
          context.setVariable("list", list);
          HttpSession session=req.getSession();
          User user=(User)session.getAttribute("user");
          context.setVariable("user", user);
          THUtils.print("blog/list.html", context, resp);
   }
}
