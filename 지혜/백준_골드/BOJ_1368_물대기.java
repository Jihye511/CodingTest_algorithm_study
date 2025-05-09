import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] cost;
    static int[][] connect;
    static int[] dist;
    static boolean[] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        cost = new int[N+1];
        visited = new boolean[N + 1];
        int minidx = 1;
        int minV = Integer.MAX_VALUE;
        for(int i =1; i<=N; i++){
            cost[i] = Integer.parseInt(br.readLine());
            if(minV >cost[i]){
                minidx = i;
                minV = cost[i];
            }
        }

        connect = new int[N+1][N+1];
        for(int i =1; i<=N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =1; j<=N; j++){
                connect[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        for(int i =1; i<=N; i++){
            q.offer(new int[]{i,cost[i]});
        }
        int result = 0;
        int connected = 0;

        while(connected<N){
            int[] cur = q.poll();
            int node =cur[0];
            int c = cur[1];
            if (visited[node]) continue;
            visited[node] = true;
            result +=c;
            connected++;
            for(int i =1; i<=N; i++){
                if(!visited[i] && connect[node][i] < cost[i]){
                    cost[i] = connect[node][i];
                    q.offer(new int[]{i, cost[i]});
                }
            }
        }

        System.out.println(result);
    }

}
