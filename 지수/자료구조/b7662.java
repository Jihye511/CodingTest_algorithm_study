package 자료구조;

import java.util.*;
import java.io.*;

public class b7662 {
    private static TreeMap<Integer, Integer> treeMap;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            treeMap = new TreeMap<>();

            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            while (K-- > 0) {
                st = new StringTokenizer(br.readLine());
                char op = st.nextToken().charAt(0);
                int num = Integer.parseInt(st.nextToken());

                switch (op) {
                    case 'I' :
                        offerOperation(num);
                        break;
                    case 'D':
                        pollOperation(num);
                        break;
                }
            }
            if (treeMap.isEmpty()) {
                System.out.println("EMPTY");
            } else {
                System.out.println(treeMap.lastKey() + " " + treeMap.firstKey());
            }
        }
    }

    private static void offerOperation(int num) {
        treeMap.put(num, treeMap.getOrDefault(num, 0) + 1);
    }

    private static void pollOperation(int num) {
        if (treeMap.isEmpty()) {
            return;
        }
        if (num == 1) {
            int targetNum = treeMap.lastKey();
            if (treeMap.get(targetNum) == 1) {
                treeMap.remove(targetNum);
            } else {
                treeMap.put(targetNum, treeMap.get(targetNum) - 1);
            }
            return;
        }

        if (num == -1) {
            int targetNum = treeMap.firstKey();
            if (treeMap.get(targetNum) == 1) {
                treeMap.remove(targetNum);
            } else {
                treeMap.put(targetNum, treeMap.get(targetNum) - 1);
            }
        }
    }

}
