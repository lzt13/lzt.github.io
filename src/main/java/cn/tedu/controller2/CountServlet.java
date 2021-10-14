package cn.tedu.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 网页设计浏览计数器
 * 根据网页中的浏览次数保存到数据cookie中
 * 将浏览次数显示在页面
 * @author ui-cgb
 *
 */
public class CountServlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int count=1;
       //首先要取出cookie中保存的浏览信息
      Cookie[] c=req.getCookies();
      if(c!=null) {
    	  for(Cookie cookie:c) {
    		//如果找到了记录访问次数的cookie,取出它
    		  if(cookie.getName().equals("count")) {
    			count=Integer.parseInt(cookie.getValue());
    			//做++运算
    			count++;
    		}
    	  }
      }
	   Cookie cookie=new Cookie("count",count+"");
	   resp.addCookie(cookie);
	   resp.setContentType("text/html;charset=utf-8");
	   PrintWriter out= resp.getWriter();
	   out.print("您访问了第"+count+"次");
	   out.close();
   }
}
