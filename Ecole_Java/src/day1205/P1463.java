package day1205;

import java.util.Scanner;

public class P1463 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n =  in.nextInt();

        int[] d = new int[n + 1];
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0 && d[i / 2] < d[i])
                d[i] = d[i / 2] + 1;
            if (i % 3 == 0 && d[i / 3] < d[i])
                d[i] = d[i / 3] + 1;
        }

        System.out.println(d[n]);
    }
}
