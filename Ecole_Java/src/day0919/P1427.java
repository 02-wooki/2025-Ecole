package day0919;

import java.util.Scanner;

public class P1427 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        char[] arr = in.nextLine().toCharArray();

        for (int i = 0; i < arr.length - 1; i++) {
            char max = 0;
            int maxIndex = -1;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > max) {
                    max = arr[j];
                    maxIndex = j;
                }
            }

            char tmp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = tmp;
        }

        System.out.println(arr);
    }
}
