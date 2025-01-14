package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1068 {
    private static ArrayList<Integer>[] graph;
    private static boolean[] visited;
    private static int N, delete, ans = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        int root = -1;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent == -1) {
                root = i;
                continue;
            }
            int child = i;
            graph[child].add(parent);
            graph[parent].add(child);
        }

        st = new StringTokenizer(br.readLine());
        delete = Integer.parseInt(st.nextToken());

        // root 노트를 삭제하면 ans = 0
        if (delete == root) {
            System.out.println(ans);
            return;
        }
        dfs(root);
        System.out.println(ans);
    }

    private static void dfs(int node) {
        visited[node] = true;
        int cnt = 0;
        for (int current : graph[node]) {
            if (current != delete && !visited[current]) {
                cnt++;
                dfs(current);
            }
        }

        // 자식 노드가 0개이면 리프노드이다.
        if (cnt == 0) {
            ans++;
        }
    }
}
