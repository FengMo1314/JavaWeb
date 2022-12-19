/**
 *
 */
package day02;

import java.io.IOException;
import java.io.PrintWriter;

import ip.GetLocalIp;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * @author LiuHe
 */
@WebServlet("/d2-1")
public class Demo1 extends HttpServlet {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Demo1() {
        // TODO 自动生成的构造函数存根
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        resp.setContentType("text/html;charset=utf-8");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.print("<H1>RR</H1>");
        out.print("欢迎" + GetLocalIp.getLocalIp(req) + "到来");
        System.out.println(GetLocalIp.getLocalIp(req));
    }

    protected void doPost(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
        // TODO 自动生成的方法存根
        this.doPost(req, resp);

    }

}
