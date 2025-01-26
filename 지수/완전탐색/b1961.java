package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class b1961 {
    private static int N;
    private static int[] S_arr;
    private static int[] B_arr;

    private static ArrayList<Integer> S_list;
    private static ArrayList<Integer> B_list;

    private static boolean[] visited;
    private static int min = Integer.MAX_VALUE;

    private static int S_sum;
    private static int B_sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S_arr = new int[N];
        B_arr = new int[N];

        S_list = new ArrayList<>();
        B_list = new ArrayList<>();

        visited = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            S_arr[i] = Integer.parseInt(st.nextToken());
            B_arr[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0);
        System.out.println(min);

    }

    private static void dfs(int cnt) {
        if (cnt == N) {
            return;
        }
        for (int i = 0; i < N; i++) {
            S_sum = 1;
            B_sum = 0;
            if (visited[i] == false) {
                S_list.add(S_arr[i]);
                B_list.add(B_arr[i]);
                visited[i] = true;

                for (int j = 0; j < S_list.size(); j++) {
                    S_sum *= S_list.get(j);
                    B_sum += B_list.get(j);
                }

                min = Math.min(min, Math.abs(S_sum - B_sum));
                dfs(cnt + 1);
                S_list.remove(S_list.size() - 1);
                B_list.remove(B_list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
