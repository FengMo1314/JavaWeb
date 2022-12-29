package cheng.json;

import cheng.bean.Goods_info_Bean;
import cheng.cuntil.HttpGetJson;
import cheng.db.Goods_info_Dao;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson2.JSON;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class SomBygoods_nameJSON extends HttpServlet {
    @Override
//    @SuppressWarnings("rawtypes")
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//请求编码类型
        /**
         * 接收json
         //         */
        JSONObject data = HttpGetJson.getJson(request);
        String name = "柳和";
        if (data != null) {
            name = String.valueOf(data.get("names"));
            System.out.println(name);
        }
        response.setCharacterEncoding("UTF-8");//响应编码类型
        response.setContentType("text/json;charset=utf-8");
        PrintWriter out = response.getWriter();
        List<Goods_info_Bean> list = Goods_info_Dao.selectSomeByGoods_Name(name);
        String jsonout = JSON.toJSONString(list);
        out.write(jsonout);
        out.flush();
        out.close();
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        this.doGet(request, response);
    }
}
