package io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 1.文件字节输入流，任何类型的文件都可以采用这个流读
 * 2.字节的方式，完成输入的操作，完成读的操作（硬盘--->内存）
 */
public class FileInputStreamTest01 {
    public static void main(String[] args){
        //创建文件字节输入对象
        //文件路径：D:\JAVA：idea会自动把\编译成\\
        //写成/也是可以的
        FileInputStream file=null;
        try {
           file=new FileInputStream("D:\\JAVA\\temp.txt");
           //开始读
           int readData= file.read();
            System.out.println(readData);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //在finally语句块中关闭流，前提是流不为空，流是null没必要关闭：避免空指针异常
            if (file == null) {
                try {
                    file.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
