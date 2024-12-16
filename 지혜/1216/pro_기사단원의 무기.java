class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i=1; i<=number; i++){
            if(divisorCount(i)<=limit){
                answer +=divisorCount(i);
            }else{
                answer +=power;
            }
            
        }
        return answer;
    }
    public static int divisorCount(int num){
        int cnt =0;
        for(int i =1; i*i<=num; i++){
            if(i*i == num){
                cnt++;
            }
            else if(num%i ==0){
                cnt +=2;
            }
        }
        return cnt;
    }
}
