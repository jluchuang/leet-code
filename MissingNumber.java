/**
 * The basic idea is to use XOR operation. 
 * We all know that a^b^b =a, 
 * which means two xor operations with the same number will eliminate 
 * the number and reveal the original number.
 * In this solution, I apply XOR operation to both the index and value of the array. 
 * In a complete array with no missing numbers, 
 * the index and value should be perfectly corresponding( nums[index] = index), 
 * so in a missing array, what left finally is the missing number.
 *
 * Another idea is use sum[1..n], but when n is too large , 
 * the sum of 1 to n may out of limit of Integer.MAX_VALUE, 
 * so we don't use that.
 **/
public class Solution {
    public int missingNumber(int[] nums) {
        int xor = 0; 
        int i = 0; 
        for(i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i]; 
        }
        
        return xor ^ i; 
    }
}