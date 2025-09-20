package day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P2751 {
    public static int[] mergeSort(int[] arr, int left, int right) {
        if (left >= right)
            return new int[] {arr[left]};

        int mid = left + (right - left) / 2;
        int[] leftArr = mergeSort(arr, left, mid);
        int[] rightArr = mergeSort(arr, mid + 1, right);

        int[] sorted = new int[leftArr.length + rightArr.length];
        int i = 0, leftPointer = 0, rightPointer = 0;

        while (leftPointer < leftArr.length && rightPointer < rightArr.length) {
            if (leftArr[leftPointer] <= rightArr[rightPointer])
                sorted[i++] = leftArr[leftPointer++];
            else
                sorted[i++] = rightArr[rightPointer++];
        }
        while (leftPointer < leftArr.length)
            sorted[i++] = leftArr[leftPointer++];
        while (rightPointer < rightArr.length)
            sorted[i++] = rightArr[rightPointer++];

        return sorted;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        arr = mergeSort(arr, 0, n - 1);
        for (int i : arr)
            System.out.println(i);
    }
}
