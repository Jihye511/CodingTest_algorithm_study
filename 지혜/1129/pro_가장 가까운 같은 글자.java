import java.io.*;
import java.util.*;
class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        HashSet<Character> set = new HashSet<Character>();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!set.contains(c)){
                set.add(c);
                answer[i] = -1;
            }else{
                int idx=0;
                for(int j=0;j<i;j++){
                    char before = s.charAt(j);
                    if(c ==before){
                        idx = j;
                    }
                }
                answer[i] = i-idx;
            }
        }
        return answer;
    }
}
