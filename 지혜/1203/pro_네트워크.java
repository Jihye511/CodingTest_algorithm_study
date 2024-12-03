import java.io.*;
import java.util.*;

class Solution {
    static boolean[] visited;
    static int cnt=0;
    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n+1];
        for(int i =0; i<n; i++){
            if(!visited[i]){
                visited[i] =true;
                answer += bfs(i, computers, n);
            }
        }

        return answer;
    }
    public static int bfs(int node, int[][] computers, int n){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int i =0; i<n; i++){
                if(computers[cur][i]==1 && cur !=i){
                    if(!visited[i]){
                        visited[i] = true;
                        q.offer(i);
                    }
                }
            }
        }
        return 1;
    }
}
