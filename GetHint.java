public class Solution {
    public String getHint(String secret, String guess) {
        int[] sMap = new int[10]; 
        int[] gMap = new int[10]; 
        
        int bulls = 0; 
        int cows = 0; 
        int len = secret.length(); 
        for(int i = 0; i < len; i ++) {
            char s = secret.charAt(i); 
            char g = guess.charAt(i); 
            
            if(s == g) {
                bulls ++;
                continue; 
            }
            
            int sN = s - '0';
            int gN = g - '0'; 
            
            if(sMap[gN] > 0) {
                cows ++; 
                sMap[gN] --;
            }
            else {
                gMap[gN] ++;
            }
            
            if(gMap[sN] > 0) {
                cows ++;
                gMap[sN] --;
            }
            else {
                sMap[sN] ++; 
            }
        }
        
        return "" + bulls + "A" + cows + "B"; 
    }
}