package 그리디;

import java.io.*;
import java.util.*;

public class b13164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] heights = new int[N];
        int[] heightDiffs = new int[N - 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N - 1; i++) {
            heightDiffs[i] = heights[i + 1] - heights[i];
        }
        Arrays.sort(heightDiffs);

        int ans = 0;
        for (int i = 0; i < (N - 1) - (K - 1); i++) {
            ans += heightDiffs[i];
        }
        System.out.println(ans);
    }
}
