package cheng.html;

import cheng.bean.TableBeanCheng;
import cheng.db.UserDao;
import cheng.isTrue.CIsTrue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class Crootanduser2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] usermesgs = request.getParameterValues("userid");
        String[] buttons = request.getParameterValues("button");
        String text = request.getParameter("text");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        CIsTrue cit = new CIsTrue();
        System.out.println("选择了用户" + Arrays.toString(usermesgs));
//        if (usermesgs != null) {//选择列表不为空
        System.out.println(buttons[0]);
        switch (buttons[0]) {
            case "1"://查询
                request.setAttribute("select", "true");
                UserDao ud = new UserDao();
                List<TableBeanCheng> list = ud.selectSomsByUserName(text);
                request.setAttribute("somList", list);
                request.getRequestDispatcher("./chtml/root.jsp").forward(request, response);
//                    response.setHeader("refresh", "1;./chtml/root.jsp");
//                    response.sendRedirect("./chtml/root.jsp");
                break;
            case "2"://修改
                out.write("dd");
                break;
            case "3"://删除
                List<String> listdell = cit.isDellArrays(usermesgs);
                out.println(listdell.toString());
                response.setHeader("refresh", "1;./chtml/root.jsp");
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
