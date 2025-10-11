package day1010;

import java.util.PriorityQueue;
import java.util.Scanner;

public class P1715 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            q.add(in.nextInt());

        int sum = 0;
        while (q.size() > 1) {
            int i = q.remove() + q.remove();
            sum += i;
            q.add(i);
        }

        System.out.println(sum);
    }
}

