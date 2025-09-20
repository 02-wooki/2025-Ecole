package day0919;

import java.io.*;

public class P10989 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(in.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(in.readLine());

        in.close();

        // 기수 정렬
        int[] output = new int[arr.length];
        int digit = 1;
        while (digit <= 10000) {
            int[] q = new int[10];
            for (int i = 0; i < arr.length; i++)
                q[arr[i] / digit % 10]++;
            for (int i = 1; i < 10; i++)
                q[i] += q[i - 1];
            for (int i = arr.length - 1; i >= 0; i--) {
                output[q[arr[i] / digit % 10] - 1] = arr[i];
                q[arr[i] / digit % 10]--;
            }
            for (int i = 0; i < arr.length; i++)
                arr[i] = output[i];

            digit *= 10;
        }

        // 출력
        for (int i = 0; i < n; i++)
            out.write(arr[i] + "\n");

        out.close();
    }
}

