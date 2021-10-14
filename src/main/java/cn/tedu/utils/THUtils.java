package cn.tedu.utils;
/**
 * ��ģ������ʵ���������ݽ��з�װ;
 * @author ui-cgb
 *
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

public class THUtils {
//����ģ������
	private static TemplateEngine te;
	static {
		//ʵ����ģ������
		te=new TemplateEngine();
		//ʵ����ģ�������������
		ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
		resolver.setCharacterEncoding("utf-8");
		//���������ö�����ظ�ģ������
		te.setTemplateResolver(resolver);
	}
	//����һ��������ָ����html�ļ��Լ�Ҫ�滻������
	//��response������Ϊ����д�������������
	//�����������ֱ�����ҳ��Ľ��
	public static void print(String filename,Context context,
		HttpServletResponse response) throws IOException {
       //��ø���ģ�����ɵ�ҳ����ַ���
		String html=te.process(filename, context);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(html);
		out.close();
	
	}
}
