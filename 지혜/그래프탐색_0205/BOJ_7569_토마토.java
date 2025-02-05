package 그래프탐색_0204;
import java.io.*;
import java.util.*;

public class BOJ_7569_토마토 {
	static int[][][] map;
	static int N,M,H;
	static boolean[][][] visited;
	static Queue<int[]> q= new LinkedList<>();
	static int[] dx= {-1,1,0,0,0,0};
	static int[] dy = {0,0,-1,1,0,0};
	static int[] dz = {0,0,0,0,-1,1};
	static int status;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[N][M][H];
		visited = new boolean [N][M][H];
		for(int h = 0; h<H; h++) {
			for(int i =0; i<N; i++) {
				st= new StringTokenizer(br.readLine());
				for(int j =0; j<M; j++) {
					map[i][j][h] = Integer.parseInt(st.nextToken());
					if(map[i][j][h] == 1) {
						q.offer(new int[] {i,j,h });
						visited[i][j][h] = true;
					}
				}
			}
		}
		//0이있는지 없는지 확인
		if(!checkZero()) {
			System.out.println(0);
			return;
		}
		int days = bfs();
		if(checkZero()) {
			status = -1;
		}else {
			status = days;
		}
		System.out.println(status);

	}
	public static boolean checkZero() {
		for(int h = 0; h<H; h++) {
			for(int i =0; i<N; i++) {
				for(int j =0; j<M; j++) {
					if(map[i][j][h] == 0) {
						return true;
					}
				}
			}
		}
		
		return false;
	}
	public static int bfs() {
		
		int days=0;
		while(!q.isEmpty()) {
			int size = q.size();
			for(int i =0; i<size; i++) {
				int[] cur = q.poll();
				for(int d =0; d<6; d++) {
					int nx = cur[0] + dx[d];
					int ny = cur[1] + dy[d];
					int nz = cur[2] + dz[d];
					
					if(nx<0 || nx>=N || ny<0 || ny>=M || nz <0 || nz>=H) continue;
					if(visited[nx][ny][nz]) continue;
					if(map[nx][ny][nz] == -1) continue;
					
					map[nx][ny][nz] =1;
					q.offer(new int[] {nx,ny,nz});
					visited[nx][ny][nz] = true;
				}
			}
			days++;
		}
		return days-1;
	}

}
