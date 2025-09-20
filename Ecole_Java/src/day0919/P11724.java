package day0919;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class P11724 {

    static boolean[] visited;
    static ArrayList<Integer>[] edgeList;

    static void bfs(int node) {
        for (Integer i : edgeList[node]) {
            if (!visited[i]) {
                visited[i] = true;
                bfs(i);
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(line.split(" ")[0]);
        int m = Integer.parseInt(line.split(" ")[1]);

        edgeList = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++)
            edgeList[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            line = br.readLine();
            int u = Integer.parseInt(line.split(" ")[0]) - 1;
            int v = Integer.parseInt(line.split(" ")[1]) - 1;

            edgeList[u].add(v);
            edgeList[v].add(u);
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            bfs(i);
            count++;
        }

        System.out.println(count);
    }
}
