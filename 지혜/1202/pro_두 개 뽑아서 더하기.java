import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = {};
        TreeSet<Integer> list = new TreeSet<>();
        for(int i =0; i<numbers.length-1; i++){
            for(int j =i+1; j<numbers.length; j++){
                int hap = numbers[i]+numbers[j];
                list.add(hap);
            }
        }
        
        answer = new int[list.size()];
        int index = 0;
        for (int num : list) {
            answer[index++] = num;
        }
        return answer;
    }
}
