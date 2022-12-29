package day07;

import db.UpdataBean;
import html.IsTrue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

public class Updata extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        int id = (int) session.getAttribute("id");
//        int id= Integer.parseInt(request.getParameter("ids"));
        String uId = request.getParameter("uid");
        String userName = request.getParameter("username");
        String pass = request.getParameter("pass");
        String pass2 = request.getParameter("pass2");
        String email = request.getParameter("email");
        Date birthday = Date.valueOf(request.getParameter("birthday"));
        UpdataBean ub = new UpdataBean(uId, userName, pass2, email, birthday);
        IsTrue it = new IsTrue();
        if (it.isUpdata(id, ub)) {
            out.println("修改成功");
        } else {
            out.println("出错了");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
