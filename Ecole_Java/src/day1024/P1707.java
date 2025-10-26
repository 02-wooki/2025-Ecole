package day1024;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1707 {

    static ArrayList<Integer>[] graph;
    static int[] colors;
    static boolean isBipartite;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList[v + 1];
            colors = new int[v + 1];
            for (int i = 1; i <= v; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int u1 = Integer.parseInt(st.nextToken());
                int u2 = Integer.parseInt(st.nextToken());
                graph[u1].add(u2);
                graph[u2].add(u1);
            }

            isBipartite = true;

            for (int i = 1; i <= v; i++) {
                if (colors[i] == 0) {
                    bfs(i);
                }
                if (!isBipartite) {
                    break;
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }
        System.out.print(sb);
    }

    static void bfs(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startNode);
        colors[startNode] = 1;

        while (!queue.isEmpty() && isBipartite) {
            int current = queue.poll();

            for (int neighbor : graph[current]) {
                if (colors[neighbor] == 0) {
                    colors[neighbor] = -colors[current];
                    queue.add(neighbor);
                } else if (colors[neighbor] == colors[current]) {
                    isBipartite = false;
                    return;
                }
            }
        }
    }
}