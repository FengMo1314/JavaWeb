/**
 * 
 */
package index;

/**
 * @author LiuHe
 *
 */
public class SQLBean {
	private String driver;
	private String url;
	private String username;
	private String password;
	
	public SQLBean() {
		super();
    	
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
	

}
