package html;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Regist extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IsTrue it = new IsTrue();
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        System.out.println(name + "\t" + pass);
        int is = it.isRegist(name, pass);
        if (is == 1) {
            out.println("注册成功！马上跳转登录");
            response.setHeader("refresh", "1;./html/login.html");
        } else if (is == 0) {
            out.println("已经存在是否登录？<div><a href=\"./html/login.html\">登录</a></div><div><a href=\"./html/regists.html\">继续注册</a></div>");
        } else {
            out.println("登录名或者密码不能为空！请重新输入注册信息");
            response.setHeader("refresh", "1;./html/regists.html");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        doGet(request, response);
    }

}
