package cheng.html;

import cheng.bean.TableBeanCheng;
import cheng.cuntil.HttpGetJson;
import cheng.isTrue.CIsTrue;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CregistAll", value = "/cregistAll")
public class CregistAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CIsTrue cit = new CIsTrue();
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        JSONObject data = HttpGetJson.getJson(request);
        if (data == null) {
            out.println("No:Yes?");
        } else {
            String userimgpath = (String) session.getAttribute("imgPath");
            String name = String.valueOf(data.get("username"));
            String pass = String.valueOf(data.get("password"));
            String isPath = String.valueOf(data.get("isPath"));
            System.out.println(name + ":" + pass);
            TableBeanCheng rtbc = new TableBeanCheng(name, pass, userimgpath);
            List isList = null;
            Map<String, Object> ismap = new HashMap<>();
            if (userimgpath == "" && isPath.equals("true")) {
                System.out.println(isPath);
                ismap.put("state", "err");
                ismap.put("mesg", "系统错误——没有获得图像地址,但是用户已提交");
            } else {
                isList = cit.isRegistAndAll(rtbc);
                if (isList.get(0).equals("-1")) {//注册成功
                    ismap.put("state", isList.get(0));
                    ismap.put("mesg", isList.get(1));
//            response.setHeader("refresh", "1;./chtml/login.jsp");
                } else if (isList.get(0).equals("0")) {//账户已注册,密码正确
//            out.println(isList.get(1));
                    ismap.put("state", isList.get(0));
                    ismap.put("mesg", isList.get(1));
                } else {//1: 账户已注册,但是密码错误
//            out.println(isList.get(1));
                    ismap.put("state", isList.get(0));
                    ismap.put("mesg", isList.get(1));
                }

            }
            response.setContentType("text/html; charset=UTF-8");
            response.setCharacterEncoding("UTF-8");
            String jsonout = JSON.toJSONString(ismap);
            out.write(jsonout);
            out.flush();
            out.close();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
