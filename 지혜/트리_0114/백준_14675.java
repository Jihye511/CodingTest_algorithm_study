package 트리_0114;

import java.io.*;
import java.util.*;

public class 백준_14675 {
    static int n, q;
    static ArrayList<Integer>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            list[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }
        q = Integer.parseInt(br.readLine());
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int node = Integer.parseInt(st.nextToken());
            if (c == 1) {
                if (list[node].size() >= 2) sb.append("yes").append('\n');
                else {
                    sb.append("no").append('\n');
                }
            } else if (c == 2) {
                sb.append("yes").append('\n');
            }

        }
        System.out.println(sb.toString());
    }
}