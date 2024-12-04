import java.io.*;
import java.util.*;
class Solution {
    static int[] dx ={-1,1,0,0};
    static int[] dy = {0,0,-1,1};
    public int solution(int[][] maps) {
        int answer = 0;
        int m = maps.length;
        int n = maps[0].length;
        bfs(maps);
        if(maps[m-1][n-1] ==1){
            return -1;
        }
        return maps[m-1][n-1];
    }
    public static void bfs(int[][]maps){
    
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[] {0,0});
        while(!q.isEmpty()){
            int[] cur = q.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            for(int i =0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy +dy[i];
                
                if(nx<0|| nx>=maps.length ||ny<0 || ny>=maps[0].length) continue;
                
                if(maps[nx][ny] !=1) continue;
                
                maps[nx][ny] +=maps[cx][cy];
                q.offer(new int[]{nx,ny});
                
            }
        }
    }
}
