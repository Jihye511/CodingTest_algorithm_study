import java.io.*;
import java.util.*;
class Subin{
    int x;
    int time;
    public Subin(int x, int time){
        this.x=x;
        this.time=time;
    }
}
public class Main {
    static int N,K;
    static boolean[] visited = new boolean[100001];
    static int [] map = new int[100001];
    static int result = Integer.MAX_VALUE;
    static Subin subin;
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        bfs(N,0);
        System.out.println(result);
    }
    public static void bfs(int now,int time){

        Queue<Subin> q= new LinkedList<>();
        visited[now] = true;
        q.offer(new Subin(now,time));
        while (!q.isEmpty()){
            Subin current = q.poll();
            visited[current.x] =true;
            if(current.x == K){
                result = Math.min(result, current.time);
            }
            if(current.x*2 <=100000 && !visited[current.x*2]){
                q.offer(new Subin(current.x*2, current.time));
            }
            if(current.x-1 >=0 && !visited[current.x-1]){
                q.offer(new Subin(current.x-1, current.time+1));
            }
            if(current.x+1 <=100000 && !visited[current.x+1]){
                q.offer(new Subin(current.x+1, current.time+1));
            }
        }
    }
}
