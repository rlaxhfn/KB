package org.scoula.lib;

import java.util.Scanner;

public class Input {
    static Scanner sc = new Scanner(System.in);

    public static String read(String title) {
        System.out.print(title+": ");
        return sc.nextLine();
    }

    public static String read(String title, String defaultValue) {
        System.out.printf("%s(%s): ", title, defaultValue);
        String ans = sc.nextLine();

        return ans.isEmpty() ? defaultValue : ans;
    }

    public static int readInt(String title) {
        System.out.print(title+": ");
        int ans = sc.nextInt();
        sc.nextLine();
        return ans;
    }

    public static boolean confirm(String title, boolean defaultValue) {
        String def = defaultValue ? "(Y/n)" : "(y/N)";
        System.out.print(title+" "+def+": ");

        String ans = sc.nextLine();
        if (ans.isEmpty()) {
            return defaultValue;
        }

        return ans.equalsIgnoreCase("y");
    }

    public static boolean confirm(String title) {
        return confirm(title, true);
    }

}
