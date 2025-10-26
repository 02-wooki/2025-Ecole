package day1024;

import com.oracle.webservices.internal.api.message.DistributedPropertySet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }
    
    public Edge(String node, String weight) {
        this(Integer.parseInt(node), Integer.parseInt(weight));
    }
}

public class P1753 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int v = Integer.parseInt(st.nextToken()), e = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(in.readLine());
        Boolean[] visited = new Boolean[v + 1];

        int[] distance = new int[v + 1];
        for (int i = 0; i <= v; i++)
            distance[i] = i == k ? 0 : Integer.MAX_VALUE;

        ArrayList<Edge>[] a = new ArrayList[v + 1];
        for (int i = 0; i <= v; i++)
            a[i] = new ArrayList<>();

        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(in.readLine());
            a[Integer.parseInt(st.nextToken())].add(new Edge(st.nextToken(), st.nextToken()));
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(k);
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (visited[cur])
                continue;
            visited[cur] = true;

            for (Edge next: a[cur]) {
                if (distance[next.node] > distance[cur] + next.weight) {
                    distance[next.node] = next.weight + distance[cur];
                    q.add(next.node);
                }
            }
        }

        for (int i = 1; i <= v; i++) {
            if (visited[i])
                System.out.println(distance[i]);
            else
                System.out.println("INF");
        }
    }
}
