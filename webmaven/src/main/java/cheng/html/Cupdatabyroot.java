package cheng.html;

import cheng.bean.TableBeanCheng;
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

public class Cupdatabyroot extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CIsTrue cit;
        response.setContentType("text/html; charset=UTF-8");
        HttpSession session = request.getSession();
        List<TableBeanCheng> tbl = (List<TableBeanCheng>) session.getAttribute("TableBeanCheng");
        PrintWriter out = response.getWriter();
//        String[] ids=request.getParameterValues("uid");
        String[] usernames = request.getParameterValues("username");
        String[] passwords = request.getParameterValues("password");
        List<UpdataBeanCheng> ubcList = null;
        UpdataBeanCheng ubc;
        String s = "成功:", s1 = "占用:";
        for (int i = 0; i < usernames.length; i++) {
            cit = new CIsTrue();
            ubc = new UpdataBeanCheng(usernames[i], passwords[i], tbl.get(i).getId());
            List<String> list = cit.isUpdata(ubc.getId(), ubc);
            if (list.get(0).equals("1")) {
                s += "\t" + list.get(1);
            } else {
                s1 += list.get(1);
            }
        }
        out.println(s + "\n" + s1);
        response.setHeader("refresh", "3;./chtml/root.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        this.doGet(request, response);
    }
}
