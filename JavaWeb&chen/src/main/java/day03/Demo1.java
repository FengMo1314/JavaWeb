package day03;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Demo1
 */
public class Demo1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Demo1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(response.getContentType());
		response.setContentType("text/html; charset=UTF-8");

		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
//		request.setAttribute("username", name);
		PrintWriter out = response.getWriter();
		Islogin islogin = new Islogin();
		boolean is = islogin.is(name, pass);
		if (is) {
			ServletContext content = getServletContext();
			System.out.print("用户名：" + name + "密码：" + pass);
			content.setAttribute("name", name);
			out.print("正确——稍等1秒跳转");
			response.sendRedirect("./day03-2");
//				request.getRequestDispatcher("./day03-2").forward(request, response);

		} else {
			out.print("用户名或者密码错误");
			response.sendRedirect("./html/login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
