package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class b19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> meetingPq = new PriorityQueue<>((o1, o2) -> {
            if (o1 == o2) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            meetingPq.offer(new int[]{start, end});
        }

        PriorityQueue<Integer> meetingRoom = new PriorityQueue<>();
        meetingRoom.offer(0);
        while (!meetingPq.isEmpty()) {
            int[] cur = meetingPq.poll();
            if (meetingRoom.peek() <= cur[0]) {
                meetingRoom.poll();
            }
            meetingRoom.offer(cur[1]);
        }
        System.out.println(meetingRoom.size());
    }
}
