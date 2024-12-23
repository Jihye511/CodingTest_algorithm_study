import java.io.*;
import java.util.*;
class Solution
{
    public int solution(int []A, int []B)
    {
        int max = A.length;
        Arrays.sort(A);
        Arrays.sort(B);
        int answer=0;
        for(int i =0; i<A.length; i++){
            answer += A[i] *B[max-i-1];
        }
        return answer;
    }
}
