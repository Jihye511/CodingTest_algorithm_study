import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Random;
import java.util.StringTokenizer;

public class Main {
    static int N;
    static double[] percentage;
    static boolean[][] check; // 로봇방향 체크용...
    static int[] dr = new int[] { -1, 1, 0, 0 };
    static int[] dc = new int[] { 0, 0, -1, 1 };
    static double sum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        percentage = new double[4];
        check = new boolean[30][30];
        sum = 0;
        for (int i = 0; i < 4; i++) {
            percentage[i] = Integer.parseInt(st.nextToken()) * 0.01; // 확률

        }

        dfs(15, 15, 1, 0); // 중앙에서 시작할게, 움직이면 시작

        BigDecimal bigDecimal = new BigDecimal(sum);

        System.out.println(bigDecimal.toString());

    }

    public static void dfs(int r, int c, double percent, int cnt) {
        if (cnt == N) {
            sum += percent;
            return;
        }
        check[r][c] = true;
        for (int d = 0; d < 4; d++) {
            int nr = r + dr[d];
            int nc = c + dc[d]; // 여기서 이탈할일은 절대없다
            if (nr >= 0 && nr < 30 && nc >= 0 && nc < 30) { // 범위 내
                if (!check[nr][nc]) {// 방문한적 없으면.
                    check[nr][nc] = true;
                    dfs(nr, nc, percent * percentage[d], cnt + 1); // 한번 재실행~
                    check[nr][nc] = false;
                }
            }
        }

    }

}
