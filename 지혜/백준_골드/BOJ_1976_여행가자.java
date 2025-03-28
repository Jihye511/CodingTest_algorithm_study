package bj;

import java.io.*;
import java.util.*;
public class BOJ_1976_여행가자 {
	static int N,M;
	static ArrayList<Integer>[] list;
	static int[][] map;
	static int [] num; //여행갈 도시
	static boolean[] v;

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine()); //도시 수
		M = Integer.parseInt(br.readLine()); //여행 계획 도시 수
		
		map = new int[N+1][N+1];
		num = new int[M];
		list = new ArrayList[N+1];
		
		v =new boolean[N+1];
		for(int i =1; i<=N; i++) {
			list[i] = new ArrayList<>();
		}
		for(int i =1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] ==1) {
					list[i].add(j);
					list[j].add(i);
				}
			}
		}			
		
		st =new StringTokenizer(br.readLine());
		for(int i =0; i<M; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		
		v[num[0]] = true;
		System.out.println(checkLink(num[0]));
	}
	public static String checkLink(int start) {
		Queue<Integer> q= new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int cur = q.poll();
			for(int i =0; i<list[cur].size();i++) {
				if(!v[list[cur].get(i)]) {
					v[list[cur].get(i)] = true;
					q.offer(list[cur].get(i));
				}
			}
		}
		for(int n: num) {
			//값들이 모두 방문이면 다 갈 수 있다는 뜻
			if(!v[n]) return "NO";
		}
		return "YES";
		
	}
}
