package ch05.sec06;

public class ArrayCreateByNewExample {
    public static void main(String[] args) {
        int[] arr1 = new int[3];
        String[] arr2 = new String[3];

        for (int i = 0; i < arr1.length; i++) {
            System.out.print("arr1["+i+"]: "+arr1[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < arr2.length; i++) {
            System.out.print("arr2["+i+"]: "+arr2[i]+" ");
        }
    }
}
