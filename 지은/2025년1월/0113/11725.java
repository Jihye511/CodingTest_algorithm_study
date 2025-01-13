import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] visited;
    static int[] result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n + 1];
        visited = new int[n + 1];
        result = new int[n + 1];
        for(int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for(int i = 0; i < n-1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        dfs(1);

        for(int i = 2; i <= n; i++) {
            sb.append(result[i]).append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }

    static void dfs(int i) {
        visited[i] = 1;
        for(int j : tree[i]) {
            if(visited[j] == 0) {
                result[j] = i;
                dfs(j);
            }
        }
    }
}
