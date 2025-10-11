package day1010;

import java.util.Scanner;

public class P1929 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt(), n = in.nextInt();

        boolean[] che = new boolean[n + 1];
        che[1] = true;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (che[i])
                continue;

            for (int j = i + i; j <= n; j += i)
                che[j] = true;
        }

        for (int i = m; i <= n; i++)
            if (!che[i])
                System.out.println(i);
    }
}
