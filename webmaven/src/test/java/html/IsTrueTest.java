package html;

import junit.framework.TestCase;

public class IsTrueTest extends TestCase {

    public void testIsRegist() {
        IsTrue it = new IsTrue();
        int i = it.isLogin("mm", "1234");
        System.out.println(i);
    }
}