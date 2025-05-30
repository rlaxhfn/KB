package ch18.sec06;

import java.io.*;

public class CharacterConvertStreamExample {
    public static void main(String[] args) throws Exception {
        write("문자 변환 스트림을 사용합니다.");
        String data = read();
        System.out.println(data);
    }

    public static void write(String str) throws Exception {
        OutputStream os = new FileOutputStream("/Users/gimhayeon/Documents/ITsYourLife/Temp/test.txt");
        Writer writer = new OutputStreamWriter(os, "UTF-8");
        writer.write(str);
        writer.flush();
        writer.close();
    }
    public static String read() throws Exception {
        InputStream is = new FileInputStream("/Users/gimhayeon/Documents/ITsYourLife/Temp/test.txt");
        Reader reader = new InputStreamReader(is, "UTF-8");
        char[] data = new char[1024];
        int num = reader.read(data);
        reader.close();
        return new String(data, 0, num);
    }
}
