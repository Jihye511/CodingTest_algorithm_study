import java.util.*;
import java.io.*;

public class Main {

    public static int N;
    public static int[][] map;
    public static int combinationNumber=0;
    public static boolean[] visited;
    public static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        visited = new boolean[N];

        for(int i=0; i< N;i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1; i<N;i++) {
            combinationNumber = i;
            simulate(0, 0);
        }
        bw.write(result);
        bw.flush();
        bw.close();
    }

    public static void simulate(int idx, int level) {
        if(level == combinationNumber) {
            int startTeam = 0;
            int linkTeam = 0;

            for(int i=0;i<N-1;i++) {
                for(int j=i+1;j<N;j++) {
                    if(visited[i] == true && visited[j] == true) {
                        startTeam += map[i][j] + map[j][i];
                    }
                    else if(visited[i] == false && visited[j] == false) {
                        linkTeam += map[i][j] +map[j][i];
                    }
                }
            }

            result = Math.min(result,  Math.abs(startTeam - linkTeam));
            return ;
        }

        for(int i=idx;i<N;i++) {
            if(visited[i] == true) continue;
            visited[i] = true;
            simulate(i + 1, level + 1);
            visited[i] = false;
        }
    }
}