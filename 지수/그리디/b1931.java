package 그리디;

import java.io.*;
import java.util.*;

public class b1931 {
    private static List<int[]> meetingList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            meetingList.add(new int[]{start, end});
        }

        meetingList.sort((a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int ans = 1;
        int[] preMeeting = meetingList.get(0);
        for (int i = 1; i < meetingList.size(); i++) {
            if (meetingList.get(i)[0] >= preMeeting[1]) {
                ans++;
                preMeeting = meetingList.get(i);
            }
        }

        System.out.println(ans);
    }

}
