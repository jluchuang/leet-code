// stack + greedy

// Reference : https://leetcode.com/discuss/99084/java-o-n-solution-using-stack-with-detail-explanation

public class Solution {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack<Character>(); 
        
        int[] count = new int[26];
        char[] array = s.toCharArray(); 
        for(int i = 0; i < array.length; i ++) {
            char c = array[i]; 
            count[c - 'a'] ++; 
        }
        
        boolean[] visited = new boolean[26]; 
        
        for(int i = 0; i < array.length; i ++) {
            char c = array[i]; 
            count[c - 'a'] --; 
            if(visited[c - 'a']) {
                continue; 
            }
            while (!stack.empty() && count[stack.peek() - 'a'] > 0 && c < stack.peek()) {
                visited[stack.pop() - 'a'] = false; 
            }
            
            stack.push(c); 
            visited[c - 'a'] = true;  
        }
        
        StringBuilder res = new StringBuilder(); 
        for(Character c : stack) {
            res.append(c); 
        }
        
        return res.toString(); 
    }
}