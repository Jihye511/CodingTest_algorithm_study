package 그래프탐색;

import java.io.*;
import java.util.*;

class State {
	public int position;		// 현재 지점
	public int time;			// 소비 시간

	public State (int position, int time) {
		this.position = position;
		this.time = time;
	}
}

public class b13549 {
	static int n, k;				// 수빈이의 시작 지점 n, 목표 동생 지점 k
	static int minTime;				// 출력, 최소 시간

	static final int MAX_POSITION = 100_000;
	static final int INF = 100_000;
	static int[] visited = new int[MAX_POSITION + 1];
	static Queue<State> queue = new LinkedList<>();

	static void bfs() {
		Arrays.fill(visited, INF);
		visited[n] = 0;
		queue.add(new State(n, 0));

		while (!queue.isEmpty()) {
			State current = queue.remove();

			int np1 = current.position - 1;
			// 현재까지 갱신된 최적 경로로 다음 지점 도달 최소 시간 visited[np1]
			// > 현재 경로로 다음 지점 도달 시간 current.time + 1
			if (isValid(np1) && visited[np1] > current.time + 1) {
				visited[np1] = current.time + 1;
				queue.add(new State(np1, visited[np1]));
			}

			int np2 = current.position + 1;
			if (isValid(np2) && visited[np2] > current.time + 1) {
				visited[np2] = current.time + 1;
				queue.add(new State(np2, visited[np2]));
			}

			int np3 = current.position * 2;
			if (isValid(np3) && visited[np3] > current.time) {
				visited[np3] = current.time;			// x 2 순간 이동은 시간 그대로
				queue.add(new State(np3, visited[np3]));
			}
		}

		minTime = visited[k];
	}

	static boolean isValid(int position) {
		return 0 <= position && position <= MAX_POSITION;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
				new InputStreamReader(System.in)
		);
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		if (n >= k)
			minTime = n - k;	// -1 칸씩 n-k 번 이동하는 한 가지
		else
			bfs();

		System.out.println(minTime);
	}
}
