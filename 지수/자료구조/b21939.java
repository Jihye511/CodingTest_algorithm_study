package 자료구조;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class b21939 {
    private static class Problem {
        int p;  // 문제 번호
        int l; // 난이도

        public Problem(int p, int l) {
            this.p = p;
            this.l = l;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // 최대 난이도, 최소 난이도 반환을 위한 TreeSet
        TreeSet<Problem> treeSet = new TreeSet<>((o1, o2) -> {
            if (o1.l == o2.l) { // 문제 난이도가 같을 때
                return o1.p - o2.p; // 문제 번호 작은 것 먼저
            }
            return o1.l - o2.l; // 문제 난이도 낮은 것 먼저
        });

        Map<Integer, Integer> map = new HashMap<>();

        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int P = Integer.parseInt(st.nextToken());   // 문제 번호
            int L = Integer.parseInt(st.nextToken());   // 난이도
            treeSet.add(new Problem(P, L));
            map.put(P, L);

        }

        int P = Integer.parseInt(br.readLine());
        while (P-- > 0) {
            st = new StringTokenizer(br.readLine());
            switch (st.nextToken()) {
                case "add":
                    int p = Integer.parseInt(st.nextToken());
                    int l = Integer.parseInt(st.nextToken());
                    Problem problem = new Problem(p, l);
                    treeSet.add(problem);
                    map.put(p, l);
                    break;
                case "recommend":
                    int num = Integer.parseInt(st.nextToken());
                    if (num == 1) { // 가장 어려운 문제의 번호를 출력 => 최대힙
                        System.out.println(treeSet.last().p);
                    } else if (num == -1) { // 가장 쉬운 문제의 번호를 출력 => 최소힙
                        System.out.println(treeSet.first().p);
                    }
                    break;
                case "solved":
                    int s_p = Integer.parseInt(st.nextToken());
                    int s_l = map.get(s_p);
                    treeSet.remove(new Problem(s_p, s_l));
                    break;
            }

        }


    }
}
