package copy;

import java.io.*;

public class CopyDir {
    public static void main(String[] args) {
        //拷贝源：E:\hk
        String originPath="E:\\hk";
        File srcFile = new File(originPath);
        //拷贝目标
        String ObjectPath="D:\\XML";
        File destFile = new File(ObjectPath);
        copyDir(srcFile, destFile);
    }
    /**
     * 拷贝目录
     *
     * @param srcFile  拷贝源
     * @param destFile 拷贝目标
     */
    private static void copyDir(File srcFile, File destFile) {
        if (srcFile.isFile()) {
            //是文件的话递归结束
            //是文件需要一边读一边写
            FileInputStream in = null;
            FileOutputStream out = null;
            try {
                //读这个文件
                //"E:\hk\推荐信\Letter of Recommendation.doc"
                in = new FileInputStream(srcFile);
                //写到这个文件
                //"D:\hk\推荐信\Letter of Recommendation.doc"
                //目标目录:新路径+\hk\推荐信
                String newsrcPath = srcFile.getAbsolutePath().substring(3);
               // System.out.println(newsrcPath);
                //目标路径
                String path = "";
                if (destFile.getAbsolutePath().endsWith("\\")) {
                    path = destFile.getAbsolutePath() + newsrcPath;
                } else {
                    path = destFile.getAbsolutePath() + "\\" + newsrcPath;
                }
                out = new FileOutputStream(path);
                //一边读一边写
                byte[] bytes = new byte[1024 * 1024];
                int readCount = 0;
                while ((readCount = in.read(bytes)) != -1) {
                    out.write(bytes, 0, readCount);

                }
                try {
                    out.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
            }
            return;
        }
        //获取源下面的子目录
        File[] files = srcFile.listFiles();//返回一个file数组
        for (File file : files) {
            //递归调用
            if (file.isDirectory()) {
                //新建对应的目录
                String srcDir = file.getAbsolutePath();//源目录
                //目标目录:新路径+\hk\推荐信
                String newsrcDir = srcDir.substring(3);
                //目标路径
                String destDir = "";
                if (destFile.getAbsolutePath().endsWith("\\")) {
                    destDir = destFile.getAbsolutePath() + newsrcDir;
                } else {
                    destDir = destFile.getAbsolutePath() + "\\" + newsrcDir;
                }
              File newFile=new File(destDir);
                if(!newFile.exists()){
                    newFile.mkdirs();//建多重目录
                }
            }
                copyDir(file, destFile);
            }
        }
    }

