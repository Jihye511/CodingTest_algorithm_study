//메모리 : 299352kb, 시간:	648ms	

import java.io.*;
import java.util.*;
public class BOJ_16234_인구이동 {
	static int N,L,R;
	static int[][] map;
	static int [][] group;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st= new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map= new int[N][N]; //인구수 저장
		group = new int[N][N]; //그룹 넘버 저장
		
		for(int i= 0; i<N; i++) {
			st= new StringTokenizer(br.readLine());
			for(int j =0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int day=0;
		while(true) {
			//전체 탐색하면서 그룹핑하기
			int n=1;
			group = new int[N][N];
			for(int i= 0; i<N; i++) {
				for(int j =0; j<N; j++) {
					if(group[i][j]==0) {
						//n을 넣어서 같은 숫자는 같은 그룹으로 묶기
						grouping(i, j, n);
						n++;
					}
				}
			}
			if(n== N*N+1) {
				//국경선 아무데도 안열렸음
				break;
			}
			day++;
		}
		System.out.println(day);
	}

	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	//국경선 열린 거 확인
	public static void grouping(int x, int y,int n) {
		Queue<int[]> q = new LinkedList<>(); //인근 지역 탐색
		ArrayList<int[]> list = new ArrayList<>(); //그룹핑 된 국가 저장
		q.offer(new int[] {x,y});
		group[x][y] =n; //방문 체크
		int hap=0; //인구수 재분배하기위해 저장할 그룹핑 인구 수 합
		hap += map[x][y];
		list.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int i =0; i<4; i++) {
				int nx = cur[0] + dx[i];
				int ny = cur[1] + dy[i];
				
				if(nx<0 || nx>=N || ny<0 || ny>=N) continue;
				if(group[nx][ny] != 0) continue; // 이미 다른 그룹으로 묶임 
				
				//현재 국가 인구랑 다음 국가 인구 비교
				int now = map[cur[0]][cur[1]];
				int next =map[nx][ny]; 
				if(compared(now, next)) { //국경 열어서 같은 그룹으로 묶기
					group[nx][ny] = n;
					q.offer(new int[] {nx,ny});
					list.add(new int[] {nx,ny});
					hap += map[nx][ny];
				}
			}
		}
		//계산해서 map에 인구수 다시 넣기
		for(int[] point: list) {
			map[point[0]][point[1]] =(int)hap/list.size();
		}
	}
	
	//국경 열어도 되는 지 확인
	public static boolean compared(int cur, int next) {
		return (L<= Math.abs(cur-next)) && (Math.abs(cur-next)<=R);
	}

}
