package day1024;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class P2252 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(), m = in.nextInt();
        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            a.add(new ArrayList<>());

        int[] indegree = new int[n + 1];
        for (int i = 0; i < m; i++) {
            int s = in.nextInt(), e = in.nextInt();
            a.get(s).add(e);
            indegree[e]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        while (!q.isEmpty()) {
            int current = q.poll();
            System.out.print(current + " ");
            for (int i : a.get(current)) {
                indegree[i]--;
                if (indegree[i] == 0)
                    q.offer(i);
            }
        }
    }
}

