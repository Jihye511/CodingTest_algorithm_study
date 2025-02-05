import java.util.*;
import java.io.*;

public class Main {
    static int N,M,H;
    static int[] dx = {1,0,-1,0,0,0};
    static int[] dy = {0,1,0,-1,0,0};
    static int[] dh = {0,0,0,0,1,-1};
    static int[][][] arr;
    static Deque<Node> nodes = new ArrayDeque<>();
    static int result = -1;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        arr = new int[H][N][M];
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                for(int k=0; k<M; k++) {
                    int v = Integer.parseInt(st.nextToken());
                    arr[i][j][k] = v;
                    nodes.add(new Node(i,j,k,0));
                }
            }
        }

        bfs();

        boolean check = true;
        for(int i=0; i<H; i++) {
            for(int j=0; j<N; j++) {
                for(int k=0; k<M; k++) {
                    if(arr[i][j][k] == 0) {
                        check = false;
                        break;
                    }
                }
            }
        }

        bw.write(check? String.valueOf(result) : "-1");
        bw.flush();
        bw.close();
    }

    static void bfs() {
        while(!nodes.isEmpty()) {
            Node node = nodes.removeFirst();
            for(int i=0; i<6; i++) {
                int c = node.c + dx[i];
                int r = node.r + dy[i];
                int h = node.h + dh[i];

                if(c>=0 && c<M && r>=0 && r<N && h>=0 && h<H) {
                    if(arr[h][r][c] == 0) {
                        arr[h][r][c]++;
                        nodes.add(new Node(h,r,c,node.day+1));
                    }
                }
            }
            result = Math.max(result, node.day);
        }
    }
}

class Node{
    int h, r, c, day;

    public Node(int h, int r, int c, int day) {
        this.h = h;
        this.r = r;
        this.c = c;
        this.day = day;
    }
}