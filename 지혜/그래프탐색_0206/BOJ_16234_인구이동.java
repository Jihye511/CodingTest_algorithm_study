package 그래프탐색_0206;


import javax.management.Query;
import java.io.*;
import java.util.*;
class Pair{
    int x;
    int y;
    public Pair(int x, int y){
        this.x = x;
        this.y= y;
    }
}
public class BOJ_16234_인구이동 {
    static int N,R,L;
    static int[][] map;
    static boolean[][] check;
    static int cnt=0;
    static int[] dx ={-1,1,0,0};
    static int[] dy ={0,0,-1,1};
    static ArrayList<Pair> unionXY = new ArrayList<>();
    static boolean isMove = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N =Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            isMove = false;
            check = new boolean[N][N];
            for(int i=0; i<N; i++){
                for(int j =0; j<N; j++){
                    if(!check[i][j]){
                        bfs(i,j);

                    }
                }
            }
            //만약 다 true가 없으면 break;
            if(!isMove) break;
            cnt++;
        }
        System.out.println(cnt);
    }
    public static void bfs(int x, int y) {
        Queue<Pair> q  = new LinkedList<>();
        check[x][y] = true;
        q.offer(new Pair(x,y));
        unionXY.add(new Pair(x,y));

        while (!q.isEmpty()){
            Pair p = q.poll();
            x = p.x;
            y = p.y;
            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                //범위확인
                if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                //차이 확인
                int cha = map[nx][ny] - map[x][y];
                if (L <= Math.abs(cha) && R >= Math.abs(cha) && !check[nx][ny]) {
                    isMove =true;
                    check[nx][ny] = true;
                    unionXY.add(new Pair(nx,ny));
                    q.offer(new Pair(nx,ny));
                }

            }
        }

        int sum =0;
        for(int i=0; i<unionXY.size(); i++){
            Pair p = unionXY.get(i);
            sum += map[p.x][p.y];
        }
        for(Pair p : unionXY){
            map[p.x][p.y] = sum/unionXY.size();
        }
        unionXY.removeAll(unionXY);
    }
}