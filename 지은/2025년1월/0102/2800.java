import java.io.*;
import java.util.*;

public class Main {
    static List<Pair> pairs;
    static int pairCount;
    static Set<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String input = br.readLine();
        Deque<Integer> stk = new ArrayDeque<>();
        set = new TreeSet<>();
        pairs = new ArrayList<>();

        int inputSize = input.length();
        for (int i = 0; i < inputSize; i++) {
            char cur = input.charAt(i);
            if (cur == '(') {
                stk.add(i);
            }
            else if (cur == ')') {
                pairs.add(new Pair(stk.pop(), i));
            }
        }

        pairCount = pairs.size();
        makeString(0, input+"");

        set.remove(input);

        StringBuilder answer = new StringBuilder();
        for (String s : set) {
            answer.append(s).append("\n");
        }

        bw.write(answer.toString());
        bw.flush();
        bw.close();
    }

    static void makeString(int idx, String str) {
        if (idx == pairCount) {
            set.add(str.replaceAll(" ",""));
            return;
        }

        Pair pair = pairs.get(idx);
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(pair.left,' ');
        sb.setCharAt(pair.right, ' ');
        makeString(idx + 1, sb.toString());

        makeString(idx + 1, str);
    }
}

class Pair
{
    int left, right;

    public Pair(int left, int right) {
        this.left = left;
        this.right = right;
    }
}