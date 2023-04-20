package day02;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo3
 */
@WebServlet("/d2-3")
public class Demo3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo3() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
//		读取ServletConfig属性——私有属性
//		ServletConfig sconfig = getServletConfig();
//		String name=sconfig.getInitParameter("user");
//		out.print("<h2>name:</h2>"+name);
//		String password=sconfig.getInitParameter("password");
//		out.print("<h2>password</h2>"+password);
//		读取ServletConfig属性——公共属性
		ServletContext context = getServletContext();
		String cname = context.getInitParameter("name");
		out.print("<h1>Demo3</h1>");
		out.print("<h3>name:</h3>" + cname);
		String cpas = context.getInitParameter("pas");
		out.print("<h3>password:</h3>" + cpas);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 * response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
