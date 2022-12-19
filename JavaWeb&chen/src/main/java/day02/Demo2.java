package day02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo2
 */
@WebServlet("/d2-2")
public class Demo2 implements Servlet {

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse
	 * response) 原生service
	 */
	@Override
	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		String methods = req.getMethod();
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		if (methods.equals("GET")) {
			out.print("Demo2 doGet...");
			System.out.println("Demo2 doGet...");
		} else if (methods.equals("POST")) {
			System.out.println("Demo2 doPost...");
			out.print("Demo2 doPost...");
		}

	}

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根

	}

	@Override
	public ServletConfig getServletConfig() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public String getServletInfo() {
		// TODO 自动生成的方法存根
		return null;
	}

	@Override
	public void init(ServletConfig arg0) throws ServletException {
		// TODO 自动生成的方法存根

	}

}
