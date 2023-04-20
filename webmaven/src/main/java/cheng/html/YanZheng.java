package cheng.html;

import cheng.cuntil.Coodle;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "yanzheng", value = "/yanzheng")
public class YanZheng extends HttpServlet {
    private String coode;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        this.doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");//响应编码类型
        response.setContentType("text/json;charset=utf-8");
        ServletOutputStream out = response.getOutputStream();
        // 获取验证码
        String scode = Coodle.getCode();
        // 将验证码保存到session中，便于以后验证码
        HttpSession session = request.getSession();
//        session.setMaxInactiveInterval(10);
        session.setAttribute("scode", scode);
        // 发送图片
        ImageIO.write(Coodle.getCodeImg(scode), "jpg", response.getOutputStream());
    }
}
