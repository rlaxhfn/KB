package ch18.sec11;

import java.io.File;

public class FileExample {
    public static void main(String[] args) throws Exception {
        File target=new File("/Users/gimhayeon/Documents/ITsYourLife/Temp/file1.txt");

        if(target.exists()){
            if(target.isFile()){
                System.out.println("파일 경로: "+target.getAbsolutePath());
                System.out.println("파일 크기: "+target.length()+"byte");
            } else if(target.isDirectory()){
                System.out.println("<dir> 파일 경로: "+target.getAbsolutePath());
            }
        } else {
            System.out.println("해당 파일은 없는 파일입니다.");
        }
    }
}
