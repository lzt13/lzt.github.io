package cn.tedu.utils;
/**
 * 将模板引擎实例化的内容进行封装;
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
//声明模板引擎
	private static TemplateEngine te;
	static {
		//实例化模板引擎
		te=new TemplateEngine();
		//实例化模板配置引擎对象
		ClassLoaderTemplateResolver resolver=new ClassLoaderTemplateResolver();
		resolver.setCharacterEncoding("utf-8");
		//将引擎配置对象加载给模板引擎
		te.setTemplateResolver(resolver);
	}
	//定义一个方法将指定的html文件以及要替换的内容
	//和response对象作为参数写在这个方法当中
	//调用这个方法直接输出页面的结果
	public static void print(String filename,Context context,
		HttpServletResponse response) throws IOException {
       //获得根据模板生成的页面的字符串
		String html=te.process(filename, context);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out=response.getWriter();
		out.print(html);
		out.close();
	
	}
}
