/**
 *
 */
package index;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author LiuHe
 */
public class DBhelp {
    static SQLBean sqb;
    Statement stmt;
    Properties properties;
    ResultSet rs;
    Connection conn;

    public DBhelp(String Myproperties) {
        this.openSQL(Myproperties);
    }

    public DBhelp(String driver, String url, String name, String pass) {
        this.openSQL(driver, url, name, pass);
    }

    public static void main(String[] args) {
        DBhelp d = new DBhelp("/properties/MySql.properties");
//		DBhelp d2=new DBhelp("D:\\MyProgrammingLanguagesWorkspace\\JavaWeb\\JavaWeb&chen\\src\\main\\java\\index\\properties\\MySql.properties");
        d.select();
//		d2.select();
//		sqb=new SQLBean("D:\\MyProgrammingLanguagesWorkspace\\JavaWeb\\JavaWeb&chen\\src\\main\\java\\index\\properties\\MySql.properties");
        System.out.println(DBhelp.sqb.toString());
    }

    private void openSQL(String Myproperties) {
        sqb = new SQLBean(Myproperties);
        try {
            // 注册 JDBC 驱动
            Class.forName(sqb.getDriver());
            conn = DriverManager.getConnection(sqb.getUrl(), sqb.getName(), sqb.getPass());
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    private void openSQL(String driver, String url, String name, String pass) {
        sqb = new SQLBean(driver, url, name, pass);
        try {
            // 注册 JDBC 驱动
            Class.forName(sqb.getDriver());
            conn = DriverManager.getConnection(sqb.getUrl(), sqb.getName(), sqb.getPass());
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
    }

    public void select() {
        String sql = "SELECT * FROM mes";
        try {
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String username = rs.getString("username");
                String pass = rs.getString("password");
                // 输出数据
                String lis = "ID\tname\tpass\n" + id + "\t" + username + "\t" + pass;
                System.out.println(lis);
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }

    }

    public boolean insert() {
        return true;
    }

}
