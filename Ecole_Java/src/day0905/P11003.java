package day0905;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Tuple {
    int first;
    int second;

    public Tuple(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class P11003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), l = Integer.parseInt(st.nextToken());

        Deque<Tuple> queue = new ArrayDeque<>();
        st = new StringTokenizer(br.readLine());

        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Tuple t = new Tuple(i, Integer.parseInt(st.nextToken()));

            while (!queue.isEmpty() && queue.peekFirst().first <= t.first - l)
                queue.removeFirst();

            while (!queue.isEmpty() && queue.peekLast().second >= t.second)
                queue.removeLast();

            queue.addLast(t);
            ans.append(queue.peekFirst().second).append(" ");
        }

        System.out.println(ans);
    }
}
