import java.io.*;
import java.util.*;

public class Main {
    private static int[] di = {1, -1, 0, 0};
    private static int[] dj = {0, 0, 1, -1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        boolean[][] isEmpty = new boolean[n][m];

        for(int i = 0; i < n; i++) {
            char[] temp = br.readLine().toCharArray();

            for(int j = 0; j < m; j++) {
                if(temp[j] == '0') {
                    isEmpty[i][j] = true;
                }
            }
        }

        int min = bfs(isEmpty, n, m);

        System.out.println(min);
    }

    private static int bfs(boolean[][] isEmpty, int n, int m) {
        boolean[][] visited = new boolean[n][m];
        visited[0][0] = true;
        Deque<Point> deque = new ArrayDeque<Point>();
        deque.offer(new Point(0, 0, 0));

        while(!deque.isEmpty()) {
            Point poll = deque.poll();
            int i = poll.getI();
            int j = poll.getJ();
            int cnt = poll.getCnt();

            if(i == n - 1 && j == m - 1) {
                return cnt;
            }

            for(int k = 0; k < 4; k++) {
                int nextI = i + di[k];
                int nextJ = j + dj[k];

                if(nextI >= 0 && nextJ >= 0 && nextI < n && nextJ < m && !visited[nextI][nextJ]) {
                    visited[nextI][nextJ] = true;

                    if(isEmpty[nextI][nextJ]) {
                        deque.addFirst(new Point(nextI, nextJ, cnt));
                    } else {
                        deque.addLast(new Point(nextI, nextJ, cnt + 1));
                    }
                }
            }
        }

        return -1;
    }

    private static class Point {
        private int i;
        private int j;
        private int cnt;

        public Point(int i, int j, int cnt) {
            this.i = i;
            this.j = j;
            this.cnt = cnt;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        public int getCnt() {
            return cnt;
        }
    }
}
