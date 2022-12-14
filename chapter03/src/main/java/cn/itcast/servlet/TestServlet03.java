package cn.itcast.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet03 extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = 973717943616367101L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		// 得到ServletContext对象
		ServletContext context = this.getServletContext();
		// 得到包含所有初始化参数名的Enumeration对象
		Enumeration<String> paramNames = context.getInitParameterNames();
		// 遍历所有的初始化参数名，得到相应的参数值，打印到控制台
		out.println("all the paramName and paramValue are following:");
		// 遍历所有的初始化参数名，得到相应的参数值并打印
		while (paramNames.hasMoreElements()) {
			String name = paramNames.nextElement();
			String value = context.getInitParameter(name);
			out.println(name + ": " + value);
			out.println("<br>");
		}
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
