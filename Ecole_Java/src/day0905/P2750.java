package day0905;

import java.util.Scanner;

public class P2750 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        boolean[] arr = new boolean[2001];
        while (n-- > 0)
            arr[in.nextInt() + 1000] = true;

        for (int i = 0; i < arr.length; i++)
            if (arr[i])
                System.out.println(i - 1000);
    }
}

