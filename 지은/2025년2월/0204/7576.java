import java.util.*;
import java.io.*;

public class Main {
    static int[][] arr;
    static Deque<Node> tomatoes = new ArrayDeque<>();
    static int[] dx = {1,0,-1,0};
    static int[] dy = {0,1,0,-1};
    static int N,M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int v = Integer.parseInt(st.nextToken());
                arr[i][j] = v;
                if(v == 1) tomatoes.add(new Node(i,j));
            }
        }

        int result = -1; //이미 모두가 1인 상태에도 1번 더 반복하므로 -1해줘야함
        while(!tomatoes.isEmpty()) {
            operation(tomatoes.size());
            result++;
        }

        boolean check = true;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(arr[i][j] == 0) {
                    check = false;
                    break;
                }
            }
        }

        bw.write(check? String.valueOf(result) : "-1");
        bw.flush();
        bw.close();
    }

    static void operation(int n) {
        for(int i=0; i<n; i++) {
            Node node = tomatoes.removeFirst();
            for(int j=0; j<4; j++) {
                int x = node.r + dx[j];
                int y = node.c + dy[j];

                if(x>=0 && y>=0 && x<N && y<M) {
                    if(arr[x][y] == 0) {
                        arr[x][y]++;
                        tomatoes.add(new Node(x,y));
                    }
                }
            }
        }
    }
}

class Node {
    int r,c;

    public Node(int r, int c) {
        this.r = r;
        this.c = c;
    }
}