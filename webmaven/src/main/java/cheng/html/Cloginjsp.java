package cheng.html;

import cheng.cuntil.AboutCookies;
import cheng.cuntil.HttpGetJson;
import cheng.isTrue.CIsTrue;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "Cloginjsp", value = "/cloginjsp")
public class Cloginjsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        CIsTrue cit = new CIsTrue();
        JSONObject data = HttpGetJson.getJson(request);
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        String jima = request.getParameter("jima");
        // 获取前台输入的验证码
        String code = request.getParameter("coodimg");
        // 获取后台的验证码
        String scode = (String) session.getAttribute("scode");
        //

        List<String> isList = null;
        Cookie[] s = request.getCookies();
        if (code == "" || name == "" || pass == "") {//非空判断
            out.println("空的不行");

        } else {
            if (code.equals(scode)) {//验证码对
                isList = cit.isLogin(name, pass);
                AboutCookies cookies = new AboutCookies(request, response);
                if (isList.get(0).equals("-1")) {
                    out.println("未注册——即将帮您登录");
                    response.setHeader("refresh", "1;./chtml/regist.jsp");
                } else if (isList.get(0).equals("0")) {
                    String id = isList.get(2);
                    session = request.getSession();
                    session.setMaxInactiveInterval(100);//设置非活跃间隔时间
                    session.setAttribute("username", name);
                    session.setAttribute("id", id);
                    if (jima.equals("true")) {
                        Date date = new Date();
                        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
                        String[] keys = {"username", "id", "isLogin", "lastAccesss"};
                        String[] values = {name, id, "true", dateFormat.format(date)};
                        cookies.setCookies(keys, values);
                    }
//                        response.setHeader("refresh", "1;./");
                } else if (isList.get(0).equals("1")) {
                    out.println(isList.get(1));
                }
            } else {
                out.println("验证码错误");
                response.setHeader("refresh", "1;./chtml/login.jsp");
            }

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
