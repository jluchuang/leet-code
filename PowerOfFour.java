public class Solution {
    public boolean isPowerOfFour(int num) {
        if(num > 0 && (num & (num - 1)) == 0) {
            int tmp = num; 
            int count = 0; 
            while (tmp != 1) {
                tmp = tmp >> 1; 
                count ++; 
            }
            
            if(count % 2 == 0) {
                return true; 
            }
        }
        return false; 
    }
}