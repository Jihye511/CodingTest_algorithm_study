import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        TreeSet<Problem> tree = new TreeSet<>();
        List<TreeSet<Problem>> subtrees = new ArrayList<>();
        for (int i = 0; i <= 100; i++) {
            subtrees.add(new TreeSet<>());
        }
        HashMap<Integer, int[]> hMap = new HashMap<>();


        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int no = Integer.parseInt(st.nextToken());
            int level = Integer.parseInt(st.nextToken());
            int group = Integer.parseInt(st.nextToken());
            subtrees.get(group).add(new Problem(no, level, group));
            tree.add(new Problem(no, level, group));
            hMap.put(no, new int[] {level, group});
        }


        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            if (command.equals("recommend")) {
                int group = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(subtrees.get(group).last().no).append("\n");
                } else {
                    sb.append(subtrees.get(group).first().no).append("\n");
                }
            } else if (command.equals("recommend2")) {
                int x = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    sb.append(tree.last().no).append("\n");
                } else {
                    sb.append(tree.first().no).append("\n");
                }
            } else if (command.equals("recommend3")) {
                int x = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                if (x == 1) {
                    if (tree.ceiling(new Problem(0, level, 0)) == null) sb.append("-1\n");
                    else sb.append(tree.ceiling(new Problem(0, level, 0)).no).append("\n");
                } else {
                    if (tree.lower(new Problem(0, level, 0)) == null) sb.append("-1\n");
                    else sb.append(tree.lower(new Problem(0, level, 0)).no).append("\n");
                }
            } else if (command.equals("add")) {
                int no = Integer.parseInt(st.nextToken());
                int level = Integer.parseInt(st.nextToken());
                int group = Integer.parseInt(st.nextToken());
                subtrees.get(group).add(new Problem(no, level, group));
                tree.add(new Problem(no, level, group));
                hMap.put(no, new int[] {level, group});
            } else {
                int no = Integer.parseInt(st.nextToken());
                if (!hMap.containsKey(no)) continue;
                int level = hMap.get(no)[0];
                int group = hMap.get(no)[1];
                hMap.remove(no);
                tree.remove(new Problem(no, level, group));
                subtrees.get(group).remove(new Problem(no, level, group));
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
    }


    static class Problem implements Comparable<Problem> {
        int no;
        int level;
        int group;

        public Problem(int no, int level, int group) {
            this.no = no;
            this.level = level;
            this.group = group;
        }

        @Override
        public int compareTo(Problem o) {
            if (level == o.level) {
                return Integer.compare(no, o.no);
            }
            return Integer.compare(level, o.level);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Problem other = (Problem) obj;
            if (group != other.group)
                return false;
            if (level != other.level)
                return false;
            if (no != other.no)
                return false;
            return true;
        }
    }

}