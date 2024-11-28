import java.io.*;
import java.util.*;
class Solution {
    public int solution(int[] money) {
        int[] Include0 = new int[money.length];
        int[] Exclude0 = new int[money.length];
        
        //0번째 포함
        Include0[0] = Include0[1] = money[0];
        //불포함
        Exclude0[1] = money[1];
        
        for(int i =2; i<money.length; i++){
            Include0[i] = Math.max(Include0[i-2] +money[i], Include0[i-1]);
            Exclude0[i] = Math.max(Exclude0[i-2] + money[i], Exclude0[i-1]);
        }
        return Math.max(Include0[money.length-2],Exclude0[money.length-1]);
    }
}
