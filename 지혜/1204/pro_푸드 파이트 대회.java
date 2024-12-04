import java.io.*;
import java.util.*;
class Solution {
    public String solution(int[] food) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<food.length; i++){
            for(int j =0; j<food[i]/2;j++){
                sb.append(i);
            }
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(sb.toString());
        sb2.reverse();
        sb.append(0);
        sb.append(sb2.toString());
        
        return sb.toString();
    }
}
