package cheng.html;

import cheng.cuntil.AboutCookies;
import cheng.cuntil.HttpGetJson;
import cheng.isTrue.CIsTrue;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Clogin extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        CIsTrue cit = new CIsTrue();
        JSONObject data = HttpGetJson.getJson(request);
        String name = String.valueOf(data.get("username"));
        String pass = String.valueOf(data.get("password"));
        String jima = String.valueOf(data.get("jima"));
        // 获取前台输入的验证码
        String code = String.valueOf(data.get("coodimg"));
        // 获取后台的验证码
        String scode = (String) session.getAttribute("scode");
        //
        Map<String, Object> ismap = new HashMap<>();
        List<String> isList = null;
        Cookie[] s = request.getCookies();
        if (code == "" || name == "" || pass == "") {//非空判断
            ismap.put("state", "No");
            ismap.put("mesg", "用户名或者密码和验证码不能为空");
        } else {
            if (code.equals(scode)) {//验证码对
                isList = cit.isLogin(name, pass);
                AboutCookies cookies = new AboutCookies(request, response);
                if (isList.get(0).equals("-1")) {
                    ismap.put("state", isList.get(0));
                    ismap.put("mesg", isList.get(1));
//                    response.setHeader("refresh", "1;./chtml/regist.jsp");
                } else if (isList.get(0).equals("0")) {
                    ismap.put("state", isList.get(0));
                    ismap.put("mesg", isList.get(1));
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
                    ismap.put("state", isList.get(0));
                    ismap.put("mesg", isList.get(1));
//                out.println(isList.get(1));
                }
            } else {
                ismap.put("state", "err");
                ismap.put("mesg", "验证码错误");
            }

        }
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        String jsonout = JSON.toJSONString(ismap);
        out.write(jsonout);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }
}

