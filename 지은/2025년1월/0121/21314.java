import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();

        String max = "";
        String min = "";
        String subMax = "";
        String subMin = "";
        for(int i=0;i<str.length();i++) {

            if(str.charAt(i) == 'M') {
                subMin+="M";
                subMax+="M";
            }else if(str.charAt(i) == 'K') {
                if(subMin.length() > 0) {
                    min+="1";
                    for(int j=0;j<subMin.length()-1;j++) {
                        min+="0";
                    }
                    subMin="";
                }
                min+="5";
                max+="5";
                for(int j=0;j<subMax.length();j++) {
                    max+="0";
                }
                subMax = "";
            }
        }
        if(subMax!="") {
            for(int i=0;i<subMax.length();i++) {
                max+="1";
            }
        }

        if(subMin!="") {
            min+="1";
            for(int i=0;i<subMin.length()-1;i++) {
                min+="0";
            }
        }

        sb.append(max).append("\n").append(min);
        bw.write(sb.toString());
        bw.flush();
        bw.close();

    }
}