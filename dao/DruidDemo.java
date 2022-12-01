package dao;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;

import com.alibaba.druid.pool.DruidDataSourceFactory;

/**
 * Druid数据库连接池演示
 */
public class DruidDemo {
    public boolean UserLogin(String uname,String upass) throws Exception {
        Connection con=getCon();
        //3. 定义sql
        String sql = "select * from userinfo where username='"+uname+"' and userpass='"+upass+"' "  ;

        //4. 获取statement对象
        Statement stmt = con.createStatement();

        //5. 执行sql
        ResultSet rs = stmt.executeQuery(sql);

        boolean hasUser=false;


        //6. 处理结果， 遍历rs中的所有数据
       // 6.1 光标向下移动一行，并且判断当前行是否有数据
        while (rs.next()){
            //6.2 获取数据  getXxx()
            int id = rs.getInt(1);
            String name = rs.getString(2);
            String pass = rs.getString(3);

            System.out.println(id);
            System.out.println(name);
            System.out.println(pass);

            System.out.println("--------------");
            hasUser=true;

        }
//        return uname.equals("Admin") && upass.equals("123456");
        return hasUser;
    }

    public Connection getCon() throws Exception {
        Properties prop = new Properties();
//        prop.load(new FileInputStream("D:\\Teach\\JavaWeb\\Code\\MeavenDemo03\\src\\main\\java\\com\\ccit\\dao\\druid.properties"));

        prop.load(new FileInputStream("D:/Teach/JavaWeb/Code/MeavenDemo03/src/main/java/com/ccit/dao/druid.properties"));


        //4. 获取连接池对象
        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
        System.out.println(prop.getProperty("username"));

        //5. 获取数据库连接 Connection
        Connection connection = dataSource.getConnection();

        //System.out.println(connection);
        return connection;
    }

//    public static void main(String[] args) throws Exception {
//        //1.导入jar包
//        //2.定义配置文件
//
//        //3. 加载配置文件
//        Properties prop = new Properties();
////        prop.load(new FileInputStream("D:\\Teach\\JavaWeb\\Code\\MeavenDemo03\\src\\main\\java\\com\\ccit\\dao\\druid.properties"));
//
//        prop.load(new FileInputStream("D:/Teach/JavaWeb/Code/MeavenDemo03/src/main/java/com/ccit/dao/druid.properties"));
//
//
//        //4. 获取连接池对象
//        DataSource dataSource = DruidDataSourceFactory.createDataSource(prop);
//        System.out.println(prop.getProperty("username"));
//
//        //5. 获取数据库连接 Connection
//        Connection connection = dataSource.getConnection();
//
//        System.out.println(connection);
//
//
//        //System.out.println(System.getProperty("user.dir"));
//    }
}
