package cn.tedu.controller2;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie�Ļ������ݹ���
 * @author ui-cgb
 *
 */
public class CookieServlet extends HttpServlet {
     @Override
     //����cookie����
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     Cookie c1=new Cookie("name","Tom");
     //�������õ�cookie���󱣴浽�����
     resp.addCookie(c1);
     //�����cookie���淽ʽû��ָ������ʱ��
     //Ĭ�ϻ���Ựһ����ʧ
     //�����cookie���淽ʽ�ǳ��ڱ�����������е�cookie
     Cookie c2=new Cookie("info", "Jerry");
     //���ù���ʱ�� һ����cookie���浽�����֮ǰ����
     c2.setMaxAge(60*60*24*30);//��λ���� ����һ����
     resp.addCookie(c2);
     //�����cookie�������� �������������
     //�������,���ڻ�ȡ������Ҫ����;
     Cookie c3=new Cookie("msg",URLEncoder.encode("������Ѽ��������������","utf-8"));
     resp.addCookie(c3);
     }
	
	
	
}
