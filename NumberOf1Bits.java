public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        
        int hamming = 0; 
        
        long t = n & 0x00000000ffffffffL; 
        
        while(t > 0) {
            if((t & 1) != 0) {
                hamming ++; 
            } 
            t = t >> 1; 
        }
        
        return hamming; 
    }
}