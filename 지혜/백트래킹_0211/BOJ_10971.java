package 백트래킹_0211;
import java.io.*;
import java.util.*;
public class BOJ_10971 {
    static int N;
    static int[][] w;
    static boolean[]visited;
    static int minValue = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        w = new int[N][N];
        visited = new boolean[N];
        for(int i =0; i<N; i++){
            StringTokenizer st =new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                w[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i =0; i<N; i++){
            Arrays.fill(visited,false);
            visited[i] =true;
            dfs(i,i,0,1);

        }
        System.out.println(minValue);
    }
    public static void dfs(int home,int start, int hap,int cnt){
//        System.out.print(start);
        if(cnt==N ){
            if(w[start][home] !=0){
                minValue = Math.min(hap+w[start][home], minValue);

            }
            return;
        }

        for(int i =0; i<N; i++){
            if(!visited[i]&& w[start][i] !=0){
                visited[i] =true;
                dfs(home,i, hap+w[start][i],cnt+1);
                visited[i] = false;
            }
        }
    }
}
