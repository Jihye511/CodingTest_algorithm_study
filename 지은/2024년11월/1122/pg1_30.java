import java.util.*;

class Solution {
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean wordCheck = false;
        boolean start = false;
        if((s.charAt(0) >= 97 && s.charAt(0) <=122) ||
              (s.charAt(0) >= 65 && s.charAt(0) <=90)) {
            wordCheck = true;
            start = true;
        }
 
        int curWord = 0;
        int curG = 0;
        List<String> sList = new ArrayList<>();
        List<String> split = new ArrayList<>();
        for(int i = 0; i<s.length(); i++) {
            if((s.charAt(i) >= 97 && s.charAt(i) <=122) ||
              (s.charAt(i) >= 65 && s.charAt(i) <=90)) {
                if(!wordCheck) {
                    split.add(s.substring(curG, i));
                    wordCheck = true;
                    curWord = i;
                }
            } else {
                if(wordCheck) {
                    sList.add(s.substring(curWord, i));
                    wordCheck = false;
                    curG = i;
                }
            }
        }
        
        if(wordCheck) sList.add(s.substring(curWord, s.length()));
        else split.add(s.substring(curG, s.length()));
        split.add("");
        
        if(!start) sb.append(split.get(0));
        for(int j = 0; j<sList.size(); j++) {
            String str = sList.get(j);
            for(int i = 0; i<str.length(); i++) {
                if(i % 2 == 0) {
                    if(str.charAt(i) >= 97 && str.charAt(i) <=122)
                        sb.append((char)(str.charAt(i) - 32));
                    else sb.append(str.charAt(i));
                }
                else {
                    if(str.charAt(i) >= 65 && str.charAt(i) <=90)
                        sb.append((char)(str.charAt(i) + 32));
                    else sb.append(str.charAt(i));
                }
            }
            if(!start) sb.append(split.get(j+1));
            else  sb.append(split.get(j));
        }
        
        return sb.toString();
    }
}