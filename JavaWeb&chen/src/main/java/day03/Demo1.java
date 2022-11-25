package day03;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

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
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		System.out.println(response.getContentType());
		response.setContentType("text/html; charset=UTF-8");
		
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");
		request.setAttribute("username", name);
		PrintWriter out = response.getWriter();
		Islogin islogin=new Islogin();
		boolean is=islogin.is(name, pass);
		if(is) {
			System.out.print("用户名："+name+"密码："+pass);
			request.getRequestDispatcher("/day03-2");
//			.forward(request, response);
		}else {
			out.print("用户名或者密码错误");
			response.sendRedirect("http://localhost:8080/lh.com/html/login.html");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
