public class Solution {
    public int[] singleNumber(int[] nums) {
        int[] res = new int[2]; 
        
        int xor = 0; 
        for(int i = 0; i < nums.length; i ++) {
            xor = xor ^ nums[i]; 
        }
        
        xor = xor & ~(xor - 1);     // find the right most diff bit of the two res
        
        int res1 = 0; 
        int res2 = 0; 
        for(int i = 0; i < nums.length; i ++) {
            if((nums[i] & xor) != 0) {
                res1 = res1 ^ nums[i]; 
            }
            else {
                res2 = res2 ^ nums[i]; 
            }
        }
        
        res[0] = res1;
        res[1] = res2; 
        return res; 
    }
}