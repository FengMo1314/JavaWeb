package cheng.html;

import cheng.bean.TableBeanCheng;
import cheng.db.UserDao;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "Alluser", value = "/alluser")
public class Alluser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");//响应编码类型
        response.setContentType("text/json;charset=utf-8");
        UserDao ud = new UserDao();
        List<TableBeanCheng> tbcList = ud.selectAllTableMesgs();
        PrintWriter out = response.getWriter();
        String jsonout = JSON.toJSONString(tbcList);
        out.write(jsonout);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
