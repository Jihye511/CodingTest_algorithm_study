import java.io.*;
import java.util.*;
class Solution {
    public String[] solution(int n  , int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        int[][] map = new int[n][n];
        //이진수로 변환
        for(int i =0; i<n; i++){
            int cur1 = arr1[i];
            int cur2 = arr2[i];
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<n; j++){
                int extra1 = cur1%2;
                int extra2 = cur2%2;
                if(extra1 ==1 || extra2 ==1){
                    sb.append("#");
                }else{
                    sb.append(" ");
                }
                cur1/=2;
                cur2/=2;
                
            }
            answer[i] = sb.reverse().toString();
        }
        
        return answer;
    }
}
