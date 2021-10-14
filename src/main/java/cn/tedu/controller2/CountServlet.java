package cn.tedu.controller2;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * ��ҳ������������
 * ������ҳ�е�����������浽����cookie��
 * �����������ʾ��ҳ��
 * @author ui-cgb
 *
 */
public class CountServlet extends HttpServlet {
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int count=1;
       //����Ҫȡ��cookie�б���������Ϣ
      Cookie[] c=req.getCookies();
      if(c!=null) {
    	  for(Cookie cookie:c) {
    		//����ҵ��˼�¼���ʴ�����cookie,ȡ����
    		  if(cookie.getName().equals("count")) {
    			count=Integer.parseInt(cookie.getValue());
    			//��++����
    			count++;
    		}
    	  }
      }
	   Cookie cookie=new Cookie("count",count+"");
	   resp.addCookie(cookie);
	   resp.setContentType("text/html;charset=utf-8");
	   PrintWriter out= resp.getWriter();
	   out.print("�������˵�"+count+"��");
	   out.close();
   }
}
