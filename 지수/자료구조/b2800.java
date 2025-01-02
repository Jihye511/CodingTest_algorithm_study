package 자료구조;
import java.util.*;
import java.io.*;

public class b2800 {
    private static final char LEFT_BRACKET = '(';
    private static final char RIGHT_BRACKET = ')';

    private static String str;
    private static char[] ch;
    private static Set<String> results = new TreeSet<>();
    private static List<int[]> pairs = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();
        ch = str.toCharArray();

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (ch[i] == LEFT_BRACKET) {
                stack.push(i);
            } else if (ch[i] == RIGHT_BRACKET) {
                if (!stack.isEmpty()) {
                    pairs.add(new int[]{stack.pop(), i});
                }
            }
        }

        // 모든 조합을 생성하여 괄호를 제거
        generateCombinations(0, new HashSet<>());

        // 원본 수식 제거
        results.remove(str);
        for (String result : results) {
            System.out.println(result);
        }
    }

    private static void generateCombinations(int depth, Set<Integer> removeSet) {
        if (depth == pairs.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < ch.length; i++) {
                if (!removeSet.contains(i)) {
                    sb.append(ch[i]);
                }
            }
            results.add(sb.toString());
            return;
        }

        // 현재 괄호를 제거하지 않는 경우
        generateCombinations(depth + 1, removeSet);

        // 현재 괄호를 제거하는 경우
        int[] pair = pairs.get(depth);
        removeSet.add(pair[0]);
        removeSet.add(pair[1]);
        generateCombinations(depth + 1, removeSet);
        removeSet.remove(pair[0]);
        removeSet.remove(pair[1]);
    }
}
