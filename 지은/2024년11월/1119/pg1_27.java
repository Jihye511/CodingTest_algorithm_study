import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> stk = new ArrayDeque<>();
        stk.push(arr[0]);
        for(int i = 1; i<arr.length; i++) {
            if(stk.peek() != arr[i]) stk.push(arr[i]);
        }

        int size = stk.size();
        int[] answer = new int[size];
        for(int i=0; i<size; i++) {
            answer[i] = stk.removeLast();
        }

        return answer;
    }
}