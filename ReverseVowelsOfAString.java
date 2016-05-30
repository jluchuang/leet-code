public class Solution {
    public String reverseVowels(String s) {
        if(s == null) {
            return null; 
        }
        
        char[] array = s.toCharArray();
        int start = 0; 
        int end = s.length() - 1;
        
        while (start < end) {
            while (start < s.length() && !judgeVowells(array[start])) {
                start ++;
            } 
            while (end >= 0 && !judgeVowells(array[end])) {
                end --; 
            }
            
            if(start < end) {
                char tmp = array[start]; 
                array[start] = array[end];
                array[end] = tmp;
            }
            start ++; 
            end --; 
        }
        return new String(array);
    }
    
    private boolean judgeVowells(char a) {
        if(a == 'a' || a == 'A'
        || a == 'e' || a == 'E'
        || a == 'i' || a == 'I'
        || a == 'o' || a == 'O'
        || a == 'u' || a == 'U' ) {
            return true; 
        }
        
        return false; 
    }
}