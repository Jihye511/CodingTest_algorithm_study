package gold;

import java.io.*;
import java.util.*;

public class B1099_알수없는문장 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int n = Integer.parseInt(br.readLine());

        HashMap<String, List<String>> map = new HashMap<>();

        // 단어들을 HashMap에 저장 (정렬된 단어를 Key로, 원본 단어 리스트를 Value로)
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            String orderedWord = order(word);
            map.computeIfAbsent(orderedWord, k -> new ArrayList<>()).add(word);
        }

        int[] dp = new int[line.length() + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0; // 첫 번째 문자부터 시작할 것이므로 0으로 설정

        // DP로 최소 변경 횟수 찾기
        for (int i = 1; i <= line.length(); i++) {
            for (int j = 0; j < i; j++) {
                String tempWord = line.substring(j, i);
                String orderedTempWord = order(tempWord);

                // 디버깅 출력
//                System.out.println("tempWord: " + tempWord + " orderedTempWord: " + orderedTempWord);

                if (map.containsKey(orderedTempWord)) {
                    List<String> list = map.get(orderedTempWord);
                    int minCount = Integer.MAX_VALUE;

                    for (String s : list) {
                        int tempCount = checkCount(s, tempWord);
                        minCount = Math.min(minCount, tempCount);
                    }

                    if (dp[j] != Integer.MAX_VALUE) { // 초기값이면 갱신하지 않음
                        dp[i] = Math.min(dp[i], dp[j] + minCount);
                    }
                }
            }
        }

        // 정답 출력
        System.out.println(dp[line.length()] == Integer.MAX_VALUE ? -1 : dp[line.length()]);
    }

    // 단어 정렬 후 반환
    public static String order(String word) {
        char[] wordArr = word.toCharArray();
        Arrays.sort(wordArr);
        return new String(wordArr);
    }

    // 두 단어의 차이를 계산 (길이가 다르면 Integer.MAX_VALUE 반환)
    public static int checkCount(String origin, String check) {
        if (origin.length() != check.length()) return Integer.MAX_VALUE;
        int returnAnswer = 0;
        for (int i = 0; i < origin.length(); i++) {
            if (origin.charAt(i) != check.charAt(i)) {
                returnAnswer++;
            }
        }
        return returnAnswer;
    }
}