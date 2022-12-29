package cheng.test;

import cheng.bean.Goods_info_Bean;
import cheng.db.Goods_info_Dao;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class TJSON_userban extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/json;charset=utf-8");
        List<Goods_info_Bean> list = Goods_info_Dao.selectAll();
        PrintWriter out = response.getWriter();
        String json = JSON.toJSONString(list);
        out.write(json);
        out.flush();
        out.close();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
