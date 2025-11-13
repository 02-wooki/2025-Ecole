package day1107;

import java.util.ArrayList;
import java.util.Scanner;

public class P11725 {

    static int[] parents;
    static boolean[] visited;
    static ArrayList<Integer>[] edges;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        parents = new int[n];
        visited = new boolean[n];
        edges = new ArrayList[n];
        for (int i = 0; i < n; i++)
            edges[i] = new ArrayList<>();

        for (int i = 0; i < n - 1; i++) {
            int s = in.nextInt() - 1, e = in.nextInt() - 1;
            edges[s].add(e);
            edges[e].add(s);
        }

        dfs(0);
        for (int i = 1; i < visited.length; i++)
            System.out.println(parents[i] + 1);
    }

    static void dfs(int node) {
        visited[node] = true;
        for (int i: edges[node]) {
            if (!visited[i]) {
                parents[i] = node;
                dfs(i);
            }
        }
    }
}

