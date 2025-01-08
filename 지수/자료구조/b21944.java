import java.util.*;

public class b21944 {

    public static class Problem implements Comparable<Problem> {
        int idx;
        int level;
        int algo;

        public Problem(int idx, int level, int algo) {
            this.idx = idx;
            this.level = level;
            this.algo = algo; 
        }

        public int compareTo(Problem o) {
            if (level - o.level == 0) {
                return idx - o.idx;
            } else {
                return level - o.level;
            }
        }

        public String toString() {
            return "idx : " + idx + " level : " + level + " algo : " + algo;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        TreeSet<Problem> ts = new TreeSet();
        Map<Integer, TreeSet<Problem>> algoTreeSet = new HashMap();
        Map<Integer, Integer> levelmap = new HashMap<>();
        Map<Integer, Integer> algomap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int n_idx = sc.nextInt();
            int n_level = sc.nextInt();
            int n_algo = sc.nextInt();
            ts.add(new Problem(n_idx, n_level, n_algo));
            if (algoTreeSet.containsKey(n_algo)) {
                TreeSet<Problem> temp = algoTreeSet.get(n_algo);
                temp.add(new Problem(n_idx, n_level, n_algo));
                algoTreeSet.replace(n_algo, temp);
            } else {
                TreeSet<Problem> temp = new TreeSet<>();
                temp.add(new Problem(n_idx, n_level, n_algo));
                algoTreeSet.put(n_algo, temp);
            }

            levelmap.put(n_idx, n_level);
            algomap.put(n_idx, n_algo);
        }

        int m = sc.nextInt();

        for (int i = 0; i < m; i++) {
            String command = sc.next();
            if (command.equals("recommend")) {
                int n_algo = sc.nextInt();
                int pos = sc.nextInt();
                if (pos == 1) {
                    System.out.println(algoTreeSet.get(n_algo).last().idx);
                } else {
                    System.out.println(algoTreeSet.get(n_algo).first().idx);
                }
            } else if (command.equals("recommend2")) {
                int pos = sc.nextInt();
                if (pos == 1) {
                    System.out.println(ts.last().idx);
                } else {
                    System.out.println(ts.first().idx);
                }
            } else if (command.equals("recommend3")) {
                int pos = sc.nextInt(); // 1, -1
                int stand = sc.nextInt();// 난이도
                if (pos == 1) {
                    if (ts.ceiling(new Problem(0, stand, 0)) == null) {
                        System.out.println(-1);
                    } else {
                        System.out.println(ts.ceiling(new Problem(0, stand, 0)).idx);
                    }
                } else {
                    if (ts.floor(new Problem(0, stand, 0)) == null) {
                        System.out.println(-1);
                    } else {
                        System.out.println(ts.floor(new Problem(0, stand, 0)).idx);
                    }
                }
            } else if (command.equals("add")) {
                int n_idx = sc.nextInt();
                int n_level = sc.nextInt();
                int n_algo = sc.nextInt();
                ts.add(new Problem(n_idx, n_level, n_algo));
                if (algoTreeSet.containsKey(n_algo)) {
                    TreeSet<Problem> temp = algoTreeSet.get(n_algo);
                    temp.add(new Problem(n_idx, n_level, n_algo));
                    algoTreeSet.replace(n_algo, temp);
                } else {
                    TreeSet<Problem> temp = new TreeSet<>();
                    temp.add(new Problem(n_idx, n_level, n_algo));
                    algoTreeSet.put(n_algo, temp);
                }
                levelmap.put(n_idx, n_level);
                algomap.put(n_idx, n_algo);
            } else {
                int n_idx = sc.nextInt();
                int n_level = levelmap.get(n_idx);
                int n_algo = algomap.get(n_idx);
                ts.remove(new Problem(n_idx, n_level, n_algo));
                algoTreeSet.get(n_algo).remove(new Problem(n_idx, n_level, n_algo));
                levelmap.remove(n_idx);
                algomap.remove(n_idx);
            }
        }
    }
}
