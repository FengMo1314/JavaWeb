/**
 *
 */
package exception;

/**
 * @author LiuHe
 *
 */
public class NumberBean {

	/**
	 *
	 */
	public static int num;

	public static int getNum() {
		return num;
	}

	public static void setNum(int num) {
		NumberBean.num = num;
	}

	public NumberBean() {
		// TODO 自动生成的构造函数存根
	}

	public int compare(int digit) {
		if (digit > num) {
			return 1;
		} else if (digit < num) {
			return -1;
		} else {
			return 0;
		}
	}
}
