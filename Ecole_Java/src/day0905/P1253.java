package day0905;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine())];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            int left = 0, right =  arr.length - 1;
            while (left < right) {
                if (left == i) {
                    left++;
                    continue;
                } else if (right == i) {
                    right--;
                    continue;
                }

                if (arr[left] + arr[right] < arr[i])
                    left++;
                else if (arr[left] + arr[right] > arr[i])
                    right--;
                else {
                    count++;
                    break;
                }
            }
        }

        System.out.println(count);
    }
}
