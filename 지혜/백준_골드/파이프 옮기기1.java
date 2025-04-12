import java.io.*;
import java.util.*;
class Node{
    int x;
    int y;
    int dir;
    public Node(int x, int y, int dir){
        this.x = x;
        this.y = y;
        this.dir = dir;

    }
}
public class Main {
    static int N;
    static int[][] map;
    static int[] dx ={0,1,1};
    static int[] dy = {1,1,0};
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N+1][N+1];
        StringTokenizer st;
        for(int i =1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =1; j<=N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(map[N][N]==1){
            System.out.println(0);
            return;
        }
        System.out.println(bfs(1,2,0));


    }
    public static int bfs(int x, int y, int dir){
        int cnt=0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y,dir));
        while(!q.isEmpty()){
            Node cur = q.poll();
            if(cur.x ==N && cur.y ==N) {
                cnt+=1;
                continue;
            }
            for (int i = 0; i < 3; i++) {
                // 가로(0)일 때 세로(2) 이동 불가, 세로(2)일 때 가로(0) 이동 불가
                if ((cur.dir == 0 && i == 2) || (cur.dir == 2 && i == 0)) continue;

                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (!isValid(nx, ny, i)) continue; // 이동 가능한지 확인

                q.offer(new Node(nx, ny, i));
            }

        }
        return cnt;
    }
    public static boolean isValid(int x, int y, int dir) {
        if (x > N || y > N) return false;
        if (map[x][y] == 1) return false;

        // 대각선 이동 시 추가 검사 (대각선 이동은 벽이 세 칸 다 뚫려 있어야 함)
        if (dir == 1) {
            if(x-1<1 || y-1< 1) return false;
            if (map[x - 1][y] == 1 || map[x][y - 1] == 1) return false;
        }

        return true;
    }
}
