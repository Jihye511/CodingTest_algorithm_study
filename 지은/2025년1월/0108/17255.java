import java.io.*;
import java.util.*;

public class Main {
    static String N;
    static char[] nums;
    static Set<String> visited = new HashSet<>();
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = br.readLine();
        nums = N.toCharArray();

        for (int i = 0; i < nums.length; i++) {
            solution(Character.toString(nums[i]), i, i, Character.toString(nums[i]));
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();
    }

    static void solution(String current, int left, int right, String sequence) {
        if (current.equals(N) && !visited.contains(sequence)) {
            visited.add(sequence);
            answer++;
            return;
        }

        if (left > 0) {
            solution(nums[left - 1] + current, left - 1, right, sequence + current);
        }

        if (right < nums.length - 1) {
            solution(current + nums[right + 1], left, right + 1, sequence + current);
        }
    }
}
