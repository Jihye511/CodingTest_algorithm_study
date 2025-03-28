package gold;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class B16234_인구이동 {
    static int N, L, R;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken()); 
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        
        // 땅 입력받기
        map = new int[N][N];
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()); 
            }
        }
        
        int days = 0;
        while(true) {
            boolean hasMoved = false;
            visited = new boolean[N][N]; // 방문 배열 초기화
            
            for(int i=0; i<N; i++) {
                for(int j=0; j<N; j++) {
                    if(!visited[i][j]) {
                        if(BFS(i, j)) {
                            hasMoved = true;
                        }
                    }
                }
            }
            
            if(!hasMoved) break; // 더 이상 인구 이동이 없으면 종료
            days++;
        }
        
        System.out.println(days);
    }
    
    public static boolean BFS(int i, int j) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        List<int[]> union = new ArrayList<>(); // 연합 국가들의 좌표를 저장
        
        queue.offer(new int[] {i, j});
        visited[i][j] = true;
        union.add(new int[] {i, j});
        
        int total = map[i][j]; // 연합 나라 총 인구수
        
        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0];
            int y = now[1];
            
            for(int k=0; k<4; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];
                
                // map을 벗어나지 않고 아직 방문하지 않은 국가일 때
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !visited[nx][ny]) {
                    int diff = Math.abs(map[x][y] - map[nx][ny]); // 인구 차이
                    
                    // 인구 차이가 L이상 R이하일 때
                    if(L <= diff && diff <= R) {
                        queue.offer(new int[] {nx, ny});
                        visited[nx][ny] = true;
                        union.add(new int[] {nx, ny});
                        total += map[nx][ny];
                    }
                }
            }
        }
        
        // 연합이 하나의 국가만 있는 경우 (인구 이동 없음)
        if(union.size() <= 1) {
            return false;
        }
        
        // 인구 이동
        int population = total / union.size();
        for(int[] pos : union) {
            map[pos[0]][pos[1]] = population;
        }
        
        return true;
    }
}