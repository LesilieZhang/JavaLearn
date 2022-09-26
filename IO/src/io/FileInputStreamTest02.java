package io;

import java.io.FileInputStream;
import java.io.IOException;


public class FileInputStreamTest02 {
    public static void main(String[] args) {
        FileInputStream file=null;
        try {
            file=new FileInputStream("D:\\JAVA\\temp.txt");
            //循环读
            int readData=0;
            while ((readData=file.read())!=-1){
                System.out.println(readData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
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
