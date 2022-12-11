package html;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class UserInformation extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        IsTrue it = new IsTrue();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (it.isDell(username)) {
            out.println("注销成功！");
            session.invalidate();
            response.setHeader("refresh", "2;./");
        } else {
            out.println("无效的注销！可能是登录已过期");
            out.println("<a href=\"./html/login.html\">重新登录</a>");
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        this.doGet(request, response);
    }
}
