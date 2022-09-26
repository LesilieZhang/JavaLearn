package copy;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 使用输入输出流完成文件的拷贝
 * 拷贝的过程是一边读一边写
 * 使用以上的字节流拷贝文件的时候，文件类型随意，万能的，什么样的文件都能拷贝
 */
public class Test01 {
    public static void main(String[] args) throws IOException {
        FileInputStream file=null;
        FileOutputStream fos=null;
        try {
            //创建一个输入流对象
            file=new FileInputStream("D:\\JAVA\\test.txt");
            //创建一个输出流对象
            fos=new FileOutputStream("D:\\JAVA\\ACM\\test.txt");
            byte[] bytes=new byte[10*1024];//一次拷贝10kb
            int readCount=0;
            while ((readCount=file.read(bytes))!=-1){
                //读到多少就写多少
                fos.write(bytes,0,readCount);
            }
            //刷新
            fos.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //分开try
            try{
                if(fos!=null){
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (file != null) {
                    file.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

