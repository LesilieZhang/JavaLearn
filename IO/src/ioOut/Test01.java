package ioOut;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Test01 {
    public static void main(String[] args) {
        FileOutputStream fos = null;
        try {
            //以追加的方式在文件末尾写入，不会清空源文件内容
            fos=new FileOutputStream("myfile",true);
            //开始写
            byte[] bytes={97,98,99,100};
            fos.write(bytes);//将文件全部写出
            fos.write(bytes,0,2);//将文件部分写出
            String s="Let bygones be bygones";
            byte[] b=s.getBytes();//转成byte数组
            fos.write(b);
            //写完刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
