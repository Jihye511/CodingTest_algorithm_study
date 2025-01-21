package 백준;

import java.io.*;
import java.util.*;

public class b1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        PriorityQueue<int[]> classPq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] == o2[0]) {
                return o1[1] - o2[1];
            }
            return o1[0] - o2[0];
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            classPq.offer(new int[]{start, end});
        }



        int cnt = 0;
        PriorityQueue<Integer> room = new PriorityQueue<>();
        room.offer(0);
        while (!classPq.isEmpty()) {
            int[] cur = classPq.poll();
            if (room.peek() <= cur[0]) {
                room.poll();
            }
            room.offer(cur[1]);
        }

        System.out.println(room.size());
    }
}
