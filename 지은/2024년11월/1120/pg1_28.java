class Solution {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = n*m/answer[0];
        return answer;
    }
    
    //최대공약수
    int gcd(int a, int b) {
        if(b != 0) return gcd(b, a%b);
        else return a;
    }
}