class Solution {
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        int answer = dfs(target, begin, words, visited, 0);
        return answer == Integer.MAX_VALUE ? 0 : answer;
    }
    public static int dfs(String target, String current, String[] words, boolean[] visited, int count) {
         if (current.equals(target)) {
            return count; // 변환 횟수 반환
        }
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && checkWords(current, words[i])) {
                visited[i] = true;
                minCount = Math.min(minCount, dfs(target, words[i], words, visited, count + 1));
                visited[i] = false; 
            }
        }
        
        return minCount;
    }
    public static boolean checkWords(String str, String temp){
        int cnt=0;
        for(int i =0; i<str.length(); i++){
            char c = str.charAt(i);
            char n = temp.charAt(i);
            if(c !=n ){
                cnt++;
            }
        }
        if(cnt ==1) return true;
        else return false;
    }
}
