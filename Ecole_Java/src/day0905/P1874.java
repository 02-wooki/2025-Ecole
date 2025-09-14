package day0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class P1874 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int now = 1, n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();

        while (n-- > 0) {
            int t = Integer.parseInt(br.readLine());
            while (now <= t) {
                stack.push(now++);
                sb.append("+\n");
            }

            if (stack.pop() == t)
                sb.append("-\n");
            else {
                System.out.println("NO");
                return;
            }
        }
        System.out.println(sb.toString());
    }
}

