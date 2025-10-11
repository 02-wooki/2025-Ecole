package day1010;

import java.util.Scanner;

public class P1541 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String[] strArr = in.nextLine().split("-");

        int ans = 0;
        for(String s : strArr[0].split("\\+"))
            ans += Integer.parseInt(s);

        for(int i = 1; i < strArr.length; i++) {
            for (String s : strArr[i].split("\\+"))
                ans -= Integer.parseInt(s);
        }

        System.out.println(ans);
    }
}

