package cn.tedu.controller;

import java.io.IOException;
/**
 * 此类是reg.html页面的响应
 */
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.utils.THUtils;
public class ShowRegServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         Context context=new Context();
        THUtils.print("blog/reg.html", context, resp);
     }
    
}
