package ch12.sec05;
import java.util.StringTokenizer;
public class StringTokenizerExample {
    public static void main(String[] args) {
        String data1 = "홍길동&이수홍,박연수";
        String[] arr = data1.split("&|,"); // split
        for (String s : arr) {
            System.out.println(s);
        }

        String data2 = "홍길동/이수홍/박연수";
        StringTokenizer st = new StringTokenizer(data2, "/"); // StringTokenizer
        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}
