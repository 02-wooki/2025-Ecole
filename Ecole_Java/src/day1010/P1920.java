package day1010;

import java.util.Arrays;
import java.util.Scanner;

public class P1920 {
    static int  binarySearch(int[] arr, int target, int start, int end) {
        if (start > end)
            return 0;

        int mid = start + (end - start) / 2;

        if (arr[mid] == target)
            return 1;
        else if (arr[mid] < target)
            return binarySearch(arr, target, mid + 1, end);
        else
            return binarySearch(arr, target, start, mid - 1);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++)
            a[i] = in.nextInt();
        Arrays.sort(a);

        int m = in.nextInt();
        int[] x = new int[m];
        for (int i = 0; i < m; i++)
            x[i] = in.nextInt();

        for (int target : x)
            System.out.println(binarySearch(a, target, 0, a.length - 1));
    }
}

