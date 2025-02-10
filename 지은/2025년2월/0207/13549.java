import java.util.*;
import java.io.*;

public class Main {
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        visit = new boolean[100001];
        
        bfs(N,K);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();
    }

    static void bfs(int n, int k) {
        Deque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(n,0));
        while(!queue.isEmpty()) {
            Node cur = queue.remove();
            visit[cur.x] = true;

            if(cur.x == k) min = Math.min(cur.time, min);

            if(cur.x * 2 <= 100000 && !visit[cur.x*2]) queue.add(new Node(cur.x*2,cur.time));
            if(cur.x - 1 >= 0 && !visit[cur.x-1]) queue.add(new Node(cur.x-1,cur.time+1));
            if(cur.x + 1 <= 100000 && !visit[cur.x+1]) queue.add(new Node(cur.x+1,cur.time+1));
        }
    }

    static class Node {
        int x;
        int time;

        public Node(int x, int time) {
            this.x = x;
            this.time = time;
        }
    }
}