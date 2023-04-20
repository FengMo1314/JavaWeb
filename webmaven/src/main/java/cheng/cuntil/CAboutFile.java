package cheng.cuntil;

public class CAboutFile {
    /**
     * 判断是否绝对路径
     * 当路径以 / 开头则为相对路径，否则视为绝对路径
     *
     * @param uploadDir
     * @return
     */
    public static boolean isAbsolutePath(String uploadDir) {
        boolean result = uploadDir.startsWith("/") || uploadDir.startsWith("./") || uploadDir.startsWith("../");
        //是相对路径
        return result;
    }

}
