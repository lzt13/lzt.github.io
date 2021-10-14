package cn.tedu.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.entity.User;

/**
 * 过滤器
 * 将用户信息存储的代码统一提取
 * @author ui-cgb
 *1.实现Filter接口类
 *2.重写doFilter()方法
 */
public class MyFilter implements Filter{
   @Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	//当有请求需要过滤器处理时
	   //获取session
	   //由于ServletRequest是httpservletrequest的子类
	   //所以需要强转
	   HttpServletRequest req=(HttpServletRequest)request;
	   HttpServletResponse resp=(HttpServletResponse)response;
	   HttpSession session=req.getSession();
	   //要验证用户是否登录
	   User user=(User)session.getAttribute("user");
    if(user!=null) {
    	//如果登录 则允许访问
    	//chain放行 通过这个过滤器
    	chain.doFilter(req, resp);
    }else{
    	//如果没有登陆
    	resp.sendRedirect(req.getContextPath()+"/ShowLoginServlet");
    }
   }
   @Override
	public void destroy() {
		
	}
   @Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//初始化时运行
	}
}
