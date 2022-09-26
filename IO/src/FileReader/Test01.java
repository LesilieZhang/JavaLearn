package FileReader;

import java.io.FileReader;

/**
 * 文件字符输入流，只能读取普通文本
 * 读取文本内容时，方便快捷
 */
public class Test01 {
    public static void main(String[] args) {
        FileReader reader=null;
        try{
            //创建文件字符输入流
            reader=new FileReader("tempfile");
            //准备一个char数组，往char数组中读
            char[] chars=new char[4];//一次读取4个字符
            reader.read(chars);//按照字符方式读取，第一次a，第二次b。。。
            for(char c:chars){
             System.out.println(c);
         }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
