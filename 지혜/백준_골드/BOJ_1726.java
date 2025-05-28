import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int goal[];
    static int map[][];
    static int dx[], dy[];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        //동서남북 = 오왼밑위
        dx = new int[] {0, 0, 1, -1};
        dy = new int[] {1, -1, 0, 0};
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N+2][M+2];
        for(int i=1;i<=N;i++) {
            map[i][0] = 1;
            map[i][M+1] = 1;
            st = new StringTokenizer(br.readLine());
            for(int j=1;j<=M;j++) {
                if(st.nextToken().charAt(0)=='1')
                    map[i][j] = 1;
                else
                    map[i][j] = Integer.MIN_VALUE;
            }
        }
        //벽세우기
        //가로
        for(int i=0; i<M+2; i++) {
            map[0][i] = 1;
            map[N+1][i] = 1;
        }

        //현재 로봇의 위치와 방향
        st = new StringTokenizer(br.readLine());
        int robot[] = new int[3];
        robot[0] = Integer.parseInt(st.nextToken());
        robot[1] = Integer.parseInt(st.nextToken());
        robot[2] = Integer.parseInt(st.nextToken());
        //도착지점 로봇의 위치와 방향
        goal = new int[3];
        st = new StringTokenizer(br.readLine());
        goal[0] = Integer.parseInt(st.nextToken());
        goal[1] = Integer.parseInt(st.nextToken());
        goal[2] = Integer.parseInt(st.nextToken());

        dfs(robot[0], robot[1], robot[2], 0, 3);//이동 거리, 한번에 직진한 거리

        System.out.println(-map[goal[0]][goal[1]]);
    }
    //회전 횟수 반환
    public static int getTurn(int from, int to) {
        int dxy[] = {1, 3, 2, 4};//동서남북 => 시계방향과 매칭
        int dir = Math.abs(dxy[from]-dxy[to]);
        if(dir==3) dir=1;
        return dir;
    }

    public static void dfs(int x, int y, int d, int distance, int jump) {

        if(x == goal[0] && y == goal[1]) {
            map[x][y] = Math.max(map[x][y], distance-getTurn(d-1, goal[2]-1));
            return;
        }

        if(map[x][y] < distance) {
            map[x][y] = distance;
        }
        else
            return;

        for(int j=0; j<4; j++) {//4방향
            if(d==j+1 && jump!=3) {
                continue;
            }
            else {
                //방향 전환
                int dir = getTurn(d-1, j);
                //1칸, 2칸, 3칸 전진
                for(int k=1;k<=3;k++) {
                    int nx = x+k*dx[j];
                    int ny = y+k*dy[j];
                    if(map[nx][ny]==1) break;
                    dfs(nx, ny, j+1, map[x][y]-dir-1, k);
                }
            }
        }

    }


}
