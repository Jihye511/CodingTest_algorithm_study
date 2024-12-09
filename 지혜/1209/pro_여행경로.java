import java.io.*;
import java.util.*;
class Solution {
    static ArrayList<String> list;
    static boolean[] visited;
    public String[] solution(String[][] tickets) {
        String[] answer = {};
        list = new ArrayList<>();
        visited = new boolean[tickets.length];
        dfs("ICN","ICN", 0,tickets);
        Collections.sort(list);
        answer = list.get(0).split(" ");
        return answer;
    }
    public static void dfs(String start,String path, int idx, String[][] tickets){
        if(idx == tickets.length){
            list.add(path);
            return;
        }
        
        for(int i =0; i<tickets.length; i++){
            if(start.equals(tickets[i][0])&&!visited[i]){
                visited[i] = true;
                dfs(tickets[i][1],path+" "+tickets[i][1], idx+1, tickets);
                visited[i] = false;
            }
        }
    }
}
