import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] dura;
	static int[] weight;
	static int max = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		dura = new int[N];
		weight = new int[N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			dura[i] = Integer.parseInt(st.nextToken()); // 계란의 내구도
			weight[i] = Integer.parseInt(st.nextToken()); // 계란의 무게
		}
		
		bt(0, 0);
		
		System.out.println(max);
	}
	
	static void bt(int idx, int cnt) {
		// 마지막 계란까지 다 들어봤으면 종료
		if(idx == N) {
			// 최댓값 갱신
			max = Math.max(max, cnt);
			return;
		}
		// 손으로 든 계란이 이미 깨졌거나 모든 계란이 이미 다 깨져 있다면
		if(dura[idx] <= 0 || cnt == N-1) {
			// 다음 계란을 들어 봄
			bt(idx + 1, cnt);
			return;
		}
		// 다른 계란들과 모두 부딪혀봄
		int nCnt = cnt;
		for(int i=0; i<N; i++) {

			if(i == idx) continue;

			if(dura[i] <= 0) continue;
			hitEgg(idx, i);
			// 부딪혀 봤는데 손에 든 계란이 깨지면 cnt++
			if(dura[idx] <= 0) {
				cnt++;
			}
			// 부딪혀 봤는데 타겟이 된 계란이 깨지면 cnt++
			if(dura[i] <= 0) {
				cnt++;
			}
			bt(idx + 1, cnt);
			recoveryEgg(idx, i);
			cnt = nCnt;
		}
	}
	

	static void hitEgg(int handEgg, int targetEgg) {
		dura[targetEgg] -= weight[handEgg];
		dura[handEgg] -= weight[targetEgg];
	}
	
	static void recoveryEgg(int handEgg, int targetEgg) {
		dura[targetEgg] += weight[handEgg];
		dura[handEgg] += weight[targetEgg];		
	}
	
}
