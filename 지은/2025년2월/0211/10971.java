import java.io.*;
import java.util.*;


public class Main {
    static int N;
    static int[][] arr;
    static boolean[] visit;
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        arr = new int[N+1][N+1];
        visit = new boolean[N+1];
        for(int i =1; i<=N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,1,1);

        bw.write(String.valueOf(min));
        bw.flush();
        bw.close();

    }

    static void dfs(int d, int cur, int count) {
        if(count == N && arr[cur][1] > 0) { //마지막에서 1(처음)으로 가는 길이 있을 때만
            min = Math.min(min, d+arr[cur][1]);
        }
        for(int i = 2; i<=N; i++) { //1은 시작지점이므로 제외
            if(!visit[i] && arr[cur][i] > 0) {
                visit[i] = true;
                dfs(d + arr[cur][i], i, count + 1);
                visit[i] = false;
            }
        }
    }
}