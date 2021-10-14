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
 * ��ȡcookie�Ĺ���
 * @author ui-cgb
 *
 */
public class GetCookieServlet extends HttpServlet {
     @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      //����ͨ��request�����ȡ�������������cookie
    	 //��ʱ��ȡ������һ��cookie���͵�����
    	 //����cookie�����ȡ��Ҫ������Ԫ��
    	 //��ȡcookie����
      Cookie[] cookie=req.getCookies();
      //�ǿ��ж�
      if(cookie!=null) {
    	  for(Cookie c:cookie) {
    		  //��ȡcookie�����name��value
    		  String name=c.getName();
    		  String value=c.getValue();
    		  //��value���н���
    		  value=URLDecoder.decode(value,"utf-8");
    	    	 System.out.println(name+" "+value); 
    	      }
      }
      
     }
}
