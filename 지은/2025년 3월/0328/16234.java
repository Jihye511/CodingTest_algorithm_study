import java.util.*;
import java.io.*;

public class Main {
    static int N,L,R;
    static int[][] A;
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static Node[] completeA;
    static boolean[][] visited;
    static int res;
    static int count, cell;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        A = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        completeA = new Node[N*N]; //탐색 완료한 것들 저장
        boolean check = true;
        while(check) {
            check = false;
            visited = new boolean[N][N];

            for(int r=0; r<N; r++) {
                for(int c=0; c<N; c++) {
                    if(!visited[r][c]) { //하루가 안끝났고, 아직 들리지 않은 국가
                        count = 0; //연합의 인구수
                        cell = 0; //연합을 이루고 있는 칸의 개수

                        dfs(r,c);
                        
                        if(cell > 1) { //연합국이 2개 이상이면
                            int avg = count / cell;
                            for(int i=0; i<cell; i++) { //이번 연합에 해당하는 국가만
                                Node n = completeA[i];
                                A[n.y][n.x] = avg;
                            }
                            check = true;
                        }
                    }
                }
            } //하루 끝
            if(check) res++;
        }
        bw.write(String.valueOf(res));
        bw.flush();
        bw.close();
    }

    static void dfs(int y, int x) {
        visited[y][x] = true;
        count += A[y][x];
        completeA[cell] = new Node(x,y);
        cell++;

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx>=0 && ny >=0 && nx<N && ny<N) {
                if(!visited[ny][nx]) {
                    int d = Math.abs(A[y][x] - A[ny][nx]);
                    if(d >= L && d <= R) dfs(ny, nx);
                }
            }
        }
    }
}

class Node {
    int x,y;
    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
