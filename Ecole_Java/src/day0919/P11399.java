package day0919;

import java.util.Scanner;
import java.util.stream.Stream;

public class P11399 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        in.nextLine();
        int[] arr = Stream.of(in.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 1; i < arr.length; i++) {
            int position = i;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[i]) {
                    position = j;
                    break;
                }
            }

            int target = arr[i];
            for (int j = i; j > position; j--)
                arr[j] = arr[j - 1];
            arr[position] = target;
        }

        for (int i = 1; i < arr.length; i++)
            arr[i] += arr[i - 1];

        int sum = 0;
        for (int i : arr)
            sum += i;

        System.out.println(sum);
    }
}
