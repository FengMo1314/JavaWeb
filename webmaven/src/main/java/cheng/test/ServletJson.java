package cheng.test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;


//import java.util.TreeMap;

//import com.alibaba.fastjson.JSONPath;


@WebServlet(name = "ServletJson", value = "/demojson")
public class ServletJson extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demojson doPost...");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demojson doGet...");
//
//        PrintWriter out = response.getWriter();
//
//        UserService userService=new UserService();
//        List<UserBean> users=new ArrayList<UserBean>();
//        try {
//            users=userService.UserGetAll();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        String strings= JSON.toJSONString(users);
//
//        response.setContentType("application/json");
//        out.println(strings);
//        out.flush();

        response.setContentType("text/json;charset=utf-8");
//        String numA = request.getParameter("numA");
//        String numB = request.getParameter("numB");
        String numA = "15";
        String numB = "20";
        Float fnumA = Float.parseFloat(numA);
        Float fnumB = Float.parseFloat(numB);
        Float sum, minus, multiply, divide;
        sum = fnumA + fnumB;
        minus = fnumA - fnumB;
        multiply = fnumA * fnumB;
        divide = fnumA / fnumB;
        DecimalFormat df = new DecimalFormat("#0.00");//取小数点后两位四舍五入
        String sminus = df.format(minus);
        String ssum = df.format(sum);
        String smultiply = df.format(multiply);
        String sdivide = df.format(divide);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("sum", ssum);
        map.put("minus", sminus);
        map.put("multiply", smultiply);
        map.put("divide", sdivide);
        System.out.println("MapTest:" + map);
        JSONObject json = JSONObject.parseObject(JSON.toJSONString(map));//把map转为json数据
        PrintWriter out = response.getWriter();
        out.write(json.toString());
        out.flush();
        out.close();
    }
}
