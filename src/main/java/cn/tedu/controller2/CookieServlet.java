package cn.tedu.controller2;
import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie的缓存数据过程
 * @author ui-cgb
 *
 */
public class CookieServlet extends HttpServlet {
     @Override
     //创建cookie对象
     protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
     Cookie c1=new Cookie("name","Tom");
     //将创建好的cookie对象保存到浏览器
     resp.addCookie(c1);
     //上面的cookie保存方式没有指定保存时间
     //默认会跟会话一起消失
     //下面的cookie保存方式是长期保存在浏览器中的cookie
     Cookie c2=new Cookie("info", "Jerry");
     //设置过期时间 一定在cookie保存到浏览器之前设置
     c2.setMaxAge(60*60*24*30);//单位是秒 这是一个月
     resp.addCookie(c2);
     //如果在cookie保存中文 会有乱码的问题
     //定义编码,后期获取数据需要解码;
     Cookie c3=new Cookie("msg",URLEncoder.encode("北京烤鸭宫保鸡丁蛋炒饭","utf-8"));
     resp.addCookie(c3);
     }
	
	
	
}
