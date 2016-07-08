public class Solution {
    
    // perfect square is 1 + 3 + 5 + 7 ...
    
    public boolean isPerfectSquare(int num) {
        int i = 1; 
        while(num > 0) {
            num = num - i; 
            i += 2; 
        }
        return num == 0; 
    }
}