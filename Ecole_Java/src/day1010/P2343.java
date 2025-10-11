package day1010;

import java.util.Arrays;
import java.util.Scanner;

public class P2343 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        int[] lessons = new int[n];
        int min = 0, max = 0;

        for (int i = 0; i < n; i++) {
            lessons[i] = in.nextInt();
            min = Math.max(min, lessons[i]);
            max += lessons[i];
        }

        while (min <= max) {
            int mid = min + (max - min) / 2;
            int sum = 0, count = 0;

            for (int i: lessons) {
                if (sum + i > mid) {
                    count++;
                    sum = 0;
                }
                sum += i;
            }

            if (sum > 0)
                count++;

            if (count > m)
                min = mid + 1;
            else
                max = mid - 1;
        }

        System.out.println(min);
    }
}

