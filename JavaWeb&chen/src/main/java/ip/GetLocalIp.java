/**
 *
 */
package ip;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;

/**
 * @author LiuHe
 *
 */
public class GetLocalIp extends HttpServlet {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public static  String getLocalIp(HttpServletRequest request) {
		// TODO 自动生成的构造函数存根
		request.getLocalAddr();
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

}
