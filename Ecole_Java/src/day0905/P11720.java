package day0905;

import java.util.Scanner;

public class P11720 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.nextLine();
        String str = in.nextLine();

        int n = 0;
        for (int i = 0; i < str.length(); i++)
            n += str.charAt(i) - '0';

        System.out.println(n);
    }
}
