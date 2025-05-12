package ch18.sec11;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample2 {
    public static void main(String[] args) throws Exception {
        File dir = new File("src/Temp/images");

        if(!dir.exists()) dir.mkdirs();

        File temp = new File("src/Temp");
        File[] contents = temp.listFiles();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm");
        for(File f : contents) {
            System.out.printf("%-25s", sdf.format(new Date(f.lastModified())));
            if(f.isDirectory()) System.out.printf("%-10s%-20s", "<DIR>", f.getName());
            else System.out.printf("%-10s%-20s", f.length(), f.getName());
            System.out.println();
        }
    }
}
