package day1010;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class P1931 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            a[i][0] = in.nextInt();
            a[i][1] = in.nextInt();
        }

        Arrays.sort(a, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1])
                    return o1[0] - o2[0];
                return o1[1] - o2[1];
            }
        });

        int count = 0, end = -1;
        for (int i = 0; i < n; i++) {
            if (a[i][0] >= end) {
                end = a[i][1];
                count++;
            }
        }

        System.out.println(count);
    }
}
