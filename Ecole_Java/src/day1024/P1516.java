package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1516 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(in.readLine());

        ArrayList<ArrayList<Integer>> a = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            a.add(new ArrayList<>());

        int[] indegree = new int[n + 1];
        int[] selfBuild = new int[n + 1];
        for (int i = 1; i <= n ; i++) {
            StringTokenizer s = new StringTokenizer(in.readLine());
            selfBuild[i] = Integer.parseInt(s.nextToken());
            while (true) {
                int x = Integer.parseInt(s.nextToken());
                if (x == -1)
                    break;
                a.get(x).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++)
            if (indegree[i] == 0)
                q.offer(i);

        int[] res = new int[n + 1];
        while(!q.isEmpty()) {
            int current = q.poll();
            for (int i : a.get(current)) {
                indegree[i]--;
                res[i] = Math.max(res[i], res[current] + selfBuild[current]);
                if (indegree[i] == 0)
                    q.offer(i);
            }
        }
        for (int i = 1; i <= n; i++)
            System.out.println(res[i] + selfBuild[i]);
    }
}
