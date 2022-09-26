package FileReader;

import java.io.FileWriter;
import java.io.IOException;

public class Test02 {
    public static void main(String[] args) {
        FileWriter out=null;
        try {
            //创建一个文件字符输出流对象
            out = new FileWriter("file",true);
            //开始写
            char[] chars={'我','爱','你'};
            out.write(chars);
            //写一部分
            out.write(chars,0,2);
            //刷新
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
