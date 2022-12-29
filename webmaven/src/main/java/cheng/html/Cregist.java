package cheng.html;

import cheng.isTrue.CIsTrue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Cregist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CIsTrue cit = new CIsTrue();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        List isList = cit.isRegist(name, pass);
        if (isList.get(0).equals("-1")) {//注册成功
            out.println(isList.get(1));
            response.setHeader("refresh", "1;./chtml/login.jsp");
        } else if (isList.get(0).equals("0")) {
            out.println(isList.get(1));

        } else {
            out.println(isList.get(1));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
