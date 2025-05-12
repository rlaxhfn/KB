package ch18.sec04.exam01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriteExample {
    public static void main(String[] args) {
        try {
            Writer writer = new FileWriter("/Users/gimhayeon/Documents/ITsYourLife/Temp/test.txt");

            char a = 'A';
            char b = 'B';
            char[] arr = {'C', 'D', 'E'};

            writer.write(a);
            writer.write(b);
            writer.write(arr);

            writer.write("FGH");
            writer.flush();

            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
