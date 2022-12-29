package cheng.cuntil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PropertiesPaths {
    private static final List<String> relatively = new ArrayList<>();
    private static final List<String> absolute = new ArrayList<>();
//    public static void main(String[] args) {
//        //这是需要获取的文件夹路径
//        String path = "D:\\MyProgrammingLanguagesWorkspace\\JavaWeb\\webmaven\\src\\main\\resources";
//
//       List<String> l=getFileRelativelyPath(path,1);
//          for(String s:l){
//              System.out.println(s);
//          }
//          System.out.println("-----------------------");
//        for (String s:getFileAbsolutePath(path,1)
//             ) {
//            System.out.println(s);
//        }
//    }

    /*
     * 函数名：getFile
     * 作用：使用递归，输出指定文件夹内的所有文件
     * 参数：path：文件夹路径   deep：表示文件的层次深度，控制前置空格的个数
     * 前置空格缩进，显示文件层次结构
     */
    public List<String> getFileRelativelyPath(String path, int deep) {

        // 获得指定文件对象
        File file = new File(path);
        // 获得该文件夹内的所有文件
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile())//如果是文件
            {
                for (int j = 0; j < deep; j++)//输出前置空格
//                    System.out.print(" ");
                    relatively.add(array[i].getName());
                // 只输出文件名字
                System.out.println("读取sql配置文件名字：" + array[i].getName());
                // 输出当前文件的完整路径
                // System.out.println("#####" + array[i]);
                // 同样输出当前文件的完整路径   大家可以去掉注释 测试一下
                // System.out.println(array[i].getPath());
            } else if (array[i].isDirectory())//如果是文件夹
            {
                for (int j = 0; j < deep; j++)//输出前置空格
//                    System.out.print(" ");

//                System.out.println( array[i].getName());
                    //System.out.println(array[i].getPath());
                    //文件夹需要调用递归 ，深度+1
                    getFileRelativelyPath(array[i].getPath(), deep + 1);
            }
        }
        return relatively;
    }

    public List<String> getFileAbsolutePath(String path, int deep) {
        // 获得指定文件对象
        File file = new File(path);
        // 获得该文件夹内的所有文件
        File[] array = file.listFiles();

        for (int i = 0; i < array.length; i++) {
            if (array[i].isFile())//如果是文件
            {
                for (int j = 0; j < deep; j++)//输出前置空格
//                    System.out.print(" ");
//                    relatively.add(array[i].getName());
                    // 只输出文件名字
//                System.out.println( array[i].getName());
                    // 输出当前文件的完整路径
                    // System.out.println("#####" + array[i]);
                    // 同样输出当前文件的完整路径   大家可以去掉注释 测试一下
                    System.out.println("读取SQL配置绝对路径：" + array[i].getPath());
                absolute.add(array[i].getPath());
            } else if (array[i].isDirectory())//如果是文件夹
            {
                for (int j = 0; j < deep; j++)//输出前置空格
//                    System.out.print(" ");
//                System.out.println( array[i].getName());
                    //System.out.println(array[i].getPath());
                    //文件夹需要调用递归 ，深度+1
                    getFileAbsolutePath(array[i].getPath(), deep + 1);
            }
        }
        return absolute;
    }
}
