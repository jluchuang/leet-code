public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0; 
        int min = Integer.MAX_VALUE;
        int j = 0; 
        for (int i = 0; i < nums.length;) {
            sum += nums[i ++]; 
            
            while(sum >= s) {
                min = Math.min(min, i - j);
                sum -= nums[j++];
            }
        }
        
        return min == Integer.MAX_VALUE ? 0 : min; 
    }
}