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
import cn.tedu.dao.LinkDao;
import cn.tedu.dao.TagDao;
import cn.tedu.entity.Article;
import cn.tedu.entity.Link;
import cn.tedu.entity.Tag;
import cn.tedu.entity.User;
import cn.tedu.utils.THUtils;

public class SearchServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
              //获得用户输入的关键字
		String keyword=req.getParameter("keyword");
		Context context=new Context();
        ArticleDao ad=new ArticleDao();
        List<Article> list= ad.getArticleListByKeyword(keyword);
        context.setVariable("list", list);
        HttpSession session=req.getSession();
        User user=(User)session.getAttribute("user");
        context.setVariable("user", user);
        List<Article> timeList=ad.getListByType("created");
        //按照评论量降序获取文章
        List<Article> commentList=ad.getListByType("commentcount");
        //按照浏览量降序获取文章
        List<Article> viewList=ad.getListByType("viewcount");
        context.setVariable("timeList", timeList);
        context.setVariable("commentList", commentList);
        context.setVariable("viewList", viewList);
        //调用分类标签的内容
          TagDao td=new TagDao();
          List<Tag> tags=td.getList();
          context.setVariable("tags", tags);
          LinkDao ld=new LinkDao();
          List<Link> links=ld.getList();
          context.setVariable("links", links);
        THUtils.print("blog/list.html", context, resp);
	}

}
