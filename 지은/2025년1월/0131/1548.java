import java.util.*;
import java.io.*;

public class Main {
    static int answer = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        if(n==1 || n==2){
            bw.write(String.valueOf(n));
            bw.flush();
            bw.close();
            return;
        }

        Arrays.sort(arr);

        int len = 0;
        for(int i=0; i<n-2; i++){
            len = 2;
            for(int j=i+2; j<n; j++){
                if(arr[i]+arr[i+1] > arr[j]){
                    len++;
                }
                else{
                    break;
                }
            }
            answer = Math.max(answer, len);
        }

        bw.write(String.valueOf(answer));
        bw.flush();
        bw.close();

    }

}