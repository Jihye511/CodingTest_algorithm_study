import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int mod = 1000000007;
        int[][] map = new int[n + 1][m + 1]; // n: 행(row), m: 열(column)

        // 물웅덩이 표시
        for (int[] puddle : puddles) {
            map[puddle[1]][puddle[0]] = -1; // y, x 순서
        }

        map[1][1] = 1; // 시작점 초기화

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (map[i][j] == -1) {
                    map[i][j] = 0; // 물웅덩이는 경로에 포함되지 않음
                    continue;
                }
                if (i > 1) map[i][j] += map[i - 1][j] % mod; // 위쪽에서 오는 경로
                if (j > 1) map[i][j] += map[i][j - 1] % mod; // 왼쪽에서 오는 경로
                map[i][j] %= mod; // 모듈러 연산
            }
        }

        return map[n][m];
    }
}
