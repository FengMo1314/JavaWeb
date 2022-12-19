package exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuessControl
 */
public class GuessControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public GuessControl() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html; charset=UTF-8");
		// TODO 自动生成的方法存根
//			获取输入框中的数字（String->Integer）
		int webNb = Integer.parseInt(req.getParameter("guess"));
////			创建Session对象
//			HttpSession hs=req.getSession();
//			获取随机数
		int rNub = (Integer) req.getSession().getAttribute("nub");
		NumberBean nb = new NumberBean();
		NumberBean.setNum(rNub);
//	        获取返回码
		int index = nb.compare(webNb);
//			保存返回码
		req.getSession().setAttribute("index", index);
//			保存输入的数字
		req.getSession().setAttribute("webNb", webNb);
//			重新定向页面
		resp.sendRedirect("http://localhost:8080/MyWeb/MyApp/exception/guessResult.jsp");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	System.out.println("猜数字提交给了post");
	}

}
