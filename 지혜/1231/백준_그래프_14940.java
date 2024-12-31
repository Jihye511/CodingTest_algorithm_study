import java.io.*;
import java.sql.PreparedStatement;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] dis;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        dis = new int[n][m];
        visited = new boolean[n][m];
        int x = 0;
        int y = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    map[i][j] = 0;
                    visited[i][j] =true;
                    x = i;
                    y = j;
                }
            }
        }
        bfs(x, y);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(!visited[i][j] &&map[i][j]==1){
                    sb.append(-1).append(" ");
                }else{
                    sb.append(map[i][j]).append(" ");
                }

            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void bfs(int x, int y) {
        map[x][y] =0;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int []{x,y});
        while (!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            for(int i =0; i<4; i++){
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx< 0 || nx>=n || ny<0 || ny>=m) continue;
                if(map[nx][ny]==0) continue;

                if(!visited[nx][ny]){
                    visited[nx][ny] =true;
                    map[nx][ny] = map[cx][cy]+1;
                    q.offer(new int[]{nx,ny});
                }
            }
        }
    }
}
