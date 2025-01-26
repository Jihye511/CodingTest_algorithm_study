package 완전탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class b14620 {
    private static int N;
    private static int ans = Integer.MAX_VALUE;
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0);
        System.out.println(ans);
    }

    private static boolean checkVisit(int x, int y) {
        for (int i = 0; i < 4; i++) {
            if (visited[x + dx[i]][y + dy[i]]) {
                return false;
            }
        }
        return true;
    }

    private static int getCost(int x, int y) {
        int sum = map[x][y];
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            sum += map[x + dx[i]][y + dy[i]];
            visited[x+dx[i]][y+dy[i]] = true;
        }
        return sum;
    }

    private static void clearVisit(int x, int y) {
        for (int i = 0; i < 4; i++) {
            visited[x+dx[i]][y+dy[i]] = false;
        }
        visited[x][y] = false;
    }

    private static void dfs(int depth, int sum) {
        if (sum >= ans) {
            return;
        }

        if (depth == 3) {
            ans = Math.min(sum, ans);
        } else {
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < N - 1; j++) {
                    if (!visited[i][j] && checkVisit(i, j)) {
                        int cost = getCost(i, j);
                        dfs(depth + 1, sum + cost);
                        clearVisit(i, j);
                    }
                }
            }
        }
    }
}
