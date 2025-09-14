package day0905;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class P2164 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= n; i++)
            q.addLast(i);

        while (q.size() > 1) {
            q.poll();
            q.addLast(q.poll());
        }

        System.out.println(q.poll());
    }
}
