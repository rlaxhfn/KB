package ch03;

public class TrapezoidArea {
    public static void main(String[] args) {
        int lengthTop = 5;
        int lengthBottom = 10;
        int height = 7;
        double area = (lengthTop + lengthBottom) * height / 2.0;
        System.out.println(area);
    }
}
