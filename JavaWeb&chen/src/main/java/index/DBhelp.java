/**
 * 
 */
package index;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author LiuHe
 *
 */
public class DBhelp {
	Connection conn;
	Statement stmt;
	Properties properties;
	SQLBean sqb;
	ResultSet rs; 
	DBhelp(String Myproperties) {
		properties = new Properties();
		sqb = new SQLBean();
		try {
			InputStream input=sqb.getClass().getResourceAsStream(Myproperties);
//			InputStream input = new FileInputStream(Myproperties);
			properties.load(input);
			sqb.setDriver(properties.getProperty("driver"));
			sqb.setUrl(properties.getProperty("url"));
			sqb.setName(properties.getProperty("username"));
			sqb.setPass(properties.getProperty("password"));
			// 注册 JDBC 驱动
			Class.forName(sqb.getDriver());
			// 打开链接
			conn = DriverManager.getConnection(sqb.getUrl(), sqb.getName(), sqb.getPass());
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("1");
		} 
		catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("Path");
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("SQL");
		} finally {
//			System.out.println(properties.getProperty("driver"));
//			System.out.println(properties.getProperty("url"));
			System.out.println("读取配置文件并连接了数据库！");
		}
	}

	DBhelp(String driver, String url, String name, String pass) {
		sqb = new SQLBean(driver, url, name, pass);
		try {
			// 注册 JDBC 驱动
			Class.forName(sqb.getDriver());
			// 打开链接
			conn = DriverManager.getConnection(sqb.getUrl(), sqb.getName(), sqb.getPass());
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

	}
	public void select(){
		String sql="SELECT * FROM mes;";
		try {
			System.out.println(" 实例化Statement对象...");
	        stmt = conn.createStatement();
			rs= stmt.executeQuery(sql);
			// 展开结果集数据库
            while(rs.next()){
                // 通过字段检索
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                // 输出数据
                String lis="ID\tname\tage\n"+id+"\t"+name+"\t"+age;
                System.out.println(lis);
//                System.out.print("ID: " + id);
//                System.out.print(", " + name);
//                System.out.print(", 站点 age: " + age);
//                System.out.print("\n");
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
	public static void main(String[] args) {
		DBhelp d=new DBhelp("properties/MySql.properties");
//		DBhelp d=new DBhelp("D:\\MyProgrammingLanguagesWorkspace\\JavaWeb\\JavaWeb&chen\\src\\main\\java\\index\\properties\\MySql.properties");
		d.select();
	}

}
