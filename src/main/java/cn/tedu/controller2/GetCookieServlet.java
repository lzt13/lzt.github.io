package cn.tedu.controller2;

import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * 获取cookie的过程
 * @author ui-cgb
 *
 */
public class GetCookieServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //我们通过request对象获取保存在浏览器的cookie
    	 //此时获取到的是一个cookie类型的数组
    	 //遍历cookie数组获取想要的数组元素
    	 //获取cookie数组
      Cookie[] cookie=req.getCookies();
      //非空判断
      if(cookie!=null) {
    	  for(Cookie c:cookie) {
    		  //获取cookie对象的name和value
    		  String name=c.getName();
    		  String value=c.getValue();
    		  //对value进行解码
    		  value=URLDecoder.decode(value,"utf-8");
    	    	 System.out.println(name+" "+value); 
    	      }
      }
      
     }
}
