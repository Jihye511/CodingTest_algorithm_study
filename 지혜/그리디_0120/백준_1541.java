package 그리디_0120;

import java.io.*;
import java.util.*;

public class 백준_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int sum = Integer.MAX_VALUE;
        String[] split = str.split("-");
        for(String s : split){
            int temp=0;
            String[] split2 = s.split("\\+");
            for(int j =0; j<split2.length; j++){
                temp += Integer.parseInt(split2[j]);
            }

            if(sum ==Integer.MAX_VALUE){
                sum = temp;
            }else{
                sum-=temp;
            }
        }
        System.out.println(sum);
    }
}
