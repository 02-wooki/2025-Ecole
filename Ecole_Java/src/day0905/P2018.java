package day0905;

import java.util.Scanner;

public class P2018 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int count = 0;
        int sum = 1, left = 1, right = 1;
        while (right <= n) {
            if (sum == n) {
                count++;
                sum += ++right;
            } else if (sum < n)
                sum += ++right;
            else
                sum -= left++;
        }

        System.out.println(count);
    }
}
