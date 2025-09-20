package day0919;

import java.util.Scanner;

public class P11004 {

    public static void swap(int[] arr, int i1, int i2) {
        int tmp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = tmp;
    }

    public static int quickSort(int[] arr, int k, int left, int right) {
        if (right - left < 2)
            return k == left ?
                Math.min(arr[left], arr[right])
                : Math.max(arr[left], arr[right]);

        int mid = left + (right - left) / 2;
        swap(arr, left, mid);

        int i = left + 1, j = right;
        while (i <= j) {
            while (arr[left] < arr[j] && i <= j)
                j--;
            while (arr[left] > arr[i] && i <= j)
                i++;
            if (i <= j)
                swap(arr, i++, j--);
        }

        swap(arr, left, j);
        if (k == j)
            return arr[j];
        else if (k < j)
            return quickSort(arr, k, left, j - 1);
        else
            return quickSort(arr, k, j + 1, right);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), k = in.nextInt() - 1;
        int[] arr = new int[n];

        for (int i = 0; i < n; i++)
            arr[i] = in.nextInt();

        System.out.println(quickSort(arr, k, 0, n - 1));
    }
}
