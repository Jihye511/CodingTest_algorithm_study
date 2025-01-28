package 완전탐색_0128;
import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
public class 백준_15661 {
    static int N;
    static int[][] map;
    static int start, link, minDiff = Integer.MAX_VALUE;
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        boolean[] visited = new boolean[N];
        for(int i =0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j =0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        combi(0,visited);
        System.out.println(minDiff);
    }
    //팀 조합 찾기
    public static void combi(int idx, boolean[] visited){

        if(idx ==N){
            ArrayList<Integer> startTeam = new ArrayList<>();
            ArrayList<Integer> linkTeam = new ArrayList<>();
            //그팀의 능력치 계산해서 최소 차 구하기
            for(int i =0; i<N; i++){
                if(visited[i]){
                    startTeam.add(i);
                }else{
                    linkTeam.add(i);
                }
            }
            if(startTeam.isEmpty() || linkTeam.isEmpty()) return;
            int diff = Math.abs(dfs(startTeam) - dfs(linkTeam));
            minDiff = Math.min(minDiff, diff);
            return;
        }
        visited[idx] =true;
        combi(idx+1, visited );
        visited[idx] =false;
        combi(idx+1, visited);
    }
    public static int dfs(ArrayList<Integer> team){
        int sum =0;
        for(int i =0; i<team.size(); i++){
            for(int j = 0; j<team.size(); j++){
                if(i == j) continue;
                int x =team.get(i);
                int y = team.get(j);
                sum += map[x][y];
            }
        }
        return sum;
    }
}
