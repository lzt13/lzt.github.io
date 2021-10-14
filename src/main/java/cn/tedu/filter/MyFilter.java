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
 * ������
 * ���û���Ϣ�洢�Ĵ���ͳһ��ȡ
 * @author ui-cgb
 *1.ʵ��Filter�ӿ���
 *2.��дdoFilter()����
 */
public class MyFilter implements Filter{
   @Override
public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
		throws IOException, ServletException {
	//����������Ҫ����������ʱ
	   //��ȡsession
	   //����ServletRequest��httpservletrequest������
	   //������Ҫǿת
	   HttpServletRequest req=(HttpServletRequest)request;
	   HttpServletResponse resp=(HttpServletResponse)response;
	   HttpSession session=req.getSession();
	   //Ҫ��֤�û��Ƿ��¼
	   User user=(User)session.getAttribute("user");
    if(user!=null) {
    	//�����¼ ���������
    	//chain���� ͨ�����������
    	chain.doFilter(req, resp);
    }else{
    	//���û�е�½
    	resp.sendRedirect(req.getContextPath()+"/ShowLoginServlet");
    }
   }
   @Override
	public void destroy() {
		
	}
   @Override
	public void init(FilterConfig filterConfig) throws ServletException {
		//��ʼ��ʱ����
	}
}
