import java.io.*;
import java.util.*;

public class Main {
    public static int N;
    public static int[] arr = {9,8,7,6,5,4,3,2,1, 0};
    public static ArrayList<Long> arrList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());

        dfs(0, 0);
        Collections.sort(arrList);

        if(N <= 1023) {
            System.out.println(arrList.get(N-1));
        }else {
            System.out.println("-1");
        }
    }
    public static void dfs(int level, long num) {
        if(!arrList.contains(num)) {
            arrList.add(num);
        }
        if(level >= 10)
            return;

        dfs(level + 1, (num * 10) + arr[level] );
        dfs(level + 1, (num) );
    }

}
