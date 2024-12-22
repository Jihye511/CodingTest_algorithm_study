class Solution {
    public int solution(String t, String p) {
        int answer = 0;
        int size = p.length();
        for(int i = 0; i<=t.length()-size; i++) {
            long tLong = Long.parseLong(t.substring(i, i+size));
            long pLong = Long.parseLong(p);
            if(tLong <= pLong) answer++;
        }
        return answer;
    }
}