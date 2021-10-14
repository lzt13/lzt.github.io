package cn.tedu.controller;
/**
 * 响应发布文章的页面
 */
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.utils.THUtils;

public class ShowSendServlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      Context context=new Context();
      THUtils.print("blog/send.html", context, resp);
   }
}
