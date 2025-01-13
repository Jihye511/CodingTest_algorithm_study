package 트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class b9934 {
    private static int K, size;
    private static int[] num;
    private static List<Integer>[] tree;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        K = Integer.parseInt(br.readLine());
        size = (int) (Math.pow(2, K) - 1);
        tree = new ArrayList[K + 1];
        num = new int[size + 1];

        for (int i = 0; i <= K; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int idx = 1;
        while (st.hasMoreTokens()) {
            int n = Integer.parseInt(st.nextToken());
            num[idx] = n;
            idx++;
        }

        search(1, 1, size);

        for (int i = 1; i <= K; i++) {
            for (int j = 0; j < tree[i].size(); j++) {
                System.out.print(tree[i].get(j) + " ");
            }
            System.out.println();
        }

    }

    private static void search(int depth, int start, int end) {
        int mid = (start + end) / 2;
        tree[depth].add(num[mid]);
        if (depth == K) {
            return;
        }

        search(depth + 1, start, mid - 1);
        search(depth + 1, mid + 1, end);
    }
}
