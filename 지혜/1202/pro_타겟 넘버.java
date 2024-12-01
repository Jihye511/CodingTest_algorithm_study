class Solution {
    static int cnt=0;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        dfs(numbers,0,0,target);
        return cnt;
    }
    public static void dfs(int[] numbers,int depth, int hap, int target){
        if(depth==numbers.length){
            if(hap == target){
                cnt+=1;
            }
            return;
        }
        dfs(numbers, depth+1, hap+numbers[depth],target);
        dfs(numbers, depth+1, hap-numbers[depth], target);
    }
}
