class Solution {
    public String solution(String s, int n) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c ==' '){
                sb.append(c);
                continue;
            }
            //소문자 경우
            if(c>='a' &&c<='z'){
                c = (char)((c-'a'+n)%26 +'a');
            }
            else if(c>='A' && c<='Z'){
                c = (char)((c-'A'+n)%26 +'A');
            }
            sb.append(c);
        }
        return sb.toString();
    }
}
