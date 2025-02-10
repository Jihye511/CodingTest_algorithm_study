import java.io.*;
import java.util.*;

public class b15666 {

	static int N, M;
	static int[] numArray;
	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		numArray = new int[N];
		st = new StringTokenizer(br.readLine(), " ");
		for (int i = 0; i < N; i++) {
			numArray[i] = Integer.parseInt(st.nextToken());
		}

		int[] combinatedArray = new int[M];

		// 문제 풀기전에 정렬
		Arrays.sort(numArray);
		combination(0, 0, combinatedArray);						
		System.out.println(sb);
		
	}

	private static void combination(int cnt, int start, int[] combinatedArray) {
		if (cnt == M) {
			for(int i=0; i<cnt; i++) {
				sb.append(combinatedArray[i]).append(' ');
			}
			sb.append("\n");						
			return;
		}
		int before = Integer.MIN_VALUE;
		for (int i = start; i < N; i++) {
			if(before == numArray[i]) continue;
			combinatedArray[cnt] = numArray[i];
			combination(cnt + 1,i, combinatedArray);
			before = numArray[i];
		}
	}

}
