package cheng.html;

import cheng.bean.UpdataBeanCheng;
import cheng.isTrue.CIsTrue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Cupdatabyuser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CIsTrue cit = new CIsTrue();
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(session.getAttribute("id").toString());
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        UpdataBeanCheng ubc = new UpdataBeanCheng(name, pass, id);
        System.out.println("Cupdatabyuser获取id(session)=" + id);
        List isList = cit.isUpdata(id, ubc);
        if (isList.get(0).equals("1")) {
            out.println(isList.get(1));
            response.setHeader("refresh", "1;./chtml/updataByuser.jsp");
        } else if (isList.get(0).equals("0")) {
            out.println(isList.get(1));
            response.setHeader("refresh", "1;./chtml/user.jsp");

        } else {
            out.println(isList.get(1));
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
