import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int a, int b) {
        int ra = find(a);
        int rb = find(b);
        if (ra != rb) parent[rb] = ra;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 사람 수
        int M = Integer.parseInt(st.nextToken()); // 파티 수

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        st = new StringTokenizer(br.readLine());
        int truthCount = Integer.parseInt(st.nextToken());
        List<Integer> truthPeople = new ArrayList<>();

        for (int i = 0; i < truthCount; i++) {
            truthPeople.add(Integer.parseInt(st.nextToken()));
        }

        List<List<Integer>> parties = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            List<Integer> party = new ArrayList<>();
            int first = -1;

            for (int j = 0; j < num; j++) {
                int person = Integer.parseInt(st.nextToken());
                party.add(person);
                if (j == 0) first = person;
                else union(first, person); // 파티 내 사람들을 모두 연결
            }

            parties.add(party);
        }

        // 진실 아는 사람의 root를 기록
        Set<Integer> truthRoots = new HashSet<>();
        for (int person : truthPeople) {
            truthRoots.add(find(person));
        }

        int result = 0;
        for (List<Integer> party : parties) {
            boolean canLie = true;
            for (int person : party) {
                if (truthRoots.contains(find(person))) {
                    canLie = false;
                    break;
                }
            }
            if (canLie) result++;
        }

        System.out.println(result);
    }
}
