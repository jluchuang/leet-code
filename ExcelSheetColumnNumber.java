public class Solution {
    public int titleToNumber(String s) {
        int res = 0; 
        for(int i = 0; i < s.length(); i ++) {
            char tmp = s.charAt(i); 
            int num = (int)(tmp - 'A' + 1); 
            res = res * 26 + num;   
        }
        
        return res; 
    }
}