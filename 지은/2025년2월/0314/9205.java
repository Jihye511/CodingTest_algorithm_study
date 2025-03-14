import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static Node[] NodeArr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int i=0; i<T; i++) {
            N = Integer.parseInt(br.readLine());
            StringTokenizer st;
            NodeArr = new Node[N+2];
            for(int j=0; j<N+2; j++) {
                st = new StringTokenizer(br.readLine());
                NodeArr[j] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }
            sb.append(bfs(NodeArr[0])).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }

    static String bfs(Node node) {
        Deque<Node> queue = new LinkedList<>();
        visited = new boolean[N+2];
        queue.add(node);
        visited[0] = true;

        while(!queue.isEmpty()) {
            Node cur = queue.poll();
            if(cur.equals(NodeArr[NodeArr.length-1])) return "happy";
            for(int i=1; i<NodeArr.length; i++) {
                if(!visited[i] && distance(cur, NodeArr[i]) <= 1000) {
                    visited[i] = true;
                    queue.add(NodeArr[i]);
                }
            }

        }
        return "sad";
    }

    static int distance(Node a, Node b) {
        return Math.abs(a.x-b.x) + Math.abs(a.y-b.y);
    }
}

class Node {
    int x, y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}