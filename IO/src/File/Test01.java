package File;

import java.io.File;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) throws IOException {
        File f1=new File("E:\\ielts\\task1\\task1.ppt");
        //获取该文件的父路径
        String parentPath=f1.getParent();
        System.out.println(parentPath);

        //获取绝对路径
        String absolutePath=f1.getAbsolutePath();
        System.out.println(absolutePath);
    }
}
