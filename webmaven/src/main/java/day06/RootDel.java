package day06;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class RootDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] s = request.getParameterValues("usermesg");
        String[] b = request.getParameterValues("button");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        if (s != null) {
            for (String but : s) {
                System.out.println(but);
            }
            System.out.println("-----");
            for (String but : b) {
                System.out.println(but);
            }
        } else {
            out.println("没有数据");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
