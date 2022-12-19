package cn.itcast.servlet;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet06 extends HttpServlet {
	/**
	 *
	 */
	private static final long serialVersionUID = -5682475838538568444L;

	/**
	 * 相对路径
	 */
//	public void doGet(HttpServletRequest request,
//      HttpServletResponse response)throws ServletException, IOException {
//		ServletContext context = this.getServletContext();
//			PrintWriter out = response.getWriter();
//			//获取相对路径中的输入流对象
//			InputStream in = context
//				.getResourceAsStream("/WEB-INF/classes/itcast.properties");
//			Properties pros = new Properties();
//			pros.load(in);
//			out.println("Company=" + pros.getProperty("Company") + "<br>");
//			out.println("Address=" + pros.getProperty("Address") + "<br>");
//	}

	/**
	 * 绝对路径
	 */
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		ServletContext context = this.getServletContext();
		// 获取文件绝对路径
		String path = context.getRealPath("/WEB-INF/classes/itcast.properties");
		FileInputStream in = new FileInputStream(path);
		Properties pros = new Properties();
		pros.load(in);
		out.println("Company=" + pros.getProperty("Company") + "<br>");
		out.println("Address=" + pros.getProperty("Address") + "<br>");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doGet(request, response);
	}
}
