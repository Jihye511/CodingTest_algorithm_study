import java.io.*;
import java.util.*;
public class Main {
    static int N;
    static int[][] map;
    static int danji=0;
    static boolean[][] visited;
    static int[] dx = {-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        visited = new boolean[N][N];
        map = new int[N][N];
        for(int i=0; i<N; i++){
            String str =  br.readLine();
            for(int j =0; j<N; j++){
                map[i][j] = str.charAt(j)-'0';
            }
        }
        for(int i =0; i<N; i++){
            for(int j =0; j<N; j++) {
                if (map[i][j]==1 && !visited[i][j]){
                    danji+=1;
                    visited[i][j] = true;
                    list.add(bfs(i,j));
                }
            }
        }
        Collections.sort(list);
        System.out.println(danji);
        for(int v : list){
            System.out.println(v);
        }
    }
    public static int bfs(int x, int y){
        int cnt=1;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{x,y});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] +cur[0];
                int ny = dy[i] + cur[1];

                if(nx <0 || nx>=N || ny<0 || ny>=N) continue;
                if(visited[nx][ny] || map[nx][ny]==0) continue;

                cnt++;
                visited[nx][ny] = true;
                q.offer(new int[]{nx,ny});
            }
        }
        return cnt;
    }
}
