package day01;

import java.io.IOException;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;



public class HelloWolrdServelet implements Servlet {

	@Override
	public void destroy() {
		// TODO 自动生成的方法存根
		System.out.println("Servlet正在销毁");

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
	public void init(ServletConfig config) throws ServletException {
		// TODO 自动生成的方法存根
		System.out.println("Servlet正在初始化");
	}

	@Override
	public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
		// TODO 自动生成的方法存根
		// 专门向客服端提供响应的方法
		System.out.println("Servlet正在提供服务");
	}

}
