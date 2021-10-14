package cn.tedu.controller;
/**
 * 控制层
 * 处理获取所有文章信息的请求 getHomeList()
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
           //获得session对话
		    HttpSession session=request.getSession();
		    //获取会话中存储的user信息  通过key值user
	        User user=(User)session.getAttribute("user");
//	        //判断用户是否登录
//	        if(user==null) {
//	        	//没有登陆就将页面重新定向到登录页面
//	        	response.sendRedirect(request.getContextPath()+"/ShowLoginServlet");
//	        	return;//如果不写return 下面的内容还是要执行的
//	        }
		ArticleDao ad=new ArticleDao();
          //查询1-8篇文章
          List<Article> homeList=ad.getHomeList();
          //创建上下文对象
          Context context=new Context();
        //first存储的不是集合是对象; 带有所有信息的article对象
          //1篇
        context.setVariable("first", homeList.get(0));
        //2-4篇
        context.setVariable("head", homeList.subList(1, 4));
        //剩余的四篇 5-8
        context.setVariable("body", homeList.subList(4, homeList.size()));
        //获取右侧文章
        //按照时间降序获取文章
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
        //System.out.println(timeList);
        //System.out.println(commentList);
        //System.out.println(viewList);
          //将从session中得到的登录用户对象保存到context对象,以便页面显示
          context.setVariable("user",user);
        //使用Thymeleaf模板引擎输出页面
        THUtils.print("blog/index.html",context,response);
	}
       
}
