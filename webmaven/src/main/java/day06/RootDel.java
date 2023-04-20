package day06;

import html.IsTrue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

public class RootDel extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String[] usermesgs = request.getParameterValues("usermesg");
        String[] buttons = request.getParameterValues("button");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        IsTrue it = new IsTrue();
        System.out.println(Arrays.toString(usermesgs));
        if (usermesgs != null) {//选择列表不为空
            switch (buttons[0]) {
                case "1": //添加
                    out.println("添加功能正在实现中");
                    break;
                case "2":
                    out.println("修改还是遥遥无期");
                    break;
                case "3":  //删除
                    if (it.isDellMore(usermesgs)) {
                        out.println("删除成功");
                        break;
                    } else {
                        out.println("无效删除");
                        break;
                    }

                default:
                    out.println("参数错误");
            }
            response.setHeader("refresh", "1;./html/root&user.jsp");
        } else {
            out.println("选择数据");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
