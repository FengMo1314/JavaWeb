/**
 *
 */
package day02;

import java.io.IOException;
import java.io.PrintWriter;

import org.apache.catalina.Server;

import ip.GetLocalIp;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author LiuHe
 *
 */
public class Demo1{

	/**
	 *
	 */
	private static final long serialVersionUID = 7273002642778684255L;

	/**
	 *
	 */
	public Demo1() {
		// TODO 自动生成的构造函数存根
	}
	protected void doGet(ServletRequest req,ServletResponse resp) throws ServletException, IOException{
		// TODO 自动生成的方法存根
		this.doPost(req, resp);
	}
	protected void doPost(ServletRequest req,ServletResponse resp) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		resp.setContentType("text/html;charset=utf-8");
		resp.setCharacterEncoding("UTF-8");
		PrintWriter out = resp.getWriter();
		
//		out.print("欢迎"+GetLocalIp.getLocalIp(req)+"到来");
//		System.out.println(GetLocalIp.getLocalIp(req));
	}
     

}
