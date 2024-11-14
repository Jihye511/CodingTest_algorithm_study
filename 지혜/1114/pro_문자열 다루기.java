class Solution {
    public boolean solution(String s) {
        boolean answer = true;
        if(s.length()<4 || s.length()>6 || s.length()==5) return false;
        
        for(char c : s.toCharArray()){
            if(!Character.isDigit(c)){
                answer = false;
           
            }
        }
        return answer;
        
    }
}
