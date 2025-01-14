import java.util.*;
import java.io.*;

public class Main {
    static int k;
    static int[] arr;
    static List<ArrayList<Integer>> list;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        arr = new int[(int) Math.pow(2, k) - 1];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new ArrayList<>());
        }

        search(0,arr.length - 1,0);
        for (int i = 0; i < k; i++) {
            for (int j : list.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }
    static void search(int start, int end, int depth) {
        if(depth == k) {
            return;
        }

        int mid = (start + end) / 2;
        list.get(depth).add(arr[mid]);
        search(start, mid - 1, depth + 1);
        search(mid + 1, end, depth + 1);
    }
}