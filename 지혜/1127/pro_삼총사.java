class Solution {
    static int length;
    static int cnt=0;
    static int[] temp;
    public int solution(int[] number) {
        int answer = 0;
        temp = number;
        length = number.length;
        dfs(0,0,0);
        return cnt;
    }
    public static void dfs(int depth, int hap, int size){
        if(depth ==length){
            if(size==3  && hap==0){
                cnt+=1;
            }
            return;
        }
        dfs(depth+1, hap + temp[depth],size+1);
        dfs(depth+1, hap, size);
    }
}
