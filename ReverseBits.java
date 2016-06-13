public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int res = 0; 
        
        int pos = 31;
        while(pos >= 0) {
            int cur = n & 1; 
            n = n >> 1;
            
            cur = cur << pos;
            res = res | cur; 
            pos --; 
        }
        
        return res;
    }
}