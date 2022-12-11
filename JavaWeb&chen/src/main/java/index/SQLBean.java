/**
 *
 */
package index;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author LiuHe
 *
 */
public class SQLBean {
	private String driver;
	private String url;
	private String username;
	private String password;

//    Connection conn;
	public SQLBean(String Myproperties) {
		Properties properties = new Properties();
		try {
			InputStream input = this.getClass().getResourceAsStream(Myproperties);
//			InputStream inputs = new FileInputStream(Myproperties);
			properties.load(input);
//			properties.load(inputs);
			this.setDriver(properties.getProperty("driver"));
			this.setUrl(properties.getProperty("url"));
			this.setName(properties.getProperty("username"));
			this.setPass(properties.getProperty("password"));
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			System.out.println("properties.load:输入流读取时发生错误");
		} finally {
			System.out.println("读取配置文件并连接了数据库！");
		}
	}

	public SQLBean(String driver, String url, String name, String pass) {
		super();
		this.driver = driver;
		this.url = url;
		this.username = name;
		this.password = pass;
	}

	public String getDriver() {
		return driver;
	}

	public void setDriver(String driver) {
		this.driver = driver;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getName() {
		return username;
	}

	public void setName(String name) {
		this.username = name;
	}

	public String getPass() {
		return password;
	}

	public void setPass(String pass) {
		this.password = pass;
	}

	@Override
	public String toString() {
		// TODO 自动生成的方法存根
		return "{JDBC.driver:" + this.getDriver() + ",\nJDBC.url:" + this.getUrl() + ",\nJDBC.username:"
				+ this.getName() + ",\nJDBC.password:" + this.getPass() + "\n}";
	}

}
