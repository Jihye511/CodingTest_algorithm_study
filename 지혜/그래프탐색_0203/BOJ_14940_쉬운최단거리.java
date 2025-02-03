package 그래프탐색_0203;
import java.util.*;
import java.io.*;
public class BOJ_14940_쉬운최단거리 {
    static int n,m;
    static int[][] map;
    static int x;
    static int y;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static boolean[][] visited;
    static int[][] arr;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        arr = new int[n][m];
        for(int i =0; i<n; i++){
            Arrays.fill(arr[i],-1);
        }

        for(int i =0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0; j<m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2 ){
                    x = i;
                    y = j;
                }
                if(map[i][j] ==0) arr[i][j]=0;
            }
        }
        arr[x][y] =0;
        visited[x][y] =true;
        bfs(x,y);
        for(int[] r : arr){
            for(int v : r){
                sb.append(v).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);

    }
    public static void bfs(int r, int c){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{r,c});
        while(!q.isEmpty()){
            int[] cur = q.poll();

            for(int i =0; i<4; i++){
                int nx = cur[0]+ dx[i];
                int ny = cur[1] + dy[i];
                if(nx<0 || nx>= n || ny<0 || ny>=m) continue;
                if(visited[nx][ny]) continue;
                if(map[nx][ny] ==0) continue;

                visited[nx][ny] =true;
                arr[nx][ny] = arr[cur[0]][cur[1]]+1;

                q.offer(new int[] {nx,ny});
            }
        }


    }
}
