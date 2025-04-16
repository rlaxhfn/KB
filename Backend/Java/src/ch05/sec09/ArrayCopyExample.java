package ch05.sec09;

public class ArrayCopyExample {
    public static void main(String[] args) {
        String[] oldArray = {"Java", "array", "copy"};
        String[] newArray = new String[5];

        for (int i = 0; i < oldArray.length; i++) {
            newArray[i] = oldArray[i];
        }

        for (String s : newArray) {
            System.out.print(s+", ");
        }
    }
}
