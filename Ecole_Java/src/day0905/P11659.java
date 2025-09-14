package day0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P11659 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        String[] str = in.readLine().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);

        int[] arr = new int[n + 1];
        str = in.readLine().split(" ");

        for (int i = 1; i <= n; i++)
            arr[i] = Integer.parseInt(str[i - 1]) + arr[i - 1];

        while (m-- > 0) {
            str = in.readLine().split(" ");
            int left = Integer.parseInt(str[0]) - 1, right = Integer.parseInt(str[1]);

            System.out.println(arr[right] - arr[left]);
        }
    }
}
