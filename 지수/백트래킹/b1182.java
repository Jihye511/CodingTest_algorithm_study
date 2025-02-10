import java.io.*;
import java.util.*;

public class b1182 {
    static int N, S, result = 0;
    static int[] subsequence;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken()); // 정수의 개수
        S = Integer.parseInt(st.nextToken()); // 타깃 넘버
        subsequence = new int[N];

        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            subsequence[i] = Integer.parseInt(st.nextToken());
        }

        dfs(0, 0);


        if (S == 0) { // S가 0일 때 result--
            result--;
        }
        System.out.println(result);


        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(int depth, int sum) {
        if (depth == N) { // depth 가 마지막까지 갔을 경우
            if (sum == S) { // 그 중에 sum 이 타깃 넘버일 경우
                result++;
            }
            return;
        }
        dfs(depth + 1, sum + subsequence[depth]); // 원소를 선택했을 경우의 수열의 합
        dfs(depth + 1, sum); // 원소를 선택하지 않았을 경우의 수열의 합
    }
}
