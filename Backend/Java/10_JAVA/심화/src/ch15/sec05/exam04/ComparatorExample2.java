package ch15.sec05.exam04;

import java.util.Comparator;
import java.util.TreeSet;

public class ComparatorExample2 {
    public static void main(String[] args) {
        TreeSet<Fruit> treeSet = new TreeSet<Fruit>(new Comparator<Fruit>() {
           public int compare(Fruit f1, Fruit f2) {
               if(f1.price < f2.price) return -1;
               else if(f1.price == f2.price) return 0;
               else return 1;
           }
        });

        treeSet.add(new Fruit("포도", 3000));
        treeSet.add(new Fruit("수박", 10000));
        treeSet.add(new Fruit("딸기", 6000));

        for(Fruit fruit : treeSet) System.out.println(fruit.name+":"+fruit.price);
    }
}
