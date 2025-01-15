import java.util.*;
import java.io.*;

public class Main {
    static ArrayList<Integer>[] tree;
    static int[] visited;
    static int res = 0;
    static int remove = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tree = new ArrayList[n];
        visited = new int[n];
        for(int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        int root = -1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a == -1) root = i;
            else {
                tree[i].add(a);
                tree[a].add(i);
            }
        }

        remove = Integer.parseInt(br.readLine());
        if(remove == root) bw.write("0");
        else {
            dfs(root);
            bw.write(String.valueOf(res));
        }

        bw.flush();
        bw.close();

    }


    static void dfs(int i) {
        int check = 0;
        visited[i] = 1;
        for(int j : tree[i]) {
            if(visited[j] == 0 && j != remove) {
                dfs(j);
                check++;
            }
        }
        if(check == 0) res ++;
    }
}
