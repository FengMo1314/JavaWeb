package html;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Login", value = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IsTrue it = new IsTrue();
        response.setContentType("text/html; charset=UTF-8");
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(name + "\t" + pass);
        int is = it.isLogin(name, pass);
        if (is == -1) {
            out.println("您还没有注册！马上安排");
            response.setHeader("refresh", "1;./html/regists.html");
        } else if (is == 0) {
            out.println("登录成功！");
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(100);//设置非活跃间隔时间
            session.setAttribute("username", name);
            response.setHeader("refresh", "1;./");
        } else if (is == 1) {
            out.println("密码错误！请稍后重试");
            response.setHeader("refresh", "1;URL=./html/login.html");
        } else {
            out.println("登录名或者密码不能为空！请重新输入注册信息");
            response.setHeader("refresh", "1;./html/login.html");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}
