/**
 *
 */
package cheng.bean;


import until.AboutFile;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author LiuHe
 */
public class SQLBeanCheng {
    private String driver;
    private String url;
    private String username;
    private String password;


    public SQLBeanCheng(String Myproperties) {
        Properties properties = new Properties();
        Boolean isPath = AboutFile.isAbsolutePath(Myproperties);
        InputStream input = null;
        try {
            if (isPath) {//如果是相对路径
                input = this.getClass().getResourceAsStream(Myproperties);
            } else {//否则为绝对路径
                input = new FileInputStream(Myproperties);
            }
            properties.load(input);
            this.setDriver(properties.getProperty("driver"));
            this.setUrl(properties.getProperty("url"));
            this.setName(properties.getProperty("username"));
            this.setPass(properties.getProperty("password"));
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
            System.out.println("properties.load:输入流读取时发生错误_");
        } finally {
            try {
                input.close();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println(e + "关闭输入流出错——可能是路径错误，读取为空！");
//					throw new RuntimeException(e);
            }
            System.out.println("读取配置文件并连接了数据库！");
        }
    }

    public SQLBeanCheng(String driver, String url, String name, String pass) {
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
        return "SQLBean{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
