package gold;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class B1976_여행가자 {
	
	static int N, M;
	static int[][] graph;
	static int[] plan;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());  // 도시의 수
		M = Integer.parseInt(br.readLine());  // 여행계획에 속한 도시의 수
	
		// 도시 연결 여부 입력받기 - 도시가 1부터이므로 1부터 N+1
		graph = new int[N+1][N+1];
		for(int i=1; i<N+1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<N+1; j++) {
				graph[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 여행계획 입력받기
		plan = new int[M];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++){
			plan[i] = Integer.parseInt(st.nextToken());
		}
		
		
		// 여행 가능 여부 확인
        boolean isPossible = true;
        
        // 여행 계획이 비어있거나 한 도시만 방문하는 경우는 항상 가능
        if(M <= 1) {
            System.out.println("YES");
            return;
        }
        
        // 첫 번째 도시부터 시작해서 나머지 도시들로 갈 수 있는지 확인
        for(int i=0; i<M-1; i++) {
            int start = plan[i];
            int end = plan[i+1];
            
            // 같은 도시인 경우 항상 이동 가능
            if(start == end) continue;
            
            // BFS로 start에서 end로 갈 수 있는지 확인
            visited = new boolean[N+1];
            if(!bfs(start, end)) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
    }

    public static boolean bfs(int start, int end) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while(!queue.isEmpty()) {
            int current = queue.poll();
            
            // 목적지에 도달했다면 true 반환
            if(current == end) {
                return true;
            }

            // 현재 도시에서 갈 수 있는 모든 도시 확인
            for(int i=1; i<=N; i++) {
                // 연결되어 있고 아직 방문하지 않은 도시라면
                if(graph[current][i] == 1 && !visited[i]) {
                    queue.offer(i);
                    visited[i] = true;
                }
            }
        }
        
        // 목적지에 도달하지 못했다면 false 반환
        return false;
    }
}






	        