package 트리_0117;
import java.io.*;
import java.util.*;
public class 백준_17073 {
    static int N, W;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N + 1; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            list.get(start).add(end);
            list.get(end).add(start);
        }
        int leafnode = 0;
        for (int i = 2; i <= N; i++) {
            if (list.get(i).size() == 1) leafnode++;


        }
        double result = (double) W/leafnode;
        System.out.println(result);
    }


}

