package algorithm_study;

import java.io.*;
import java.util.*;

public class 백준_1693 {
	public static void main(String[] args)throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int cnt=0;
		while(A<=B) {
			if(A==B) {
				cnt++;
				break;
			}
			if(B %2 ==0) {
				B /=2;
				cnt++;
			}else if(B %10 ==1){
				B /=10;
				cnt++;
			}
			else {
				cnt=-1;
				break;
			}
		}
		
		System.out.println(cnt);
		
	}
}
