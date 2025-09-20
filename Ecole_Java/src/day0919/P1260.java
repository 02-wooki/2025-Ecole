package day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class P1260 {
    static StringBuilder res;
    static LinkedList<Integer>[] graph;
    static boolean[] visited;
    static Queue<Integer> queue;

    static void dfs(int node) {
        visited[node] = true;
        res.append(node + 1).append(" ");
        for (int i : graph[node]) {
            if (!visited[i])
                dfs(i);
        }
    }

    static void bfs(int startNode) {
        visited[startNode] = true;
        res.append(startNode + 1).append(" ");
        queue.addAll(graph[startNode]);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            if (!visited[current]) {
                visited[current] = true;
                res.append(current + 1).append(" ");
                queue.addAll(graph[current]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] line = Arrays.stream(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = line[0], m = line[1], v = line[2] - 1;
        res = new StringBuilder();

        visited = new boolean[n];
        graph = new LinkedList[n];
        for (int i = 0; i < n; i++)
            graph[i] = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            line = Arrays.stream(br.readLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int u = line[0] - 1, w = line[1] - 1;

            graph[u].add(w);
            graph[w].add(u);
        }

        for (int i = 0; i < n; i++)
            graph[i].sort(Integer::compareTo);

        dfs(v);
        System.out.println(res);

        visited = new boolean[n];
        queue = new LinkedList<>();
        res = new StringBuilder();
        bfs(v);
        System.out.println(res);
    }
}
