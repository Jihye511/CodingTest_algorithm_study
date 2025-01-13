package 트리_0113;

import java.io.*;
import java.util.*;

public class 백준_11725 {
    static ArrayList<Integer>[] list;
    static int n;
    static int[] result;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1]; //입력 값 저장
        result = new int[n+1];
        visited = new boolean[n+1];
        for(int i =0; i<n+1; i++){
            list[i] = new ArrayList<>();
        }
        for(int i =0; i<n-1; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        for (int i = 2; i <= n; i++) { // 2번 노드부터 출력
            System.out.println(result[i]);
        }
    }
    public static void dfs(int node) {
        visited[node] = true;

        for (int next : list[node]) {
            if (!visited[next]) { // 방문하지 않은 노드만 탐색
                result[next] = node; // 부모 노드 저장
                dfs(next);
            }
        }
    }
}
