package 그래프탐색;

import java.io.*;
import java.util.*;

public class b16234 {
    static int N, L, R;
    static int[][] map;
    static ArrayList<int[]> linkList;
    static boolean[][] visited;
    static boolean ismove;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int answer;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력받기
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        linkList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 구현
        move();
        // 출력
        System.out.println(answer);
    }

    public static void move() {

        while (true) {
            ismove = false;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j]) {
                        BFS(i,j);
                    }
                }
            }
            if (!ismove) {
                break;
            } else {
                answer++;
            }
        }
    }
    public static void BFS(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        visited[x][y] = true;
        linkList.add(new int[]{x, y});



        while (!queue.isEmpty()) {

            int now[] = queue.poll();
            x = now[0];
            y = now[1];
            for (int o = 0; o < 4; o++) {
                int nx = x + dx[o];
                int ny = y + dy[o];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
                    continue;
                }
                int sub = Math.abs(map[x][y] - map[nx][ny]);
                if (!visited[nx][ny] && sub >= L && sub <= R) {
                    ismove = true;
                    visited[nx][ny] = true;
                    linkList.add(new int[]{nx, ny});
                    queue.add(new int[]{nx, ny});
                }

            }
        }

        int sum = 0;
        for (int i = 0; i < linkList.size(); i++) {
            sum += map[linkList.get(i)[0]][linkList.get(i)[1]];
        }
        for (int i = 0; i < linkList.size(); i++) {
            map[linkList.get(i)[0]][linkList.get(i)[1]] = sum / linkList.size();
        }
        linkList.clear();

    }

}
