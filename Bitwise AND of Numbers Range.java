public class Solution {
    /**
     * Basic Idea is one loop from m to n,
     * then the complication will be O(n)
     * 
     * Lets take a look at [5, 7] 
     * 5: 101
     * 6: 110
     * 7: 111
     * We want to get bitwise and answer 
     * 1. So if one bit has 0, the bit of the res will be 0
     * 2. when m != n, There is at least an odd number and an even number, 
     * 3. so the last bit position result is 0.
     * 5. Move m and n rigth a position.
     * */
    public int rangeBitwiseAnd(int m, int n) {
        int moveFactor = 1;
        
        while(m != n) {
            m >>= 1; 
            n >>= 1; 
            
            moveFactor <<= 1; 
        }
        
        // return (m * moveFactor) will also get the right answer !
        return (n * moveFactor); 
    }
}