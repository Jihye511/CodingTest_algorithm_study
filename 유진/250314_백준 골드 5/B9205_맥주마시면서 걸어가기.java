package gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
public class B9205_맥주마시면서걸어가기 {
    static int T, C, home_x, home_y, rock_x, rock_y;
    static int combi[][];
    static String answer;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        // 테스트케이스만큼 반복
        T = Integer.parseInt(br.readLine());
        for(int tc=1; tc<=T; tc++) {
            
            C = Integer.parseInt(br.readLine());  // 편의점 개수
            
            // 집 좌표
            StringTokenizer st = new StringTokenizer(br.readLine());
            home_x = Integer.parseInt(st.nextToken());
            home_y = Integer.parseInt(st.nextToken());
            
            // 편의점 좌표
            combi = new int[C][2];
            for(int i=0; i<C; i++) {
                st = new StringTokenizer(br.readLine());
                combi[i][0] = Integer.parseInt(st.nextToken());
                combi[i][1] = Integer.parseInt(st.nextToken());
            }
            
            // 페스티벌 좌표
            st = new StringTokenizer(br.readLine());
            rock_x = Integer.parseInt(st.nextToken());
            rock_y = Integer.parseInt(st.nextToken());
            
            visited = new boolean[C];
            answer = BFS(home_x, home_y);
            sb.append(answer).append("\n");
        }
        
        System.out.print(sb);
    }
    
    public static String BFS(int start_x, int start_y) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        
        queue.offer(new int[]{start_x, start_y});
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            
            int x = now[0];
            int y = now[1];
            
            // 현재 위치에서 페스티벌까지 갈 수 있는지 확인
            int fest_dist = Math.abs(x - rock_x) + Math.abs(y - rock_y);
            if(fest_dist <= 1000) {
                return "happy";
            }
            
            // 편의점 방문
            for(int k=0; k<C; k++) {
                if(visited[k]) continue; // 이미 방문한 편의점은 스킵
                
                int nx = combi[k][0];
                int ny = combi[k][1];
                
                // 현재 위치에서 편의점까지의 거리가 1000 이하인지 확인
                int store_dist = Math.abs(x - nx) + Math.abs(y - ny);
                if(store_dist <= 1000) {
                    queue.offer(new int[]{nx, ny});
                    visited[k] = true;
                }
            }
        }
        
        return "sad"; // 모든 가능한 경로를 탐색한 후에도 도착 못하면 sad
    }
}