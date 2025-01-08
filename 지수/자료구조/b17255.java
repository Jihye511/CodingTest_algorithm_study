import java.util.HashMap;
import java.util.Scanner;

public class b17255 {
    private static String N;
    private static char[] nums;
    private static HashMap<String, Integer> visited = new HashMap<>();
    private static int answer = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextLine();
        nums = N.toCharArray();

        for (int i = 0; i < nums.length; i++) {
            solution(Character.toString(nums[i]), i, i, Character.toString(nums[i]));
        }
        
        System.out.println(answer);
        scanner.close();
    }

    private static void solution(String caseStr, int left, int right, String seque) {
        if (caseStr.equals(N) && !visited.containsKey(seque)) {
            visited.put(seque, 0);
            answer += 1;
        } else {
            if (left > 0) {
                solution(Character.toString(nums[left - 1]) + caseStr, left - 1, right, seque + caseStr);
            }
            
            if (right < nums.length - 1) {
                solution(caseStr + Character.toString(nums[right + 1]), left, right + 1, seque + caseStr);
            }
        }
    }
}
