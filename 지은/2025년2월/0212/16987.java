import java.io.*;
import java.util.*;

public class Main {
    static int N, answer;
    static int[] durability, weight;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        durability = new int[N];
        weight = new int[N];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            durability[i] = Integer.parseInt(st.nextToken());
            weight[i] = Integer.parseInt(st.nextToken());
        }

        answer = 0;
        dfs(0, 0);

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    private static void dfs(int idx, int cnt) {
        if (idx == N) {
            answer = Math.max(cnt, answer);
            return;
        }

        if (durability[idx] <= 0 || cnt == N - 1) {
            dfs(idx + 1, cnt);
            return;
        }

        int tmp = cnt;
        for (int i = 0; i < N; i++) {
            if (i == idx || durability[i] <= 0) {
                continue;
            }

            durability[i] -= weight[idx];
            durability[idx] -= weight[i];

            if (durability[i] <= 0) {
                tmp++;
            }
            if (durability[idx] <= 0) {
                tmp++;
            }

            dfs(idx + 1, tmp);

            durability[i] += weight[idx];
            durability[idx] += weight[i];
            tmp = cnt;
        }
    }

}
