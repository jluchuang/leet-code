public class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0; 
        }
        
        int count = 1; 
        int status = 0; 
        
        int len = nums.length; 
        for(int i = 1; i < len; i ++) {
            int curStatus = nums[i] - nums[i - 1]; 
            if((status == 0 && curStatus != 0) || (status * curStatus < 0) ) {
                status = curStatus; 
                count ++; 
            }
        }
        
        return count; 
    }
}