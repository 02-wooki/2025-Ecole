package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P18352 {
    static ArrayList<Integer>[] graph;
    static int[] visited;

    static void bfs(int head) {
        Queue<Integer> q = new LinkedList<>();
        q.add(head);
        visited[head]++;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int i : graph[current]) {
                if (visited[i] == -1) {
                    visited[i] = visited[current] + 1;
                    q.add(i);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(in.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = line[0], m = line[1], k = line[2], x = line[3] - 1;
        graph = new ArrayList[n];
        visited = new int[n];
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            line = Arrays.stream(in.readLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            graph[line[0] - 1].add(line[1] - 1);
        }
        for (int i = 0; i < n; i++)
            visited[i] = -1;

        bfs(x);

        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == k)
                ans.add(i + 1);
        }
        if (ans.isEmpty())
            System.out.println("-1");
        else {
            Collections.sort(ans);
            for (int i : ans)
                System.out.println(i);
        }
    }
}
