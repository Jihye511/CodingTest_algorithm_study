package 그리디_0121;

import java.io.*;
import java.util.*;

public class 백준_21314 {
    static String str;
    static StringBuilder sb_max = new StringBuilder();
    static StringBuilder sb_min = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        str = br.readLine();

        int cntM = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == 'M') {
                cntM++;
            } else if (ch == 'K') {
                if (cntM > 0) {
                    sb_max.append('5');
                    for (int j = 0; j < cntM; j++) {
                        sb_max.append('0');
                    }
                } else {
                    sb_max.append('5');
                }
                if(cntM>0){
                    sb_min.append('1');
                    for(int j =1; j<cntM; j++){
                        sb_min.append('0');
                    }
                    sb_min.append('5');
                }else{
                    sb_min.append('5');
                }
                cntM=0;
            }

        }
        if(cntM>0){
            for(int j =0; j<cntM; j++){
                sb_max.append('1');
            }

            sb_min.append('1');
            for(int j =1; j<cntM; j++){
                sb_min.append('0');
            }
        }

        System.out.println(sb_max.toString());
        System.out.println(sb_min.toString());
    }


}
