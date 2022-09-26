package io;

import java.io.FileInputStream;
import java.io.IOException;

/**\
 * 一次最多读取b.length字节
 * 减少内存和硬盘交互
 */
public class Test03 {
    public static void main(String[] args) {
        FileInputStream file=null;
        try{
            file=new FileInputStream("tempfile");
            //采用byte数组一次读取多个字节。最多读取数组.length字节
            byte[] bytes=new byte[4];
            int readCount=file.read(bytes);//返回的是读取到的字节数量
            System.out.println("第一次读："+readCount+"个字节");//第一次读到4个字节
            System.out.println("第一次读："+new String(bytes,0,readCount));
            readCount=file.read(bytes);
            System.out.println("第二次读："+readCount+"个字节");
            System.out.println("第二次读："+new String(bytes,0,readCount));
            readCount=file.read(bytes);
            System.out.println("第三次读："+readCount+"个字节");
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (file != null) {
                try{
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
