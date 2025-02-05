package 그래프탐색;

import java.io.*;
import java.util.*;

public class b7569 {
    static int M, N, H;
    static ArrayList<int[][]> box;
    static ArrayList<boolean[][]> visited;

    static int[] dx = {0, 0, 0, 0, -1, 1};
    static int[] dy = {0, 0, -1, 1, 0, 0};
    static int[] dz = {-1, 1, 0, 0, 0, 0};
    static int answer = 0;
    static Queue<int[]> queue;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());   // 가로
        N = Integer.parseInt(st.nextToken());   // 세로
        H = Integer.parseInt(st.nextToken());   // 높이(상자의 수)

        // 1. 입력받기
        box = new ArrayList<>();
        visited = new ArrayList<>();
        for (int h = 0; h < H; h++) {
            box.add(new int[N][M]);
            visited.add(new boolean[N][M]);
            for (int n = 0; n < N; n++) {
                st = new StringTokenizer(br.readLine());
                for (int m = 0; m < M; m++) {
                    box.get(h)[n][m] = Integer.parseInt(st.nextToken());
                }
            }
        }

        // 2. 구현
        // 안 익은 토마토가 있는지 검사
        boolean non_ripe = false;
        if (checkZero(non_ripe)) {
            queue = new LinkedList<>();
            for (int h = 0; h < H; h++) {
                for (int n = 0; n < N; n++) {
                    for (int m = 0; m < M; m++) {
                        if (box.get(h)[n][m] == 1) {
                            queue.offer(new int[]{h, n, m});
                        }
                    }
                }
            }
            bfs();

            // 안 익은 토마토가 있는지 검사
            boolean all_done = false;
            if (checkZero(all_done)) {
                answer = -1;
            }

        } else {
            answer = 0;
        }


        System.out.println(answer);
    }

    private static boolean checkZero(boolean flag) {
        for (int h = 0; h < H; h++) {
            for (int n = 0; n < N; n++) {
                for (int m = 0; m < M; m++) {
                    if (box.get(h)[n][m] == 0) {
                        flag = true;
                        return flag;
                    }
                }
            }
        }
        return flag;
    }
    private static void bfs() {
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            for (int p = 0; p < 6 ; p++) {
                int nz = now[0] + dz[p];
                int nx = now[1] + dx[p];
                int ny = now[2] + dy[p];

                if (nz < 0 || nx < 0 || ny < 0 || nz >= H || nx >= N || ny >= M) {
                    continue;
                }

                if (!visited.get(nz)[nx][ny] && box.get(nz)[nx][ny] == 0) {
                    visited.get(nz)[nx][ny] = true;
                    box.get(nz)[nx][ny] = box.get(now[0])[now[1]][now[2]] + 1;
                    answer = Math.max(answer,box.get(nz)[nx][ny]);
                    queue.offer(new int[]{nz, nx, ny});
                }

            }
        }
        answer -= 1;
    }



}

