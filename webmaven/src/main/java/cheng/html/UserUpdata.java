package cheng.html;

import com.alibaba.fastjson2.JSON;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserUpdata", value = "/userUpdata")
public class UserUpdata extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("ServletUpload doGet...");

        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();

        DiskFileItemFactory factory = new DiskFileItemFactory();

        File f = new File("D:\\MyProgrammingLanguagesWorkspace\\JavaWeb\\webmaven\\src\\main\\java\\cheng\\IMG");
        if (!f.exists()) {
            f.mkdir();
        }

        //设置文件的缓存路径
        factory.setRepository(f);
        System.out.println("f:" + f);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setHeaderEncoding("utf-8");
        String imgPath = "";
        try {
            List<FileItem> fileitems = upload.parseRequest(request);

            for (FileItem fileitem : fileitems) {
                if (!fileitem.isFormField()) {

                    String fieldName = fileitem.getFieldName();

                    String fileName = fileitem.getName();
                    boolean isInMemory = fileitem.isInMemory();
                    long sizeInBytes = fileitem.getSize();


                    System.out.println("fieldName:" + fieldName);
                    System.out.println("fileName:" + fileName);
                    System.out.println("isInMemory:" + isInMemory);
                    System.out.println("sizeInBytes:" + sizeInBytes);

                    // 写入文件
                    String filename = fileName.substring(fieldName.lastIndexOf("\\") + 1);
                    String webPath = "userUpdata/";
//                    filename= UUID.randomUUID().toString()+"_"+filename;  //避免同名
                    String filepath = getServletContext().getRealPath(webPath + filename);

                    System.out.println("/filepath:" + filepath);
                    File file = new File(filepath);

                    fileitem.write(file);

                    //删除临时文件
//                    fileitem.delete();

//                    out.println("<h2>文件上传成功&nbsp;<a href="+webPath+filename+">"+filename+"</a></h2>");
                    imgPath = webPath + filename;
//                    版权声明：本文为CSDN博主「促酒」的原创文章，遵循CC 4.0 BY-SA版权协议，转载请附上原文出处链接及本声明。
//                    原文链接：https://blog.csdn.net/qq_44275894/article/details/107781113
                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Map<String, Object> ismap = new HashMap<>();
        ismap.put("imgPath", imgPath);
        if (imgPath == "") {
            ismap.put("isPath", "false");
        } else {
            ismap.put("isPath", "true");
        }
        String jsonout = JSON.toJSONString(ismap);
        HttpSession session = request.getSession();
        session.setAttribute("imgPath", imgPath);
//            TableBeanCheng rtbc=new TableBeanCheng(name,pass,userimg);
        System.out.println(jsonout);
        out.write(jsonout);
        out.flush();
        out.close();

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        this.doGet(request, response);
    }
}
