package 완전탐색_0127;
import java.io.*;
import java.util.*;

public class 백준_2961 {
    static int N;
    static long[][] ingredients;
    static long minTasty = Long.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ingredients = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            ingredients[i][0] = Integer.parseInt(st.nextToken()); // 신맛
            ingredients[i][1] = Integer.parseInt(st.nextToken()); // 쓴맛
        }

        dfs(0, 1, 0, false);
        System.out.println(minTasty);
    }

    public static void dfs(int idx, long sour, long bitter, boolean used) {
        if (idx == N) {
            if (used) { // 적어도 하나의 재료를 사용한 경우만 계산
                long diff = Math.abs(sour - bitter);
                minTasty = Math.min(minTasty, diff);
            }
            return;
        }

        // 현재 재료를 사용하는 경우
        dfs(idx + 1, sour * ingredients[idx][0], bitter + ingredients[idx][1], true);

        // 현재 재료를 사용하지 않는 경우
        dfs(idx + 1, sour, bitter, used);
    }
}
