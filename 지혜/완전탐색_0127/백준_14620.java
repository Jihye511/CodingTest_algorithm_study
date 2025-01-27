package 완전탐색_0127;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_14620 {
    static int N;
    static int[][] map;
    static int minPrice=Integer.MAX_VALUE;
    static boolean[][] visited;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        StringTokenizer st;
        for(int i =0; i<N; i++){
            st  = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0,0);
        System.out.println(minPrice);
    }
    public static  void dfs(int depth, int price){
        if(depth ==3){
            minPrice = Math.min(price,minPrice);
            return;
        }
        for(int i =1; i<N-1; i++){
            for(int j =1; j<N-1; j++){
                if(!visited[i][j] &&!visited[i-1][j] && !visited[i+1][j] && !visited[i][j+1] && !visited[i][j-1]){
                    visited[i][j] =true;
                    visited[i-1][j] =true;
                    visited[i+1][j] = true;
                    visited[i][j+1] = true;
                    visited[i][j-1] =true;
                    dfs(depth+1, price + map[i][j]+ map[i-1][j] + map[i+1][j] + map[i][j-1] + map[i][j+1]);
                    visited[i][j] =false;
                    visited[i-1][j] =false;
                    visited[i+1][j] = false;
                    visited[i][j+1] = false;
                    visited[i][j-1] =false;
                }
            }
        }
    }
}
