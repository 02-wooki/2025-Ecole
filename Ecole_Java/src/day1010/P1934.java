package day1010;

import java.util.Scanner;

public class P1934 {
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        while (t-- > 0) {
            int a = in.nextInt(), b = in.nextInt();
            System.out.println(a * b / gcd(a, b));
        }
    }
}
