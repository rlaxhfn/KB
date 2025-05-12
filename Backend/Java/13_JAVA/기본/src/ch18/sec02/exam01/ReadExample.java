package ch18.sec02.exam01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class ReadExample {
    public static void main(String[] args) {
        try {
            InputStream is = new FileInputStream("/Users/gimhayeon/Documents/ITsYourLife/Temp/test1.db");

            while(true) {
                int data = is.read();

                if(data == -1) break;
                System.out.println(data);
            }

            is.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
