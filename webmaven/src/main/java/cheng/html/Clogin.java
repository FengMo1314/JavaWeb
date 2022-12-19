package cheng.html;

import cheng.cuntil.AboutCookies;
import cheng.isTrue.CIsTrue;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Clogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CIsTrue cit = new CIsTrue();
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        String name = request.getParameter("username");
        String pass = request.getParameter("password");
        Cookie[] s=request.getCookies();
        System.out.println(s.toString());
        List<String> isList=cit.isLogin(name,pass);
        AboutCookies cookies=new AboutCookies(request,response);
        if(isList.get(0).equals("-1")){
            out.println(isList.get(1));
            response.setHeader("refresh", "1;./chtml/regist.jsp");
        } else if (isList.get(0).equals("0")) {
            out.println(isList.get(1));
            String id= isList.get(2);
            System.out.println(id);
            HttpSession session = request.getSession();
            session.setMaxInactiveInterval(100);//设置非活跃间隔时间
            session.setAttribute("username", name);
            session.setAttribute("id",id);
            Date date = new Date();
            SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd :hh:mm:ss");
            String[] keys={"username","id","isLogin","lastAccesss"};
            String[] values={name,id,"true",dateFormat.format(date)};
            cookies.setCookies(keys,values);
            response.setHeader("refresh", "1;./");
        }else if(isList.get(0).equals("1")){
            out.println(isList.get(1));
        }else{
            out.println("账户或者密码为空");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
      this.doGet(request,response);
    }
}
